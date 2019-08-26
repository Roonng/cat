/*
 * @ClassName DeviceRefAutoDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.DeviceRefAutoVO;

/**
 * 设备任务安排管理dao接口类
 * @author 彭羽飞
 *
 */
public interface IDeviceRefAutoDao {
	
	/**
	 * 新增一条设备任务安排管理信息
	 * @param deviceRefAuto 设备任务安排管理对象
	 * @return 成功更新条数
	 */
    int insert(DeviceRefAutoVO deviceRefAuto);

	/**
     * 批量新增设备任务安排管理信息
     * @param deviceRefAutolist 设备任务安排管理对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<DeviceRefAutoVO> deviceRefAutolist);

	/**
     * 更新一条设备任务安排管理信息
     * @param deviceRefAuto 设备任务安排管理对象
     * @return 成功更新条数
     */
    int update(DeviceRefAutoVO deviceRefAuto);
    
	/**
     * 批量更新设备任务安排管理信息
     * @param deviceRefAutolist 设备任务安排管理对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<DeviceRefAutoVO> deviceRefAutolist);
    
	/**
     * 批量更新设备任务安排管理信息
     * @param datamap 设备任务安排管理对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条设备任务安排管理信息
     * @param deviceRefAutoid 设备任务安排管理信息主键
     * @return 成功更新条数
     */
    int delete(String deviceRefAutoid);
    
    /**
     * 删除符合设备任务安排管理条件的全部信息
     * @param deviceRefAuto 设备任务安排管理对象
     * @return 成功更新条数
     */
    int deleteForObj(DeviceRefAutoVO deviceRefAuto);

	/**
     * 批量删除设备任务安排管理信息，通过in数据主键
     * @param deviceRefAutolist 设备任务安排管理信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> deviceRefAutolist);

	/**
     * 批量删除设备任务安排管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 设备任务安排管理信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除设备任务安排管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 设备任务安排管理信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条设备任务安排管理的详情信息
     * @param deviceRefAutoid 设备任务安排管理信息主键
     * @return 设备任务安排管理信息对象
     */
    DeviceRefAutoVO searchById(String deviceRefAutoid);

	/**
     * 查询一条设备任务安排管理的详情信息，实现数据行锁定
     * @param deviceRefAutoid 设备任务安排管理信息主键
     * @return 设备任务安排管理信息对象
     */
    DeviceRefAutoVO searchByIdUpdate(String deviceRefAutoid);

	/**
     * 批量查询设备任务安排管理信息，通过in数据主键
     * @param deviceRefAutolist 设备任务安排管理信息主键列表
     * @return 设备任务安排管理信息对象列表
     */
    List<DeviceRefAutoVO> searchBatch(List<String> deviceRefAutolist);

	/**
     * 获取设备任务安排管理指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 设备任务安排管理信息map对象
     * @return 设备任务安排管理信息对象列表
     */
    List<DeviceRefAutoVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条设备任务安排管理信息表信息，=条件判断符
     * @param deviceRefAuto 设备任务安排管理信息对象
     * @return 设备任务安排管理信息对象
     */
    DeviceRefAutoVO searchObjByObj(DeviceRefAutoVO deviceRefAuto);

	/**
     * 获取符合条件的设备任务安排管理信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param deviceRefAuto 设备任务安排管理信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(DeviceRefAutoVO deviceRefAuto);

	/**
     * 获取符合条件的全部设备任务安排管理信息，=条件判断符
     * @param deviceRefAuto 设备任务安排管理信息对象
     * @return 设备任务安排管理信息对象列表
     */
    List<DeviceRefAutoVO> searchListByObj(DeviceRefAutoVO deviceRefAuto);
	
    /**
     * 获取符合条件的全部设备任务安排管理信息，支持动态关联分页查询
     * @param deviceRefAuto 设备任务安排管理信息对象
     * @return 设备任务安排管理信息对象列表
     */
    List<DeviceRefAutoVO> searchListPageByObj(DeviceRefAutoVO deviceRefAuto);
	
    /**
     * 获取符合条件的全部设备任务安排管理信息，支持动态关联分页查询
     * @param deviceRefAuto 设备任务安排管理信息对象
     * @return 设备任务安排管理信息对象列表
     */
    List<DeviceRefAutoVO> searchListPageByObjOr(DeviceRefAutoVO deviceRefAuto);
	
    /**
     * 获取符合条件的全部设备任务安排管理信息，支持动态关联分页查询
     * @param deviceRefAuto 设备任务安排管理信息对象
     * @return 设备任务安排管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(DeviceRefAutoVO deviceRefAuto);
	
    /**
     * 获取符合条件的全部设备任务安排管理信息，支持动态关联分页查询
     * @param deviceRefAuto 设备任务安排管理信息对象
     * @return 设备任务安排管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(DeviceRefAutoVO deviceRefAuto);
    
}