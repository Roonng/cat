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
import wo.develop.util.P;
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
@RequestMapping("/cat")
public class LoginWebController {
    private static Logger log = LoggerFactory.getLogger(LoginWebController.class);

    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> login(HttpServletRequest request) {
        try {
            Map<String, String> parammap = BeanRefUtil.setvalueFromRequest(request);
            log.debug("用户登录登录请求参数：{}", parammap);

            String loginAccount = MapUtils.getString(parammap, "loginAccount", "");
            String loginPassword = MapUtils.getString(parammap, "loginPassword", "");
            if (StringUtil.isBlank(loginAccount)) {
                throw new Exception("登录账号为空");
            }
            if (StringUtil.isBlank(loginPassword)) {
                throw new Exception("登录密码为空");
            }
            UserInfoVO helperUserVO_search = new UserInfoVO();
            helperUserVO_search.setMobile(loginAccount);
            helperUserVO_search.setPass(loginPassword);
            UserInfoVO helperUserVO = userInfoService.searchObjByObj(helperUserVO_search);

            if (null == helperUserVO || StringUtil.isBlank(helperUserVO.getUiid())) {
                throw new Exception("未找到用户信息或密码为空");
            }
            request.getSession().setAttribute("dhuuiid", helperUserVO.getUiid());
            return returnmap(helperUserVO);
        } catch (Exception e) {
            log.error("用户登录异常", e);
            return ResultUtil.error(19999, e.getMessage());
        }
    }

    /**
     * 返回用户登录成功的信息
     *
     * @param helperUserVO
     * @return
     */
    private Map returnmap(UserInfoVO helperUserVO) throws Exception {
        Map returnmap = new HashMap();
        returnmap.put("cuiuiid", helperUserVO.getUiid());
        returnmap.put("name", helperUserVO.getName());
        returnmap.put("wsruiid", helperUserVO.getMenurole());
        returnmap.put("wspuiid", P.g("wspuiid"));
        return ResultUtil.ok(returnmap);
    }

    @Resource
    private IUserInfoService userInfoService;
}
