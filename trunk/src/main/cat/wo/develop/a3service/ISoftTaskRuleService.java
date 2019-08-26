package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.SoftTaskRuleVO;

import com.github.pagehelper.PageInfo;

/**
 * 步骤查找规则信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface ISoftTaskRuleService {
	
	/**
	 * 插入一条【步骤查找规则】信息
	 * @param softTaskRuleVO 步骤查找规则信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(SoftTaskRuleVO softTaskRuleVO);
	
	/**
	 * 插入一条【步骤查找规则】信息
	 * @param map 步骤查找规则信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【步骤查找规则】信息
	 * @param json 步骤查找规则json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【步骤查找规则】信息
	 * @param objlist 步骤查找规则信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<SoftTaskRuleVO> objlist);
	
	/**
	 * 批量插入【步骤查找规则】信息
	 * @param maplist 步骤查找规则信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【步骤查找规则】信息
	 * @param obj 步骤查找规则信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(SoftTaskRuleVO obj) throws Exception;
	
	/**
	 * 更新一条【步骤查找规则】信息
	 * @param softTaskRuleVO 步骤查找规则信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(SoftTaskRuleVO softTaskRuleVO);
	
	/**
	 * 更新一条【步骤查找规则】信息
	 * @param map 步骤查找规则信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【步骤查找规则】信息
	 * @param objlist 步骤查找规则信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<SoftTaskRuleVO> objlist);
	
	/**
	 * 批量更新【步骤查找规则】信息
	 * @param maplist 步骤查找规则信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【步骤查找规则】信息
	 * @param map 步骤查找规则信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【步骤查找规则】信息
	 * @param id 步骤查找规则信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【步骤查找规则】信息
	 * @param softTaskRuleVO 步骤查找规则信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(SoftTaskRuleVO softTaskRuleVO);

	/**
	 * 删除一条【步骤查找规则】信息
	 * @param map 步骤查找规则信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【步骤查找规则】信息
	 * @param softTaskRulelist 步骤查找规则信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> softTaskRulelist) throws Exception;
	
	/**
	 * 批量删除【步骤查找规则】信息
	 * @param softTaskRulelist 步骤查找规则信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<SoftTaskRuleVO> softTaskRulelist) throws Exception;
	
	/**
	 * 批量删除【步骤查找规则】信息
	 * @param maplist 步骤查找规则信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 步骤查找规则信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【步骤查找规则】信息
	 * @param softTaskRuleid 步骤查找规则信息主键
	 * @return 步骤查找规则信息对象
	 */
	public SoftTaskRuleVO searchById(String softTaskRuleid) throws Exception;
	
	/**
	 * 批量查询【步骤查找规则】信息
	 * @param uiids 步骤查找规则信息主键列表
	 * @return 步骤查找规则信息对象列表
	 */
	public List<SoftTaskRuleVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param softTaskRuleVO 步骤查找规则信息主键
     * @return 步骤查找规则信息对象列表
     */
	public List<SoftTaskRuleVO> searchByMoreId(SoftTaskRuleVO softTaskRuleVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 步骤查找规则信息json对象
     * @return 步骤查找规则信息对象列表
     */
	public List<SoftTaskRuleVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 步骤查找规则信息map对象
     * @return 步骤查找规则信息对象列表
     */
	public List<SoftTaskRuleVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param softTaskRuleVO 步骤查找规则信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(SoftTaskRuleVO softTaskRuleVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param softTaskRuleVO 步骤查找规则信息对象
	 * @return 步骤查找规则信息对象
	 */
	public SoftTaskRuleVO searchObjByObj(SoftTaskRuleVO softTaskRuleVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param softTaskRuleVO 步骤查找规则信息对象
	 * @return 步骤查找规则信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskRuleVO> searchListByObj(SoftTaskRuleVO softTaskRuleVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 步骤查找规则信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 步骤查找规则信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskRuleVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskRuleVO 步骤查找规则信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 步骤查找规则信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskRuleVO> searchListPageByObj(SoftTaskRuleVO softTaskRuleVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskRuleVO 步骤查找规则信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 步骤查找规则信息对象列表，含分页对象
	 */
	public PageInfo<SoftTaskRuleVO> searchListPageByObjOr(SoftTaskRuleVO softTaskRuleVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskRuleVO 步骤查找规则信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 步骤查找规则信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(SoftTaskRuleVO softTaskRuleVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskRuleVO 步骤查找规则信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 步骤查找规则信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(SoftTaskRuleVO softTaskRuleVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【步骤查找规则】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 步骤查找规则信息对象
	 * softTaskRuleVO
	 * pageNo
	 * pageSize
	 * @return 步骤查找规则信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	/**
	 * 数据排序
	 * @param sort 列表排序数据UIID列表
	 * @return 排序更新条数
	 */
	public int listsort(String sort) throws Exception;
	
}
