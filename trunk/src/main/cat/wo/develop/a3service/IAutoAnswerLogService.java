package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.AutoAnswerLogVO;

import com.github.pagehelper.PageInfo;

/**
 * 帖子回复日志信息信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface IAutoAnswerLogService {
	
	/**
	 * 插入一条【帖子回复日志信息】信息
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(AutoAnswerLogVO autoAnswerLogVO);
	
	/**
	 * 插入一条【帖子回复日志信息】信息
	 * @param map 帖子回复日志信息信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【帖子回复日志信息】信息
	 * @param json 帖子回复日志信息json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【帖子回复日志信息】信息
	 * @param objlist 帖子回复日志信息信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<AutoAnswerLogVO> objlist);
	
	/**
	 * 批量插入【帖子回复日志信息】信息
	 * @param maplist 帖子回复日志信息信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【帖子回复日志信息】信息
	 * @param obj 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(AutoAnswerLogVO obj) throws Exception;
	
	/**
	 * 更新一条【帖子回复日志信息】信息
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(AutoAnswerLogVO autoAnswerLogVO);
	
	/**
	 * 更新一条【帖子回复日志信息】信息
	 * @param map 帖子回复日志信息信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【帖子回复日志信息】信息
	 * @param objlist 帖子回复日志信息信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<AutoAnswerLogVO> objlist);
	
	/**
	 * 批量更新【帖子回复日志信息】信息
	 * @param maplist 帖子回复日志信息信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【帖子回复日志信息】信息
	 * @param map 帖子回复日志信息信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【帖子回复日志信息】信息
	 * @param id 帖子回复日志信息信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【帖子回复日志信息】信息
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(AutoAnswerLogVO autoAnswerLogVO);

	/**
	 * 删除一条【帖子回复日志信息】信息
	 * @param map 帖子回复日志信息信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【帖子回复日志信息】信息
	 * @param autoAnswerLoglist 帖子回复日志信息信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> autoAnswerLoglist) throws Exception;
	
	/**
	 * 批量删除【帖子回复日志信息】信息
	 * @param autoAnswerLoglist 帖子回复日志信息信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<AutoAnswerLogVO> autoAnswerLoglist) throws Exception;
	
	/**
	 * 批量删除【帖子回复日志信息】信息
	 * @param maplist 帖子回复日志信息信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【帖子回复日志信息】信息
	 * @param autoAnswerLogid 帖子回复日志信息信息主键
	 * @return 帖子回复日志信息信息对象
	 */
	public AutoAnswerLogVO searchById(String autoAnswerLogid) throws Exception;
	
	/**
	 * 批量查询【帖子回复日志信息】信息
	 * @param uiids 帖子回复日志信息信息主键列表
	 * @return 帖子回复日志信息信息对象列表
	 */
	public List<AutoAnswerLogVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param autoAnswerLogVO 帖子回复日志信息信息主键
     * @return 帖子回复日志信息信息对象列表
     */
	public List<AutoAnswerLogVO> searchByMoreId(AutoAnswerLogVO autoAnswerLogVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 帖子回复日志信息信息json对象
     * @return 帖子回复日志信息信息对象列表
     */
	public List<AutoAnswerLogVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 帖子回复日志信息信息map对象
     * @return 帖子回复日志信息信息对象列表
     */
	public List<AutoAnswerLogVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(AutoAnswerLogVO autoAnswerLogVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 帖子回复日志信息信息对象
	 */
	public AutoAnswerLogVO searchObjByObj(AutoAnswerLogVO autoAnswerLogVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 帖子回复日志信息信息对象列表，含分页对象
	 */
	public PageInfo<AutoAnswerLogVO> searchListByObj(AutoAnswerLogVO autoAnswerLogVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 帖子回复日志信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子回复日志信息信息对象列表，含分页对象
	 */
	public PageInfo<AutoAnswerLogVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子回复日志信息信息对象列表，含分页对象
	 */
	public PageInfo<AutoAnswerLogVO> searchListPageByObj(AutoAnswerLogVO autoAnswerLogVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子回复日志信息信息对象列表，含分页对象
	 */
	public PageInfo<AutoAnswerLogVO> searchListPageByObjOr(AutoAnswerLogVO autoAnswerLogVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子回复日志信息信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(AutoAnswerLogVO autoAnswerLogVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子回复日志信息信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(AutoAnswerLogVO autoAnswerLogVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【帖子回复日志信息】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 帖子回复日志信息信息对象
	 * autoAnswerLogVO
	 * pageNo
	 * pageSize
	 * @return 帖子回复日志信息信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	
}
