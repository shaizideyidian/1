const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot3e655/",
            name: "springboot3e655",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot3e655/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于springboot公租房申请管理系统"
        } 
    }
}
export default base
