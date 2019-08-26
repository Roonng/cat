package wo.develop.service.impl;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import wo.develop.a3service.IAutoAnswerMessageService;
import wo.develop.a3service.IUserRefSubjectService;
import wo.develop.a4dao.IAutoAnswerLogDao;
import wo.develop.a5vo.AutoAnswerLogVO;
import wo.develop.a5vo.UserRefSubjectVO;
import wo.develop.run.a3service.IRunService;
import wo.develop.service.IAnswerService;
import wo.develop.util.ResultUtil;
import wo.develop.util.UniqueUtil;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("answerService")
public class AnswerImpl implements IAnswerService {

    @Override
    public String answer(Map<String, String> parammap) throws Exception {
        String content = MapUtils.getString(parammap, "content", "");
        String username = MapUtils.getString(parammap, "username", "");
        String uiid = MapUtils.getString(parammap, "uiid", "");
        content = URLDecoder.decode(URLDecoder.decode(content,"utf-8"),"utf-8");
        username = URLDecoder.decode(URLDecoder.decode(username,"utf-8"),"utf-8");
        uiid = URLDecoder.decode(URLDecoder.decode(uiid,"utf-8"),"utf-8");

        UserRefSubjectVO userRefSubjectVO = userRefSubjectService.searchById(uiid);

        if(String.valueOf(1).equals(userRefSubjectVO.getCheckrepeat())){
            /**
             * 3天之内，同一帖子避免重复添加重复回复
             */
            Map<String, Object> datamap = runService.searchlist(
                    "select l.caal_uiid  from com_auto_answer_log l where l.caal_content = '" + content + "' and DATEDIFF(l.caal_addtime,now()) < "+userRefSubjectVO.getRepeatday()+" ");
            if(ResultUtil.isok(datamap)){
                List planTemplateList = (List) datamap.get(ResultUtil.data);
                if(planTemplateList.size() > 0){
                    throw new Exception("数据已存在");
                }
            }
        }
        int score = 0;
        if(null != userRefSubjectVO.getAllowkey() && !"".equals(userRefSubjectVO.getAllowkey())){//符合条件关键字加分
            String allowkeys[] = userRefSubjectVO.getAllowkey().split(",");
            for(int i = 0 ; i < allowkeys.length ; ++i){
                if(content.contains(allowkeys[i])){
                    score += 10;
                }
            }
        }
        if(null != userRefSubjectVO.getDelowkey() && !"".equals(userRefSubjectVO.getDelowkey())){//拒绝条件关键字减分
            String delowkeys[] = userRefSubjectVO.getDelowkey().split(",");
            for(int i = 0 ; i < delowkeys.length ; ++i){
                if(content.contains(delowkeys[i])){
                    score -= 10;
                }
            }
        }
        String answercon = "";
        if(score >= userRefSubjectVO.getChecscore()){
            if(String.valueOf(1).equals(userRefSubjectVO.getAnswertype())){
                Map runmap = runService.searchvalue("select * \n" +
                        "from (\n" +
                        "SELECT t.caam_answercon FROM con_auto_answer_message t \n" +
                        "where t.ref_catuiid = '"+userRefSubjectVO.getCatuiid()+"' and t.ref_cuiuiid = '"+userRefSubjectVO.getCuiuiid()+"' \n" +
                        ") s \n" +
                        "ORDER BY RAND() LIMIT 1 ");
                if(ResultUtil.isok(runmap)){
                    answercon = MapUtils.getString(runmap,ResultUtil.data,"");
                }
            }
        }
        AutoAnswerLogVO autoAnswerLogVO = new AutoAnswerLogVO();
        autoAnswerLogVO.setUiid(String.valueOf(UniqueUtil.getUniqueID()));
        autoAnswerLogVO.setContent(content);
        autoAnswerLogVO.setUsername(username);
        autoAnswerLogVO.setAddtime(new Date());
        autoAnswerLogVO.setCatuiid(userRefSubjectVO.getCatuiid());
        autoAnswerLogVO.setCuiuiid(userRefSubjectVO.getCuiuiid());

        autoAnswerLogVO.setAnswer(answercon);
        autoAnswerLogDao.insert(autoAnswerLogVO);
        return answercon;
    }

    @Resource
    private IAutoAnswerLogDao autoAnswerLogDao;
    @Resource
    private IRunService runService;
    @Resource
    private IAutoAnswerMessageService autoAnswerMessageService;
    @Resource
    private IUserRefSubjectService userRefSubjectService;
}
