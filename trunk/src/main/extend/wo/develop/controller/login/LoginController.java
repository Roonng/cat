package wo.develop.controller.login;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wo.develop.a3service.IUserInfoService;
import wo.develop.a5vo.UserInfoVO;
import wo.develop.util.BeanRefUtil;
import wo.develop.util.ResultUtil;
import wo.develop.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    public static Map<String, String> smsMap = new HashMap<>();

    @ResponseBody
    @RequestMapping("/do")
    public Map<String, Object> login(HttpServletRequest request) {
        try {
            Map<String, String> parammap = BeanRefUtil.setvalueFromRequest(request);
            log.debug("用户登录登录请求参数：{}", parammap);

            String mobile = MapUtils.getString(parammap, "mobile", "");
            String deviceid = MapUtils.getString(parammap, "deviceid", "");
            if(StringUtil.isBlank(mobile) && StringUtil.isBlank(deviceid)){
                throw new Exception("登录账号为空");
            }
            String code = MapUtils.getString(parammap, "code", "");
            String pass = MapUtils.getString(parammap, "pass", "");
            if(StringUtil.isNotNull(deviceid)){
                UserInfoVO helperUserVO_search = new UserInfoVO();
                helperUserVO_search.setDeviceid(deviceid);
                UserInfoVO helperUserVO = userInfoService.searchObjByObj(helperUserVO_search);
                if (null != helperUserVO || StringUtil.isNotNull(helperUserVO.getUiid())) {
                    return returnmap(helperUserVO);
                }
            }
            if(!(StringUtil.isNotNull(code) || StringUtil.isNotNull(pass) )){
                throw new Exception("登录信息为空");
            }
            String code_online = MapUtils.getString(LoginController.smsMap, mobile + "_login", "");

            if (StringUtil.isNotNull(pass)) {
                UserInfoVO helperUserVO_search = new UserInfoVO();
                helperUserVO_search.setMobile(mobile);
                helperUserVO_search.setPass(pass);
                UserInfoVO helperUserVO = userInfoService.searchObjByObj(helperUserVO_search);
                if (null != helperUserVO && StringUtil.isNotNull(helperUserVO.getUiid())) {
                    return returnmap(helperUserVO);
                }
            }
            if (StringUtil.isNotNull(code)) {
                if ("0000".equals(code) || (code_online.equals(code) && StringUtil.isNotNull(code_online))) {
                    UserInfoVO helperUserVO_search = new UserInfoVO();
                    helperUserVO_search.setMobile(mobile);
                    UserInfoVO helperUserVO = userInfoService.searchObjByObj(helperUserVO_search);
                    if (null == helperUserVO || StringUtil.isBlank(helperUserVO.getUiid())) {
                        return ResultUtil.error(19999, "用户未注册");
                    } else {
                        return returnmap(helperUserVO);
                    }
                }
            }
            throw new Exception("未找到有效登录信息");
        } catch (Exception e) {
            log.error("用户登录异常", e);
            return ResultUtil.error(19999, e.getMessage());
        }
    }

    /**
     * 返回用户登录成功的信息
     * @param helperUserVO
     * @return
     */
    private Map returnmap(UserInfoVO helperUserVO) throws Exception {
        Map returnmap = new HashMap();
        returnmap.put("uiid", helperUserVO.getUiid());
        returnmap.put("name", helperUserVO.getName());
        if(StringUtil.isNotNull(helperUserVO.getDebugrole()) && "1".equals(helperUserVO.getDebugrole())){
            returnmap.put("debug", helperUserVO.getDebugrole());
        }
        if(StringUtil.isNotNull(helperUserVO.getAutorole()) && "1".equals(helperUserVO.getAutorole())){
            returnmap.put("auto", helperUserVO.getAutorole());
        }
        returnmap.put("accesstocken", AccessTockenUtil.encodeAccessTocken(returnmap));
        return ResultUtil.ok(returnmap);
    }

    @Resource
    private IUserInfoService userInfoService;
}
