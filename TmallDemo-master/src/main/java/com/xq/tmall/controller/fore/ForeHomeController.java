package com.xq.tmall.controller.fore;

import com.alibaba.fastjson.JSONObject;
import com.xq.tmall.controller.BaseController;
import com.xq.tmall.entity.Category;
import com.xq.tmall.entity.Product;
import com.xq.tmall.entity.User;
import com.xq.tmall.service.CategoryService;
import com.xq.tmall.service.ProductImageService;
import com.xq.tmall.service.ProductService;
import com.xq.tmall.service.UserService;
import com.xq.tmall.util.OrderUtil;
import com.xq.tmall.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 前台天猫-主页
 */
@Controller
public class ForeHomeController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImageService productImageService;

    //转到前台天猫-主页
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToPage(HttpSession session, Map<String, Object> map) {
        logger.info("检查用户是否登录");
//        checkUser方法检验用户是否已登录，返回一个用户ID
        Object userId = checkUser(session);
        if (userId != null) {
            logger.info("获取用户信息");
            User user = userService.get(Integer.parseInt(userId.toString()));
            map.put("user", user);
        }
        logger.info("获取产品分类列表");
//        调用categoryService.getList方法获取产品分类列表的数据
        List<Category> categoryList = categoryService.getList(null, null);
        logger.info("获取每个分类下的产品列表");
        for (Category category : categoryList) {
            logger.info("获取分类id为{}的产品集合，按产品ID倒序排序", category.getCategory_id());
//            调用productService.getList方法获取特定分类下的产品列表，其中包括了一些查询条件和排序方式
            List<Product> productList = productService.getList(new Product().setProduct_category(category), new Byte[]{0, 2}, new OrderUtil("product_id", true), new PageUtil(0, 8));
            if (productList != null) {
                for (Product product : productList) {
                    Integer product_id = product.getProduct_id();
                    logger.info("获取产品id为{}的产品预览图片信息", product_id);
//                    调用productImageService.getList方法获取产品的预览图片信息，并设置到产品对象中
                    product.setSingleProductImageList(productImageService.getList(product_id, (byte) 0, new PageUtil(0, 1)));
                }
            }
            category.setProductList(productList);
        }
        map.put("categoryList", categoryList);
        logger.info("获取促销产品列表");
//        调用productService.getList方法获取促销产品列表
        List<Product> specialProductList = productService.getList(null, new Byte[]{2}, null, new PageUtil(0, 6));
        map.put("specialProductList", specialProductList);

        logger.info("转到前台主页");
        return "fore/homePage";
    }

    //转到前台天猫-错误页
    @RequestMapping(value = "error", method = RequestMethod.GET)
    public String goToErrorPage() {
        return "fore/errorPage";
    }

    //获取主页分类下产品信息-ajax
    @ResponseBody
    @RequestMapping(value = "product/nav/{category_id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getProductByNav(@PathVariable("category_id") Integer category_id) {
        JSONObject object = new JSONObject();
        if (category_id == null) {
            object.put("success", false);
            return object.toJSONString();
        }
        logger.info("获取分类ID为{}的产品标题数据", category_id);
//        调用productService.getTitle方法获取特定分类ID下的产品标题数据，setProduct_category方法用于设置查询条件，setCategory_id方法用来设置ID，
        List<Product> productList = productService.getTitle(new Product().setProduct_category(new Category().setCategory_id(category_id)), new PageUtil(0, 40));
//        创建一个List<List<Product>>类型的变量，用于存储产品二维集合，每个二级列表中包含5个产品对象
        List<List<Product>> complexProductList = new ArrayList<>(8);
//        创建一个List<Product>类型的变量，用于存储临时的产品列表
        List<Product> products = new ArrayList<>(5);
        for (int i = 0; i < productList.size(); i++) {
            //如果临时集合中产品数达到5个，加入到产品二维集合中，并重新实例化临时集合
            if (i % 5 == 0) {
                complexProductList.add(products);
                products = new ArrayList<>(5);
            }
            products.add(productList.get(i));
        }
        complexProductList.add(products);
//        创建一个Category对象，并设置分类ID和产品二维集合
        Category category = new Category().setCategory_id(category_id).setComplexProductList(complexProductList);
        object.put("success", true);
        object.put("category", category);
        return object.toJSONString();
    }
}
