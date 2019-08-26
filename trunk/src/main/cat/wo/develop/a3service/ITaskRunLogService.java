package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.TaskRunLogVO;

import com.github.pagehelper.PageInfo;

/**
 * 任务执行记录信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface ITaskRunLogService {
	
	/**
	 * 插入一条【任务执行记录】信息
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(TaskRunLogVO taskRunLogVO);
	
	/**
	 * 插入一条【任务执行记录】信息
	 * @param map 任务执行记录信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【任务执行记录】信息
	 * @param json 任务执行记录json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【任务执行记录】信息
	 * @param objlist 任务执行记录信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<TaskRunLogVO> objlist);
	
	/**
	 * 批量插入【任务执行记录】信息
	 * @param maplist 任务执行记录信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【任务执行记录】信息
	 * @param obj 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(TaskRunLogVO obj) throws Exception;
	
	/**
	 * 更新一条【任务执行记录】信息
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(TaskRunLogVO taskRunLogVO);
	
	/**
	 * 更新一条【任务执行记录】信息
	 * @param map 任务执行记录信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【任务执行记录】信息
	 * @param objlist 任务执行记录信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<TaskRunLogVO> objlist);
	
	/**
	 * 批量更新【任务执行记录】信息
	 * @param maplist 任务执行记录信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【任务执行记录】信息
	 * @param map 任务执行记录信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【任务执行记录】信息
	 * @param id 任务执行记录信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【任务执行记录】信息
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(TaskRunLogVO taskRunLogVO);

	/**
	 * 删除一条【任务执行记录】信息
	 * @param map 任务执行记录信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【任务执行记录】信息
	 * @param taskRunLoglist 任务执行记录信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> taskRunLoglist) throws Exception;
	
	/**
	 * 批量删除【任务执行记录】信息
	 * @param taskRunLoglist 任务执行记录信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<TaskRunLogVO> taskRunLoglist) throws Exception;
	
	/**
	 * 批量删除【任务执行记录】信息
	 * @param maplist 任务执行记录信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【任务执行记录】信息
	 * @param taskRunLogid 任务执行记录信息主键
	 * @return 任务执行记录信息对象
	 */
	public TaskRunLogVO searchById(String taskRunLogid) throws Exception;
	
	/**
	 * 批量查询【任务执行记录】信息
	 * @param uiids 任务执行记录信息主键列表
	 * @return 任务执行记录信息对象列表
	 */
	public List<TaskRunLogVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param taskRunLogVO 任务执行记录信息主键
     * @return 任务执行记录信息对象列表
     */
	public List<TaskRunLogVO> searchByMoreId(TaskRunLogVO taskRunLogVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 任务执行记录信息json对象
     * @return 任务执行记录信息对象列表
     */
	public List<TaskRunLogVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 任务执行记录信息map对象
     * @return 任务执行记录信息对象列表
     */
	public List<TaskRunLogVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(TaskRunLogVO taskRunLogVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 任务执行记录信息对象
	 */
	public TaskRunLogVO searchObjByObj(TaskRunLogVO taskRunLogVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 任务执行记录信息对象列表，含分页对象
	 */
	public PageInfo<TaskRunLogVO> searchListByObj(TaskRunLogVO taskRunLogVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 任务执行记录信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 任务执行记录信息对象列表，含分页对象
	 */
	public PageInfo<TaskRunLogVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 任务执行记录信息对象列表，含分页对象
	 */
	public PageInfo<TaskRunLogVO> searchListPageByObj(TaskRunLogVO taskRunLogVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 任务执行记录信息对象列表，含分页对象
	 */
	public PageInfo<TaskRunLogVO> searchListPageByObjOr(TaskRunLogVO taskRunLogVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 任务执行记录信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(TaskRunLogVO taskRunLogVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 任务执行记录信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(TaskRunLogVO taskRunLogVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【任务执行记录】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 任务执行记录信息对象
	 * taskRunLogVO
	 * pageNo
	 * pageSize
	 * @return 任务执行记录信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	
}
