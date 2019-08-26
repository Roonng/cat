package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.SoftTaskStepVO;

import com.github.pagehelper.PageInfo;

/**
 * 业务操作步骤信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface ISoftTaskStepService {
	
	/**
	 * 插入一条【业务操作步骤】信息
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(SoftTaskStepVO softTaskStepVO);
	
	/**
	 * 插入一条【业务操作步骤】信息
	 * @param map 业务操作步骤信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【业务操作步骤】信息
	 * @param json 业务操作步骤json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【业务操作步骤】信息
	 * @param objlist 业务操作步骤信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<SoftTaskStepVO> objlist);
	
	/**
	 * 批量插入【业务操作步骤】信息
	 * @param maplist 业务操作步骤信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【业务操作步骤】信息
	 * @param obj 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(SoftTaskStepVO obj) throws Exception;
	
	/**
	 * 更新一条【业务操作步骤】信息
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(SoftTaskStepVO softTaskStepVO);
	
	/**
	 * 更新一条【业务操作步骤】信息
	 * @param map 业务操作步骤信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【业务操作步骤】信息
	 * @param objlist 业务操作步骤信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<SoftTaskStepVO> objlist);
	
	/**
	 * 批量更新【业务操作步骤】信息
	 * @param maplist 业务操作步骤信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【业务操作步骤】信息
	 * @param map 业务操作步骤信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【业务操作步骤】信息
	 * @param id 业务操作步骤信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【业务操作步骤】信息
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(SoftTaskStepVO softTaskStepVO);

	/**
	 * 删除一条【业务操作步骤】信息
	 * @param map 业务操作步骤信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【业务操作步骤】信息
	 * @param softTaskSteplist 业务操作步骤信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> softTaskSteplist) throws Exception;
	
	/**
	 * 批量删除【业务操作步骤】信息
	 * @param softTaskSteplist 业务操作步骤信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<SoftTaskStepVO> softTaskSteplist) throws Exception;
	
	/**
	 * 批量删除【业务操作步骤】信息
	 * @param maplist 业务操作步骤信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【业务操作步骤】信息
	 * @param softTaskStepid 业务操作步骤信息主键
	 * @return 业务操作步骤信息对象
	 */
	public SoftTaskStepVO searchById(String softTaskStepid) throws Exception;
	
	/**
	 * 批量查询【业务操作步骤】信息
	 * @param uiids 业务操作步骤信息主键列表
	 * @return 业务操作步骤信息对象列表
	 */
	public List<SoftTaskStepVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param softTaskStepVO 业务操作步骤信息主键
     * @return 业务操作步骤信息对象列表
     */
	public List<SoftTaskStepVO> searchByMoreId(SoftTaskStepVO softTaskStepVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 业务操作步骤信息json对象
     * @return 业务操作步骤信息对象列表
     */
	public List<SoftTaskStepVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 业务操作步骤信息map对象
     * @return 业务操作步骤信息对象列表
     */
	public List<SoftTaskStepVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(SoftTaskStepVO softTaskStepVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 业务操作步骤信息对象
	 */
	public SoftTaskStepVO searchObjByObj(SoftTaskStepVO softTaskStepVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 业务操作步骤信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskStepVO> searchListByObj(SoftTaskStepVO softTaskStepVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 业务操作步骤信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务操作步骤信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskStepVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务操作步骤信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskStepVO> searchListPageByObj(SoftTaskStepVO softTaskStepVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务操作步骤信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskStepVO> searchListPageByObjOr(SoftTaskStepVO softTaskStepVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务操作步骤信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(SoftTaskStepVO softTaskStepVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务操作步骤信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(SoftTaskStepVO softTaskStepVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【业务操作步骤】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 业务操作步骤信息对象
	 * softTaskStepVO
	 * pageNo
	 * pageSize
	 * @return 业务操作步骤信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	/**
	 * 数据排序
	 * @param sort 列表排序数据UIID列表
	 * @return 排序更新条数
	 */
	public int listsort(String sort) throws Exception;
	
}
