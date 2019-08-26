package wo.develop.controller.login;

import com.aliyun.util.SmsALiYunUtil;
import net.sf.json.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wo.develop.util.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 获取用户登录的验证码
 */
@Controller
@RequestMapping("/login")
public class LoginSmsCodeController {
    private static Logger log = LoggerFactory.getLogger(LoginSmsCodeController.class);

    @ResponseBody
    @RequestMapping("/smscode")
    public Map<String, Object> smscode(HttpServletRequest request) {
        try {
            Map<String, String> parammap = BeanRefUtil.setvalueFromRequest(request);
            String mobile = MapUtils.getString(parammap, "mobile", "");
            String code = new RandomString().getRandomString(4, "i");// 创建4位随机数验证码
            JSONObject paramobj = new JSONObject();
            paramobj.put("code", code);
            boolean b = SmsALiYunUtil.sendAliyunSmsReturnSuccess(String.valueOf(UniqueUtil.getUniqueID()), mobile, P.g("aliyunloginsmscode"), paramobj);// 发送验证码短信
            if (b) {
                LoginController.smsMap.put(mobile+"_login", code);
                log.debug(DateHelper.toLocalDate() + "  用户存在，给用户登录验证码发送成功：" + "sendRegisterCode" + "  发送验证码信息：" + code);
                return ResultUtil.ok();
            } else {
                log.debug(DateHelper.toLocalDate() + "  用户存在，给用户登录验证码发送失败：" + "sendRegisterCode" + "  发送验证码信息：" + code);
                return ResultUtil.error(19999, "验证码发送失败");
            }
        } catch (Exception e) {
            return ResultUtil.error(19999, e.getMessage());
        }

    }
}
