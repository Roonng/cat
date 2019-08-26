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
import wo.develop.util.UniqueUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户注册
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    private static Logger log = LoggerFactory.getLogger(RegisterController.class);

    @ResponseBody
    @RequestMapping("/do")
    public Map<String, Object> register(HttpServletRequest request) {
        try {
            Map<String, String> parammap = BeanRefUtil.setvalueFromRequest(request);

            String mobile = MapUtils.getString(parammap, "mobile", "");
            String recomid = MapUtils.getString(parammap, "recomid", "");
            String deviceid = MapUtils.getString(parammap, "deviceid", "");
            if (StringUtil.isEmpty(mobile)) {
                throw new Exception("注册用户账号为空");
            }
            String name = MapUtils.getString(parammap, "name", "");
            if (StringUtil.isEmpty(name)) {
                throw new Exception("注册用户姓名为空");
            }
            UserInfoVO userInfoVO = new UserInfoVO();

            String code = MapUtils.getString(parammap, "code", "");
            String code_online = MapUtils.getString(LoginController.smsMap, mobile + "_register", "");
            if ((code.equals(String.valueOf("0000"))) || (code_online.equals(code) && StringUtil.isNotNull(code_online))) {
                UserInfoVO userInfoVO_search = new UserInfoVO();//校验用户账户是否已完成注册
                userInfoVO_search.setMobile(mobile);
                userInfoVO = userInfoService.searchObjByObj(userInfoVO_search);
                if (null != userInfoVO && StringUtil.isNotNull(userInfoVO.getUiid())) {//手机号已注册，直接返回；这里应该更新下openid，appopenid
                    throw new Exception("该手机号账号已注册");
                }

                UserInfoVO userInfoVO_search2 = new UserInfoVO();//校验用户账户是否已完成注册
                userInfoVO_search2.setDeviceid(deviceid);
                userInfoVO = userInfoService.searchObjByObj(userInfoVO_search2);
                if (null != userInfoVO && StringUtil.isNotNull(userInfoVO.getUiid())) {//手机号已注册，直接返回；这里应该更新下openid，appopenid
                    throw new Exception("该设备已完成绑定");
                }

                userInfoVO = new UserInfoVO();
                userInfoVO.setUiid(String.valueOf(UniqueUtil.getUniqueID()));
                userInfoVO.setMobile(mobile);
                userInfoVO.setDeviceid(deviceid);
                userInfoVO.setStarttime(new Date());
                userInfoVO.setName(name);

                if (StringUtil.isNotNull(recomid)) {
                    UserInfoVO helperUserVO2_search = new UserInfoVO();//校验用户账户是否已完成注册
                    helperUserVO2_search.setMobile(recomid);
                    UserInfoVO helperUserVO2 = userInfoService.searchObjByObj(helperUserVO2_search);
                    if (null != helperUserVO2 && StringUtil.isNotNull(helperUserVO2.getUiid())) {//手机号已注册，直接返回；这里应该更新下openid，appopenid
                        userInfoVO.setRecomid(helperUserVO2.getUiid());
                    }
                }
                userInfoService.insertForObj(userInfoVO);
                return returnmap(userInfoVO);
            } else {
                return ResultUtil.error(19999, "注册验证码不正确");
            }
        } catch (Exception e) {
            log.error("用户注册异常", e);
            return ResultUtil.error(19999, e.getMessage());
        }
    }

    /**
     * 返回注册用户的信息
     * @param userInfoVO
     * @return
     */
    private Map returnmap(UserInfoVO userInfoVO) throws Exception {
        Map returnmap = new HashMap();
        returnmap.put("uiid", userInfoVO.getUiid());
        returnmap.put("name", userInfoVO.getName());
        returnmap.put("accesstocken", AccessTockenUtil.encodeAccessTocken(returnmap));
        return ResultUtil.ok(returnmap);
    }

    @Resource
    private IUserInfoService userInfoService;
}
