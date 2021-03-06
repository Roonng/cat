package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.SoftTaskVO;

import com.github.pagehelper.PageInfo;

/**
 * 软件业务管理信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface ISoftTaskService {
	
	/**
	 * 插入一条【软件业务管理】信息
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(SoftTaskVO softTaskVO);
	
	/**
	 * 插入一条【软件业务管理】信息
	 * @param map 软件业务管理信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【软件业务管理】信息
	 * @param json 软件业务管理json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【软件业务管理】信息
	 * @param objlist 软件业务管理信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<SoftTaskVO> objlist);
	
	/**
	 * 批量插入【软件业务管理】信息
	 * @param maplist 软件业务管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【软件业务管理】信息
	 * @param obj 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(SoftTaskVO obj) throws Exception;
	
	/**
	 * 更新一条【软件业务管理】信息
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(SoftTaskVO softTaskVO);
	
	/**
	 * 更新一条【软件业务管理】信息
	 * @param map 软件业务管理信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【软件业务管理】信息
	 * @param objlist 软件业务管理信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<SoftTaskVO> objlist);
	
	/**
	 * 批量更新【软件业务管理】信息
	 * @param maplist 软件业务管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【软件业务管理】信息
	 * @param map 软件业务管理信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【软件业务管理】信息
	 * @param id 软件业务管理信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【软件业务管理】信息
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(SoftTaskVO softTaskVO);

	/**
	 * 删除一条【软件业务管理】信息
	 * @param map 软件业务管理信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【软件业务管理】信息
	 * @param softTasklist 软件业务管理信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> softTasklist) throws Exception;
	
	/**
	 * 批量删除【软件业务管理】信息
	 * @param softTasklist 软件业务管理信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<SoftTaskVO> softTasklist) throws Exception;
	
	/**
	 * 批量删除【软件业务管理】信息
	 * @param maplist 软件业务管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【软件业务管理】信息
	 * @param softTaskid 软件业务管理信息主键
	 * @return 软件业务管理信息对象
	 */
	public SoftTaskVO searchById(String softTaskid) throws Exception;
	
	/**
	 * 批量查询【软件业务管理】信息
	 * @param uiids 软件业务管理信息主键列表
	 * @return 软件业务管理信息对象列表
	 */
	public List<SoftTaskVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param softTaskVO 软件业务管理信息主键
     * @return 软件业务管理信息对象列表
     */
	public List<SoftTaskVO> searchByMoreId(SoftTaskVO softTaskVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 软件业务管理信息json对象
     * @return 软件业务管理信息对象列表
     */
	public List<SoftTaskVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 软件业务管理信息map对象
     * @return 软件业务管理信息对象列表
     */
	public List<SoftTaskVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(SoftTaskVO softTaskVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 软件业务管理信息对象
	 */
	public SoftTaskVO searchObjByObj(SoftTaskVO softTaskVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 软件业务管理信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskVO> searchListByObj(SoftTaskVO softTaskVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 软件业务管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件业务管理信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskVO 软件业务管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件业务管理信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskVO> searchListPageByObj(SoftTaskVO softTaskVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskVO 软件业务管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件业务管理信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskVO> searchListPageByObjOr(SoftTaskVO softTaskVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskVO 软件业务管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件业务管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(SoftTaskVO softTaskVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskVO 软件业务管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件业务管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(SoftTaskVO softTaskVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【软件业务管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 软件业务管理信息对象
	 * softTaskVO
	 * pageNo
	 * pageSize
	 * @return 软件业务管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	/**
	 * 数据排序
	 * @param sort 列表排序数据UIID列表
	 * @return 排序更新条数
	 */
	public int listsort(String sort) throws Exception;
	
}
