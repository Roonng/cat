package wo.develop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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

/**
 * 获取当前用户全部待执行的任务
 */
@Controller
@RequestMapping("/get")
public class GetUserAllTaskController {
    private static Logger log = LoggerFactory.getLogger(GetUserAllTaskController.class);

    @ResponseBody
    @RequestMapping("/UserAllTask")
    public Map<String, Object> answer(HttpServletRequest request) {
        try {
            String indatastr = "";
            Map<String, Object> parammap = BeanRefUtil.setvalueFromRequest(request);
            parammap.put("sqluiid","getUserAllTask");
            Map<String, Object> retuanmap = runService.searchlist(parammap);
            if(ResultUtil.isok(retuanmap)){
                ArrayList data = (ArrayList) retuanmap.get(ResultUtil.data);
                for(int i = 0 ; i < data.size() ; i ++){
                    Map datamap = (Map) data.get(i);
                    if(datamap.containsKey("param2") && null != datamap.get("param2") && !"".equals(datamap.get("param2"))){
                        String param2_str = (String) datamap.get("param2");
                        JSONArray param2_map = JSON.parseArray(param2_str);
                        for(int j = 0 ;j < param2_map.size() ; ++j){
                            Map param2_datamap = (Map) param2_map.get(j);
                            String param2_key = (String) param2_datamap.get("name");
                            if(datamap.containsKey("extparam") && null != datamap.get("extparam") && !"".equals(datamap.get("extparam"))){
                                String extparam_str = (String)datamap.get("extparam");
                                Map extparam_map = JSON.parseObject(extparam_str);
                                String extparam_value = (String) extparam_map.get(param2_key);
                                datamap.put("title",datamap.get("title")+"("+extparam_value+")");
                            }
                        }
                    }
                }
                String datastr = JSON.toJSONString(data);
                indatastr = RSAUtil.encryptByPrivateKey(datastr, MyClass.PRIVATE_KEY);
            }
            return ResultUtil.ok(indatastr);
        } catch (Exception e) {
            log.error("获取当前用户全部待执行的任务异常：",e);
            return ResultUtil.error(19999, e.getMessage());
        }
    }

    @Resource
    private IRunService runService;

}
