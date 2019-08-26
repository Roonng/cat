package wo.develop.a2service.impl;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wo.develop.run.runutil.ColumnToPropertyUtil;
import wo.develop.a4dao.IAutoArticleDao;
import wo.develop.a5vo.AutoArticleVO;
import wo.develop.a3service.IAutoArticleService;
import wo.develop.a5vo.SysFieldVO;
import wo.develop.run.a2service.impl.UploadServiceImpl;
import wo.develop.run.runutil.RunModel;
import wo.develop.util.BeanRefUtil;
import wo.develop.util.DateHelper;
import wo.develop.util.JsonHelper;
import wo.develop.util.P;
import wo.develop.util.ResultSetUtil;
import wo.develop.util.StringUtil;
import wo.develop.util.UniqueUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 发帖数据信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("autoArticleService")
public class AutoArticleServiceImpl implements IAutoArticleService {
	private static Logger log = LoggerFactory.getLogger(AutoArticleServiceImpl.class);

	@Resource
	private IAutoArticleDao autoArticleDao;

	/**
	 * 插入一条【发帖数据】信息
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(AutoArticleVO autoArticleVO) {
		if(!StringUtil.isNotNull(autoArticleVO.getUiid())){
			autoArticleVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.autoArticleDao.insert(autoArticleVO);
	}

	/**
	 * 插入一条【发帖数据】信息
	 * @param map 发帖数据信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		AutoArticleVO autoArticleVO = new AutoArticleVO();
		BeanRefUtil.setFieldValue(autoArticleVO, map);
		if(!StringUtil.isNotNull(autoArticleVO.getUiid())){
			autoArticleVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.autoArticleDao.insert(autoArticleVO);
	}

	/**
	 * 插入一条【发帖数据】信息
	 * @param json 发帖数据信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		AutoArticleVO autoArticleVO = (AutoArticleVO )JsonHelper.jsonToObj(AutoArticleVO.class.getName(), json);
		if(!StringUtil.isNull(autoArticleVO)){
			if(!StringUtil.isNotNull(autoArticleVO.getUiid())){
				autoArticleVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.autoArticleDao.insert(autoArticleVO);
		}
		return 0;
	}

	/**
	 * 批量插入【发帖数据】信息
	 * @param objlist 发帖数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<AutoArticleVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			AutoArticleVO autoArticleVO = objlist.get(i);
			if(!StringUtil.isNotNull(autoArticleVO.getUiid())){
				autoArticleVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.autoArticleDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【发帖数据】信息
	 * @param maplist 发帖数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<AutoArticleVO> objlist = new ArrayList<AutoArticleVO>();
		for (Map<String, String> map : maplist) {
			AutoArticleVO autoArticleVO = new AutoArticleVO();
			BeanRefUtil.setFieldValue(autoArticleVO, map);
			if(!StringUtil.isNotNull(autoArticleVO.getUiid())){
				autoArticleVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(autoArticleVO);
		}
		return this.autoArticleDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【发帖数据】信息
	 * @param obj 发帖数据信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(AutoArticleVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【发帖数据】信息
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(AutoArticleVO autoArticleVO) {
		if(!StringUtil.isNull(autoArticleVO)){
			if(StringUtil.isNotNull(autoArticleVO.getUiid())){
				return this.autoArticleDao.update(autoArticleVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【发帖数据】信息
	 * @param map 发帖数据信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		AutoArticleVO autoArticleVO = new AutoArticleVO();
		BeanRefUtil.setFieldValue(autoArticleVO, map);
		if(StringUtil.isNotNull(autoArticleVO.getUiid())){
			return this.autoArticleDao.update(autoArticleVO);
		}
		return 0;
	}

	/**
	 * 批量更新【发帖数据】信息
	 * @param objlist 发帖数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<AutoArticleVO> objlist) {
		for(AutoArticleVO autoArticleVO:objlist){
			if(!StringUtil.isNotNull(autoArticleVO.getUiid())){
				return 0;
			}
		}
		return this.autoArticleDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【发帖数据】信息
	 * @param maplist 发帖数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<AutoArticleVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			AutoArticleVO autoArticleVO = new AutoArticleVO();
			BeanRefUtil.setFieldValue(autoArticleVO, map);
			objlist.add(autoArticleVO);
		}
		for(AutoArticleVO autoArticleVO:objlist){
			if(!StringUtil.isNotNull(autoArticleVO.getUiid())){
				return 0;
			}
		}
		return this.autoArticleDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【发帖数据】信息
	 * @param map 发帖数据信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.autoArticleDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 发帖数据信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						AutoArticleVO autoArticleVO = autoArticleDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AutoArticleVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(AutoArticleVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(autoArticleVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					AutoArticleVO autoArticleVO = autoArticleDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AutoArticleVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(AutoArticleVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(autoArticleVO);
						if(!UploadServiceImpl.deletefile(filevalue)){
							log.warn("附件删除失败");
						}
					}
				}
			}
		}catch(Exception e){
			log.error("删除当前数据表的全部附件",e);
		}
		return true;
	}
	
	/**
	 * 删除当前虚拟字段嵌套编辑的从表数据
	 * @param datauiid 发帖数据信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【发帖数据】信息
	 * @param autoArticleid 发帖数据信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String autoArticleid) {
		if(!StringUtil.isNotNull(autoArticleid)){
			return -1;
		}
		this.deletefile(autoArticleid);
		this.deleteinvent(autoArticleid);
		return this.autoArticleDao.delete(autoArticleid);
	}
	
	
	/**
	 * 删除一条【发帖数据】信息
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(AutoArticleVO autoArticleVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(autoArticleVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(autoArticleVO.getUiid());
		this.deleteinvent(autoArticleVO.getUiid());
		return this.autoArticleDao.deleteForObj(autoArticleVO);
	}

	/**
	 * 删除一条【发帖数据】信息
	 * @param map 发帖数据信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("caa_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("caa_uiid"));
		this.deleteinvent(map.get("caa_uiid"));
		return this.autoArticleDao.delete(map.get("caa_uiid"));
	}

	/**
	 * 批量删除【发帖数据】信息
	 * @param autoArticleVOlist 发帖数据信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> autoArticleVOlist) throws Exception {
		if(autoArticleVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < autoArticleVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += autoArticleVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoArticleDao.deleteBatch(autoArticleVOlist);
	}

	/**
	 * 批量删除【发帖数据】信息
	 * @param autoArticleVOlist 发帖数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<AutoArticleVO> autoArticleVOlist) throws Exception {
		List<String> autoArticleVOlist1 = new ArrayList<String>();
		String stss = "";
		for (AutoArticleVO autoArticleVO : autoArticleVOlist) {
			autoArticleVOlist1.add(autoArticleVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += autoArticleVO.getUiid();
		}
		if(autoArticleVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoArticleDao.deleteBatch(autoArticleVOlist1);
	}

	/**
	 * 批量删除【发帖数据】信息
	 * @param maplist 发帖数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> autoArticleVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			autoArticleVOlist1.add(map.get("caa_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("caa_uiid");
		}
		if(autoArticleVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoArticleDao.deleteBatch(autoArticleVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 发帖数据信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.autoArticleDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.autoArticleDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【发帖数据】信息
	 * @param autoArticleVOid 发帖数据信息主键
	 * @return 发帖数据信息对象
	 */
	@Override
	public AutoArticleVO searchById(String autoArticleVOid) throws Exception {
		if(!StringUtil.isNotNull(autoArticleVOid)){
			throw new Exception("数据空异常");
		}
		return this.autoArticleDao.searchById(autoArticleVOid);
	}

	/**
	 * 批量查询【发帖数据】信息
	 * @param uiids 发帖数据信息主键列表
	 * @return 发帖数据信息对象列表
	 */
	@Override
	public List<AutoArticleVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<AutoArticleVO> autoArticleListtemp = this.autoArticleDao.searchBatch(list);
		List<AutoArticleVO> autoArticleList = new ArrayList<AutoArticleVO>();
		for(String uu : u){
			AutoArticleVO autoArticleVO = null;
			for(int i = 0 ; i < autoArticleListtemp.size() ; i ++){
				autoArticleVO = autoArticleListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(autoArticleVO.getUiid())){
					autoArticleList.add(autoArticleVO);
				}
			}
		}
		return autoArticleList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 发帖数据信息对象列表
	 */
	@Override
	public List<AutoArticleVO> searchByMoreId(AutoArticleVO autoArticleVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 发帖数据json信息对象
	 * @return 发帖数据信息对象列表
	 */
	@Override
	public List<AutoArticleVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 发帖数据map信息对象
	 * @return 发帖数据信息对象列表
	 */
	@Override
	public List<AutoArticleVO> searchByMoreId(Map<String,Object> map) {
		return this.autoArticleDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(AutoArticleVO autoArticleVO) {
		return this.autoArticleDao.searchCountByObj(autoArticleVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 发帖数据信息对象
	 */
	@Override
	public AutoArticleVO searchObjByObj(AutoArticleVO autoArticleVO) {
		return this.autoArticleDao.searchObjByObj(autoArticleVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param autoArticleVO 发帖数据信息对象
	 * @return 发帖数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoArticleVO> searchListByObj(AutoArticleVO autoArticleVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoArticleVO> list = this.autoArticleDao.searchListByObj(autoArticleVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoArticleVO> page = new PageInfo<AutoArticleVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 发帖数据map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 发帖数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoArticleVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		AutoArticleVO autoArticleVO = new AutoArticleVO();
		BeanRefUtil.setFieldValue(autoArticleVO, map);
		return searchListPageByObj(autoArticleVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoArticleVO 发帖数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 发帖数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoArticleVO> searchListPageByObj(AutoArticleVO autoArticleVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoArticleVO> list = this.autoArticleDao.searchListPageByObj(autoArticleVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoArticleVO> page = new PageInfo<AutoArticleVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoArticleVO 发帖数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 发帖数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoArticleVO> searchListPageByObjOr(AutoArticleVO autoArticleVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoArticleVO> list = this.autoArticleDao.searchListPageByObjOr(autoArticleVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoArticleVO> page = new PageInfo<AutoArticleVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoArticleVO 发帖数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 发帖数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(AutoArticleVO autoArticleVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.autoArticleDao.searchListPageByObjRefin(autoArticleVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoArticleVO 发帖数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 发帖数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(AutoArticleVO autoArticleVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.autoArticleDao.searchListPageByObjReftable(autoArticleVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【发帖数据】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 发帖数据信息对象
	 * autoArticleVO
	 * pageNo
	 * pageSize
	 * @return 发帖数据信息对象列表，含分页对象
	 */
	@Override
	public PageInfo<Map<String, Object>> extendsearch(Map<String, String> extendmap) throws Exception {
		Connection conn = sqlSessionFactory.openSession().getConnection();
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery(extendmap.get("sql"));
		@SuppressWarnings("rawtypes")
		PageInfo _PageInfo = new PageInfo();
		_PageInfo.setList(ResultSetUtil.extractData(rs));
		rs.close();
		state.close();
		conn.close();
		return _PageInfo;
	}
	
	
	
	
	
	
	
	
}
