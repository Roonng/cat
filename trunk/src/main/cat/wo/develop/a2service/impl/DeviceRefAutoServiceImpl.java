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
import wo.develop.a4dao.IDeviceRefAutoDao;
import wo.develop.a5vo.DeviceRefAutoVO;
import wo.develop.a3service.IDeviceRefAutoService;
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
 * 设备任务安排管理信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("deviceRefAutoService")
public class DeviceRefAutoServiceImpl implements IDeviceRefAutoService {
	private static Logger log = LoggerFactory.getLogger(DeviceRefAutoServiceImpl.class);

	@Resource
	private IDeviceRefAutoDao deviceRefAutoDao;

	/**
	 * 插入一条【设备任务安排管理】信息
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(DeviceRefAutoVO deviceRefAutoVO) {
		if(!StringUtil.isNotNull(deviceRefAutoVO.getUiid())){
			deviceRefAutoVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.deviceRefAutoDao.insert(deviceRefAutoVO);
	}

	/**
	 * 插入一条【设备任务安排管理】信息
	 * @param map 设备任务安排管理信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		DeviceRefAutoVO deviceRefAutoVO = new DeviceRefAutoVO();
		BeanRefUtil.setFieldValue(deviceRefAutoVO, map);
		if(!StringUtil.isNotNull(deviceRefAutoVO.getUiid())){
			deviceRefAutoVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.deviceRefAutoDao.insert(deviceRefAutoVO);
	}

	/**
	 * 插入一条【设备任务安排管理】信息
	 * @param json 设备任务安排管理信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		DeviceRefAutoVO deviceRefAutoVO = (DeviceRefAutoVO )JsonHelper.jsonToObj(DeviceRefAutoVO.class.getName(), json);
		if(!StringUtil.isNull(deviceRefAutoVO)){
			if(!StringUtil.isNotNull(deviceRefAutoVO.getUiid())){
				deviceRefAutoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.deviceRefAutoDao.insert(deviceRefAutoVO);
		}
		return 0;
	}

	/**
	 * 批量插入【设备任务安排管理】信息
	 * @param objlist 设备任务安排管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<DeviceRefAutoVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			DeviceRefAutoVO deviceRefAutoVO = objlist.get(i);
			if(!StringUtil.isNotNull(deviceRefAutoVO.getUiid())){
				deviceRefAutoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.deviceRefAutoDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【设备任务安排管理】信息
	 * @param maplist 设备任务安排管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<DeviceRefAutoVO> objlist = new ArrayList<DeviceRefAutoVO>();
		for (Map<String, String> map : maplist) {
			DeviceRefAutoVO deviceRefAutoVO = new DeviceRefAutoVO();
			BeanRefUtil.setFieldValue(deviceRefAutoVO, map);
			if(!StringUtil.isNotNull(deviceRefAutoVO.getUiid())){
				deviceRefAutoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(deviceRefAutoVO);
		}
		return this.deviceRefAutoDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【设备任务安排管理】信息
	 * @param obj 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(DeviceRefAutoVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【设备任务安排管理】信息
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(DeviceRefAutoVO deviceRefAutoVO) {
		if(!StringUtil.isNull(deviceRefAutoVO)){
			if(StringUtil.isNotNull(deviceRefAutoVO.getUiid())){
				return this.deviceRefAutoDao.update(deviceRefAutoVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【设备任务安排管理】信息
	 * @param map 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		DeviceRefAutoVO deviceRefAutoVO = new DeviceRefAutoVO();
		BeanRefUtil.setFieldValue(deviceRefAutoVO, map);
		if(StringUtil.isNotNull(deviceRefAutoVO.getUiid())){
			return this.deviceRefAutoDao.update(deviceRefAutoVO);
		}
		return 0;
	}

	/**
	 * 批量更新【设备任务安排管理】信息
	 * @param objlist 设备任务安排管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<DeviceRefAutoVO> objlist) {
		for(DeviceRefAutoVO deviceRefAutoVO:objlist){
			if(!StringUtil.isNotNull(deviceRefAutoVO.getUiid())){
				return 0;
			}
		}
		return this.deviceRefAutoDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【设备任务安排管理】信息
	 * @param maplist 设备任务安排管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<DeviceRefAutoVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			DeviceRefAutoVO deviceRefAutoVO = new DeviceRefAutoVO();
			BeanRefUtil.setFieldValue(deviceRefAutoVO, map);
			objlist.add(deviceRefAutoVO);
		}
		for(DeviceRefAutoVO deviceRefAutoVO:objlist){
			if(!StringUtil.isNotNull(deviceRefAutoVO.getUiid())){
				return 0;
			}
		}
		return this.deviceRefAutoDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【设备任务安排管理】信息
	 * @param map 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.deviceRefAutoDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 设备任务安排管理信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						DeviceRefAutoVO deviceRefAutoVO = deviceRefAutoDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(DeviceRefAutoVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(DeviceRefAutoVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(deviceRefAutoVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					DeviceRefAutoVO deviceRefAutoVO = deviceRefAutoDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(DeviceRefAutoVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(DeviceRefAutoVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(deviceRefAutoVO);
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
	 * @param datauiid 设备任务安排管理信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【设备任务安排管理】信息
	 * @param deviceRefAutoid 设备任务安排管理信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String deviceRefAutoid) {
		if(!StringUtil.isNotNull(deviceRefAutoid)){
			return -1;
		}
		this.deletefile(deviceRefAutoid);
		this.deleteinvent(deviceRefAutoid);
		return this.deviceRefAutoDao.delete(deviceRefAutoid);
	}
	
	
	/**
	 * 删除一条【设备任务安排管理】信息
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(DeviceRefAutoVO deviceRefAutoVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(deviceRefAutoVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(deviceRefAutoVO.getUiid());
		this.deleteinvent(deviceRefAutoVO.getUiid());
		return this.deviceRefAutoDao.deleteForObj(deviceRefAutoVO);
	}

	/**
	 * 删除一条【设备任务安排管理】信息
	 * @param map 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("cdra_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("cdra_uiid"));
		this.deleteinvent(map.get("cdra_uiid"));
		return this.deviceRefAutoDao.delete(map.get("cdra_uiid"));
	}

	/**
	 * 批量删除【设备任务安排管理】信息
	 * @param deviceRefAutoVOlist 设备任务安排管理信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> deviceRefAutoVOlist) throws Exception {
		if(deviceRefAutoVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < deviceRefAutoVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += deviceRefAutoVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.deviceRefAutoDao.deleteBatch(deviceRefAutoVOlist);
	}

	/**
	 * 批量删除【设备任务安排管理】信息
	 * @param deviceRefAutoVOlist 设备任务安排管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<DeviceRefAutoVO> deviceRefAutoVOlist) throws Exception {
		List<String> deviceRefAutoVOlist1 = new ArrayList<String>();
		String stss = "";
		for (DeviceRefAutoVO deviceRefAutoVO : deviceRefAutoVOlist) {
			deviceRefAutoVOlist1.add(deviceRefAutoVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += deviceRefAutoVO.getUiid();
		}
		if(deviceRefAutoVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.deviceRefAutoDao.deleteBatch(deviceRefAutoVOlist1);
	}

	/**
	 * 批量删除【设备任务安排管理】信息
	 * @param maplist 设备任务安排管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> deviceRefAutoVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			deviceRefAutoVOlist1.add(map.get("cdra_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("cdra_uiid");
		}
		if(deviceRefAutoVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.deviceRefAutoDao.deleteBatch(deviceRefAutoVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 设备任务安排管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.deviceRefAutoDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.deviceRefAutoDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【设备任务安排管理】信息
	 * @param deviceRefAutoVOid 设备任务安排管理信息主键
	 * @return 设备任务安排管理信息对象
	 */
	@Override
	public DeviceRefAutoVO searchById(String deviceRefAutoVOid) throws Exception {
		if(!StringUtil.isNotNull(deviceRefAutoVOid)){
			throw new Exception("数据空异常");
		}
		return this.deviceRefAutoDao.searchById(deviceRefAutoVOid);
	}

	/**
	 * 批量查询【设备任务安排管理】信息
	 * @param uiids 设备任务安排管理信息主键列表
	 * @return 设备任务安排管理信息对象列表
	 */
	@Override
	public List<DeviceRefAutoVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<DeviceRefAutoVO> deviceRefAutoListtemp = this.deviceRefAutoDao.searchBatch(list);
		List<DeviceRefAutoVO> deviceRefAutoList = new ArrayList<DeviceRefAutoVO>();
		for(String uu : u){
			DeviceRefAutoVO deviceRefAutoVO = null;
			for(int i = 0 ; i < deviceRefAutoListtemp.size() ; i ++){
				deviceRefAutoVO = deviceRefAutoListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(deviceRefAutoVO.getUiid())){
					deviceRefAutoList.add(deviceRefAutoVO);
				}
			}
		}
		return deviceRefAutoList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 设备任务安排管理信息对象列表
	 */
	@Override
	public List<DeviceRefAutoVO> searchByMoreId(DeviceRefAutoVO deviceRefAutoVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 设备任务安排管理json信息对象
	 * @return 设备任务安排管理信息对象列表
	 */
	@Override
	public List<DeviceRefAutoVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 设备任务安排管理map信息对象
	 * @return 设备任务安排管理信息对象列表
	 */
	@Override
	public List<DeviceRefAutoVO> searchByMoreId(Map<String,Object> map) {
		return this.deviceRefAutoDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(DeviceRefAutoVO deviceRefAutoVO) {
		return this.deviceRefAutoDao.searchCountByObj(deviceRefAutoVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 设备任务安排管理信息对象
	 */
	@Override
	public DeviceRefAutoVO searchObjByObj(DeviceRefAutoVO deviceRefAutoVO) {
		return this.deviceRefAutoDao.searchObjByObj(deviceRefAutoVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @return 设备任务安排管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<DeviceRefAutoVO> searchListByObj(DeviceRefAutoVO deviceRefAutoVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<DeviceRefAutoVO> list = this.deviceRefAutoDao.searchListByObj(deviceRefAutoVO);
		// 用PageInfo对结果进行包装
		PageInfo<DeviceRefAutoVO> page = new PageInfo<DeviceRefAutoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 设备任务安排管理map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备任务安排管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<DeviceRefAutoVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		DeviceRefAutoVO deviceRefAutoVO = new DeviceRefAutoVO();
		BeanRefUtil.setFieldValue(deviceRefAutoVO, map);
		return searchListPageByObj(deviceRefAutoVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备任务安排管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<DeviceRefAutoVO> searchListPageByObj(DeviceRefAutoVO deviceRefAutoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<DeviceRefAutoVO> list = this.deviceRefAutoDao.searchListPageByObj(deviceRefAutoVO);
		// 用PageInfo对结果进行包装
		PageInfo<DeviceRefAutoVO> page = new PageInfo<DeviceRefAutoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备任务安排管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<DeviceRefAutoVO> searchListPageByObjOr(DeviceRefAutoVO deviceRefAutoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<DeviceRefAutoVO> list = this.deviceRefAutoDao.searchListPageByObjOr(deviceRefAutoVO);
		// 用PageInfo对结果进行包装
		PageInfo<DeviceRefAutoVO> page = new PageInfo<DeviceRefAutoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备任务安排管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(DeviceRefAutoVO deviceRefAutoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.deviceRefAutoDao.searchListPageByObjRefin(deviceRefAutoVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param deviceRefAutoVO 设备任务安排管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 设备任务安排管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(DeviceRefAutoVO deviceRefAutoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.deviceRefAutoDao.searchListPageByObjReftable(deviceRefAutoVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【设备任务安排管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 设备任务安排管理信息对象
	 * deviceRefAutoVO
	 * pageNo
	 * pageSize
	 * @return 设备任务安排管理信息对象列表，含分页对象
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
