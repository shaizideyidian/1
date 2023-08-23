package com.xq.tmall.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xq.tmall.controller.BaseController;
import com.xq.tmall.entity.Address;
import com.xq.tmall.entity.Product;
import com.xq.tmall.entity.ProductOrder;
import com.xq.tmall.entity.ProductOrderItem;
import com.xq.tmall.service.*;
import com.xq.tmall.util.OrderUtil;
import com.xq.tmall.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 后台管理-订单页
 */
@Controller
public class OrderController extends BaseController{
    @Autowired
    private ProductOrderService productOrderService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductOrderItemService productOrderItemService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private LastIDService lastIDService;

    //转到后台管理-订单页-ajax
    @RequestMapping(value = "admin/order", method = RequestMethod.GET)
    public String goToPage(HttpSession session, Map<String, Object> map){
        logger.info("检查管理员权限");
//        检查管理员权限，如果管理员未登录，放回一个提示信息
        Object adminId = checkAdmin(session);
        if(adminId == null){
            return "admin/include/loginMessage";
        }

        logger.info("获取前10条订单列表");
//        管理员登录后，则获取前10条订单列表
//        创建一个PageUtil对象，并设置其总记录数为订单数量
        PageUtil pageUtil = new PageUtil(0, 10);
        List<ProductOrder> productOrderList = productOrderService.getList(null, null, new OrderUtil("productOrder_id", true), pageUtil);
//        将订单列表添加到map中
        map.put("productOrderList",productOrderList);
        logger.info("获取订单总数量");
        Integer productOrderCount = productOrderService.getTotal(null, null);
//        获取订单总数量添加到map中
        map.put("productOrderCount", productOrderCount);
        logger.info("获取分页信息");
        pageUtil.setTotal(productOrderCount);
//        将PageUtil对象添加到map中
        map.put("pageUtil", pageUtil);

        logger.info("转到后台管理-订单页-ajax方式");
        return "admin/orderManagePage";
    }

    //转到后台管理-订单详情页-ajax
    @RequestMapping(value = "admin/order/{oid}", method = RequestMethod.GET)
    public String goToDetailsPage(HttpSession session, Map<String, Object> map, @PathVariable Integer oid/* 订单ID */) {
        logger.info("检查管理员权限");
        Object adminId = checkAdmin(session);
//        通过checkAdmin方法检验管理员权限
        if(adminId == null){
            return "admin/include/loginMessage";
        }

        logger.info("获取order_id为{}的订单信息",oid);
//        获取订单ID为oid的订单信息
        ProductOrder order = productOrderService.get(oid);
        logger.info("获取订单详情-地址信息");
//        根据订单中的地址区域ID获取地址对象，并存储到address变量中
        Address address = addressService.get(order.getProductOrder_address().getAddress_areaId());
//        创建一个Stack对象，Stack是一种后进先出的数据结构，它可以用来操作和存储一组元素
        Stack<String> addressStack = new Stack<>();
        //详细地址
//        order.getProductOrder_detail_address()获取订单详情的详细地址，然后push压栈近addressStack中
        addressStack.push(order.getProductOrder_detail_address());
        //最后一级地址
//        将地址对象的名称address.getAddress_name和一个空格字符压栈到addressStack中，表示地址中的最后一级信息
        addressStack.push(address.getAddress_name() + " ");
//        如果地址对象的区域ID不等于其上一级区域ID，进入循环
        //如果不是第一级地址
        while (!address.getAddress_areaId().equals(address.getAddress_regionId().getAddress_areaId())) {
//            根据当前地址对象的上一级区域ID获取上一级地址对象，并更新address变量
            address = addressService.get(address.getAddress_regionId().getAddress_areaId());
            addressStack.push(address.getAddress_name() + " ");
        }
//        创建一个StringBuilder对象
        StringBuilder builder = new StringBuilder();
        while (!addressStack.empty()) {
//            循环体内通过不断从addressStack中弹出元素，追加到builder中，构建了完整的地址字符串
            builder.append(addressStack.pop());
        }
        logger.warn("订单地址字符串：{}", builder);
//        通过order的setProductOrder_detail_address查询订单的详细地址，通过builder.toString方法获取完整的订单地址字符串
        order.setProductOrder_detail_address(builder.toString());
        logger.info("获取订单详情-用户信息");
//        使用userService的get方法，根据订单中的ID获取用户对象，并将其设置为订单的用户对象
        order.setProductOrder_user(userService.get(order.getProductOrder_user().getUser_id()));
        logger.info("获取订单详情-订单项信息");
//        使用getListByOederId方法，根据订单的ID获取订单项信息，并将其储存在list中
        List<ProductOrderItem> productOrderItemList = productOrderItemService.getListByOrderId(oid, null);
        if (productOrderItemList != null) {
            logger.info("获取订单详情-订单项对应的产品信息");
//            使用for循环遍历订单项列表中的每一个订单项
            for (ProductOrderItem productOrderItem : productOrderItemList) {
//                获取当前订单项的产品ID
                Integer productId = productOrderItem.getProductOrderItem_product().getProduct_id();
                logger.warn("获取产品ID为{}的产品信息", productId);
//                通过productService的get方法获取该产品对象，将其设置为订单项的产品对象
                Product product = productService.get(productId);
                if (product != null) {
                    logger.warn("获取产品ID为{}的第一张预览图片信息", productId);
//                    记录获取产品ID为productId的第一张预览图片信息
//                    使用productImageService.getList方法，根据产品ID、图片类型和分页参数获取图片列表，并将其设置为产品的单一产品图片列表
                    product.setSingleProductImageList(productImageService.getList(productId, (byte) 0, new PageUtil(0, 1)));
                }

                productOrderItem.setProductOrderItem_product(product);
            }
        }
        //                将已经处理完的订单项列表设置返回订单对象
        order.setProductOrderItemList(productOrderItemList);
        map.put("order", order);
        logger.info("转到后台管理-订单详情页-ajax方式");
        return "admin/include/orderDetails";
    }

    //更新订单信息-ajax
    @ResponseBody
    @RequestMapping(value = "admin/order/{order_id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public String updateOrder(@PathVariable("order_id") String order_id) {
//        创建一个JSONObject对象用于返回结果
        JSONObject jsonObject = new JSONObject();
        logger.info("整合订单信息");
//        创建一个ProductOrder对象，并设置其订单ID、订单状态和交货日期
        ProductOrder productOrder = new ProductOrder()
                .setProductOrder_id(Integer.valueOf(order_id))
                .setProductOrder_status((byte) 2)
                .setProductOrder_delivery_date(new Date());
        logger.info("更新订单信息，订单ID值为：{}", order_id);
//        创建一个yn对象用来保存更新操作返回的结果
        boolean yn = productOrderService.update(productOrder);
        if (yn) {
            logger.info("更新成功！");
//            如果更新成功将success字段设置为true
            jsonObject.put("success", true);
        } else {
            logger.info("更新失败！事务回滚");
            jsonObject.put("success", false);
            throw new RuntimeException();
        }
//        将订单ID添加到返回结果的order_id字段中
        jsonObject.put("order_id", order_id);
        return jsonObject.toJSONString();
    }

    //按条件查询订单-ajax
    @ResponseBody
    @RequestMapping(value = "admin/order/{index}/{count}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getOrderBySearch(@RequestParam(required = false) String productOrder_code/* 订单号 */,
                                   @RequestParam(required = false) String productOrder_post/* 订单邮政编码 */,
                                   @RequestParam(required = false) Byte[] productOrder_status_array/* 订单状态数组 */,
                                   @RequestParam(required = false) String orderBy/* 排序字段 */,
                                   @RequestParam(required = false,defaultValue = "true") Boolean isDesc/* 是否倒序 */,
                                   @PathVariable Integer index/* 页数 */,
                                   @PathVariable Integer count/* 行数 */){
        //移除不必要条件
//        如果订单状态数组为空或者长度小于等于0或大于等于5，则将其设置为null
        if (productOrder_status_array != null && (productOrder_status_array.length <= 0 || productOrder_status_array.length >=5)) {
            productOrder_status_array = null;
        }
//        如果订单号或订单邮政编码为空，则将其设置为null
        if (productOrder_code != null){
            productOrder_code = "".equals(productOrder_code) ? null : productOrder_code;
        }
        if(productOrder_post != null){
            productOrder_post = "".equals(productOrder_post) ? null : productOrder_post;
        }
//        如果排序字段为空字符串，则将其设置为null
        if (orderBy != null && "".equals(orderBy)) {
            orderBy = null;
        }
        //封装查询条件
//        创建一个ProductOrder对象，并设置其订单号和订单邮政编码
        ProductOrder productOrder = new ProductOrder()
                .setProductOrder_code(productOrder_code)
                .setProductOrder_post(productOrder_post);
        OrderUtil orderUtil = null;
//        如果存在排序字段，创建一个orderUtil对象，该对象用于指定排序字段和排序方式
        if (orderBy != null) {
            logger.info("根据{}排序，是否倒序:{}",orderBy,isDesc);
            orderUtil = new OrderUtil(orderBy, isDesc);
        }
//        创建一个JSONObject对象用来存储返回结果
        JSONObject object = new JSONObject();
        logger.info("按条件获取第{}页的{}条订单", index + 1, count);
//        创建一个PageUtil对象，并设置其页数和行数
        PageUtil pageUtil = new PageUtil(index, count);
//        使用productOrderService.getList方法，根据查询条件、订单状态数组、排序工具和分页工具获取订单列表，并将结果保存在productOrderList中
        List<ProductOrder> productOrderList = productOrderService.getList(productOrder, productOrder_status_array, orderUtil, pageUtil);
//        将productOrderList转换为JSON数组并添加到返回结果中
        object.put("productOrderList", JSONArray.parseArray(JSON.toJSONString(productOrderList)));
        logger.info("按条件获取订单总数量");
//        使用productOrderService.getTotal方法，根据查询条件和订单状态数组获取订单总数量，并将结果保存在productOrderCount中
        Integer productOrderCount = productOrderService.getTotal(productOrder, productOrder_status_array);
//        将productOrderCount保存到返回结果中
        object.put("productOrderCount", productOrderCount);
        logger.info("获取分页信息");
//        设置分页工具的总记录数，并将分页工具的总页数和分页工具本身添加到返回结果中
        pageUtil.setTotal(productOrderCount);
        object.put("totalPage", pageUtil.getTotalPage());
        object.put("pageUtil", pageUtil);

        return object.toJSONString();
    }
}
