package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.AutoAnswerMessageVO;

import com.github.pagehelper.PageInfo;

/**
 * 帖子留言回复数据信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface IAutoAnswerMessageService {
	
	/**
	 * 插入一条【帖子留言回复数据】信息
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(AutoAnswerMessageVO autoAnswerMessageVO);
	
	/**
	 * 插入一条【帖子留言回复数据】信息
	 * @param map 帖子留言回复数据信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【帖子留言回复数据】信息
	 * @param json 帖子留言回复数据json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【帖子留言回复数据】信息
	 * @param objlist 帖子留言回复数据信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<AutoAnswerMessageVO> objlist);
	
	/**
	 * 批量插入【帖子留言回复数据】信息
	 * @param maplist 帖子留言回复数据信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【帖子留言回复数据】信息
	 * @param obj 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(AutoAnswerMessageVO obj) throws Exception;
	
	/**
	 * 更新一条【帖子留言回复数据】信息
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(AutoAnswerMessageVO autoAnswerMessageVO);
	
	/**
	 * 更新一条【帖子留言回复数据】信息
	 * @param map 帖子留言回复数据信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【帖子留言回复数据】信息
	 * @param objlist 帖子留言回复数据信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<AutoAnswerMessageVO> objlist);
	
	/**
	 * 批量更新【帖子留言回复数据】信息
	 * @param maplist 帖子留言回复数据信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【帖子留言回复数据】信息
	 * @param map 帖子留言回复数据信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【帖子留言回复数据】信息
	 * @param id 帖子留言回复数据信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【帖子留言回复数据】信息
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(AutoAnswerMessageVO autoAnswerMessageVO);

	/**
	 * 删除一条【帖子留言回复数据】信息
	 * @param map 帖子留言回复数据信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【帖子留言回复数据】信息
	 * @param autoAnswerMessagelist 帖子留言回复数据信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> autoAnswerMessagelist) throws Exception;
	
	/**
	 * 批量删除【帖子留言回复数据】信息
	 * @param autoAnswerMessagelist 帖子留言回复数据信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<AutoAnswerMessageVO> autoAnswerMessagelist) throws Exception;
	
	/**
	 * 批量删除【帖子留言回复数据】信息
	 * @param maplist 帖子留言回复数据信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【帖子留言回复数据】信息
	 * @param autoAnswerMessageid 帖子留言回复数据信息主键
	 * @return 帖子留言回复数据信息对象
	 */
	public AutoAnswerMessageVO searchById(String autoAnswerMessageid) throws Exception;
	
	/**
	 * 批量查询【帖子留言回复数据】信息
	 * @param uiids 帖子留言回复数据信息主键列表
	 * @return 帖子留言回复数据信息对象列表
	 */
	public List<AutoAnswerMessageVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param autoAnswerMessageVO 帖子留言回复数据信息主键
     * @return 帖子留言回复数据信息对象列表
     */
	public List<AutoAnswerMessageVO> searchByMoreId(AutoAnswerMessageVO autoAnswerMessageVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 帖子留言回复数据信息json对象
     * @return 帖子留言回复数据信息对象列表
     */
	public List<AutoAnswerMessageVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 帖子留言回复数据信息map对象
     * @return 帖子留言回复数据信息对象列表
     */
	public List<AutoAnswerMessageVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(AutoAnswerMessageVO autoAnswerMessageVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 帖子留言回复数据信息对象
	 */
	public AutoAnswerMessageVO searchObjByObj(AutoAnswerMessageVO autoAnswerMessageVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 帖子留言回复数据信息对象列表，含分页对象
	 */
	public PageInfo<AutoAnswerMessageVO> searchListByObj(AutoAnswerMessageVO autoAnswerMessageVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 帖子留言回复数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子留言回复数据信息对象列表，含分页对象
	 */
	public PageInfo<AutoAnswerMessageVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子留言回复数据信息对象列表，含分页对象
	 */
	public PageInfo<AutoAnswerMessageVO> searchListPageByObj(AutoAnswerMessageVO autoAnswerMessageVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子留言回复数据信息对象列表，含分页对象
	 */
	public PageInfo<AutoAnswerMessageVO> searchListPageByObjOr(AutoAnswerMessageVO autoAnswerMessageVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子留言回复数据信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(AutoAnswerMessageVO autoAnswerMessageVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子留言回复数据信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(AutoAnswerMessageVO autoAnswerMessageVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【帖子留言回复数据】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 帖子留言回复数据信息对象
	 * autoAnswerMessageVO
	 * pageNo
	 * pageSize
	 * @return 帖子留言回复数据信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	
}
