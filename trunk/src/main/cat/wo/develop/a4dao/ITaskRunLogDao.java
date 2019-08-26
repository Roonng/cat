/*
 * @ClassName TaskRunLogDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.TaskRunLogVO;

/**
 * 任务执行记录dao接口类
 * @author 彭羽飞
 *
 */
public interface ITaskRunLogDao {
	
	/**
	 * 新增一条任务执行记录信息
	 * @param taskRunLog 任务执行记录对象
	 * @return 成功更新条数
	 */
    int insert(TaskRunLogVO taskRunLog);

	/**
     * 批量新增任务执行记录信息
     * @param taskRunLoglist 任务执行记录对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<TaskRunLogVO> taskRunLoglist);

	/**
     * 更新一条任务执行记录信息
     * @param taskRunLog 任务执行记录对象
     * @return 成功更新条数
     */
    int update(TaskRunLogVO taskRunLog);
    
	/**
     * 批量更新任务执行记录信息
     * @param taskRunLoglist 任务执行记录对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<TaskRunLogVO> taskRunLoglist);
    
	/**
     * 批量更新任务执行记录信息
     * @param datamap 任务执行记录对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条任务执行记录信息
     * @param taskRunLogid 任务执行记录信息主键
     * @return 成功更新条数
     */
    int delete(String taskRunLogid);
    
    /**
     * 删除符合任务执行记录条件的全部信息
     * @param taskRunLog 任务执行记录对象
     * @return 成功更新条数
     */
    int deleteForObj(TaskRunLogVO taskRunLog);

	/**
     * 批量删除任务执行记录信息，通过in数据主键
     * @param taskRunLoglist 任务执行记录信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> taskRunLoglist);

	/**
     * 批量删除任务执行记录指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 任务执行记录信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除任务执行记录指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 任务执行记录信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条任务执行记录的详情信息
     * @param taskRunLogid 任务执行记录信息主键
     * @return 任务执行记录信息对象
     */
    TaskRunLogVO searchById(String taskRunLogid);

	/**
     * 查询一条任务执行记录的详情信息，实现数据行锁定
     * @param taskRunLogid 任务执行记录信息主键
     * @return 任务执行记录信息对象
     */
    TaskRunLogVO searchByIdUpdate(String taskRunLogid);

	/**
     * 批量查询任务执行记录信息，通过in数据主键
     * @param taskRunLoglist 任务执行记录信息主键列表
     * @return 任务执行记录信息对象列表
     */
    List<TaskRunLogVO> searchBatch(List<String> taskRunLoglist);

	/**
     * 获取任务执行记录指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 任务执行记录信息map对象
     * @return 任务执行记录信息对象列表
     */
    List<TaskRunLogVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条任务执行记录信息表信息，=条件判断符
     * @param taskRunLog 任务执行记录信息对象
     * @return 任务执行记录信息对象
     */
    TaskRunLogVO searchObjByObj(TaskRunLogVO taskRunLog);

	/**
     * 获取符合条件的任务执行记录信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param taskRunLog 任务执行记录信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(TaskRunLogVO taskRunLog);

	/**
     * 获取符合条件的全部任务执行记录信息，=条件判断符
     * @param taskRunLog 任务执行记录信息对象
     * @return 任务执行记录信息对象列表
     */
    List<TaskRunLogVO> searchListByObj(TaskRunLogVO taskRunLog);
	
    /**
     * 获取符合条件的全部任务执行记录信息，支持动态关联分页查询
     * @param taskRunLog 任务执行记录信息对象
     * @return 任务执行记录信息对象列表
     */
    List<TaskRunLogVO> searchListPageByObj(TaskRunLogVO taskRunLog);
	
    /**
     * 获取符合条件的全部任务执行记录信息，支持动态关联分页查询
     * @param taskRunLog 任务执行记录信息对象
     * @return 任务执行记录信息对象列表
     */
    List<TaskRunLogVO> searchListPageByObjOr(TaskRunLogVO taskRunLog);
	
    /**
     * 获取符合条件的全部任务执行记录信息，支持动态关联分页查询
     * @param taskRunLog 任务执行记录信息对象
     * @return 任务执行记录信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(TaskRunLogVO taskRunLog);
	
    /**
     * 获取符合条件的全部任务执行记录信息，支持动态关联分页查询
     * @param taskRunLog 任务执行记录信息对象
     * @return 任务执行记录信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(TaskRunLogVO taskRunLog);
    
}