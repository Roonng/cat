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
import wo.develop.a4dao.ISoftInfoDao;
import wo.develop.a5vo.SoftInfoVO;
import wo.develop.a3service.ISoftInfoService;
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
 * 软件管理信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("softInfoService")
public class SoftInfoServiceImpl implements ISoftInfoService {
	private static Logger log = LoggerFactory.getLogger(SoftInfoServiceImpl.class);

	@Resource
	private ISoftInfoDao softInfoDao;

	/**
	 * 插入一条【软件管理】信息
	 * @param softInfoVO 软件管理信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(SoftInfoVO softInfoVO) {
		if(!StringUtil.isNotNull(softInfoVO.getUiid())){
			softInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.softInfoDao.insert(softInfoVO);
	}

	/**
	 * 插入一条【软件管理】信息
	 * @param map 软件管理信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		SoftInfoVO softInfoVO = new SoftInfoVO();
		BeanRefUtil.setFieldValue(softInfoVO, map);
		if(!StringUtil.isNotNull(softInfoVO.getUiid())){
			softInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.softInfoDao.insert(softInfoVO);
	}

	/**
	 * 插入一条【软件管理】信息
	 * @param json 软件管理信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		SoftInfoVO softInfoVO = (SoftInfoVO )JsonHelper.jsonToObj(SoftInfoVO.class.getName(), json);
		if(!StringUtil.isNull(softInfoVO)){
			if(!StringUtil.isNotNull(softInfoVO.getUiid())){
				softInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.softInfoDao.insert(softInfoVO);
		}
		return 0;
	}

	/**
	 * 批量插入【软件管理】信息
	 * @param objlist 软件管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<SoftInfoVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			SoftInfoVO softInfoVO = objlist.get(i);
			if(!StringUtil.isNotNull(softInfoVO.getUiid())){
				softInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.softInfoDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【软件管理】信息
	 * @param maplist 软件管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<SoftInfoVO> objlist = new ArrayList<SoftInfoVO>();
		for (Map<String, String> map : maplist) {
			SoftInfoVO softInfoVO = new SoftInfoVO();
			BeanRefUtil.setFieldValue(softInfoVO, map);
			if(!StringUtil.isNotNull(softInfoVO.getUiid())){
				softInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(softInfoVO);
		}
		return this.softInfoDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【软件管理】信息
	 * @param obj 软件管理信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(SoftInfoVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【软件管理】信息
	 * @param softInfoVO 软件管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(SoftInfoVO softInfoVO) {
		if(!StringUtil.isNull(softInfoVO)){
			if(StringUtil.isNotNull(softInfoVO.getUiid())){
				return this.softInfoDao.update(softInfoVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【软件管理】信息
	 * @param map 软件管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		SoftInfoVO softInfoVO = new SoftInfoVO();
		BeanRefUtil.setFieldValue(softInfoVO, map);
		if(StringUtil.isNotNull(softInfoVO.getUiid())){
			return this.softInfoDao.update(softInfoVO);
		}
		return 0;
	}

	/**
	 * 批量更新【软件管理】信息
	 * @param objlist 软件管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<SoftInfoVO> objlist) {
		for(SoftInfoVO softInfoVO:objlist){
			if(!StringUtil.isNotNull(softInfoVO.getUiid())){
				return 0;
			}
		}
		return this.softInfoDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【软件管理】信息
	 * @param maplist 软件管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<SoftInfoVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			SoftInfoVO softInfoVO = new SoftInfoVO();
			BeanRefUtil.setFieldValue(softInfoVO, map);
			objlist.add(softInfoVO);
		}
		for(SoftInfoVO softInfoVO:objlist){
			if(!StringUtil.isNotNull(softInfoVO.getUiid())){
				return 0;
			}
		}
		return this.softInfoDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【软件管理】信息
	 * @param map 软件管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.softInfoDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 软件管理信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						SoftInfoVO softInfoVO = softInfoDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(SoftInfoVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(SoftInfoVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(softInfoVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					SoftInfoVO softInfoVO = softInfoDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(SoftInfoVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(SoftInfoVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(softInfoVO);
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
	 * @param datauiid 软件管理信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【软件管理】信息
	 * @param softInfoid 软件管理信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String softInfoid) {
		if(!StringUtil.isNotNull(softInfoid)){
			return -1;
		}
		this.deletefile(softInfoid);
		this.deleteinvent(softInfoid);
		return this.softInfoDao.delete(softInfoid);
	}
	
	
	/**
	 * 删除一条【软件管理】信息
	 * @param softInfoVO 软件管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(SoftInfoVO softInfoVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(softInfoVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(softInfoVO.getUiid());
		this.deleteinvent(softInfoVO.getUiid());
		return this.softInfoDao.deleteForObj(softInfoVO);
	}

	/**
	 * 删除一条【软件管理】信息
	 * @param map 软件管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("csi_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("csi_uiid"));
		this.deleteinvent(map.get("csi_uiid"));
		return this.softInfoDao.delete(map.get("csi_uiid"));
	}

	/**
	 * 批量删除【软件管理】信息
	 * @param softInfoVOlist 软件管理信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> softInfoVOlist) throws Exception {
		if(softInfoVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < softInfoVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += softInfoVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softInfoDao.deleteBatch(softInfoVOlist);
	}

	/**
	 * 批量删除【软件管理】信息
	 * @param softInfoVOlist 软件管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<SoftInfoVO> softInfoVOlist) throws Exception {
		List<String> softInfoVOlist1 = new ArrayList<String>();
		String stss = "";
		for (SoftInfoVO softInfoVO : softInfoVOlist) {
			softInfoVOlist1.add(softInfoVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += softInfoVO.getUiid();
		}
		if(softInfoVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softInfoDao.deleteBatch(softInfoVOlist1);
	}

	/**
	 * 批量删除【软件管理】信息
	 * @param maplist 软件管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> softInfoVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			softInfoVOlist1.add(map.get("csi_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("csi_uiid");
		}
		if(softInfoVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softInfoDao.deleteBatch(softInfoVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 软件管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.softInfoDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.softInfoDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【软件管理】信息
	 * @param softInfoVOid 软件管理信息主键
	 * @return 软件管理信息对象
	 */
	@Override
	public SoftInfoVO searchById(String softInfoVOid) throws Exception {
		if(!StringUtil.isNotNull(softInfoVOid)){
			throw new Exception("数据空异常");
		}
		return this.softInfoDao.searchById(softInfoVOid);
	}

	/**
	 * 批量查询【软件管理】信息
	 * @param uiids 软件管理信息主键列表
	 * @return 软件管理信息对象列表
	 */
	@Override
	public List<SoftInfoVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<SoftInfoVO> softInfoListtemp = this.softInfoDao.searchBatch(list);
		List<SoftInfoVO> softInfoList = new ArrayList<SoftInfoVO>();
		for(String uu : u){
			SoftInfoVO softInfoVO = null;
			for(int i = 0 ; i < softInfoListtemp.size() ; i ++){
				softInfoVO = softInfoListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(softInfoVO.getUiid())){
					softInfoList.add(softInfoVO);
				}
			}
		}
		return softInfoList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param softInfoVO 软件管理信息对象
	 * @return 软件管理信息对象列表
	 */
	@Override
	public List<SoftInfoVO> searchByMoreId(SoftInfoVO softInfoVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 软件管理json信息对象
	 * @return 软件管理信息对象列表
	 */
	@Override
	public List<SoftInfoVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 软件管理map信息对象
	 * @return 软件管理信息对象列表
	 */
	@Override
	public List<SoftInfoVO> searchByMoreId(Map<String,Object> map) {
		return this.softInfoDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param softInfoVO 软件管理信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(SoftInfoVO softInfoVO) {
		return this.softInfoDao.searchCountByObj(softInfoVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param softInfoVO 软件管理信息对象
	 * @return 软件管理信息对象
	 */
	@Override
	public SoftInfoVO searchObjByObj(SoftInfoVO softInfoVO) {
		return this.softInfoDao.searchObjByObj(softInfoVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param softInfoVO 软件管理信息对象
	 * @return 软件管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftInfoVO> searchListByObj(SoftInfoVO softInfoVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftInfoVO> list = this.softInfoDao.searchListByObj(softInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftInfoVO> page = new PageInfo<SoftInfoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 软件管理map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftInfoVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		SoftInfoVO softInfoVO = new SoftInfoVO();
		BeanRefUtil.setFieldValue(softInfoVO, map);
		return searchListPageByObj(softInfoVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softInfoVO 软件管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftInfoVO> searchListPageByObj(SoftInfoVO softInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftInfoVO> list = this.softInfoDao.searchListPageByObj(softInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftInfoVO> page = new PageInfo<SoftInfoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softInfoVO 软件管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftInfoVO> searchListPageByObjOr(SoftInfoVO softInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftInfoVO> list = this.softInfoDao.searchListPageByObjOr(softInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftInfoVO> page = new PageInfo<SoftInfoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softInfoVO 软件管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(SoftInfoVO softInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.softInfoDao.searchListPageByObjRefin(softInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softInfoVO 软件管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 软件管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(SoftInfoVO softInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.softInfoDao.searchListPageByObjReftable(softInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【软件管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 软件管理信息对象
	 * softInfoVO
	 * pageNo
	 * pageSize
	 * @return 软件管理信息对象列表，含分页对象
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
			List<SoftInfoVO> softInfoVOlist = new ArrayList<SoftInfoVO>();
			for(int i = 0 ; i < uiids.length ; i ++){
				if(StringUtil.isNotNull(uiids[i])){
					SoftInfoVO softInfoVO = new SoftInfoVO();
					softInfoVO.setUiid(uiids[i]);
					softInfoVO.setSort(i*10 + 10);
					softInfoVOlist.add(softInfoVO);
				}
			}
			return this.softInfoDao.updateBatch(softInfoVOlist);
		}else{
			throw new Exception("排序数据为空");
		}
	}
	
	
	
	
	
}
