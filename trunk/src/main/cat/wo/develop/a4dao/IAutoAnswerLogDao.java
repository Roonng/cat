/*
 * @ClassName AutoAnswerLogDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.AutoAnswerLogVO;

/**
 * 帖子回复日志信息dao接口类
 * @author 彭羽飞
 *
 */
public interface IAutoAnswerLogDao {
	
	/**
	 * 新增一条帖子回复日志信息信息
	 * @param autoAnswerLog 帖子回复日志信息对象
	 * @return 成功更新条数
	 */
    int insert(AutoAnswerLogVO autoAnswerLog);

	/**
     * 批量新增帖子回复日志信息信息
     * @param autoAnswerLoglist 帖子回复日志信息对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<AutoAnswerLogVO> autoAnswerLoglist);

	/**
     * 更新一条帖子回复日志信息信息
     * @param autoAnswerLog 帖子回复日志信息对象
     * @return 成功更新条数
     */
    int update(AutoAnswerLogVO autoAnswerLog);
    
	/**
     * 批量更新帖子回复日志信息信息
     * @param autoAnswerLoglist 帖子回复日志信息对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<AutoAnswerLogVO> autoAnswerLoglist);
    
	/**
     * 批量更新帖子回复日志信息信息
     * @param datamap 帖子回复日志信息对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条帖子回复日志信息信息
     * @param autoAnswerLogid 帖子回复日志信息信息主键
     * @return 成功更新条数
     */
    int delete(String autoAnswerLogid);
    
    /**
     * 删除符合帖子回复日志信息条件的全部信息
     * @param autoAnswerLog 帖子回复日志信息对象
     * @return 成功更新条数
     */
    int deleteForObj(AutoAnswerLogVO autoAnswerLog);

	/**
     * 批量删除帖子回复日志信息信息，通过in数据主键
     * @param autoAnswerLoglist 帖子回复日志信息信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> autoAnswerLoglist);

	/**
     * 批量删除帖子回复日志信息指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 帖子回复日志信息信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除帖子回复日志信息指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 帖子回复日志信息信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条帖子回复日志信息的详情信息
     * @param autoAnswerLogid 帖子回复日志信息信息主键
     * @return 帖子回复日志信息信息对象
     */
    AutoAnswerLogVO searchById(String autoAnswerLogid);

	/**
     * 查询一条帖子回复日志信息的详情信息，实现数据行锁定
     * @param autoAnswerLogid 帖子回复日志信息信息主键
     * @return 帖子回复日志信息信息对象
     */
    AutoAnswerLogVO searchByIdUpdate(String autoAnswerLogid);

	/**
     * 批量查询帖子回复日志信息信息，通过in数据主键
     * @param autoAnswerLoglist 帖子回复日志信息信息主键列表
     * @return 帖子回复日志信息信息对象列表
     */
    List<AutoAnswerLogVO> searchBatch(List<String> autoAnswerLoglist);

	/**
     * 获取帖子回复日志信息指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 帖子回复日志信息信息map对象
     * @return 帖子回复日志信息信息对象列表
     */
    List<AutoAnswerLogVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条帖子回复日志信息信息表信息，=条件判断符
     * @param autoAnswerLog 帖子回复日志信息信息对象
     * @return 帖子回复日志信息信息对象
     */
    AutoAnswerLogVO searchObjByObj(AutoAnswerLogVO autoAnswerLog);

	/**
     * 获取符合条件的帖子回复日志信息信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param autoAnswerLog 帖子回复日志信息信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(AutoAnswerLogVO autoAnswerLog);

	/**
     * 获取符合条件的全部帖子回复日志信息信息，=条件判断符
     * @param autoAnswerLog 帖子回复日志信息信息对象
     * @return 帖子回复日志信息信息对象列表
     */
    List<AutoAnswerLogVO> searchListByObj(AutoAnswerLogVO autoAnswerLog);
	
    /**
     * 获取符合条件的全部帖子回复日志信息信息，支持动态关联分页查询
     * @param autoAnswerLog 帖子回复日志信息信息对象
     * @return 帖子回复日志信息信息对象列表
     */
    List<AutoAnswerLogVO> searchListPageByObj(AutoAnswerLogVO autoAnswerLog);
	
    /**
     * 获取符合条件的全部帖子回复日志信息信息，支持动态关联分页查询
     * @param autoAnswerLog 帖子回复日志信息信息对象
     * @return 帖子回复日志信息信息对象列表
     */
    List<AutoAnswerLogVO> searchListPageByObjOr(AutoAnswerLogVO autoAnswerLog);
	
    /**
     * 获取符合条件的全部帖子回复日志信息信息，支持动态关联分页查询
     * @param autoAnswerLog 帖子回复日志信息信息对象
     * @return 帖子回复日志信息信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(AutoAnswerLogVO autoAnswerLog);
	
    /**
     * 获取符合条件的全部帖子回复日志信息信息，支持动态关联分页查询
     * @param autoAnswerLog 帖子回复日志信息信息对象
     * @return 帖子回复日志信息信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(AutoAnswerLogVO autoAnswerLog);
    
}