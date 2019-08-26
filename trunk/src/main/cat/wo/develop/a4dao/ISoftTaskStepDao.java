/*
 * @ClassName SoftTaskStepDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.SoftTaskStepVO;

/**
 * 业务操作步骤dao接口类
 * @author 彭羽飞
 *
 */
public interface ISoftTaskStepDao {
	
	/**
	 * 新增一条业务操作步骤信息
	 * @param softTaskStep 业务操作步骤对象
	 * @return 成功更新条数
	 */
    int insert(SoftTaskStepVO softTaskStep);

	/**
     * 批量新增业务操作步骤信息
     * @param softTaskSteplist 业务操作步骤对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<SoftTaskStepVO> softTaskSteplist);

	/**
     * 更新一条业务操作步骤信息
     * @param softTaskStep 业务操作步骤对象
     * @return 成功更新条数
     */
    int update(SoftTaskStepVO softTaskStep);
    
	/**
     * 批量更新业务操作步骤信息
     * @param softTaskSteplist 业务操作步骤对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<SoftTaskStepVO> softTaskSteplist);
    
	/**
     * 批量更新业务操作步骤信息
     * @param datamap 业务操作步骤对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条业务操作步骤信息
     * @param softTaskStepid 业务操作步骤信息主键
     * @return 成功更新条数
     */
    int delete(String softTaskStepid);
    
    /**
     * 删除符合业务操作步骤条件的全部信息
     * @param softTaskStep 业务操作步骤对象
     * @return 成功更新条数
     */
    int deleteForObj(SoftTaskStepVO softTaskStep);

	/**
     * 批量删除业务操作步骤信息，通过in数据主键
     * @param softTaskSteplist 业务操作步骤信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> softTaskSteplist);

	/**
     * 批量删除业务操作步骤指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 业务操作步骤信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除业务操作步骤指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 业务操作步骤信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条业务操作步骤的详情信息
     * @param softTaskStepid 业务操作步骤信息主键
     * @return 业务操作步骤信息对象
     */
    SoftTaskStepVO searchById(String softTaskStepid);

	/**
     * 查询一条业务操作步骤的详情信息，实现数据行锁定
     * @param softTaskStepid 业务操作步骤信息主键
     * @return 业务操作步骤信息对象
     */
    SoftTaskStepVO searchByIdUpdate(String softTaskStepid);

	/**
     * 批量查询业务操作步骤信息，通过in数据主键
     * @param softTaskSteplist 业务操作步骤信息主键列表
     * @return 业务操作步骤信息对象列表
     */
    List<SoftTaskStepVO> searchBatch(List<String> softTaskSteplist);

	/**
     * 获取业务操作步骤指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 业务操作步骤信息map对象
     * @return 业务操作步骤信息对象列表
     */
    List<SoftTaskStepVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条业务操作步骤信息表信息，=条件判断符
     * @param softTaskStep 业务操作步骤信息对象
     * @return 业务操作步骤信息对象
     */
    SoftTaskStepVO searchObjByObj(SoftTaskStepVO softTaskStep);

	/**
     * 获取符合条件的业务操作步骤信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param softTaskStep 业务操作步骤信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(SoftTaskStepVO softTaskStep);

	/**
     * 获取符合条件的全部业务操作步骤信息，=条件判断符
     * @param softTaskStep 业务操作步骤信息对象
     * @return 业务操作步骤信息对象列表
     */
    List<SoftTaskStepVO> searchListByObj(SoftTaskStepVO softTaskStep);
	
    /**
     * 获取符合条件的全部业务操作步骤信息，支持动态关联分页查询
     * @param softTaskStep 业务操作步骤信息对象
     * @return 业务操作步骤信息对象列表
     */
    List<SoftTaskStepVO> searchListPageByObj(SoftTaskStepVO softTaskStep);
	
    /**
     * 获取符合条件的全部业务操作步骤信息，支持动态关联分页查询
     * @param softTaskStep 业务操作步骤信息对象
     * @return 业务操作步骤信息对象列表
     */
    List<SoftTaskStepVO> searchListPageByObjOr(SoftTaskStepVO softTaskStep);
	
    /**
     * 获取符合条件的全部业务操作步骤信息，支持动态关联分页查询
     * @param softTaskStep 业务操作步骤信息对象
     * @return 业务操作步骤信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(SoftTaskStepVO softTaskStep);
	
    /**
     * 获取符合条件的全部业务操作步骤信息，支持动态关联分页查询
     * @param softTaskStep 业务操作步骤信息对象
     * @return 业务操作步骤信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(SoftTaskStepVO softTaskStep);
    
}