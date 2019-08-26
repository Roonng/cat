/*
 * @ClassName AutoAnswerMessageDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.AutoAnswerMessageVO;

/**
 * 帖子留言回复数据dao接口类
 * @author 彭羽飞
 *
 */
public interface IAutoAnswerMessageDao {
	
	/**
	 * 新增一条帖子留言回复数据信息
	 * @param autoAnswerMessage 帖子留言回复数据对象
	 * @return 成功更新条数
	 */
    int insert(AutoAnswerMessageVO autoAnswerMessage);

	/**
     * 批量新增帖子留言回复数据信息
     * @param autoAnswerMessagelist 帖子留言回复数据对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<AutoAnswerMessageVO> autoAnswerMessagelist);

	/**
     * 更新一条帖子留言回复数据信息
     * @param autoAnswerMessage 帖子留言回复数据对象
     * @return 成功更新条数
     */
    int update(AutoAnswerMessageVO autoAnswerMessage);
    
	/**
     * 批量更新帖子留言回复数据信息
     * @param autoAnswerMessagelist 帖子留言回复数据对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<AutoAnswerMessageVO> autoAnswerMessagelist);
    
	/**
     * 批量更新帖子留言回复数据信息
     * @param datamap 帖子留言回复数据对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条帖子留言回复数据信息
     * @param autoAnswerMessageid 帖子留言回复数据信息主键
     * @return 成功更新条数
     */
    int delete(String autoAnswerMessageid);
    
    /**
     * 删除符合帖子留言回复数据条件的全部信息
     * @param autoAnswerMessage 帖子留言回复数据对象
     * @return 成功更新条数
     */
    int deleteForObj(AutoAnswerMessageVO autoAnswerMessage);

	/**
     * 批量删除帖子留言回复数据信息，通过in数据主键
     * @param autoAnswerMessagelist 帖子留言回复数据信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> autoAnswerMessagelist);

	/**
     * 批量删除帖子留言回复数据指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 帖子留言回复数据信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除帖子留言回复数据指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 帖子留言回复数据信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条帖子留言回复数据的详情信息
     * @param autoAnswerMessageid 帖子留言回复数据信息主键
     * @return 帖子留言回复数据信息对象
     */
    AutoAnswerMessageVO searchById(String autoAnswerMessageid);

	/**
     * 查询一条帖子留言回复数据的详情信息，实现数据行锁定
     * @param autoAnswerMessageid 帖子留言回复数据信息主键
     * @return 帖子留言回复数据信息对象
     */
    AutoAnswerMessageVO searchByIdUpdate(String autoAnswerMessageid);

	/**
     * 批量查询帖子留言回复数据信息，通过in数据主键
     * @param autoAnswerMessagelist 帖子留言回复数据信息主键列表
     * @return 帖子留言回复数据信息对象列表
     */
    List<AutoAnswerMessageVO> searchBatch(List<String> autoAnswerMessagelist);

	/**
     * 获取帖子留言回复数据指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 帖子留言回复数据信息map对象
     * @return 帖子留言回复数据信息对象列表
     */
    List<AutoAnswerMessageVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条帖子留言回复数据信息表信息，=条件判断符
     * @param autoAnswerMessage 帖子留言回复数据信息对象
     * @return 帖子留言回复数据信息对象
     */
    AutoAnswerMessageVO searchObjByObj(AutoAnswerMessageVO autoAnswerMessage);

	/**
     * 获取符合条件的帖子留言回复数据信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param autoAnswerMessage 帖子留言回复数据信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(AutoAnswerMessageVO autoAnswerMessage);

	/**
     * 获取符合条件的全部帖子留言回复数据信息，=条件判断符
     * @param autoAnswerMessage 帖子留言回复数据信息对象
     * @return 帖子留言回复数据信息对象列表
     */
    List<AutoAnswerMessageVO> searchListByObj(AutoAnswerMessageVO autoAnswerMessage);
	
    /**
     * 获取符合条件的全部帖子留言回复数据信息，支持动态关联分页查询
     * @param autoAnswerMessage 帖子留言回复数据信息对象
     * @return 帖子留言回复数据信息对象列表
     */
    List<AutoAnswerMessageVO> searchListPageByObj(AutoAnswerMessageVO autoAnswerMessage);
	
    /**
     * 获取符合条件的全部帖子留言回复数据信息，支持动态关联分页查询
     * @param autoAnswerMessage 帖子留言回复数据信息对象
     * @return 帖子留言回复数据信息对象列表
     */
    List<AutoAnswerMessageVO> searchListPageByObjOr(AutoAnswerMessageVO autoAnswerMessage);
	
    /**
     * 获取符合条件的全部帖子留言回复数据信息，支持动态关联分页查询
     * @param autoAnswerMessage 帖子留言回复数据信息对象
     * @return 帖子留言回复数据信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(AutoAnswerMessageVO autoAnswerMessage);
	
    /**
     * 获取符合条件的全部帖子留言回复数据信息，支持动态关联分页查询
     * @param autoAnswerMessage 帖子留言回复数据信息对象
     * @return 帖子留言回复数据信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(AutoAnswerMessageVO autoAnswerMessage);
    
}