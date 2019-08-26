package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.UserInfoVO;

import com.github.pagehelper.PageInfo;

/**
 * 用户信息管理信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface IUserInfoService {
	
	/**
	 * 插入一条【用户信息管理】信息
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(UserInfoVO userInfoVO);
	
	/**
	 * 插入一条【用户信息管理】信息
	 * @param map 用户信息管理信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【用户信息管理】信息
	 * @param json 用户信息管理json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【用户信息管理】信息
	 * @param objlist 用户信息管理信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<UserInfoVO> objlist);
	
	/**
	 * 批量插入【用户信息管理】信息
	 * @param maplist 用户信息管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【用户信息管理】信息
	 * @param obj 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(UserInfoVO obj) throws Exception;
	
	/**
	 * 更新一条【用户信息管理】信息
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(UserInfoVO userInfoVO);
	
	/**
	 * 更新一条【用户信息管理】信息
	 * @param map 用户信息管理信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【用户信息管理】信息
	 * @param objlist 用户信息管理信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<UserInfoVO> objlist);
	
	/**
	 * 批量更新【用户信息管理】信息
	 * @param maplist 用户信息管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【用户信息管理】信息
	 * @param map 用户信息管理信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【用户信息管理】信息
	 * @param id 用户信息管理信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【用户信息管理】信息
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(UserInfoVO userInfoVO);

	/**
	 * 删除一条【用户信息管理】信息
	 * @param map 用户信息管理信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【用户信息管理】信息
	 * @param userInfolist 用户信息管理信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> userInfolist) throws Exception;
	
	/**
	 * 批量删除【用户信息管理】信息
	 * @param userInfolist 用户信息管理信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<UserInfoVO> userInfolist) throws Exception;
	
	/**
	 * 批量删除【用户信息管理】信息
	 * @param maplist 用户信息管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【用户信息管理】信息
	 * @param userInfoid 用户信息管理信息主键
	 * @return 用户信息管理信息对象
	 */
	public UserInfoVO searchById(String userInfoid) throws Exception;
	
	/**
	 * 批量查询【用户信息管理】信息
	 * @param uiids 用户信息管理信息主键列表
	 * @return 用户信息管理信息对象列表
	 */
	public List<UserInfoVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param userInfoVO 用户信息管理信息主键
     * @return 用户信息管理信息对象列表
     */
	public List<UserInfoVO> searchByMoreId(UserInfoVO userInfoVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 用户信息管理信息json对象
     * @return 用户信息管理信息对象列表
     */
	public List<UserInfoVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 用户信息管理信息map对象
     * @return 用户信息管理信息对象列表
     */
	public List<UserInfoVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(UserInfoVO userInfoVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 用户信息管理信息对象
	 */
	public UserInfoVO searchObjByObj(UserInfoVO userInfoVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 用户信息管理信息对象列表，含分页对象
	 */
	public PageInfo<UserInfoVO> searchListByObj(UserInfoVO userInfoVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 用户信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户信息管理信息对象列表，含分页对象
	 */
	public PageInfo<UserInfoVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userInfoVO 用户信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户信息管理信息对象列表，含分页对象
	 */
	public PageInfo<UserInfoVO> searchListPageByObj(UserInfoVO userInfoVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userInfoVO 用户信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户信息管理信息对象列表，含分页对象
	 */
	public PageInfo<UserInfoVO> searchListPageByObjOr(UserInfoVO userInfoVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userInfoVO 用户信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户信息管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(UserInfoVO userInfoVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userInfoVO 用户信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户信息管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(UserInfoVO userInfoVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【用户信息管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 用户信息管理信息对象
	 * userInfoVO
	 * pageNo
	 * pageSize
	 * @return 用户信息管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	
}
