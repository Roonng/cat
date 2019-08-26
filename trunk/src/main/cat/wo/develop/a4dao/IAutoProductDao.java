/*
 * @ClassName AutoProductDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.AutoProductVO;

/**
 * 产品管理dao接口类
 * @author 彭羽飞
 *
 */
public interface IAutoProductDao {
	
	/**
	 * 新增一条产品管理信息
	 * @param autoProduct 产品管理对象
	 * @return 成功更新条数
	 */
    int insert(AutoProductVO autoProduct);

	/**
     * 批量新增产品管理信息
     * @param autoProductlist 产品管理对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<AutoProductVO> autoProductlist);

	/**
     * 更新一条产品管理信息
     * @param autoProduct 产品管理对象
     * @return 成功更新条数
     */
    int update(AutoProductVO autoProduct);
    
	/**
     * 批量更新产品管理信息
     * @param autoProductlist 产品管理对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<AutoProductVO> autoProductlist);
    
	/**
     * 批量更新产品管理信息
     * @param datamap 产品管理对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条产品管理信息
     * @param autoProductid 产品管理信息主键
     * @return 成功更新条数
     */
    int delete(String autoProductid);
    
    /**
     * 删除符合产品管理条件的全部信息
     * @param autoProduct 产品管理对象
     * @return 成功更新条数
     */
    int deleteForObj(AutoProductVO autoProduct);

	/**
     * 批量删除产品管理信息，通过in数据主键
     * @param autoProductlist 产品管理信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> autoProductlist);

	/**
     * 批量删除产品管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 产品管理信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除产品管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 产品管理信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条产品管理的详情信息
     * @param autoProductid 产品管理信息主键
     * @return 产品管理信息对象
     */
    AutoProductVO searchById(String autoProductid);

	/**
     * 查询一条产品管理的详情信息，实现数据行锁定
     * @param autoProductid 产品管理信息主键
     * @return 产品管理信息对象
     */
    AutoProductVO searchByIdUpdate(String autoProductid);

	/**
     * 批量查询产品管理信息，通过in数据主键
     * @param autoProductlist 产品管理信息主键列表
     * @return 产品管理信息对象列表
     */
    List<AutoProductVO> searchBatch(List<String> autoProductlist);

	/**
     * 获取产品管理指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 产品管理信息map对象
     * @return 产品管理信息对象列表
     */
    List<AutoProductVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条产品管理信息表信息，=条件判断符
     * @param autoProduct 产品管理信息对象
     * @return 产品管理信息对象
     */
    AutoProductVO searchObjByObj(AutoProductVO autoProduct);

	/**
     * 获取符合条件的产品管理信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param autoProduct 产品管理信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(AutoProductVO autoProduct);

	/**
     * 获取符合条件的全部产品管理信息，=条件判断符
     * @param autoProduct 产品管理信息对象
     * @return 产品管理信息对象列表
     */
    List<AutoProductVO> searchListByObj(AutoProductVO autoProduct);
	
    /**
     * 获取符合条件的全部产品管理信息，支持动态关联分页查询
     * @param autoProduct 产品管理信息对象
     * @return 产品管理信息对象列表
     */
    List<AutoProductVO> searchListPageByObj(AutoProductVO autoProduct);
	
    /**
     * 获取符合条件的全部产品管理信息，支持动态关联分页查询
     * @param autoProduct 产品管理信息对象
     * @return 产品管理信息对象列表
     */
    List<AutoProductVO> searchListPageByObjOr(AutoProductVO autoProduct);
	
    /**
     * 获取符合条件的全部产品管理信息，支持动态关联分页查询
     * @param autoProduct 产品管理信息对象
     * @return 产品管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(AutoProductVO autoProduct);
	
    /**
     * 获取符合条件的全部产品管理信息，支持动态关联分页查询
     * @param autoProduct 产品管理信息对象
     * @return 产品管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(AutoProductVO autoProduct);
    
}