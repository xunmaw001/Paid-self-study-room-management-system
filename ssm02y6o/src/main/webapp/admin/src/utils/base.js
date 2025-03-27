const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm02y6o/",
            name: "ssm02y6o",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm02y6o/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于微信小程序的付费自习室管理系统"
        } 
    }
}
export default base
