package wo.develop.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wo.develop.run.a3service.IRunService;
import wo.develop.util.BeanRefUtil;
import wo.develop.util.P;
import wo.develop.util.ResultUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 * 获取当前产品的安装包信息
 */
@Controller
@RequestMapping("/get")
public class GetProductInfoController {
    private static Logger log = LoggerFactory.getLogger(GetProductInfoController.class);

    @ResponseBody
    @RequestMapping("/productinfo")
    public Map<String, Object> answer(HttpServletRequest request) {
        try {
            Map<String, Object> parammap = BeanRefUtil.setvalueFromRequest(request);
            parammap.put("sqluiid","getProductInfoForDownload");
            Map<String, Object> retuanmap = runService.searchlist(parammap);
            if(ResultUtil.isok(retuanmap)){
                ArrayList data = (ArrayList) retuanmap.get(ResultUtil.data);
                for(int i = 0 ; i < data.size() ; i ++){
                    Map datamap = (Map) data.get(i);
                    if(datamap.containsKey("durl") && null != datamap.get("durl") && !"".equals(datamap.get("durl"))){
                        String param2_str = (String) datamap.get("durl");
                        datamap.put("durl", P.g("osswww")+param2_str);
                    }
                    if(datamap.containsKey("vurl") && null != datamap.get("vurl") && !"".equals(datamap.get("vurl"))){
                        String param2_str = (String) datamap.get("vurl");
                        datamap.put("vurl", P.g("osswww")+param2_str);
                    }
                    if(datamap.containsKey("logoimg") && null != datamap.get("logoimg") && !"".equals(datamap.get("logoimg"))){
                        String param2_str = (String) datamap.get("logoimg");
                        datamap.put("logoimg", P.g("osswww")+param2_str);
                    }
                }
                String datastr = JSON.toJSONString(data);
                return ResultUtil.ok(datastr);
            }
            return ResultUtil.error("19999","未找到产品安装包信息");
        } catch (Exception e) {
            log.error("获取回复信息异常：",e);
            return ResultUtil.error(19999, e.getMessage());
        }
    }

    @Resource
    private IRunService runService;

}
