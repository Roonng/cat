/*
 * @ClassName SoftTaskDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.SoftTaskVO;

/**
 * 软件业务管理dao接口类
 * @author 彭羽飞
 *
 */
public interface ISoftTaskDao {
	
	/**
	 * 新增一条软件业务管理信息
	 * @param softTask 软件业务管理对象
	 * @return 成功更新条数
	 */
    int insert(SoftTaskVO softTask);

	/**
     * 批量新增软件业务管理信息
     * @param softTasklist 软件业务管理对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<SoftTaskVO> softTasklist);

	/**
     * 更新一条软件业务管理信息
     * @param softTask 软件业务管理对象
     * @return 成功更新条数
     */
    int update(SoftTaskVO softTask);
    
	/**
     * 批量更新软件业务管理信息
     * @param softTasklist 软件业务管理对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<SoftTaskVO> softTasklist);
    
	/**
     * 批量更新软件业务管理信息
     * @param datamap 软件业务管理对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条软件业务管理信息
     * @param softTaskid 软件业务管理信息主键
     * @return 成功更新条数
     */
    int delete(String softTaskid);
    
    /**
     * 删除符合软件业务管理条件的全部信息
     * @param softTask 软件业务管理对象
     * @return 成功更新条数
     */
    int deleteForObj(SoftTaskVO softTask);

	/**
     * 批量删除软件业务管理信息，通过in数据主键
     * @param softTasklist 软件业务管理信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> softTasklist);

	/**
     * 批量删除软件业务管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 软件业务管理信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除软件业务管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 软件业务管理信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条软件业务管理的详情信息
     * @param softTaskid 软件业务管理信息主键
     * @return 软件业务管理信息对象
     */
    SoftTaskVO searchById(String softTaskid);

	/**
     * 查询一条软件业务管理的详情信息，实现数据行锁定
     * @param softTaskid 软件业务管理信息主键
     * @return 软件业务管理信息对象
     */
    SoftTaskVO searchByIdUpdate(String softTaskid);

	/**
     * 批量查询软件业务管理信息，通过in数据主键
     * @param softTasklist 软件业务管理信息主键列表
     * @return 软件业务管理信息对象列表
     */
    List<SoftTaskVO> searchBatch(List<String> softTasklist);

	/**
     * 获取软件业务管理指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 软件业务管理信息map对象
     * @return 软件业务管理信息对象列表
     */
    List<SoftTaskVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条软件业务管理信息表信息，=条件判断符
     * @param softTask 软件业务管理信息对象
     * @return 软件业务管理信息对象
     */
    SoftTaskVO searchObjByObj(SoftTaskVO softTask);

	/**
     * 获取符合条件的软件业务管理信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param softTask 软件业务管理信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(SoftTaskVO softTask);

	/**
     * 获取符合条件的全部软件业务管理信息，=条件判断符
     * @param softTask 软件业务管理信息对象
     * @return 软件业务管理信息对象列表
     */
    List<SoftTaskVO> searchListByObj(SoftTaskVO softTask);
	
    /**
     * 获取符合条件的全部软件业务管理信息，支持动态关联分页查询
     * @param softTask 软件业务管理信息对象
     * @return 软件业务管理信息对象列表
     */
    List<SoftTaskVO> searchListPageByObj(SoftTaskVO softTask);
	
    /**
     * 获取符合条件的全部软件业务管理信息，支持动态关联分页查询
     * @param softTask 软件业务管理信息对象
     * @return 软件业务管理信息对象列表
     */
    List<SoftTaskVO> searchListPageByObjOr(SoftTaskVO softTask);
	
    /**
     * 获取符合条件的全部软件业务管理信息，支持动态关联分页查询
     * @param softTask 软件业务管理信息对象
     * @return 软件业务管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(SoftTaskVO softTask);
	
    /**
     * 获取符合条件的全部软件业务管理信息，支持动态关联分页查询
     * @param softTask 软件业务管理信息对象
     * @return 软件业务管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(SoftTaskVO softTask);
    
}