/*
 * @ClassName AutoArticleDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.AutoArticleVO;

/**
 * 发帖数据dao接口类
 * @author 彭羽飞
 *
 */
public interface IAutoArticleDao {
	
	/**
	 * 新增一条发帖数据信息
	 * @param autoArticle 发帖数据对象
	 * @return 成功更新条数
	 */
    int insert(AutoArticleVO autoArticle);

	/**
     * 批量新增发帖数据信息
     * @param autoArticlelist 发帖数据对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<AutoArticleVO> autoArticlelist);

	/**
     * 更新一条发帖数据信息
     * @param autoArticle 发帖数据对象
     * @return 成功更新条数
     */
    int update(AutoArticleVO autoArticle);
    
	/**
     * 批量更新发帖数据信息
     * @param autoArticlelist 发帖数据对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<AutoArticleVO> autoArticlelist);
    
	/**
     * 批量更新发帖数据信息
     * @param datamap 发帖数据对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条发帖数据信息
     * @param autoArticleid 发帖数据信息主键
     * @return 成功更新条数
     */
    int delete(String autoArticleid);
    
    /**
     * 删除符合发帖数据条件的全部信息
     * @param autoArticle 发帖数据对象
     * @return 成功更新条数
     */
    int deleteForObj(AutoArticleVO autoArticle);

	/**
     * 批量删除发帖数据信息，通过in数据主键
     * @param autoArticlelist 发帖数据信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> autoArticlelist);

	/**
     * 批量删除发帖数据指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 发帖数据信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除发帖数据指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 发帖数据信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条发帖数据的详情信息
     * @param autoArticleid 发帖数据信息主键
     * @return 发帖数据信息对象
     */
    AutoArticleVO searchById(String autoArticleid);

	/**
     * 查询一条发帖数据的详情信息，实现数据行锁定
     * @param autoArticleid 发帖数据信息主键
     * @return 发帖数据信息对象
     */
    AutoArticleVO searchByIdUpdate(String autoArticleid);

	/**
     * 批量查询发帖数据信息，通过in数据主键
     * @param autoArticlelist 发帖数据信息主键列表
     * @return 发帖数据信息对象列表
     */
    List<AutoArticleVO> searchBatch(List<String> autoArticlelist);

	/**
     * 获取发帖数据指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 发帖数据信息map对象
     * @return 发帖数据信息对象列表
     */
    List<AutoArticleVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条发帖数据信息表信息，=条件判断符
     * @param autoArticle 发帖数据信息对象
     * @return 发帖数据信息对象
     */
    AutoArticleVO searchObjByObj(AutoArticleVO autoArticle);

	/**
     * 获取符合条件的发帖数据信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param autoArticle 发帖数据信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(AutoArticleVO autoArticle);

	/**
     * 获取符合条件的全部发帖数据信息，=条件判断符
     * @param autoArticle 发帖数据信息对象
     * @return 发帖数据信息对象列表
     */
    List<AutoArticleVO> searchListByObj(AutoArticleVO autoArticle);
	
    /**
     * 获取符合条件的全部发帖数据信息，支持动态关联分页查询
     * @param autoArticle 发帖数据信息对象
     * @return 发帖数据信息对象列表
     */
    List<AutoArticleVO> searchListPageByObj(AutoArticleVO autoArticle);
	
    /**
     * 获取符合条件的全部发帖数据信息，支持动态关联分页查询
     * @param autoArticle 发帖数据信息对象
     * @return 发帖数据信息对象列表
     */
    List<AutoArticleVO> searchListPageByObjOr(AutoArticleVO autoArticle);
	
    /**
     * 获取符合条件的全部发帖数据信息，支持动态关联分页查询
     * @param autoArticle 发帖数据信息对象
     * @return 发帖数据信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(AutoArticleVO autoArticle);
	
    /**
     * 获取符合条件的全部发帖数据信息，支持动态关联分页查询
     * @param autoArticle 发帖数据信息对象
     * @return 发帖数据信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(AutoArticleVO autoArticle);
    
}