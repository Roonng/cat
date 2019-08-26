package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.DeviceInfoVO;

import com.github.pagehelper.PageInfo;

/**
 * 设备信息管理信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface IDeviceInfoService {
	
	/**
	 * 插入一条【设备信息管理】信息
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(DeviceInfoVO deviceInfoVO);
	
	/**
	 * 插入一条【设备信息管理】信息
	 * @param map 设备信息管理信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【设备信息管理】信息
	 * @param json 设备信息管理json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【设备信息管理】信息
	 * @param objlist 设备信息管理信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<DeviceInfoVO> objlist);
	
	/**
	 * 批量插入【设备信息管理】信息
	 * @param maplist 设备信息管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【设备信息管理】信息
	 * @param obj 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(DeviceInfoVO obj) throws Exception;
	
	/**
	 * 更新一条【设备信息管理】信息
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(DeviceInfoVO deviceInfoVO);
	
	/**
	 * 更新一条【设备信息管理】信息
	 * @param map 设备信息管理信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【设备信息管理】信息
	 * @param objlist 设备信息管理信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<DeviceInfoVO> objlist);
	
	/**
	 * 批量更新【设备信息管理】信息
	 * @param maplist 设备信息管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【设备信息管理】信息
	 * @param map 设备信息管理信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【设备信息管理】信息
	 * @param id 设备信息管理信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【设备信息管理】信息
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(DeviceInfoVO deviceInfoVO);

	/**
	 * 删除一条【设备信息管理】信息
	 * @param map 设备信息管理信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【设备信息管理】信息
	 * @param deviceInfolist 设备信息管理信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> deviceInfolist) throws Exception;
	
	/**
	 * 批量删除【设备信息管理】信息
	 * @param deviceInfolist 设备信息管理信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<DeviceInfoVO> deviceInfolist) throws Exception;
	
	/**
	 * 批量删除【设备信息管理】信息
	 * @param maplist 设备信息管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【设备信息管理】信息
	 * @param deviceInfoid 设备信息管理信息主键
	 * @return 设备信息管理信息对象
	 */
	public DeviceInfoVO searchById(String deviceInfoid) throws Exception;
	
	/**
	 * 批量查询【设备信息管理】信息
	 * @param uiids 设备信息管理信息主键列表
	 * @return 设备信息管理信息对象列表
	 */
	public List<DeviceInfoVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param deviceInfoVO 设备信息管理信息主键
     * @return 设备信息管理信息对象列表
     */
	public List<DeviceInfoVO> searchByMoreId(DeviceInfoVO deviceInfoVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 设备信息管理信息json对象
     * @return 设备信息管理信息对象列表
     */
	public List<DeviceInfoVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 设备信息管理信息map对象
     * @return 设备信息管理信息对象列表
     */
	public List<DeviceInfoVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(DeviceInfoVO deviceInfoVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 设备信息管理信息对象
	 */
	public DeviceInfoVO searchObjByObj(DeviceInfoVO deviceInfoVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 设备信息管理信息对象列表，含分页对象
	 */
	public PageInfo<DeviceInfoVO> searchListByObj(DeviceInfoVO deviceInfoVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 设备信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备信息管理信息对象列表，含分页对象
	 */
	public PageInfo<DeviceInfoVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备信息管理信息对象列表，含分页对象
	 */
	public PageInfo<DeviceInfoVO> searchListPageByObj(DeviceInfoVO deviceInfoVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备信息管理信息对象列表，含分页对象
	 */
	public PageInfo<DeviceInfoVO> searchListPageByObjOr(DeviceInfoVO deviceInfoVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备信息管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(DeviceInfoVO deviceInfoVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备信息管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(DeviceInfoVO deviceInfoVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【设备信息管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 设备信息管理信息对象
	 * deviceInfoVO
	 * pageNo
	 * pageSize
	 * @return 设备信息管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	
}
