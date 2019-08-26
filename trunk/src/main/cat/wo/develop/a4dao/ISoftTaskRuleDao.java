/*
 * @ClassName SoftTaskRuleDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.SoftTaskRuleVO;

/**
 * 步骤查找规则dao接口类
 * @author 彭羽飞
 *
 */
public interface ISoftTaskRuleDao {
	
	/**
	 * 新增一条步骤查找规则信息
	 * @param softTaskRule 步骤查找规则对象
	 * @return 成功更新条数
	 */
    int insert(SoftTaskRuleVO softTaskRule);

	/**
     * 批量新增步骤查找规则信息
     * @param softTaskRulelist 步骤查找规则对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<SoftTaskRuleVO> softTaskRulelist);

	/**
     * 更新一条步骤查找规则信息
     * @param softTaskRule 步骤查找规则对象
     * @return 成功更新条数
     */
    int update(SoftTaskRuleVO softTaskRule);
    
	/**
     * 批量更新步骤查找规则信息
     * @param softTaskRulelist 步骤查找规则对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<SoftTaskRuleVO> softTaskRulelist);
    
	/**
     * 批量更新步骤查找规则信息
     * @param datamap 步骤查找规则对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条步骤查找规则信息
     * @param softTaskRuleid 步骤查找规则信息主键
     * @return 成功更新条数
     */
    int delete(String softTaskRuleid);
    
    /**
     * 删除符合步骤查找规则条件的全部信息
     * @param softTaskRule 步骤查找规则对象
     * @return 成功更新条数
     */
    int deleteForObj(SoftTaskRuleVO softTaskRule);

	/**
     * 批量删除步骤查找规则信息，通过in数据主键
     * @param softTaskRulelist 步骤查找规则信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> softTaskRulelist);

	/**
     * 批量删除步骤查找规则指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 步骤查找规则信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除步骤查找规则指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 步骤查找规则信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条步骤查找规则的详情信息
     * @param softTaskRuleid 步骤查找规则信息主键
     * @return 步骤查找规则信息对象
     */
    SoftTaskRuleVO searchById(String softTaskRuleid);

	/**
     * 查询一条步骤查找规则的详情信息，实现数据行锁定
     * @param softTaskRuleid 步骤查找规则信息主键
     * @return 步骤查找规则信息对象
     */
    SoftTaskRuleVO searchByIdUpdate(String softTaskRuleid);

	/**
     * 批量查询步骤查找规则信息，通过in数据主键
     * @param softTaskRulelist 步骤查找规则信息主键列表
     * @return 步骤查找规则信息对象列表
     */
    List<SoftTaskRuleVO> searchBatch(List<String> softTaskRulelist);

	/**
     * 获取步骤查找规则指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 步骤查找规则信息map对象
     * @return 步骤查找规则信息对象列表
     */
    List<SoftTaskRuleVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条步骤查找规则信息表信息，=条件判断符
     * @param softTaskRule 步骤查找规则信息对象
     * @return 步骤查找规则信息对象
     */
    SoftTaskRuleVO searchObjByObj(SoftTaskRuleVO softTaskRule);

	/**
     * 获取符合条件的步骤查找规则信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param softTaskRule 步骤查找规则信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(SoftTaskRuleVO softTaskRule);

	/**
     * 获取符合条件的全部步骤查找规则信息，=条件判断符
     * @param softTaskRule 步骤查找规则信息对象
     * @return 步骤查找规则信息对象列表
     */
    List<SoftTaskRuleVO> searchListByObj(SoftTaskRuleVO softTaskRule);
	
    /**
     * 获取符合条件的全部步骤查找规则信息，支持动态关联分页查询
     * @param softTaskRule 步骤查找规则信息对象
     * @return 步骤查找规则信息对象列表
     */
    List<SoftTaskRuleVO> searchListPageByObj(SoftTaskRuleVO softTaskRule);
	
    /**
     * 获取符合条件的全部步骤查找规则信息，支持动态关联分页查询
     * @param softTaskRule 步骤查找规则信息对象
     * @return 步骤查找规则信息对象列表
     */
    List<SoftTaskRuleVO> searchListPageByObjOr(SoftTaskRuleVO softTaskRule);
	
    /**
     * 获取符合条件的全部步骤查找规则信息，支持动态关联分页查询
     * @param softTaskRule 步骤查找规则信息对象
     * @return 步骤查找规则信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(SoftTaskRuleVO softTaskRule);
	
    /**
     * 获取符合条件的全部步骤查找规则信息，支持动态关联分页查询
     * @param softTaskRule 步骤查找规则信息对象
     * @return 步骤查找规则信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(SoftTaskRuleVO softTaskRule);
    
}