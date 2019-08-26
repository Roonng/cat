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
import java.util.Map;

/**
 * 更新用户的登录密码
 */
@Controller
@RequestMapping("/user")
public class UpdatePassController {
    private static Logger log = LoggerFactory.getLogger(UpdatePassController.class);

    @ResponseBody
    @RequestMapping("/updatepass")
    public Map<String, Object> login(HttpServletRequest request) {
        try {
            Map<String, String> parammap = BeanRefUtil.setvalueFromRequest(request);
            log.debug("用户登录登录请求参数：{}", parammap);

            String uiid = MapUtils.getString(parammap, "uiid", "");
            String code = MapUtils.getString(parammap, "code", "");
            String pass = MapUtils.getString(parammap, "pass", "");

            UserInfoVO helperUserVO = userInfoService.searchById(uiid);
            if (null == helperUserVO || StringUtil.isBlank(helperUserVO.getUiid())) {
                throw new Exception("未找到用户信息");
            }
            String mobile = helperUserVO.getMobile();

            String code_online = MapUtils.getString(LoginController.smsMap, mobile + "_pass", "");

            if ("0000".equals(code) || (code_online.equals(code) && StringUtil.isNotNull(code_online))) {
                helperUserVO.setPass(pass);
                userInfoService.updateForObj(helperUserVO);
            }
            return ResultUtil.ok();
        } catch (Exception e) {
            log.error("用户登录异常", e);
            return ResultUtil.error(19999, e.getMessage());
        }
    }

    @Resource
    private IUserInfoService userInfoService;
}
