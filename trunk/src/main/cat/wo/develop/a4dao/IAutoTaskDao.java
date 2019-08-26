/*
 * @ClassName AutoTaskDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.AutoTaskVO;

/**
 * 业务主题设置dao接口类
 * @author 彭羽飞
 *
 */
public interface IAutoTaskDao {
	
	/**
	 * 新增一条业务主题设置信息
	 * @param autoTask 业务主题设置对象
	 * @return 成功更新条数
	 */
    int insert(AutoTaskVO autoTask);

	/**
     * 批量新增业务主题设置信息
     * @param autoTasklist 业务主题设置对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<AutoTaskVO> autoTasklist);

	/**
     * 更新一条业务主题设置信息
     * @param autoTask 业务主题设置对象
     * @return 成功更新条数
     */
    int update(AutoTaskVO autoTask);
    
	/**
     * 批量更新业务主题设置信息
     * @param autoTasklist 业务主题设置对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<AutoTaskVO> autoTasklist);
    
	/**
     * 批量更新业务主题设置信息
     * @param datamap 业务主题设置对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条业务主题设置信息
     * @param autoTaskid 业务主题设置信息主键
     * @return 成功更新条数
     */
    int delete(String autoTaskid);
    
    /**
     * 删除符合业务主题设置条件的全部信息
     * @param autoTask 业务主题设置对象
     * @return 成功更新条数
     */
    int deleteForObj(AutoTaskVO autoTask);

	/**
     * 批量删除业务主题设置信息，通过in数据主键
     * @param autoTasklist 业务主题设置信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> autoTasklist);

	/**
     * 批量删除业务主题设置指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 业务主题设置信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除业务主题设置指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 业务主题设置信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条业务主题设置的详情信息
     * @param autoTaskid 业务主题设置信息主键
     * @return 业务主题设置信息对象
     */
    AutoTaskVO searchById(String autoTaskid);

	/**
     * 查询一条业务主题设置的详情信息，实现数据行锁定
     * @param autoTaskid 业务主题设置信息主键
     * @return 业务主题设置信息对象
     */
    AutoTaskVO searchByIdUpdate(String autoTaskid);

	/**
     * 批量查询业务主题设置信息，通过in数据主键
     * @param autoTasklist 业务主题设置信息主键列表
     * @return 业务主题设置信息对象列表
     */
    List<AutoTaskVO> searchBatch(List<String> autoTasklist);

	/**
     * 获取业务主题设置指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 业务主题设置信息map对象
     * @return 业务主题设置信息对象列表
     */
    List<AutoTaskVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条业务主题设置信息表信息，=条件判断符
     * @param autoTask 业务主题设置信息对象
     * @return 业务主题设置信息对象
     */
    AutoTaskVO searchObjByObj(AutoTaskVO autoTask);

	/**
     * 获取符合条件的业务主题设置信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param autoTask 业务主题设置信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(AutoTaskVO autoTask);

	/**
     * 获取符合条件的全部业务主题设置信息，=条件判断符
     * @param autoTask 业务主题设置信息对象
     * @return 业务主题设置信息对象列表
     */
    List<AutoTaskVO> searchListByObj(AutoTaskVO autoTask);
	
    /**
     * 获取符合条件的全部业务主题设置信息，支持动态关联分页查询
     * @param autoTask 业务主题设置信息对象
     * @return 业务主题设置信息对象列表
     */
    List<AutoTaskVO> searchListPageByObj(AutoTaskVO autoTask);
	
    /**
     * 获取符合条件的全部业务主题设置信息，支持动态关联分页查询
     * @param autoTask 业务主题设置信息对象
     * @return 业务主题设置信息对象列表
     */
    List<AutoTaskVO> searchListPageByObjOr(AutoTaskVO autoTask);
	
    /**
     * 获取符合条件的全部业务主题设置信息，支持动态关联分页查询
     * @param autoTask 业务主题设置信息对象
     * @return 业务主题设置信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(AutoTaskVO autoTask);
	
    /**
     * 获取符合条件的全部业务主题设置信息，支持动态关联分页查询
     * @param autoTask 业务主题设置信息对象
     * @return 业务主题设置信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(AutoTaskVO autoTask);
    
}