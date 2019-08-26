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
import wo.develop.a4dao.IAutoTaskDao;
import wo.develop.a5vo.AutoTaskVO;
import wo.develop.a3service.IAutoTaskService;
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
 * 业务主题设置信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("autoTaskService")
public class AutoTaskServiceImpl implements IAutoTaskService {
	private static Logger log = LoggerFactory.getLogger(AutoTaskServiceImpl.class);

	@Resource
	private IAutoTaskDao autoTaskDao;

	/**
	 * 插入一条【业务主题设置】信息
	 * @param autoTaskVO 业务主题设置信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(AutoTaskVO autoTaskVO) {
		if(!StringUtil.isNotNull(autoTaskVO.getUiid())){
			autoTaskVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.autoTaskDao.insert(autoTaskVO);
	}

	/**
	 * 插入一条【业务主题设置】信息
	 * @param map 业务主题设置信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		AutoTaskVO autoTaskVO = new AutoTaskVO();
		BeanRefUtil.setFieldValue(autoTaskVO, map);
		if(!StringUtil.isNotNull(autoTaskVO.getUiid())){
			autoTaskVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.autoTaskDao.insert(autoTaskVO);
	}

	/**
	 * 插入一条【业务主题设置】信息
	 * @param json 业务主题设置信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		AutoTaskVO autoTaskVO = (AutoTaskVO )JsonHelper.jsonToObj(AutoTaskVO.class.getName(), json);
		if(!StringUtil.isNull(autoTaskVO)){
			if(!StringUtil.isNotNull(autoTaskVO.getUiid())){
				autoTaskVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.autoTaskDao.insert(autoTaskVO);
		}
		return 0;
	}

	/**
	 * 批量插入【业务主题设置】信息
	 * @param objlist 业务主题设置信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<AutoTaskVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			AutoTaskVO autoTaskVO = objlist.get(i);
			if(!StringUtil.isNotNull(autoTaskVO.getUiid())){
				autoTaskVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.autoTaskDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【业务主题设置】信息
	 * @param maplist 业务主题设置信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<AutoTaskVO> objlist = new ArrayList<AutoTaskVO>();
		for (Map<String, String> map : maplist) {
			AutoTaskVO autoTaskVO = new AutoTaskVO();
			BeanRefUtil.setFieldValue(autoTaskVO, map);
			if(!StringUtil.isNotNull(autoTaskVO.getUiid())){
				autoTaskVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(autoTaskVO);
		}
		return this.autoTaskDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【业务主题设置】信息
	 * @param obj 业务主题设置信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(AutoTaskVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【业务主题设置】信息
	 * @param autoTaskVO 业务主题设置信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(AutoTaskVO autoTaskVO) {
		if(!StringUtil.isNull(autoTaskVO)){
			if(StringUtil.isNotNull(autoTaskVO.getUiid())){
				return this.autoTaskDao.update(autoTaskVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【业务主题设置】信息
	 * @param map 业务主题设置信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		AutoTaskVO autoTaskVO = new AutoTaskVO();
		BeanRefUtil.setFieldValue(autoTaskVO, map);
		if(StringUtil.isNotNull(autoTaskVO.getUiid())){
			return this.autoTaskDao.update(autoTaskVO);
		}
		return 0;
	}

	/**
	 * 批量更新【业务主题设置】信息
	 * @param objlist 业务主题设置信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<AutoTaskVO> objlist) {
		for(AutoTaskVO autoTaskVO:objlist){
			if(!StringUtil.isNotNull(autoTaskVO.getUiid())){
				return 0;
			}
		}
		return this.autoTaskDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【业务主题设置】信息
	 * @param maplist 业务主题设置信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<AutoTaskVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			AutoTaskVO autoTaskVO = new AutoTaskVO();
			BeanRefUtil.setFieldValue(autoTaskVO, map);
			objlist.add(autoTaskVO);
		}
		for(AutoTaskVO autoTaskVO:objlist){
			if(!StringUtil.isNotNull(autoTaskVO.getUiid())){
				return 0;
			}
		}
		return this.autoTaskDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【业务主题设置】信息
	 * @param map 业务主题设置信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.autoTaskDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 业务主题设置信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						AutoTaskVO autoTaskVO = autoTaskDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AutoTaskVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(AutoTaskVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(autoTaskVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					AutoTaskVO autoTaskVO = autoTaskDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AutoTaskVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(AutoTaskVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(autoTaskVO);
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
	 * @param datauiid 业务主题设置信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【业务主题设置】信息
	 * @param autoTaskid 业务主题设置信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String autoTaskid) {
		if(!StringUtil.isNotNull(autoTaskid)){
			return -1;
		}
		this.deletefile(autoTaskid);
		this.deleteinvent(autoTaskid);
		return this.autoTaskDao.delete(autoTaskid);
	}
	
	
	/**
	 * 删除一条【业务主题设置】信息
	 * @param autoTaskVO 业务主题设置信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(AutoTaskVO autoTaskVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(autoTaskVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(autoTaskVO.getUiid());
		this.deleteinvent(autoTaskVO.getUiid());
		return this.autoTaskDao.deleteForObj(autoTaskVO);
	}

	/**
	 * 删除一条【业务主题设置】信息
	 * @param map 业务主题设置信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("cat_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("cat_uiid"));
		this.deleteinvent(map.get("cat_uiid"));
		return this.autoTaskDao.delete(map.get("cat_uiid"));
	}

	/**
	 * 批量删除【业务主题设置】信息
	 * @param autoTaskVOlist 业务主题设置信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> autoTaskVOlist) throws Exception {
		if(autoTaskVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < autoTaskVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += autoTaskVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoTaskDao.deleteBatch(autoTaskVOlist);
	}

	/**
	 * 批量删除【业务主题设置】信息
	 * @param autoTaskVOlist 业务主题设置信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<AutoTaskVO> autoTaskVOlist) throws Exception {
		List<String> autoTaskVOlist1 = new ArrayList<String>();
		String stss = "";
		for (AutoTaskVO autoTaskVO : autoTaskVOlist) {
			autoTaskVOlist1.add(autoTaskVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += autoTaskVO.getUiid();
		}
		if(autoTaskVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoTaskDao.deleteBatch(autoTaskVOlist1);
	}

	/**
	 * 批量删除【业务主题设置】信息
	 * @param maplist 业务主题设置信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> autoTaskVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			autoTaskVOlist1.add(map.get("cat_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("cat_uiid");
		}
		if(autoTaskVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoTaskDao.deleteBatch(autoTaskVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 业务主题设置信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.autoTaskDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.autoTaskDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【业务主题设置】信息
	 * @param autoTaskVOid 业务主题设置信息主键
	 * @return 业务主题设置信息对象
	 */
	@Override
	public AutoTaskVO searchById(String autoTaskVOid) throws Exception {
		if(!StringUtil.isNotNull(autoTaskVOid)){
			throw new Exception("数据空异常");
		}
		return this.autoTaskDao.searchById(autoTaskVOid);
	}

	/**
	 * 批量查询【业务主题设置】信息
	 * @param uiids 业务主题设置信息主键列表
	 * @return 业务主题设置信息对象列表
	 */
	@Override
	public List<AutoTaskVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<AutoTaskVO> autoTaskListtemp = this.autoTaskDao.searchBatch(list);
		List<AutoTaskVO> autoTaskList = new ArrayList<AutoTaskVO>();
		for(String uu : u){
			AutoTaskVO autoTaskVO = null;
			for(int i = 0 ; i < autoTaskListtemp.size() ; i ++){
				autoTaskVO = autoTaskListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(autoTaskVO.getUiid())){
					autoTaskList.add(autoTaskVO);
				}
			}
		}
		return autoTaskList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param autoTaskVO 业务主题设置信息对象
	 * @return 业务主题设置信息对象列表
	 */
	@Override
	public List<AutoTaskVO> searchByMoreId(AutoTaskVO autoTaskVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 业务主题设置json信息对象
	 * @return 业务主题设置信息对象列表
	 */
	@Override
	public List<AutoTaskVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 业务主题设置map信息对象
	 * @return 业务主题设置信息对象列表
	 */
	@Override
	public List<AutoTaskVO> searchByMoreId(Map<String,Object> map) {
		return this.autoTaskDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param autoTaskVO 业务主题设置信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(AutoTaskVO autoTaskVO) {
		return this.autoTaskDao.searchCountByObj(autoTaskVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param autoTaskVO 业务主题设置信息对象
	 * @return 业务主题设置信息对象
	 */
	@Override
	public AutoTaskVO searchObjByObj(AutoTaskVO autoTaskVO) {
		return this.autoTaskDao.searchObjByObj(autoTaskVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param autoTaskVO 业务主题设置信息对象
	 * @return 业务主题设置信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoTaskVO> searchListByObj(AutoTaskVO autoTaskVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoTaskVO> list = this.autoTaskDao.searchListByObj(autoTaskVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoTaskVO> page = new PageInfo<AutoTaskVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 业务主题设置map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务主题设置信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoTaskVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		AutoTaskVO autoTaskVO = new AutoTaskVO();
		BeanRefUtil.setFieldValue(autoTaskVO, map);
		return searchListPageByObj(autoTaskVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoTaskVO 业务主题设置信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务主题设置信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoTaskVO> searchListPageByObj(AutoTaskVO autoTaskVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoTaskVO> list = this.autoTaskDao.searchListPageByObj(autoTaskVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoTaskVO> page = new PageInfo<AutoTaskVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoTaskVO 业务主题设置信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务主题设置信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoTaskVO> searchListPageByObjOr(AutoTaskVO autoTaskVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoTaskVO> list = this.autoTaskDao.searchListPageByObjOr(autoTaskVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoTaskVO> page = new PageInfo<AutoTaskVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoTaskVO 业务主题设置信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务主题设置信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(AutoTaskVO autoTaskVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.autoTaskDao.searchListPageByObjRefin(autoTaskVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoTaskVO 业务主题设置信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务主题设置信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(AutoTaskVO autoTaskVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.autoTaskDao.searchListPageByObjReftable(autoTaskVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【业务主题设置】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 业务主题设置信息对象
	 * autoTaskVO
	 * pageNo
	 * pageSize
	 * @return 业务主题设置信息对象列表，含分页对象
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
	
	
	
	/**
	 * 数据排序
	 * @param sort 列表排序数据UIID列表
	 * @return 排序更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int listsort( String sort) throws Exception {
		if(StringUtil.isNotNull(sort) && sort.indexOf(",") != -1){
			String uiids[] = sort.split(",");
			List<AutoTaskVO> autoTaskVOlist = new ArrayList<AutoTaskVO>();
			for(int i = 0 ; i < uiids.length ; i ++){
				if(StringUtil.isNotNull(uiids[i])){
					AutoTaskVO autoTaskVO = new AutoTaskVO();
					autoTaskVO.setUiid(uiids[i]);
					autoTaskVO.setSort(i*10 + 10);
					autoTaskVOlist.add(autoTaskVO);
				}
			}
			return this.autoTaskDao.updateBatch(autoTaskVOlist);
		}else{
			throw new Exception("排序数据为空");
		}
	}
	
	
	
	
	
}
