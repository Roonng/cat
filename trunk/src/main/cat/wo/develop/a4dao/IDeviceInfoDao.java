/*
 * @ClassName DeviceInfoDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.DeviceInfoVO;

/**
 * 设备信息管理dao接口类
 * @author 彭羽飞
 *
 */
public interface IDeviceInfoDao {
	
	/**
	 * 新增一条设备信息管理信息
	 * @param deviceInfo 设备信息管理对象
	 * @return 成功更新条数
	 */
    int insert(DeviceInfoVO deviceInfo);

	/**
     * 批量新增设备信息管理信息
     * @param deviceInfolist 设备信息管理对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<DeviceInfoVO> deviceInfolist);

	/**
     * 更新一条设备信息管理信息
     * @param deviceInfo 设备信息管理对象
     * @return 成功更新条数
     */
    int update(DeviceInfoVO deviceInfo);
    
	/**
     * 批量更新设备信息管理信息
     * @param deviceInfolist 设备信息管理对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<DeviceInfoVO> deviceInfolist);
    
	/**
     * 批量更新设备信息管理信息
     * @param datamap 设备信息管理对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条设备信息管理信息
     * @param deviceInfoid 设备信息管理信息主键
     * @return 成功更新条数
     */
    int delete(String deviceInfoid);
    
    /**
     * 删除符合设备信息管理条件的全部信息
     * @param deviceInfo 设备信息管理对象
     * @return 成功更新条数
     */
    int deleteForObj(DeviceInfoVO deviceInfo);

	/**
     * 批量删除设备信息管理信息，通过in数据主键
     * @param deviceInfolist 设备信息管理信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> deviceInfolist);

	/**
     * 批量删除设备信息管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 设备信息管理信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除设备信息管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 设备信息管理信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条设备信息管理的详情信息
     * @param deviceInfoid 设备信息管理信息主键
     * @return 设备信息管理信息对象
     */
    DeviceInfoVO searchById(String deviceInfoid);

	/**
     * 查询一条设备信息管理的详情信息，实现数据行锁定
     * @param deviceInfoid 设备信息管理信息主键
     * @return 设备信息管理信息对象
     */
    DeviceInfoVO searchByIdUpdate(String deviceInfoid);

	/**
     * 批量查询设备信息管理信息，通过in数据主键
     * @param deviceInfolist 设备信息管理信息主键列表
     * @return 设备信息管理信息对象列表
     */
    List<DeviceInfoVO> searchBatch(List<String> deviceInfolist);

	/**
     * 获取设备信息管理指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 设备信息管理信息map对象
     * @return 设备信息管理信息对象列表
     */
    List<DeviceInfoVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条设备信息管理信息表信息，=条件判断符
     * @param deviceInfo 设备信息管理信息对象
     * @return 设备信息管理信息对象
     */
    DeviceInfoVO searchObjByObj(DeviceInfoVO deviceInfo);

	/**
     * 获取符合条件的设备信息管理信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param deviceInfo 设备信息管理信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(DeviceInfoVO deviceInfo);

	/**
     * 获取符合条件的全部设备信息管理信息，=条件判断符
     * @param deviceInfo 设备信息管理信息对象
     * @return 设备信息管理信息对象列表
     */
    List<DeviceInfoVO> searchListByObj(DeviceInfoVO deviceInfo);
	
    /**
     * 获取符合条件的全部设备信息管理信息，支持动态关联分页查询
     * @param deviceInfo 设备信息管理信息对象
     * @return 设备信息管理信息对象列表
     */
    List<DeviceInfoVO> searchListPageByObj(DeviceInfoVO deviceInfo);
	
    /**
     * 获取符合条件的全部设备信息管理信息，支持动态关联分页查询
     * @param deviceInfo 设备信息管理信息对象
     * @return 设备信息管理信息对象列表
     */
    List<DeviceInfoVO> searchListPageByObjOr(DeviceInfoVO deviceInfo);
	
    /**
     * 获取符合条件的全部设备信息管理信息，支持动态关联分页查询
     * @param deviceInfo 设备信息管理信息对象
     * @return 设备信息管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(DeviceInfoVO deviceInfo);
	
    /**
     * 获取符合条件的全部设备信息管理信息，支持动态关联分页查询
     * @param deviceInfo 设备信息管理信息对象
     * @return 设备信息管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(DeviceInfoVO deviceInfo);
    
}