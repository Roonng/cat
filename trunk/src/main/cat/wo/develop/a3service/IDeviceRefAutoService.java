package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.DeviceRefAutoVO;

import com.github.pagehelper.PageInfo;

/**
 * 设备任务安排管理信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface IDeviceRefAutoService {
	
	/**
	 * 插入一条【设备任务安排管理】信息
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(DeviceRefAutoVO deviceRefAutoVO);
	
	/**
	 * 插入一条【设备任务安排管理】信息
	 * @param map 设备任务安排管理信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【设备任务安排管理】信息
	 * @param json 设备任务安排管理json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【设备任务安排管理】信息
	 * @param objlist 设备任务安排管理信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<DeviceRefAutoVO> objlist);
	
	/**
	 * 批量插入【设备任务安排管理】信息
	 * @param maplist 设备任务安排管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【设备任务安排管理】信息
	 * @param obj 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(DeviceRefAutoVO obj) throws Exception;
	
	/**
	 * 更新一条【设备任务安排管理】信息
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(DeviceRefAutoVO deviceRefAutoVO);
	
	/**
	 * 更新一条【设备任务安排管理】信息
	 * @param map 设备任务安排管理信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【设备任务安排管理】信息
	 * @param objlist 设备任务安排管理信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<DeviceRefAutoVO> objlist);
	
	/**
	 * 批量更新【设备任务安排管理】信息
	 * @param maplist 设备任务安排管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【设备任务安排管理】信息
	 * @param map 设备任务安排管理信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【设备任务安排管理】信息
	 * @param id 设备任务安排管理信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【设备任务安排管理】信息
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(DeviceRefAutoVO deviceRefAutoVO);

	/**
	 * 删除一条【设备任务安排管理】信息
	 * @param map 设备任务安排管理信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【设备任务安排管理】信息
	 * @param deviceRefAutolist 设备任务安排管理信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> deviceRefAutolist) throws Exception;
	
	/**
	 * 批量删除【设备任务安排管理】信息
	 * @param deviceRefAutolist 设备任务安排管理信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<DeviceRefAutoVO> deviceRefAutolist) throws Exception;
	
	/**
	 * 批量删除【设备任务安排管理】信息
	 * @param maplist 设备任务安排管理信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【设备任务安排管理】信息
	 * @param deviceRefAutoid 设备任务安排管理信息主键
	 * @return 设备任务安排管理信息对象
	 */
	public DeviceRefAutoVO searchById(String deviceRefAutoid) throws Exception;
	
	/**
	 * 批量查询【设备任务安排管理】信息
	 * @param uiids 设备任务安排管理信息主键列表
	 * @return 设备任务安排管理信息对象列表
	 */
	public List<DeviceRefAutoVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param deviceRefAutoVO 设备任务安排管理信息主键
     * @return 设备任务安排管理信息对象列表
     */
	public List<DeviceRefAutoVO> searchByMoreId(DeviceRefAutoVO deviceRefAutoVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 设备任务安排管理信息json对象
     * @return 设备任务安排管理信息对象列表
     */
	public List<DeviceRefAutoVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 设备任务安排管理信息map对象
     * @return 设备任务安排管理信息对象列表
     */
	public List<DeviceRefAutoVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(DeviceRefAutoVO deviceRefAutoVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 设备任务安排管理信息对象
	 */
	public DeviceRefAutoVO searchObjByObj(DeviceRefAutoVO deviceRefAutoVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 设备任务安排管理信息对象列表，含分页对象
	 */
	public PageInfo<DeviceRefAutoVO> searchListByObj(DeviceRefAutoVO deviceRefAutoVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 设备任务安排管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备任务安排管理信息对象列表，含分页对象
	 */
	public PageInfo<DeviceRefAutoVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备任务安排管理信息对象列表，含分页对象
	 */
	public PageInfo<DeviceRefAutoVO> searchListPageByObj(DeviceRefAutoVO deviceRefAutoVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备任务安排管理信息对象列表，含分页对象
	 */
	public PageInfo<DeviceRefAutoVO> searchListPageByObjOr(DeviceRefAutoVO deviceRefAutoVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备任务安排管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(DeviceRefAutoVO deviceRefAutoVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备任务安排管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(DeviceRefAutoVO deviceRefAutoVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【设备任务安排管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 设备任务安排管理信息对象
	 * deviceRefAutoVO
	 * pageNo
	 * pageSize
	 * @return 设备任务安排管理信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	
}
