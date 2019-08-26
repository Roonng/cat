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
import wo.develop.a4dao.IAutoProductDao;
import wo.develop.a5vo.AutoProductVO;
import wo.develop.a3service.IAutoProductService;
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
 * 产品管理信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("autoProductService")
public class AutoProductServiceImpl implements IAutoProductService {
	private static Logger log = LoggerFactory.getLogger(AutoProductServiceImpl.class);

	@Resource
	private IAutoProductDao autoProductDao;

	/**
	 * 插入一条【产品管理】信息
	 * @param autoProductVO 产品管理信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(AutoProductVO autoProductVO) {
		if(!StringUtil.isNotNull(autoProductVO.getUiid())){
			autoProductVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.autoProductDao.insert(autoProductVO);
	}

	/**
	 * 插入一条【产品管理】信息
	 * @param map 产品管理信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		AutoProductVO autoProductVO = new AutoProductVO();
		BeanRefUtil.setFieldValue(autoProductVO, map);
		if(!StringUtil.isNotNull(autoProductVO.getUiid())){
			autoProductVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.autoProductDao.insert(autoProductVO);
	}

	/**
	 * 插入一条【产品管理】信息
	 * @param json 产品管理信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		AutoProductVO autoProductVO = (AutoProductVO )JsonHelper.jsonToObj(AutoProductVO.class.getName(), json);
		if(!StringUtil.isNull(autoProductVO)){
			if(!StringUtil.isNotNull(autoProductVO.getUiid())){
				autoProductVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.autoProductDao.insert(autoProductVO);
		}
		return 0;
	}

	/**
	 * 批量插入【产品管理】信息
	 * @param objlist 产品管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<AutoProductVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			AutoProductVO autoProductVO = objlist.get(i);
			if(!StringUtil.isNotNull(autoProductVO.getUiid())){
				autoProductVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.autoProductDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【产品管理】信息
	 * @param maplist 产品管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<AutoProductVO> objlist = new ArrayList<AutoProductVO>();
		for (Map<String, String> map : maplist) {
			AutoProductVO autoProductVO = new AutoProductVO();
			BeanRefUtil.setFieldValue(autoProductVO, map);
			if(!StringUtil.isNotNull(autoProductVO.getUiid())){
				autoProductVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(autoProductVO);
		}
		return this.autoProductDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【产品管理】信息
	 * @param obj 产品管理信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(AutoProductVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【产品管理】信息
	 * @param autoProductVO 产品管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(AutoProductVO autoProductVO) {
		if(!StringUtil.isNull(autoProductVO)){
			if(StringUtil.isNotNull(autoProductVO.getUiid())){
				return this.autoProductDao.update(autoProductVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【产品管理】信息
	 * @param map 产品管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		AutoProductVO autoProductVO = new AutoProductVO();
		BeanRefUtil.setFieldValue(autoProductVO, map);
		if(StringUtil.isNotNull(autoProductVO.getUiid())){
			return this.autoProductDao.update(autoProductVO);
		}
		return 0;
	}

	/**
	 * 批量更新【产品管理】信息
	 * @param objlist 产品管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<AutoProductVO> objlist) {
		for(AutoProductVO autoProductVO:objlist){
			if(!StringUtil.isNotNull(autoProductVO.getUiid())){
				return 0;
			}
		}
		return this.autoProductDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【产品管理】信息
	 * @param maplist 产品管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<AutoProductVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			AutoProductVO autoProductVO = new AutoProductVO();
			BeanRefUtil.setFieldValue(autoProductVO, map);
			objlist.add(autoProductVO);
		}
		for(AutoProductVO autoProductVO:objlist){
			if(!StringUtil.isNotNull(autoProductVO.getUiid())){
				return 0;
			}
		}
		return this.autoProductDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【产品管理】信息
	 * @param map 产品管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.autoProductDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 产品管理信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						AutoProductVO autoProductVO = autoProductDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AutoProductVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(AutoProductVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(autoProductVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					AutoProductVO autoProductVO = autoProductDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AutoProductVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(AutoProductVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(autoProductVO);
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
	 * @param datauiid 产品管理信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【产品管理】信息
	 * @param autoProductid 产品管理信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String autoProductid) {
		if(!StringUtil.isNotNull(autoProductid)){
			return -1;
		}
		this.deletefile(autoProductid);
		this.deleteinvent(autoProductid);
		return this.autoProductDao.delete(autoProductid);
	}
	
	
	/**
	 * 删除一条【产品管理】信息
	 * @param autoProductVO 产品管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(AutoProductVO autoProductVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(autoProductVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(autoProductVO.getUiid());
		this.deleteinvent(autoProductVO.getUiid());
		return this.autoProductDao.deleteForObj(autoProductVO);
	}

	/**
	 * 删除一条【产品管理】信息
	 * @param map 产品管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("cap_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("cap_uiid"));
		this.deleteinvent(map.get("cap_uiid"));
		return this.autoProductDao.delete(map.get("cap_uiid"));
	}

	/**
	 * 批量删除【产品管理】信息
	 * @param autoProductVOlist 产品管理信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> autoProductVOlist) throws Exception {
		if(autoProductVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < autoProductVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += autoProductVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoProductDao.deleteBatch(autoProductVOlist);
	}

	/**
	 * 批量删除【产品管理】信息
	 * @param autoProductVOlist 产品管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<AutoProductVO> autoProductVOlist) throws Exception {
		List<String> autoProductVOlist1 = new ArrayList<String>();
		String stss = "";
		for (AutoProductVO autoProductVO : autoProductVOlist) {
			autoProductVOlist1.add(autoProductVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += autoProductVO.getUiid();
		}
		if(autoProductVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoProductDao.deleteBatch(autoProductVOlist1);
	}

	/**
	 * 批量删除【产品管理】信息
	 * @param maplist 产品管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> autoProductVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			autoProductVOlist1.add(map.get("cap_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("cap_uiid");
		}
		if(autoProductVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoProductDao.deleteBatch(autoProductVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 产品管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.autoProductDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.autoProductDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【产品管理】信息
	 * @param autoProductVOid 产品管理信息主键
	 * @return 产品管理信息对象
	 */
	@Override
	public AutoProductVO searchById(String autoProductVOid) throws Exception {
		if(!StringUtil.isNotNull(autoProductVOid)){
			throw new Exception("数据空异常");
		}
		return this.autoProductDao.searchById(autoProductVOid);
	}

	/**
	 * 批量查询【产品管理】信息
	 * @param uiids 产品管理信息主键列表
	 * @return 产品管理信息对象列表
	 */
	@Override
	public List<AutoProductVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<AutoProductVO> autoProductListtemp = this.autoProductDao.searchBatch(list);
		List<AutoProductVO> autoProductList = new ArrayList<AutoProductVO>();
		for(String uu : u){
			AutoProductVO autoProductVO = null;
			for(int i = 0 ; i < autoProductListtemp.size() ; i ++){
				autoProductVO = autoProductListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(autoProductVO.getUiid())){
					autoProductList.add(autoProductVO);
				}
			}
		}
		return autoProductList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param autoProductVO 产品管理信息对象
	 * @return 产品管理信息对象列表
	 */
	@Override
	public List<AutoProductVO> searchByMoreId(AutoProductVO autoProductVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 产品管理json信息对象
	 * @return 产品管理信息对象列表
	 */
	@Override
	public List<AutoProductVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 产品管理map信息对象
	 * @return 产品管理信息对象列表
	 */
	@Override
	public List<AutoProductVO> searchByMoreId(Map<String,Object> map) {
		return this.autoProductDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param autoProductVO 产品管理信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(AutoProductVO autoProductVO) {
		return this.autoProductDao.searchCountByObj(autoProductVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param autoProductVO 产品管理信息对象
	 * @return 产品管理信息对象
	 */
	@Override
	public AutoProductVO searchObjByObj(AutoProductVO autoProductVO) {
		return this.autoProductDao.searchObjByObj(autoProductVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param autoProductVO 产品管理信息对象
	 * @return 产品管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoProductVO> searchListByObj(AutoProductVO autoProductVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoProductVO> list = this.autoProductDao.searchListByObj(autoProductVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoProductVO> page = new PageInfo<AutoProductVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 产品管理map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 产品管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoProductVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		AutoProductVO autoProductVO = new AutoProductVO();
		BeanRefUtil.setFieldValue(autoProductVO, map);
		return searchListPageByObj(autoProductVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoProductVO 产品管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 产品管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoProductVO> searchListPageByObj(AutoProductVO autoProductVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoProductVO> list = this.autoProductDao.searchListPageByObj(autoProductVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoProductVO> page = new PageInfo<AutoProductVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoProductVO 产品管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 产品管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoProductVO> searchListPageByObjOr(AutoProductVO autoProductVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoProductVO> list = this.autoProductDao.searchListPageByObjOr(autoProductVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoProductVO> page = new PageInfo<AutoProductVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoProductVO 产品管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 产品管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(AutoProductVO autoProductVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.autoProductDao.searchListPageByObjRefin(autoProductVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoProductVO 产品管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 产品管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(AutoProductVO autoProductVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.autoProductDao.searchListPageByObjReftable(autoProductVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【产品管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 产品管理信息对象
	 * autoProductVO
	 * pageNo
	 * pageSize
	 * @return 产品管理信息对象列表，含分页对象
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
			List<AutoProductVO> autoProductVOlist = new ArrayList<AutoProductVO>();
			for(int i = 0 ; i < uiids.length ; i ++){
				if(StringUtil.isNotNull(uiids[i])){
					AutoProductVO autoProductVO = new AutoProductVO();
					autoProductVO.setUiid(uiids[i]);
					autoProductVO.setSort(i*10 + 10);
					autoProductVOlist.add(autoProductVO);
				}
			}
			return this.autoProductDao.updateBatch(autoProductVOlist);
		}else{
			throw new Exception("排序数据为空");
		}
	}
	
	
	
	
	
}
