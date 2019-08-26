package wo.develop.controller;

import com.alibaba.fastjson.JSON;
import des1.MyClass;
import des1.RSAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wo.develop.run.a3service.IRunService;
import wo.develop.util.BeanRefUtil;
import wo.develop.util.ResultUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/get")
public class GetTaskStepAndRuleController {
    private static Logger log = LoggerFactory.getLogger(GetTaskStepAndRuleController.class);

    @ResponseBody
    @RequestMapping("/TaskStepAndRule")
    public Map<String, Object> answer(HttpServletRequest request) {
        try {
            String indatastr = "";
            Map<String, Object> parammap = BeanRefUtil.setvalueFromRequest(request);
            parammap.put("sqluiid","getTaskStepAndRule");
            Map<String, Object> retuanmap = runService.searchlist(parammap);
            if(ResultUtil.isok(retuanmap)){
                ArrayList data = (ArrayList) retuanmap.get(ResultUtil.data);
                String datastr = JSON.toJSONString(data);
                indatastr = RSAUtil.encryptByPrivateKey(datastr, MyClass.PRIVATE_KEY);
            }
            return ResultUtil.ok(indatastr);
        } catch (Exception e) {
            log.error("获取回复信息异常：",e);
            return ResultUtil.error(19999, e.getMessage());
        }

    }

    @Resource
    private IRunService runService;

}
