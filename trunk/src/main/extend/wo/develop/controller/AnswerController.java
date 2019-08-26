package wo.develop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wo.develop.service.IAnswerService;
import wo.develop.util.BeanRefUtil;
import wo.develop.util.ResultUtil;
import wo.develop.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/answer")
public class AnswerController {
    private static Logger log = LoggerFactory.getLogger(AnswerController.class);

    @ResponseBody
    @RequestMapping("/content")
    public Map<String, Object> answer(HttpServletRequest request) {
        try {
            Map<String, String> parammap = BeanRefUtil.setvalueFromRequest(request);
            String answer = answerService.answer(parammap);
            if (StringUtil.isNotNull(answer)) {
                return ResultUtil.ok(answer);
            } else {
                return ResultUtil.error(19999, "");
            }
        } catch (Exception e) {
            log.error("获取回复信息异常：",e.getMessage());
            return ResultUtil.error(19999, e.getMessage());
        }

    }

    @Resource
    private IAnswerService answerService;

}
