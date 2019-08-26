/*
 * @ClassName SoftInfoDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.SoftInfoVO;

/**
 * 软件管理dao接口类
 * @author 彭羽飞
 *
 */
public interface ISoftInfoDao {
	
	/**
	 * 新增一条软件管理信息
	 * @param softInfo 软件管理对象
	 * @return 成功更新条数
	 */
    int insert(SoftInfoVO softInfo);

	/**
     * 批量新增软件管理信息
     * @param softInfolist 软件管理对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<SoftInfoVO> softInfolist);

	/**
     * 更新一条软件管理信息
     * @param softInfo 软件管理对象
     * @return 成功更新条数
     */
    int update(SoftInfoVO softInfo);
    
	/**
     * 批量更新软件管理信息
     * @param softInfolist 软件管理对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<SoftInfoVO> softInfolist);
    
	/**
     * 批量更新软件管理信息
     * @param datamap 软件管理对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条软件管理信息
     * @param softInfoid 软件管理信息主键
     * @return 成功更新条数
     */
    int delete(String softInfoid);
    
    /**
     * 删除符合软件管理条件的全部信息
     * @param softInfo 软件管理对象
     * @return 成功更新条数
     */
    int deleteForObj(SoftInfoVO softInfo);

	/**
     * 批量删除软件管理信息，通过in数据主键
     * @param softInfolist 软件管理信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> softInfolist);

	/**
     * 批量删除软件管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 软件管理信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除软件管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 软件管理信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条软件管理的详情信息
     * @param softInfoid 软件管理信息主键
     * @return 软件管理信息对象
     */
    SoftInfoVO searchById(String softInfoid);

	/**
     * 查询一条软件管理的详情信息，实现数据行锁定
     * @param softInfoid 软件管理信息主键
     * @return 软件管理信息对象
     */
    SoftInfoVO searchByIdUpdate(String softInfoid);

	/**
     * 批量查询软件管理信息，通过in数据主键
     * @param softInfolist 软件管理信息主键列表
     * @return 软件管理信息对象列表
     */
    List<SoftInfoVO> searchBatch(List<String> softInfolist);

	/**
     * 获取软件管理指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 软件管理信息map对象
     * @return 软件管理信息对象列表
     */
    List<SoftInfoVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条软件管理信息表信息，=条件判断符
     * @param softInfo 软件管理信息对象
     * @return 软件管理信息对象
     */
    SoftInfoVO searchObjByObj(SoftInfoVO softInfo);

	/**
     * 获取符合条件的软件管理信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param softInfo 软件管理信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(SoftInfoVO softInfo);

	/**
     * 获取符合条件的全部软件管理信息，=条件判断符
     * @param softInfo 软件管理信息对象
     * @return 软件管理信息对象列表
     */
    List<SoftInfoVO> searchListByObj(SoftInfoVO softInfo);
	
    /**
     * 获取符合条件的全部软件管理信息，支持动态关联分页查询
     * @param softInfo 软件管理信息对象
     * @return 软件管理信息对象列表
     */
    List<SoftInfoVO> searchListPageByObj(SoftInfoVO softInfo);
	
    /**
     * 获取符合条件的全部软件管理信息，支持动态关联分页查询
     * @param softInfo 软件管理信息对象
     * @return 软件管理信息对象列表
     */
    List<SoftInfoVO> searchListPageByObjOr(SoftInfoVO softInfo);
	
    /**
     * 获取符合条件的全部软件管理信息，支持动态关联分页查询
     * @param softInfo 软件管理信息对象
     * @return 软件管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(SoftInfoVO softInfo);
	
    /**
     * 获取符合条件的全部软件管理信息，支持动态关联分页查询
     * @param softInfo 软件管理信息对象
     * @return 软件管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(SoftInfoVO softInfo);
    
}