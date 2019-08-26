package wo.develop.a3service;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.AutoArticleVO;

import com.github.pagehelper.PageInfo;

/**
 * 发帖数据信息管理接口服务类
 * @author 彭羽飞
 *
 */
public interface IAutoArticleService {
	
	/**
	 * 插入一条【发帖数据】信息
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 成功更新条数
	 */
	public int insertForObj(AutoArticleVO autoArticleVO);
	
	/**
	 * 插入一条【发帖数据】信息
	 * @param map 发帖数据信息map对象
	 * @return 成功更新条数
	 */
	public int insertForMap(Map<String,String> map);
	
	/**
	 * 插入一条【发帖数据】信息
	 * @param json 发帖数据json字符串
	 * @return 成功更新条数
	 */
	public int insertForJson(String json);
	
	/**
	 * 批量插入【发帖数据】信息
	 * @param objlist 发帖数据信息对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(List<AutoArticleVO> objlist);
	
	/**
	 * 批量插入【发帖数据】信息
	 * @param maplist 发帖数据信息map对象列表
	 * @return 成功更新条数
	 */
	public int insertBatchForMap(List<Map> maplist) throws Exception;
	
	/**
	 * 批量插入【发帖数据】信息
	 * @param obj 发帖数据信息对象
	 * @return 成功更新条数
	 */
	public int insertBatchForObj(AutoArticleVO obj) throws Exception;
	
	/**
	 * 更新一条【发帖数据】信息
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 成功更新条数
	 */
	public int updateForObj(AutoArticleVO autoArticleVO);
	
	/**
	 * 更新一条【发帖数据】信息
	 * @param map 发帖数据信息map对象
	 * @return 成功更新条数
	 */
	public int updateForMap(Map<String,String> map);
	
	/**
	 * 批量更新【发帖数据】信息
	 * @param objlist 发帖数据信息对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForObj(List<AutoArticleVO> objlist);
	
	/**
	 * 批量更新【发帖数据】信息
	 * @param maplist 发帖数据信息map对象列表
	 * @return 成功更新条数
	 */
	public int updateBatchForList(List<Map> maplist);
	
	/**
	 * 批量更新【发帖数据】信息
	 * @param map 发帖数据信息map对象
	 * @return 成功更新条数
	 */
	public int updateBatchForMapList(Map map) throws Exception;

	/**
	 * 删除一条【发帖数据】信息
	 * @param id 发帖数据信息主键
	 * @return 成功更新条数
	 */
	public int deleteById(String id);

	/**
	 * 删除一条【发帖数据】信息
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 成功更新条数
	 */
	public int deleteByObj(AutoArticleVO autoArticleVO);

	/**
	 * 删除一条【发帖数据】信息
	 * @param map 发帖数据信息map对象
	 * @return 成功更新条数
	 */
	public int deleteByMap(Map<String,String> map) throws Exception;
	
	/**
	 * 批量删除【发帖数据】信息
	 * @param autoArticlelist 发帖数据信息主键列表
	 * @return 成功更新条数
	 */
	public int deleteBatchById(List<String> autoArticlelist) throws Exception;
	
	/**
	 * 批量删除【发帖数据】信息
	 * @param autoArticlelist 发帖数据信息对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByObj(List<AutoArticleVO> autoArticlelist) throws Exception;
	
	/**
	 * 批量删除【发帖数据】信息
	 * @param maplist 发帖数据信息map对象列表
	 * @return 成功更新条数
	 */
	public int deleteBatchByMap(List<Map<String,String>> maplist) throws Exception;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 发帖数据信息对象
	 * @return 成功更新条数
	 */
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception ;
	
	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	public int deleteAll() ;
	
	/**
	 * 通过主键获取一条【发帖数据】信息
	 * @param autoArticleid 发帖数据信息主键
	 * @return 发帖数据信息对象
	 */
	public AutoArticleVO searchById(String autoArticleid) throws Exception;
	
	/**
	 * 批量查询【发帖数据】信息
	 * @param uiids 发帖数据信息主键列表
	 * @return 发帖数据信息对象列表
	 */
	public List<AutoArticleVO> searchBatchById(String uiids);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param autoArticleVO 发帖数据信息主键
     * @return 发帖数据信息对象列表
     */
	public List<AutoArticleVO> searchByMoreId(AutoArticleVO autoArticleVO);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param json 发帖数据信息json对象
     * @return 发帖数据信息对象列表
     */
	public List<AutoArticleVO> searchByMoreId(String json);

	/**
     * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
     * @param map 发帖数据信息map对象
     * @return 发帖数据信息对象列表
     */
	public List<AutoArticleVO> searchByMoreId(Map<String,Object> map);
	
	/**
	 * 获取当前符合条件的数据条数
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 符合条件的数据条数
	 */
	public int searchCountByObj(AutoArticleVO autoArticleVO);
	
	/**
	 * 查询符合条件的一条数据
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 发帖数据信息对象
	 */
	public AutoArticleVO searchObjByObj(AutoArticleVO autoArticleVO);
	
	/**
	 * 查询符合条件的全部数据
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 发帖数据信息对象列表，含分页对象
	 */
	public PageInfo<AutoArticleVO> searchListByObj(AutoArticleVO autoArticleVO,Integer pageNo,Integer pageSize);
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 发帖数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 发帖数据信息对象列表，含分页对象
	 */
	public PageInfo<AutoArticleVO> searchListPageByMap(Map<String,String> map,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoArticleVO 发帖数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 发帖数据信息对象列表，含分页对象
	 */
	public PageInfo<AutoArticleVO> searchListPageByObj(AutoArticleVO autoArticleVO,Integer pageNo,Integer pageSize);
	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoArticleVO 发帖数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 发帖数据信息对象列表，含分页对象
	 */
	public PageInfo<AutoArticleVO> searchListPageByObjOr(AutoArticleVO autoArticleVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoArticleVO 发帖数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 发帖数据信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(AutoArticleVO autoArticleVO,Integer pageNo,Integer pageSize);

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoArticleVO 发帖数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 发帖数据信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(AutoArticleVO autoArticleVO,Integer pageNo,Integer pageSize);
	

	/**
	 * 自定义搜索【发帖数据】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 发帖数据信息对象
	 * autoArticleVO
	 * pageNo
	 * pageSize
	 * @return 发帖数据信息对象列表，含分页对象
	 */
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception;
	
	
}
