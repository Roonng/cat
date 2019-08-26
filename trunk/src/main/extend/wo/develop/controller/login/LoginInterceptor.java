package wo.develop.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import wo.develop.run.runutil.RunModel;
import wo.develop.util.P;
import wo.develop.util.ResultUtil;
import wo.develop.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * Handler执行之前调用这个方法
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try{
            String url = request.getRequestURI();//获取请求的URL
            if(checkurl(url)){//校验请求地址是否属于免校验范围
                return true;
            }
            String accesstoken = getAccessTocken(request);//从request的headinfo中获取本次请求的accesstokcen信息
            if(StringUtil.isNotNull(accesstoken)){
                Map parammap = AccessTockenUtil.decodeAccessTocken(accesstoken);//解密accesstokcen，用户与项目是否一致
                log.debug("LoginInterceptor请求解密的accesstoken信息：{},url:{}",parammap.toString(),url);
                if("1".equals(P.g("checkaccesstocken","0"))){
                    if(parammap.isEmpty()){
                        PrintWriter out = response.getWriter();//无权限，跳转到登录界面
                        out.print(ResultUtil.error(19999,"gotologin"));//返回登录信息
                        out.flush();
                        out.close();
                        return false;
                    }
                }
                return true;
            }
            HttpSession session = request.getSession();
            log.debug("inter session.getId()session.getId()session.getId()={},url={}",session.getId(),url);
            String dhuuiid = (String)session.getAttribute("dhuuiid");
            if(StringUtil.isNotNull(dhuuiid)){
                return true;
            }
            log.info("LoginInterceptor 从session校验wsuuiid：{}，wspuiid：{}",dhuuiid);
            PrintWriter out = response.getWriter();//不符合条件的，跳转到登录界面
            out.print(ResultUtil.error(19999,"gotologin"));//返回登录信息
            out.flush();
            out.close();
            return false;
        }catch (Exception e){
            log.error("LoginInterceptor权限验证异常",e);
            try{
                PrintWriter out = response.getWriter();
                out.print(ResultUtil.error(19999,"gotoerror"));//返回登录信息
                out.flush();
                out.close();
            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Handler执行完成之后调用这个方法
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exc) throws Exception {
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    /**
     * request请求header信息中获取AccessTocken
     * @param request
     * @return
     */
    private String getAccessTocken(HttpServletRequest request) {
        Map<String, String> map = getHeadersInfo(request);
        if(map.containsKey("accesstocken") && StringUtil.isNotNull(map.get("accesstocken"))){
            return map.get("accesstocken");
        }
        return "";
    }

    /**
     * 校验资源的扩展名
     * @param url
     * @return
     */
    private boolean checkurl(String url){
        if(RunModel.urlingoremap.size() == 0){
            initurlingoremap();
        }
        if(RunModel.urlingoremap.containsKey(url)){
            return true;
        }
        Iterator iterator = RunModel.urlingoremap.keySet().iterator();
        while(iterator.hasNext()){
            String curl = (String )iterator.next();
            if(curl.indexOf(url) != -1){
                log.warn("当前请求连接存在风险：{},目标融合连接：{}",url,curl);
                return true;
            }
        }
        return false;
    }

    /**
     * 初始化资源过滤map
     */
    private void initurlingoremap(){
        String ingoreextension = P.g("initurlingoreextension","");
        String[] ingoreextensionlist = ingoreextension.split(",");
        for(int i = 0 ; i < ingoreextensionlist.length ; i ++){
            RunModel.urlingoremap.put(ingoreextensionlist[i],ingoreextensionlist[i]);
        }
        initdefaulturlingoremap();
    }

    /**
     * 默认初始化资源过滤map
     */
    private void initdefaulturlingoremap(){
        RunModel.urlingoremap.put("/cat/cat/login", "/cat/cat/login");
        RunModel.urlingoremap.put("/cat/cat/tocken", "/cat/cat/tocken");
        RunModel.urlingoremap.put("/cat/register/do", "/cat/register/do");
        RunModel.urlingoremap.put("/cat/login/do", "/cat/login/do");
        RunModel.urlingoremap.put("/cat/login/smscode", "/cat/login/smscode");
        RunModel.urlingoremap.put("/cat/register/smscode", "/cat/register/smscode");
        RunModel.urlingoremap.put("/cat/wo/run/searchlist/getProductLunList", "/cat/wo/run/searchlist/getProductLunList");
        RunModel.urlingoremap.put("/cat/get/productinfo", "/cat/get/productinfo");
    }
}
