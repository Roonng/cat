/*
 * @ClassName SoftAccountDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.SoftAccountVO;

/**
 * 登录帐号信息dao接口类
 * @author 彭羽飞
 *
 */
public interface ISoftAccountDao {
	
	/**
	 * 新增一条登录帐号信息信息
	 * @param softAccount 登录帐号信息对象
	 * @return 成功更新条数
	 */
    int insert(SoftAccountVO softAccount);

	/**
     * 批量新增登录帐号信息信息
     * @param softAccountlist 登录帐号信息对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<SoftAccountVO> softAccountlist);

	/**
     * 更新一条登录帐号信息信息
     * @param softAccount 登录帐号信息对象
     * @return 成功更新条数
     */
    int update(SoftAccountVO softAccount);
    
	/**
     * 批量更新登录帐号信息信息
     * @param softAccountlist 登录帐号信息对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<SoftAccountVO> softAccountlist);
    
	/**
     * 批量更新登录帐号信息信息
     * @param datamap 登录帐号信息对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条登录帐号信息信息
     * @param softAccountid 登录帐号信息信息主键
     * @return 成功更新条数
     */
    int delete(String softAccountid);
    
    /**
     * 删除符合登录帐号信息条件的全部信息
     * @param softAccount 登录帐号信息对象
     * @return 成功更新条数
     */
    int deleteForObj(SoftAccountVO softAccount);

	/**
     * 批量删除登录帐号信息信息，通过in数据主键
     * @param softAccountlist 登录帐号信息信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> softAccountlist);

	/**
     * 批量删除登录帐号信息指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 登录帐号信息信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除登录帐号信息指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 登录帐号信息信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条登录帐号信息的详情信息
     * @param softAccountid 登录帐号信息信息主键
     * @return 登录帐号信息信息对象
     */
    SoftAccountVO searchById(String softAccountid);

	/**
     * 查询一条登录帐号信息的详情信息，实现数据行锁定
     * @param softAccountid 登录帐号信息信息主键
     * @return 登录帐号信息信息对象
     */
    SoftAccountVO searchByIdUpdate(String softAccountid);

	/**
     * 批量查询登录帐号信息信息，通过in数据主键
     * @param softAccountlist 登录帐号信息信息主键列表
     * @return 登录帐号信息信息对象列表
     */
    List<SoftAccountVO> searchBatch(List<String> softAccountlist);

	/**
     * 获取登录帐号信息指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 登录帐号信息信息map对象
     * @return 登录帐号信息信息对象列表
     */
    List<SoftAccountVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条登录帐号信息信息表信息，=条件判断符
     * @param softAccount 登录帐号信息信息对象
     * @return 登录帐号信息信息对象
     */
    SoftAccountVO searchObjByObj(SoftAccountVO softAccount);

	/**
     * 获取符合条件的登录帐号信息信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param softAccount 登录帐号信息信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(SoftAccountVO softAccount);

	/**
     * 获取符合条件的全部登录帐号信息信息，=条件判断符
     * @param softAccount 登录帐号信息信息对象
     * @return 登录帐号信息信息对象列表
     */
    List<SoftAccountVO> searchListByObj(SoftAccountVO softAccount);
	
    /**
     * 获取符合条件的全部登录帐号信息信息，支持动态关联分页查询
     * @param softAccount 登录帐号信息信息对象
     * @return 登录帐号信息信息对象列表
     */
    List<SoftAccountVO> searchListPageByObj(SoftAccountVO softAccount);
	
    /**
     * 获取符合条件的全部登录帐号信息信息，支持动态关联分页查询
     * @param softAccount 登录帐号信息信息对象
     * @return 登录帐号信息信息对象列表
     */
    List<SoftAccountVO> searchListPageByObjOr(SoftAccountVO softAccount);
	
    /**
     * 获取符合条件的全部登录帐号信息信息，支持动态关联分页查询
     * @param softAccount 登录帐号信息信息对象
     * @return 登录帐号信息信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(SoftAccountVO softAccount);
	
    /**
     * 获取符合条件的全部登录帐号信息信息，支持动态关联分页查询
     * @param softAccount 登录帐号信息信息对象
     * @return 登录帐号信息信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(SoftAccountVO softAccount);
    
}