/*
 * @ClassName AProductReleaseDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.AProductReleaseVO;

/**
 * 产品发布管理dao接口类
 * @author 彭羽飞
 *
 */
public interface IAProductReleaseDao {
	
	/**
	 * 新增一条产品发布管理信息
	 * @param aProductRelease 产品发布管理对象
	 * @return 成功更新条数
	 */
    int insert(AProductReleaseVO aProductRelease);

	/**
     * 批量新增产品发布管理信息
     * @param aProductReleaselist 产品发布管理对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<AProductReleaseVO> aProductReleaselist);

	/**
     * 更新一条产品发布管理信息
     * @param aProductRelease 产品发布管理对象
     * @return 成功更新条数
     */
    int update(AProductReleaseVO aProductRelease);
    
	/**
     * 批量更新产品发布管理信息
     * @param aProductReleaselist 产品发布管理对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<AProductReleaseVO> aProductReleaselist);
    
	/**
     * 批量更新产品发布管理信息
     * @param datamap 产品发布管理对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条产品发布管理信息
     * @param aProductReleaseid 产品发布管理信息主键
     * @return 成功更新条数
     */
    int delete(String aProductReleaseid);
    
    /**
     * 删除符合产品发布管理条件的全部信息
     * @param aProductRelease 产品发布管理对象
     * @return 成功更新条数
     */
    int deleteForObj(AProductReleaseVO aProductRelease);

	/**
     * 批量删除产品发布管理信息，通过in数据主键
     * @param aProductReleaselist 产品发布管理信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> aProductReleaselist);

	/**
     * 批量删除产品发布管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 产品发布管理信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除产品发布管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 产品发布管理信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条产品发布管理的详情信息
     * @param aProductReleaseid 产品发布管理信息主键
     * @return 产品发布管理信息对象
     */
    AProductReleaseVO searchById(String aProductReleaseid);

	/**
     * 查询一条产品发布管理的详情信息，实现数据行锁定
     * @param aProductReleaseid 产品发布管理信息主键
     * @return 产品发布管理信息对象
     */
    AProductReleaseVO searchByIdUpdate(String aProductReleaseid);

	/**
     * 批量查询产品发布管理信息，通过in数据主键
     * @param aProductReleaselist 产品发布管理信息主键列表
     * @return 产品发布管理信息对象列表
     */
    List<AProductReleaseVO> searchBatch(List<String> aProductReleaselist);

	/**
     * 获取产品发布管理指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 产品发布管理信息map对象
     * @return 产品发布管理信息对象列表
     */
    List<AProductReleaseVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条产品发布管理信息表信息，=条件判断符
     * @param aProductRelease 产品发布管理信息对象
     * @return 产品发布管理信息对象
     */
    AProductReleaseVO searchObjByObj(AProductReleaseVO aProductRelease);

	/**
     * 获取符合条件的产品发布管理信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param aProductRelease 产品发布管理信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(AProductReleaseVO aProductRelease);

	/**
     * 获取符合条件的全部产品发布管理信息，=条件判断符
     * @param aProductRelease 产品发布管理信息对象
     * @return 产品发布管理信息对象列表
     */
    List<AProductReleaseVO> searchListByObj(AProductReleaseVO aProductRelease);
	
    /**
     * 获取符合条件的全部产品发布管理信息，支持动态关联分页查询
     * @param aProductRelease 产品发布管理信息对象
     * @return 产品发布管理信息对象列表
     */
    List<AProductReleaseVO> searchListPageByObj(AProductReleaseVO aProductRelease);
	
    /**
     * 获取符合条件的全部产品发布管理信息，支持动态关联分页查询
     * @param aProductRelease 产品发布管理信息对象
     * @return 产品发布管理信息对象列表
     */
    List<AProductReleaseVO> searchListPageByObjOr(AProductReleaseVO aProductRelease);
	
    /**
     * 获取符合条件的全部产品发布管理信息，支持动态关联分页查询
     * @param aProductRelease 产品发布管理信息对象
     * @return 产品发布管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(AProductReleaseVO aProductRelease);
	
    /**
     * 获取符合条件的全部产品发布管理信息，支持动态关联分页查询
     * @param aProductRelease 产品发布管理信息对象
     * @return 产品发布管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(AProductReleaseVO aProductRelease);
    
}