package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.ManageLunVO;

import com.github.pagehelper.PageInfo;

/**
 * 轮播图信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface IManageLunService {
	
	/**
	 * 插入一条【轮播图】信息
	 * @param manageLunVO 轮播图信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(ManageLunVO manageLunVO);
	
	/**
	 * 插入一条【轮播图】信息
	 * @param map 轮播图信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【轮播图】信息
	 * @param json 轮播图json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【轮播图】信息
	 * @param objlist 轮播图信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<ManageLunVO> objlist);
	
	/**
	 * 批量插入【轮播图】信息
	 * @param maplist 轮播图信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【轮播图】信息
	 * @param obj 轮播图信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(ManageLunVO obj) throws Exception;
	
	/**
	 * 更新一条【轮播图】信息
	 * @param manageLunVO 轮播图信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(ManageLunVO manageLunVO);
	
	/**
	 * 更新一条【轮播图】信息
	 * @param map 轮播图信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【轮播图】信息
	 * @param objlist 轮播图信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<ManageLunVO> objlist);
	
	/**
	 * 批量更新【轮播图】信息
	 * @param maplist 轮播图信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【轮播图】信息
	 * @param map 轮播图信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【轮播图】信息
	 * @param id 轮播图信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【轮播图】信息
	 * @param manageLunVO 轮播图信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(ManageLunVO manageLunVO);

	/**
	 * 删除一条【轮播图】信息
	 * @param map 轮播图信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【轮播图】信息
	 * @param manageLunlist 轮播图信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> manageLunlist) throws Exception;
	
	/**
	 * 批量删除【轮播图】信息
	 * @param manageLunlist 轮播图信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<ManageLunVO> manageLunlist) throws Exception;
	
	/**
	 * 批量删除【轮播图】信息
	 * @param maplist 轮播图信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 轮播图信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【轮播图】信息
	 * @param manageLunid 轮播图信息主键
	 * @return 轮播图信息对象
	 */
	public ManageLunVO searchById(String manageLunid) throws Exception;
	
	/**
	 * 批量查询【轮播图】信息
	 * @param uiids 轮播图信息主键列表
	 * @return 轮播图信息对象列表
	 */
	public List<ManageLunVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param manageLunVO 轮播图信息主键
     * @return 轮播图信息对象列表
     */
	public List<ManageLunVO> searchByMoreId(ManageLunVO manageLunVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 轮播图信息json对象
     * @return 轮播图信息对象列表
     */
	public List<ManageLunVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 轮播图信息map对象
     * @return 轮播图信息对象列表
     */
	public List<ManageLunVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param manageLunVO 轮播图信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(ManageLunVO manageLunVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param manageLunVO 轮播图信息对象
	 * @return 轮播图信息对象
	 */
	public ManageLunVO searchObjByObj(ManageLunVO manageLunVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param manageLunVO 轮播图信息对象
	 * @return 轮播图信息对象列表，含分页对象
	 */
	public PageInfo<ManageLunVO> searchListByObj(ManageLunVO manageLunVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 轮播图信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 轮播图信息对象列表，含分页对象
	 */
	public PageInfo<ManageLunVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param manageLunVO 轮播图信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 轮播图信息对象列表，含分页对象
	 */
	public PageInfo<ManageLunVO> searchListPageByObj(ManageLunVO manageLunVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param manageLunVO 轮播图信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 轮播图信息对象列表，含分页对象
	 */
	public PageInfo<ManageLunVO> searchListPageByObjOr(ManageLunVO manageLunVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param manageLunVO 轮播图信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 轮播图信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(ManageLunVO manageLunVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param manageLunVO 轮播图信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 轮播图信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(ManageLunVO manageLunVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【轮播图】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 轮播图信息对象
	 * manageLunVO
	 * pageNo
	 * pageSize
	 * @return 轮播图信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	/**
	 * 数据排序
	 * @param sort 列表排序数据UIID列表
	 * @return 排序更新条数
	 */
	public int listsort(String sort) throws Exception;
	
}
