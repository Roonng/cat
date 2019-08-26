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
import wo.develop.a4dao.ITaskRunLogDao;
import wo.develop.a5vo.TaskRunLogVO;
import wo.develop.a3service.ITaskRunLogService;
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
 * 任务执行记录信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("taskRunLogService")
public class TaskRunLogServiceImpl implements ITaskRunLogService {
	private static Logger log = LoggerFactory.getLogger(TaskRunLogServiceImpl.class);

	@Resource
	private ITaskRunLogDao taskRunLogDao;

	/**
	 * 插入一条【任务执行记录】信息
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(TaskRunLogVO taskRunLogVO) {
		if(!StringUtil.isNotNull(taskRunLogVO.getUiid())){
			taskRunLogVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.taskRunLogDao.insert(taskRunLogVO);
	}

	/**
	 * 插入一条【任务执行记录】信息
	 * @param map 任务执行记录信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		TaskRunLogVO taskRunLogVO = new TaskRunLogVO();
		BeanRefUtil.setFieldValue(taskRunLogVO, map);
		if(!StringUtil.isNotNull(taskRunLogVO.getUiid())){
			taskRunLogVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.taskRunLogDao.insert(taskRunLogVO);
	}

	/**
	 * 插入一条【任务执行记录】信息
	 * @param json 任务执行记录信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		TaskRunLogVO taskRunLogVO = (TaskRunLogVO )JsonHelper.jsonToObj(TaskRunLogVO.class.getName(), json);
		if(!StringUtil.isNull(taskRunLogVO)){
			if(!StringUtil.isNotNull(taskRunLogVO.getUiid())){
				taskRunLogVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.taskRunLogDao.insert(taskRunLogVO);
		}
		return 0;
	}

	/**
	 * 批量插入【任务执行记录】信息
	 * @param objlist 任务执行记录信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<TaskRunLogVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			TaskRunLogVO taskRunLogVO = objlist.get(i);
			if(!StringUtil.isNotNull(taskRunLogVO.getUiid())){
				taskRunLogVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.taskRunLogDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【任务执行记录】信息
	 * @param maplist 任务执行记录信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<TaskRunLogVO> objlist = new ArrayList<TaskRunLogVO>();
		for (Map<String, String> map : maplist) {
			TaskRunLogVO taskRunLogVO = new TaskRunLogVO();
			BeanRefUtil.setFieldValue(taskRunLogVO, map);
			if(!StringUtil.isNotNull(taskRunLogVO.getUiid())){
				taskRunLogVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(taskRunLogVO);
		}
		return this.taskRunLogDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【任务执行记录】信息
	 * @param obj 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(TaskRunLogVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【任务执行记录】信息
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(TaskRunLogVO taskRunLogVO) {
		if(!StringUtil.isNull(taskRunLogVO)){
			if(StringUtil.isNotNull(taskRunLogVO.getUiid())){
				return this.taskRunLogDao.update(taskRunLogVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【任务执行记录】信息
	 * @param map 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		TaskRunLogVO taskRunLogVO = new TaskRunLogVO();
		BeanRefUtil.setFieldValue(taskRunLogVO, map);
		if(StringUtil.isNotNull(taskRunLogVO.getUiid())){
			return this.taskRunLogDao.update(taskRunLogVO);
		}
		return 0;
	}

	/**
	 * 批量更新【任务执行记录】信息
	 * @param objlist 任务执行记录信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<TaskRunLogVO> objlist) {
		for(TaskRunLogVO taskRunLogVO:objlist){
			if(!StringUtil.isNotNull(taskRunLogVO.getUiid())){
				return 0;
			}
		}
		return this.taskRunLogDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【任务执行记录】信息
	 * @param maplist 任务执行记录信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<TaskRunLogVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			TaskRunLogVO taskRunLogVO = new TaskRunLogVO();
			BeanRefUtil.setFieldValue(taskRunLogVO, map);
			objlist.add(taskRunLogVO);
		}
		for(TaskRunLogVO taskRunLogVO:objlist){
			if(!StringUtil.isNotNull(taskRunLogVO.getUiid())){
				return 0;
			}
		}
		return this.taskRunLogDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【任务执行记录】信息
	 * @param map 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.taskRunLogDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 任务执行记录信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						TaskRunLogVO taskRunLogVO = taskRunLogDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(TaskRunLogVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(TaskRunLogVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(taskRunLogVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					TaskRunLogVO taskRunLogVO = taskRunLogDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(TaskRunLogVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(TaskRunLogVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(taskRunLogVO);
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
	 * @param datauiid 任务执行记录信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【任务执行记录】信息
	 * @param taskRunLogid 任务执行记录信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String taskRunLogid) {
		if(!StringUtil.isNotNull(taskRunLogid)){
			return -1;
		}
		this.deletefile(taskRunLogid);
		this.deleteinvent(taskRunLogid);
		return this.taskRunLogDao.delete(taskRunLogid);
	}
	
	
	/**
	 * 删除一条【任务执行记录】信息
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(TaskRunLogVO taskRunLogVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(taskRunLogVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(taskRunLogVO.getUiid());
		this.deleteinvent(taskRunLogVO.getUiid());
		return this.taskRunLogDao.deleteForObj(taskRunLogVO);
	}

	/**
	 * 删除一条【任务执行记录】信息
	 * @param map 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("ctrl_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("ctrl_uiid"));
		this.deleteinvent(map.get("ctrl_uiid"));
		return this.taskRunLogDao.delete(map.get("ctrl_uiid"));
	}

	/**
	 * 批量删除【任务执行记录】信息
	 * @param taskRunLogVOlist 任务执行记录信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> taskRunLogVOlist) throws Exception {
		if(taskRunLogVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < taskRunLogVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += taskRunLogVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.taskRunLogDao.deleteBatch(taskRunLogVOlist);
	}

	/**
	 * 批量删除【任务执行记录】信息
	 * @param taskRunLogVOlist 任务执行记录信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<TaskRunLogVO> taskRunLogVOlist) throws Exception {
		List<String> taskRunLogVOlist1 = new ArrayList<String>();
		String stss = "";
		for (TaskRunLogVO taskRunLogVO : taskRunLogVOlist) {
			taskRunLogVOlist1.add(taskRunLogVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += taskRunLogVO.getUiid();
		}
		if(taskRunLogVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.taskRunLogDao.deleteBatch(taskRunLogVOlist1);
	}

	/**
	 * 批量删除【任务执行记录】信息
	 * @param maplist 任务执行记录信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> taskRunLogVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			taskRunLogVOlist1.add(map.get("ctrl_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("ctrl_uiid");
		}
		if(taskRunLogVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.taskRunLogDao.deleteBatch(taskRunLogVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 任务执行记录信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.taskRunLogDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.taskRunLogDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【任务执行记录】信息
	 * @param taskRunLogVOid 任务执行记录信息主键
	 * @return 任务执行记录信息对象
	 */
	@Override
	public TaskRunLogVO searchById(String taskRunLogVOid) throws Exception {
		if(!StringUtil.isNotNull(taskRunLogVOid)){
			throw new Exception("数据空异常");
		}
		return this.taskRunLogDao.searchById(taskRunLogVOid);
	}

	/**
	 * 批量查询【任务执行记录】信息
	 * @param uiids 任务执行记录信息主键列表
	 * @return 任务执行记录信息对象列表
	 */
	@Override
	public List<TaskRunLogVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<TaskRunLogVO> taskRunLogListtemp = this.taskRunLogDao.searchBatch(list);
		List<TaskRunLogVO> taskRunLogList = new ArrayList<TaskRunLogVO>();
		for(String uu : u){
			TaskRunLogVO taskRunLogVO = null;
			for(int i = 0 ; i < taskRunLogListtemp.size() ; i ++){
				taskRunLogVO = taskRunLogListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(taskRunLogVO.getUiid())){
					taskRunLogList.add(taskRunLogVO);
				}
			}
		}
		return taskRunLogList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 任务执行记录信息对象列表
	 */
	@Override
	public List<TaskRunLogVO> searchByMoreId(TaskRunLogVO taskRunLogVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 任务执行记录json信息对象
	 * @return 任务执行记录信息对象列表
	 */
	@Override
	public List<TaskRunLogVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 任务执行记录map信息对象
	 * @return 任务执行记录信息对象列表
	 */
	@Override
	public List<TaskRunLogVO> searchByMoreId(Map<String,Object> map) {
		return this.taskRunLogDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(TaskRunLogVO taskRunLogVO) {
		return this.taskRunLogDao.searchCountByObj(taskRunLogVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 任务执行记录信息对象
	 */
	@Override
	public TaskRunLogVO searchObjByObj(TaskRunLogVO taskRunLogVO) {
		return this.taskRunLogDao.searchObjByObj(taskRunLogVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @return 任务执行记录信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<TaskRunLogVO> searchListByObj(TaskRunLogVO taskRunLogVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<TaskRunLogVO> list = this.taskRunLogDao.searchListByObj(taskRunLogVO);
		// 用PageInfo对结果进行包装
		PageInfo<TaskRunLogVO> page = new PageInfo<TaskRunLogVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 任务执行记录map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 任务执行记录信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<TaskRunLogVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		TaskRunLogVO taskRunLogVO = new TaskRunLogVO();
		BeanRefUtil.setFieldValue(taskRunLogVO, map);
		return searchListPageByObj(taskRunLogVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 任务执行记录信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<TaskRunLogVO> searchListPageByObj(TaskRunLogVO taskRunLogVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<TaskRunLogVO> list = this.taskRunLogDao.searchListPageByObj(taskRunLogVO);
		// 用PageInfo对结果进行包装
		PageInfo<TaskRunLogVO> page = new PageInfo<TaskRunLogVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 任务执行记录信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<TaskRunLogVO> searchListPageByObjOr(TaskRunLogVO taskRunLogVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<TaskRunLogVO> list = this.taskRunLogDao.searchListPageByObjOr(taskRunLogVO);
		// 用PageInfo对结果进行包装
		PageInfo<TaskRunLogVO> page = new PageInfo<TaskRunLogVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 任务执行记录信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(TaskRunLogVO taskRunLogVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.taskRunLogDao.searchListPageByObjRefin(taskRunLogVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param taskRunLogVO 任务执行记录信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 任务执行记录信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(TaskRunLogVO taskRunLogVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.taskRunLogDao.searchListPageByObjReftable(taskRunLogVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【任务执行记录】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 任务执行记录信息对象
	 * taskRunLogVO
	 * pageNo
	 * pageSize
	 * @return 任务执行记录信息对象列表，含分页对象
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
