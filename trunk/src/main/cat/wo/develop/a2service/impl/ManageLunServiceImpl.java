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
import wo.develop.a4dao.IManageLunDao;
import wo.develop.a5vo.ManageLunVO;
import wo.develop.a3service.IManageLunService;
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
 * 轮播图信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("manageLunService")
public class ManageLunServiceImpl implements IManageLunService {
	private static Logger log = LoggerFactory.getLogger(ManageLunServiceImpl.class);

	@Resource
	private IManageLunDao manageLunDao;

	/**
	 * 插入一条【轮播图】信息
	 * @param manageLunVO 轮播图信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(ManageLunVO manageLunVO) {
		if(!StringUtil.isNotNull(manageLunVO.getUiid())){
			manageLunVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.manageLunDao.insert(manageLunVO);
	}

	/**
	 * 插入一条【轮播图】信息
	 * @param map 轮播图信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		ManageLunVO manageLunVO = new ManageLunVO();
		BeanRefUtil.setFieldValue(manageLunVO, map);
		if(!StringUtil.isNotNull(manageLunVO.getUiid())){
			manageLunVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.manageLunDao.insert(manageLunVO);
	}

	/**
	 * 插入一条【轮播图】信息
	 * @param json 轮播图信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		ManageLunVO manageLunVO = (ManageLunVO )JsonHelper.jsonToObj(ManageLunVO.class.getName(), json);
		if(!StringUtil.isNull(manageLunVO)){
			if(!StringUtil.isNotNull(manageLunVO.getUiid())){
				manageLunVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.manageLunDao.insert(manageLunVO);
		}
		return 0;
	}

	/**
	 * 批量插入【轮播图】信息
	 * @param objlist 轮播图信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<ManageLunVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			ManageLunVO manageLunVO = objlist.get(i);
			if(!StringUtil.isNotNull(manageLunVO.getUiid())){
				manageLunVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.manageLunDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【轮播图】信息
	 * @param maplist 轮播图信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<ManageLunVO> objlist = new ArrayList<ManageLunVO>();
		for (Map<String, String> map : maplist) {
			ManageLunVO manageLunVO = new ManageLunVO();
			BeanRefUtil.setFieldValue(manageLunVO, map);
			if(!StringUtil.isNotNull(manageLunVO.getUiid())){
				manageLunVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(manageLunVO);
		}
		return this.manageLunDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【轮播图】信息
	 * @param obj 轮播图信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(ManageLunVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【轮播图】信息
	 * @param manageLunVO 轮播图信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(ManageLunVO manageLunVO) {
		if(!StringUtil.isNull(manageLunVO)){
			if(StringUtil.isNotNull(manageLunVO.getUiid())){
				return this.manageLunDao.update(manageLunVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【轮播图】信息
	 * @param map 轮播图信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		ManageLunVO manageLunVO = new ManageLunVO();
		BeanRefUtil.setFieldValue(manageLunVO, map);
		if(StringUtil.isNotNull(manageLunVO.getUiid())){
			return this.manageLunDao.update(manageLunVO);
		}
		return 0;
	}

	/**
	 * 批量更新【轮播图】信息
	 * @param objlist 轮播图信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<ManageLunVO> objlist) {
		for(ManageLunVO manageLunVO:objlist){
			if(!StringUtil.isNotNull(manageLunVO.getUiid())){
				return 0;
			}
		}
		return this.manageLunDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【轮播图】信息
	 * @param maplist 轮播图信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<ManageLunVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			ManageLunVO manageLunVO = new ManageLunVO();
			BeanRefUtil.setFieldValue(manageLunVO, map);
			objlist.add(manageLunVO);
		}
		for(ManageLunVO manageLunVO:objlist){
			if(!StringUtil.isNotNull(manageLunVO.getUiid())){
				return 0;
			}
		}
		return this.manageLunDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【轮播图】信息
	 * @param map 轮播图信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.manageLunDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 轮播图信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						ManageLunVO manageLunVO = manageLunDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(ManageLunVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(ManageLunVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(manageLunVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					ManageLunVO manageLunVO = manageLunDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(ManageLunVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(ManageLunVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(manageLunVO);
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
	 * @param datauiid 轮播图信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【轮播图】信息
	 * @param manageLunid 轮播图信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String manageLunid) {
		if(!StringUtil.isNotNull(manageLunid)){
			return -1;
		}
		this.deletefile(manageLunid);
		this.deleteinvent(manageLunid);
		return this.manageLunDao.delete(manageLunid);
	}
	
	
	/**
	 * 删除一条【轮播图】信息
	 * @param manageLunVO 轮播图信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(ManageLunVO manageLunVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(manageLunVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(manageLunVO.getUiid());
		this.deleteinvent(manageLunVO.getUiid());
		return this.manageLunDao.deleteForObj(manageLunVO);
	}

	/**
	 * 删除一条【轮播图】信息
	 * @param map 轮播图信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("cml_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("cml_uiid"));
		this.deleteinvent(map.get("cml_uiid"));
		return this.manageLunDao.delete(map.get("cml_uiid"));
	}

	/**
	 * 批量删除【轮播图】信息
	 * @param manageLunVOlist 轮播图信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> manageLunVOlist) throws Exception {
		if(manageLunVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < manageLunVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += manageLunVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.manageLunDao.deleteBatch(manageLunVOlist);
	}

	/**
	 * 批量删除【轮播图】信息
	 * @param manageLunVOlist 轮播图信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<ManageLunVO> manageLunVOlist) throws Exception {
		List<String> manageLunVOlist1 = new ArrayList<String>();
		String stss = "";
		for (ManageLunVO manageLunVO : manageLunVOlist) {
			manageLunVOlist1.add(manageLunVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += manageLunVO.getUiid();
		}
		if(manageLunVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.manageLunDao.deleteBatch(manageLunVOlist1);
	}

	/**
	 * 批量删除【轮播图】信息
	 * @param maplist 轮播图信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> manageLunVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			manageLunVOlist1.add(map.get("cml_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("cml_uiid");
		}
		if(manageLunVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.manageLunDao.deleteBatch(manageLunVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 轮播图信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.manageLunDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.manageLunDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【轮播图】信息
	 * @param manageLunVOid 轮播图信息主键
	 * @return 轮播图信息对象
	 */
	@Override
	public ManageLunVO searchById(String manageLunVOid) throws Exception {
		if(!StringUtil.isNotNull(manageLunVOid)){
			throw new Exception("数据空异常");
		}
		return this.manageLunDao.searchById(manageLunVOid);
	}

	/**
	 * 批量查询【轮播图】信息
	 * @param uiids 轮播图信息主键列表
	 * @return 轮播图信息对象列表
	 */
	@Override
	public List<ManageLunVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<ManageLunVO> manageLunListtemp = this.manageLunDao.searchBatch(list);
		List<ManageLunVO> manageLunList = new ArrayList<ManageLunVO>();
		for(String uu : u){
			ManageLunVO manageLunVO = null;
			for(int i = 0 ; i < manageLunListtemp.size() ; i ++){
				manageLunVO = manageLunListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(manageLunVO.getUiid())){
					manageLunList.add(manageLunVO);
				}
			}
		}
		return manageLunList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param manageLunVO 轮播图信息对象
	 * @return 轮播图信息对象列表
	 */
	@Override
	public List<ManageLunVO> searchByMoreId(ManageLunVO manageLunVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 轮播图json信息对象
	 * @return 轮播图信息对象列表
	 */
	@Override
	public List<ManageLunVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 轮播图map信息对象
	 * @return 轮播图信息对象列表
	 */
	@Override
	public List<ManageLunVO> searchByMoreId(Map<String,Object> map) {
		return this.manageLunDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param manageLunVO 轮播图信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(ManageLunVO manageLunVO) {
		return this.manageLunDao.searchCountByObj(manageLunVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param manageLunVO 轮播图信息对象
	 * @return 轮播图信息对象
	 */
	@Override
	public ManageLunVO searchObjByObj(ManageLunVO manageLunVO) {
		return this.manageLunDao.searchObjByObj(manageLunVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param manageLunVO 轮播图信息对象
	 * @return 轮播图信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<ManageLunVO> searchListByObj(ManageLunVO manageLunVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<ManageLunVO> list = this.manageLunDao.searchListByObj(manageLunVO);
		// 用PageInfo对结果进行包装
		PageInfo<ManageLunVO> page = new PageInfo<ManageLunVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 轮播图map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 轮播图信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<ManageLunVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		ManageLunVO manageLunVO = new ManageLunVO();
		BeanRefUtil.setFieldValue(manageLunVO, map);
		return searchListPageByObj(manageLunVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param manageLunVO 轮播图信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 轮播图信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<ManageLunVO> searchListPageByObj(ManageLunVO manageLunVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<ManageLunVO> list = this.manageLunDao.searchListPageByObj(manageLunVO);
		// 用PageInfo对结果进行包装
		PageInfo<ManageLunVO> page = new PageInfo<ManageLunVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param manageLunVO 轮播图信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 轮播图信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<ManageLunVO> searchListPageByObjOr(ManageLunVO manageLunVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<ManageLunVO> list = this.manageLunDao.searchListPageByObjOr(manageLunVO);
		// 用PageInfo对结果进行包装
		PageInfo<ManageLunVO> page = new PageInfo<ManageLunVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param manageLunVO 轮播图信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 轮播图信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(ManageLunVO manageLunVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.manageLunDao.searchListPageByObjRefin(manageLunVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param manageLunVO 轮播图信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 轮播图信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(ManageLunVO manageLunVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.manageLunDao.searchListPageByObjReftable(manageLunVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【轮播图】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 轮播图信息对象
	 * manageLunVO
	 * pageNo
	 * pageSize
	 * @return 轮播图信息对象列表，含分页对象
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
			List<ManageLunVO> manageLunVOlist = new ArrayList<ManageLunVO>();
			for(int i = 0 ; i < uiids.length ; i ++){
				if(StringUtil.isNotNull(uiids[i])){
					ManageLunVO manageLunVO = new ManageLunVO();
					manageLunVO.setUiid(uiids[i]);
					manageLunVO.setSort(i*10 + 10);
					manageLunVOlist.add(manageLunVO);
				}
			}
			return this.manageLunDao.updateBatch(manageLunVOlist);
		}else{
			throw new Exception("排序数据为空");
		}
	}
	
	
	
	
	
}
