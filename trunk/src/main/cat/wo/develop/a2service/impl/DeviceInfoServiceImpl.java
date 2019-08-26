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
import wo.develop.a4dao.IDeviceInfoDao;
import wo.develop.a5vo.DeviceInfoVO;
import wo.develop.a3service.IDeviceInfoService;
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
 * 设备信息管理信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("deviceInfoService")
public class DeviceInfoServiceImpl implements IDeviceInfoService {
	private static Logger log = LoggerFactory.getLogger(DeviceInfoServiceImpl.class);

	@Resource
	private IDeviceInfoDao deviceInfoDao;

	/**
	 * 插入一条【设备信息管理】信息
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(DeviceInfoVO deviceInfoVO) {
		if(!StringUtil.isNotNull(deviceInfoVO.getUiid())){
			deviceInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.deviceInfoDao.insert(deviceInfoVO);
	}

	/**
	 * 插入一条【设备信息管理】信息
	 * @param map 设备信息管理信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		DeviceInfoVO deviceInfoVO = new DeviceInfoVO();
		BeanRefUtil.setFieldValue(deviceInfoVO, map);
		if(!StringUtil.isNotNull(deviceInfoVO.getUiid())){
			deviceInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.deviceInfoDao.insert(deviceInfoVO);
	}

	/**
	 * 插入一条【设备信息管理】信息
	 * @param json 设备信息管理信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		DeviceInfoVO deviceInfoVO = (DeviceInfoVO )JsonHelper.jsonToObj(DeviceInfoVO.class.getName(), json);
		if(!StringUtil.isNull(deviceInfoVO)){
			if(!StringUtil.isNotNull(deviceInfoVO.getUiid())){
				deviceInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.deviceInfoDao.insert(deviceInfoVO);
		}
		return 0;
	}

	/**
	 * 批量插入【设备信息管理】信息
	 * @param objlist 设备信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<DeviceInfoVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			DeviceInfoVO deviceInfoVO = objlist.get(i);
			if(!StringUtil.isNotNull(deviceInfoVO.getUiid())){
				deviceInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.deviceInfoDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【设备信息管理】信息
	 * @param maplist 设备信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<DeviceInfoVO> objlist = new ArrayList<DeviceInfoVO>();
		for (Map<String, String> map : maplist) {
			DeviceInfoVO deviceInfoVO = new DeviceInfoVO();
			BeanRefUtil.setFieldValue(deviceInfoVO, map);
			if(!StringUtil.isNotNull(deviceInfoVO.getUiid())){
				deviceInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(deviceInfoVO);
		}
		return this.deviceInfoDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【设备信息管理】信息
	 * @param obj 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(DeviceInfoVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【设备信息管理】信息
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(DeviceInfoVO deviceInfoVO) {
		if(!StringUtil.isNull(deviceInfoVO)){
			if(StringUtil.isNotNull(deviceInfoVO.getUiid())){
				return this.deviceInfoDao.update(deviceInfoVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【设备信息管理】信息
	 * @param map 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		DeviceInfoVO deviceInfoVO = new DeviceInfoVO();
		BeanRefUtil.setFieldValue(deviceInfoVO, map);
		if(StringUtil.isNotNull(deviceInfoVO.getUiid())){
			return this.deviceInfoDao.update(deviceInfoVO);
		}
		return 0;
	}

	/**
	 * 批量更新【设备信息管理】信息
	 * @param objlist 设备信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<DeviceInfoVO> objlist) {
		for(DeviceInfoVO deviceInfoVO:objlist){
			if(!StringUtil.isNotNull(deviceInfoVO.getUiid())){
				return 0;
			}
		}
		return this.deviceInfoDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【设备信息管理】信息
	 * @param maplist 设备信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<DeviceInfoVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			DeviceInfoVO deviceInfoVO = new DeviceInfoVO();
			BeanRefUtil.setFieldValue(deviceInfoVO, map);
			objlist.add(deviceInfoVO);
		}
		for(DeviceInfoVO deviceInfoVO:objlist){
			if(!StringUtil.isNotNull(deviceInfoVO.getUiid())){
				return 0;
			}
		}
		return this.deviceInfoDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【设备信息管理】信息
	 * @param map 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.deviceInfoDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 设备信息管理信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						DeviceInfoVO deviceInfoVO = deviceInfoDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(DeviceInfoVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(DeviceInfoVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(deviceInfoVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					DeviceInfoVO deviceInfoVO = deviceInfoDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(DeviceInfoVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(DeviceInfoVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(deviceInfoVO);
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
	 * @param datauiid 设备信息管理信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【设备信息管理】信息
	 * @param deviceInfoid 设备信息管理信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String deviceInfoid) {
		if(!StringUtil.isNotNull(deviceInfoid)){
			return -1;
		}
		this.deletefile(deviceInfoid);
		this.deleteinvent(deviceInfoid);
		return this.deviceInfoDao.delete(deviceInfoid);
	}
	
	
	/**
	 * 删除一条【设备信息管理】信息
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(DeviceInfoVO deviceInfoVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(deviceInfoVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(deviceInfoVO.getUiid());
		this.deleteinvent(deviceInfoVO.getUiid());
		return this.deviceInfoDao.deleteForObj(deviceInfoVO);
	}

	/**
	 * 删除一条【设备信息管理】信息
	 * @param map 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("cdi_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("cdi_uiid"));
		this.deleteinvent(map.get("cdi_uiid"));
		return this.deviceInfoDao.delete(map.get("cdi_uiid"));
	}

	/**
	 * 批量删除【设备信息管理】信息
	 * @param deviceInfoVOlist 设备信息管理信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> deviceInfoVOlist) throws Exception {
		if(deviceInfoVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < deviceInfoVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += deviceInfoVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.deviceInfoDao.deleteBatch(deviceInfoVOlist);
	}

	/**
	 * 批量删除【设备信息管理】信息
	 * @param deviceInfoVOlist 设备信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<DeviceInfoVO> deviceInfoVOlist) throws Exception {
		List<String> deviceInfoVOlist1 = new ArrayList<String>();
		String stss = "";
		for (DeviceInfoVO deviceInfoVO : deviceInfoVOlist) {
			deviceInfoVOlist1.add(deviceInfoVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += deviceInfoVO.getUiid();
		}
		if(deviceInfoVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.deviceInfoDao.deleteBatch(deviceInfoVOlist1);
	}

	/**
	 * 批量删除【设备信息管理】信息
	 * @param maplist 设备信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> deviceInfoVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			deviceInfoVOlist1.add(map.get("cdi_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("cdi_uiid");
		}
		if(deviceInfoVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.deviceInfoDao.deleteBatch(deviceInfoVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 设备信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.deviceInfoDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.deviceInfoDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【设备信息管理】信息
	 * @param deviceInfoVOid 设备信息管理信息主键
	 * @return 设备信息管理信息对象
	 */
	@Override
	public DeviceInfoVO searchById(String deviceInfoVOid) throws Exception {
		if(!StringUtil.isNotNull(deviceInfoVOid)){
			throw new Exception("数据空异常");
		}
		return this.deviceInfoDao.searchById(deviceInfoVOid);
	}

	/**
	 * 批量查询【设备信息管理】信息
	 * @param uiids 设备信息管理信息主键列表
	 * @return 设备信息管理信息对象列表
	 */
	@Override
	public List<DeviceInfoVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<DeviceInfoVO> deviceInfoListtemp = this.deviceInfoDao.searchBatch(list);
		List<DeviceInfoVO> deviceInfoList = new ArrayList<DeviceInfoVO>();
		for(String uu : u){
			DeviceInfoVO deviceInfoVO = null;
			for(int i = 0 ; i < deviceInfoListtemp.size() ; i ++){
				deviceInfoVO = deviceInfoListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(deviceInfoVO.getUiid())){
					deviceInfoList.add(deviceInfoVO);
				}
			}
		}
		return deviceInfoList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 设备信息管理信息对象列表
	 */
	@Override
	public List<DeviceInfoVO> searchByMoreId(DeviceInfoVO deviceInfoVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 设备信息管理json信息对象
	 * @return 设备信息管理信息对象列表
	 */
	@Override
	public List<DeviceInfoVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 设备信息管理map信息对象
	 * @return 设备信息管理信息对象列表
	 */
	@Override
	public List<DeviceInfoVO> searchByMoreId(Map<String,Object> map) {
		return this.deviceInfoDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(DeviceInfoVO deviceInfoVO) {
		return this.deviceInfoDao.searchCountByObj(deviceInfoVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 设备信息管理信息对象
	 */
	@Override
	public DeviceInfoVO searchObjByObj(DeviceInfoVO deviceInfoVO) {
		return this.deviceInfoDao.searchObjByObj(deviceInfoVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @return 设备信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<DeviceInfoVO> searchListByObj(DeviceInfoVO deviceInfoVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<DeviceInfoVO> list = this.deviceInfoDao.searchListByObj(deviceInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<DeviceInfoVO> page = new PageInfo<DeviceInfoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 设备信息管理map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<DeviceInfoVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		DeviceInfoVO deviceInfoVO = new DeviceInfoVO();
		BeanRefUtil.setFieldValue(deviceInfoVO, map);
		return searchListPageByObj(deviceInfoVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<DeviceInfoVO> searchListPageByObj(DeviceInfoVO deviceInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<DeviceInfoVO> list = this.deviceInfoDao.searchListPageByObj(deviceInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<DeviceInfoVO> page = new PageInfo<DeviceInfoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<DeviceInfoVO> searchListPageByObjOr(DeviceInfoVO deviceInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<DeviceInfoVO> list = this.deviceInfoDao.searchListPageByObjOr(deviceInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<DeviceInfoVO> page = new PageInfo<DeviceInfoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(DeviceInfoVO deviceInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.deviceInfoDao.searchListPageByObjRefin(deviceInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceInfoVO 设备信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(DeviceInfoVO deviceInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.deviceInfoDao.searchListPageByObjReftable(deviceInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【设备信息管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 设备信息管理信息对象
	 * deviceInfoVO
	 * pageNo
	 * pageSize
	 * @return 设备信息管理信息对象列表，含分页对象
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
