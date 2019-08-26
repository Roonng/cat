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
import wo.develop.a4dao.ISoftTaskDao;
import wo.develop.a5vo.SoftTaskVO;
import wo.develop.a3service.ISoftTaskService;
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
 * 软件业务管理信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("softTaskService")
public class SoftTaskServiceImpl implements ISoftTaskService {
	private static Logger log = LoggerFactory.getLogger(SoftTaskServiceImpl.class);

	@Resource
	private ISoftTaskDao softTaskDao;

	/**
	 * 插入一条【软件业务管理】信息
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(SoftTaskVO softTaskVO) {
		if(!StringUtil.isNotNull(softTaskVO.getUiid())){
			softTaskVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.softTaskDao.insert(softTaskVO);
	}

	/**
	 * 插入一条【软件业务管理】信息
	 * @param map 软件业务管理信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		SoftTaskVO softTaskVO = new SoftTaskVO();
		BeanRefUtil.setFieldValue(softTaskVO, map);
		if(!StringUtil.isNotNull(softTaskVO.getUiid())){
			softTaskVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.softTaskDao.insert(softTaskVO);
	}

	/**
	 * 插入一条【软件业务管理】信息
	 * @param json 软件业务管理信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		SoftTaskVO softTaskVO = (SoftTaskVO )JsonHelper.jsonToObj(SoftTaskVO.class.getName(), json);
		if(!StringUtil.isNull(softTaskVO)){
			if(!StringUtil.isNotNull(softTaskVO.getUiid())){
				softTaskVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.softTaskDao.insert(softTaskVO);
		}
		return 0;
	}

	/**
	 * 批量插入【软件业务管理】信息
	 * @param objlist 软件业务管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<SoftTaskVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			SoftTaskVO softTaskVO = objlist.get(i);
			if(!StringUtil.isNotNull(softTaskVO.getUiid())){
				softTaskVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.softTaskDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【软件业务管理】信息
	 * @param maplist 软件业务管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<SoftTaskVO> objlist = new ArrayList<SoftTaskVO>();
		for (Map<String, String> map : maplist) {
			SoftTaskVO softTaskVO = new SoftTaskVO();
			BeanRefUtil.setFieldValue(softTaskVO, map);
			if(!StringUtil.isNotNull(softTaskVO.getUiid())){
				softTaskVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(softTaskVO);
		}
		return this.softTaskDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【软件业务管理】信息
	 * @param obj 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(SoftTaskVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【软件业务管理】信息
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(SoftTaskVO softTaskVO) {
		if(!StringUtil.isNull(softTaskVO)){
			if(StringUtil.isNotNull(softTaskVO.getUiid())){
				return this.softTaskDao.update(softTaskVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【软件业务管理】信息
	 * @param map 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		SoftTaskVO softTaskVO = new SoftTaskVO();
		BeanRefUtil.setFieldValue(softTaskVO, map);
		if(StringUtil.isNotNull(softTaskVO.getUiid())){
			return this.softTaskDao.update(softTaskVO);
		}
		return 0;
	}

	/**
	 * 批量更新【软件业务管理】信息
	 * @param objlist 软件业务管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<SoftTaskVO> objlist) {
		for(SoftTaskVO softTaskVO:objlist){
			if(!StringUtil.isNotNull(softTaskVO.getUiid())){
				return 0;
			}
		}
		return this.softTaskDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【软件业务管理】信息
	 * @param maplist 软件业务管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<SoftTaskVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			SoftTaskVO softTaskVO = new SoftTaskVO();
			BeanRefUtil.setFieldValue(softTaskVO, map);
			objlist.add(softTaskVO);
		}
		for(SoftTaskVO softTaskVO:objlist){
			if(!StringUtil.isNotNull(softTaskVO.getUiid())){
				return 0;
			}
		}
		return this.softTaskDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【软件业务管理】信息
	 * @param map 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.softTaskDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 软件业务管理信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						SoftTaskVO softTaskVO = softTaskDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(SoftTaskVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(SoftTaskVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(softTaskVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					SoftTaskVO softTaskVO = softTaskDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(SoftTaskVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(SoftTaskVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(softTaskVO);
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
	 * @param datauiid 软件业务管理信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【软件业务管理】信息
	 * @param softTaskid 软件业务管理信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String softTaskid) {
		if(!StringUtil.isNotNull(softTaskid)){
			return -1;
		}
		this.deletefile(softTaskid);
		this.deleteinvent(softTaskid);
		return this.softTaskDao.delete(softTaskid);
	}
	
	
	/**
	 * 删除一条【软件业务管理】信息
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(SoftTaskVO softTaskVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(softTaskVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(softTaskVO.getUiid());
		this.deleteinvent(softTaskVO.getUiid());
		return this.softTaskDao.deleteForObj(softTaskVO);
	}

	/**
	 * 删除一条【软件业务管理】信息
	 * @param map 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("cst_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("cst_uiid"));
		this.deleteinvent(map.get("cst_uiid"));
		return this.softTaskDao.delete(map.get("cst_uiid"));
	}

	/**
	 * 批量删除【软件业务管理】信息
	 * @param softTaskVOlist 软件业务管理信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> softTaskVOlist) throws Exception {
		if(softTaskVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < softTaskVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += softTaskVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softTaskDao.deleteBatch(softTaskVOlist);
	}

	/**
	 * 批量删除【软件业务管理】信息
	 * @param softTaskVOlist 软件业务管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<SoftTaskVO> softTaskVOlist) throws Exception {
		List<String> softTaskVOlist1 = new ArrayList<String>();
		String stss = "";
		for (SoftTaskVO softTaskVO : softTaskVOlist) {
			softTaskVOlist1.add(softTaskVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += softTaskVO.getUiid();
		}
		if(softTaskVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softTaskDao.deleteBatch(softTaskVOlist1);
	}

	/**
	 * 批量删除【软件业务管理】信息
	 * @param maplist 软件业务管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> softTaskVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			softTaskVOlist1.add(map.get("cst_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("cst_uiid");
		}
		if(softTaskVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softTaskDao.deleteBatch(softTaskVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 软件业务管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.softTaskDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.softTaskDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【软件业务管理】信息
	 * @param softTaskVOid 软件业务管理信息主键
	 * @return 软件业务管理信息对象
	 */
	@Override
	public SoftTaskVO searchById(String softTaskVOid) throws Exception {
		if(!StringUtil.isNotNull(softTaskVOid)){
			throw new Exception("数据空异常");
		}
		return this.softTaskDao.searchById(softTaskVOid);
	}

	/**
	 * 批量查询【软件业务管理】信息
	 * @param uiids 软件业务管理信息主键列表
	 * @return 软件业务管理信息对象列表
	 */
	@Override
	public List<SoftTaskVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<SoftTaskVO> softTaskListtemp = this.softTaskDao.searchBatch(list);
		List<SoftTaskVO> softTaskList = new ArrayList<SoftTaskVO>();
		for(String uu : u){
			SoftTaskVO softTaskVO = null;
			for(int i = 0 ; i < softTaskListtemp.size() ; i ++){
				softTaskVO = softTaskListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(softTaskVO.getUiid())){
					softTaskList.add(softTaskVO);
				}
			}
		}
		return softTaskList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 软件业务管理信息对象列表
	 */
	@Override
	public List<SoftTaskVO> searchByMoreId(SoftTaskVO softTaskVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 软件业务管理json信息对象
	 * @return 软件业务管理信息对象列表
	 */
	@Override
	public List<SoftTaskVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 软件业务管理map信息对象
	 * @return 软件业务管理信息对象列表
	 */
	@Override
	public List<SoftTaskVO> searchByMoreId(Map<String,Object> map) {
		return this.softTaskDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(SoftTaskVO softTaskVO) {
		return this.softTaskDao.searchCountByObj(softTaskVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 软件业务管理信息对象
	 */
	@Override
	public SoftTaskVO searchObjByObj(SoftTaskVO softTaskVO) {
		return this.softTaskDao.searchObjByObj(softTaskVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param softTaskVO 软件业务管理信息对象
	 * @return 软件业务管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftTaskVO> searchListByObj(SoftTaskVO softTaskVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftTaskVO> list = this.softTaskDao.searchListByObj(softTaskVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftTaskVO> page = new PageInfo<SoftTaskVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 软件业务管理map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件业务管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftTaskVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		SoftTaskVO softTaskVO = new SoftTaskVO();
		BeanRefUtil.setFieldValue(softTaskVO, map);
		return searchListPageByObj(softTaskVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskVO 软件业务管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件业务管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftTaskVO> searchListPageByObj(SoftTaskVO softTaskVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftTaskVO> list = this.softTaskDao.searchListPageByObj(softTaskVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftTaskVO> page = new PageInfo<SoftTaskVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskVO 软件业务管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件业务管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftTaskVO> searchListPageByObjOr(SoftTaskVO softTaskVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftTaskVO> list = this.softTaskDao.searchListPageByObjOr(softTaskVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftTaskVO> page = new PageInfo<SoftTaskVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskVO 软件业务管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件业务管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(SoftTaskVO softTaskVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.softTaskDao.searchListPageByObjRefin(softTaskVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskVO 软件业务管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件业务管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(SoftTaskVO softTaskVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.softTaskDao.searchListPageByObjReftable(softTaskVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【软件业务管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 软件业务管理信息对象
	 * softTaskVO
	 * pageNo
	 * pageSize
	 * @return 软件业务管理信息对象列表，含分页对象
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
			List<SoftTaskVO> softTaskVOlist = new ArrayList<SoftTaskVO>();
			for(int i = 0 ; i < uiids.length ; i ++){
				if(StringUtil.isNotNull(uiids[i])){
					SoftTaskVO softTaskVO = new SoftTaskVO();
					softTaskVO.setUiid(uiids[i]);
					softTaskVO.setSort(i*10 + 10);
					softTaskVOlist.add(softTaskVO);
				}
			}
			return this.softTaskDao.updateBatch(softTaskVOlist);
		}else{
			throw new Exception("排序数据为空");
		}
	}
	
	
	
	
	
}
