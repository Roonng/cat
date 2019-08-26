package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.SoftAccountVO;

import com.github.pagehelper.PageInfo;

/**
 * 登录帐号信息信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface ISoftAccountService {
	
	/**
	 * 插入一条【登录帐号信息】信息
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(SoftAccountVO softAccountVO);
	
	/**
	 * 插入一条【登录帐号信息】信息
	 * @param map 登录帐号信息信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【登录帐号信息】信息
	 * @param json 登录帐号信息json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【登录帐号信息】信息
	 * @param objlist 登录帐号信息信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<SoftAccountVO> objlist);
	
	/**
	 * 批量插入【登录帐号信息】信息
	 * @param maplist 登录帐号信息信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【登录帐号信息】信息
	 * @param obj 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(SoftAccountVO obj) throws Exception;
	
	/**
	 * 更新一条【登录帐号信息】信息
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(SoftAccountVO softAccountVO);
	
	/**
	 * 更新一条【登录帐号信息】信息
	 * @param map 登录帐号信息信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【登录帐号信息】信息
	 * @param objlist 登录帐号信息信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<SoftAccountVO> objlist);
	
	/**
	 * 批量更新【登录帐号信息】信息
	 * @param maplist 登录帐号信息信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【登录帐号信息】信息
	 * @param map 登录帐号信息信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【登录帐号信息】信息
	 * @param id 登录帐号信息信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【登录帐号信息】信息
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(SoftAccountVO softAccountVO);

	/**
	 * 删除一条【登录帐号信息】信息
	 * @param map 登录帐号信息信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【登录帐号信息】信息
	 * @param softAccountlist 登录帐号信息信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> softAccountlist) throws Exception;
	
	/**
	 * 批量删除【登录帐号信息】信息
	 * @param softAccountlist 登录帐号信息信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<SoftAccountVO> softAccountlist) throws Exception;
	
	/**
	 * 批量删除【登录帐号信息】信息
	 * @param maplist 登录帐号信息信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【登录帐号信息】信息
	 * @param softAccountid 登录帐号信息信息主键
	 * @return 登录帐号信息信息对象
	 */
	public SoftAccountVO searchById(String softAccountid) throws Exception;
	
	/**
	 * 批量查询【登录帐号信息】信息
	 * @param uiids 登录帐号信息信息主键列表
	 * @return 登录帐号信息信息对象列表
	 */
	public List<SoftAccountVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param softAccountVO 登录帐号信息信息主键
     * @return 登录帐号信息信息对象列表
     */
	public List<SoftAccountVO> searchByMoreId(SoftAccountVO softAccountVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 登录帐号信息信息json对象
     * @return 登录帐号信息信息对象列表
     */
	public List<SoftAccountVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 登录帐号信息信息map对象
     * @return 登录帐号信息信息对象列表
     */
	public List<SoftAccountVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(SoftAccountVO softAccountVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 登录帐号信息信息对象
	 */
	public SoftAccountVO searchObjByObj(SoftAccountVO softAccountVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 登录帐号信息信息对象列表，含分页对象
	 */
	public PageInfo<SoftAccountVO> searchListByObj(SoftAccountVO softAccountVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 登录帐号信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 登录帐号信息信息对象列表，含分页对象
	 */
	public PageInfo<SoftAccountVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softAccountVO 登录帐号信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 登录帐号信息信息对象列表，含分页对象
	 */
	public PageInfo<SoftAccountVO> searchListPageByObj(SoftAccountVO softAccountVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softAccountVO 登录帐号信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 登录帐号信息信息对象列表，含分页对象
	 */
	public PageInfo<SoftAccountVO> searchListPageByObjOr(SoftAccountVO softAccountVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softAccountVO 登录帐号信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 登录帐号信息信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(SoftAccountVO softAccountVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softAccountVO 登录帐号信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 登录帐号信息信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(SoftAccountVO softAccountVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【登录帐号信息】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 登录帐号信息信息对象
	 * softAccountVO
	 * pageNo
	 * pageSize
	 * @return 登录帐号信息信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	
}
