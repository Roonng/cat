/*
 * @ClassName ManageLunDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.ManageLunVO;

/**
 * 轮播图dao接口类
 * @author 彭羽飞
 *
 */
public interface IManageLunDao {
	
	/**
	 * 新增一条轮播图信息
	 * @param manageLun 轮播图对象
	 * @return 成功更新条数
	 */
    int insert(ManageLunVO manageLun);

	/**
     * 批量新增轮播图信息
     * @param manageLunlist 轮播图对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<ManageLunVO> manageLunlist);

	/**
     * 更新一条轮播图信息
     * @param manageLun 轮播图对象
     * @return 成功更新条数
     */
    int update(ManageLunVO manageLun);
    
	/**
     * 批量更新轮播图信息
     * @param manageLunlist 轮播图对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<ManageLunVO> manageLunlist);
    
	/**
     * 批量更新轮播图信息
     * @param datamap 轮播图对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条轮播图信息
     * @param manageLunid 轮播图信息主键
     * @return 成功更新条数
     */
    int delete(String manageLunid);
    
    /**
     * 删除符合轮播图条件的全部信息
     * @param manageLun 轮播图对象
     * @return 成功更新条数
     */
    int deleteForObj(ManageLunVO manageLun);

	/**
     * 批量删除轮播图信息，通过in数据主键
     * @param manageLunlist 轮播图信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> manageLunlist);

	/**
     * 批量删除轮播图指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 轮播图信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除轮播图指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 轮播图信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条轮播图的详情信息
     * @param manageLunid 轮播图信息主键
     * @return 轮播图信息对象
     */
    ManageLunVO searchById(String manageLunid);

	/**
     * 查询一条轮播图的详情信息，实现数据行锁定
     * @param manageLunid 轮播图信息主键
     * @return 轮播图信息对象
     */
    ManageLunVO searchByIdUpdate(String manageLunid);

	/**
     * 批量查询轮播图信息，通过in数据主键
     * @param manageLunlist 轮播图信息主键列表
     * @return 轮播图信息对象列表
     */
    List<ManageLunVO> searchBatch(List<String> manageLunlist);

	/**
     * 获取轮播图指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 轮播图信息map对象
     * @return 轮播图信息对象列表
     */
    List<ManageLunVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条轮播图信息表信息，=条件判断符
     * @param manageLun 轮播图信息对象
     * @return 轮播图信息对象
     */
    ManageLunVO searchObjByObj(ManageLunVO manageLun);

	/**
     * 获取符合条件的轮播图信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param manageLun 轮播图信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(ManageLunVO manageLun);

	/**
     * 获取符合条件的全部轮播图信息，=条件判断符
     * @param manageLun 轮播图信息对象
     * @return 轮播图信息对象列表
     */
    List<ManageLunVO> searchListByObj(ManageLunVO manageLun);
	
    /**
     * 获取符合条件的全部轮播图信息，支持动态关联分页查询
     * @param manageLun 轮播图信息对象
     * @return 轮播图信息对象列表
     */
    List<ManageLunVO> searchListPageByObj(ManageLunVO manageLun);
	
    /**
     * 获取符合条件的全部轮播图信息，支持动态关联分页查询
     * @param manageLun 轮播图信息对象
     * @return 轮播图信息对象列表
     */
    List<ManageLunVO> searchListPageByObjOr(ManageLunVO manageLun);
	
    /**
     * 获取符合条件的全部轮播图信息，支持动态关联分页查询
     * @param manageLun 轮播图信息对象
     * @return 轮播图信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(ManageLunVO manageLun);
	
    /**
     * 获取符合条件的全部轮播图信息，支持动态关联分页查询
     * @param manageLun 轮播图信息对象
     * @return 轮播图信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(ManageLunVO manageLun);
    
}