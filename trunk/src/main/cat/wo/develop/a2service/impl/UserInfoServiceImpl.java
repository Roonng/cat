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
import wo.develop.a4dao.IUserInfoDao;
import wo.develop.a5vo.UserInfoVO;
import wo.develop.a3service.IUserInfoService;
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
 * 用户信息管理信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
	private static Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Resource
	private IUserInfoDao userInfoDao;

	/**
	 * 插入一条【用户信息管理】信息
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(UserInfoVO userInfoVO) {
		if(!StringUtil.isNotNull(userInfoVO.getUiid())){
			userInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.userInfoDao.insert(userInfoVO);
	}

	/**
	 * 插入一条【用户信息管理】信息
	 * @param map 用户信息管理信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		UserInfoVO userInfoVO = new UserInfoVO();
		BeanRefUtil.setFieldValue(userInfoVO, map);
		if(!StringUtil.isNotNull(userInfoVO.getUiid())){
			userInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.userInfoDao.insert(userInfoVO);
	}

	/**
	 * 插入一条【用户信息管理】信息
	 * @param json 用户信息管理信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		UserInfoVO userInfoVO = (UserInfoVO )JsonHelper.jsonToObj(UserInfoVO.class.getName(), json);
		if(!StringUtil.isNull(userInfoVO)){
			if(!StringUtil.isNotNull(userInfoVO.getUiid())){
				userInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.userInfoDao.insert(userInfoVO);
		}
		return 0;
	}

	/**
	 * 批量插入【用户信息管理】信息
	 * @param objlist 用户信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<UserInfoVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			UserInfoVO userInfoVO = objlist.get(i);
			if(!StringUtil.isNotNull(userInfoVO.getUiid())){
				userInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.userInfoDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【用户信息管理】信息
	 * @param maplist 用户信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<UserInfoVO> objlist = new ArrayList<UserInfoVO>();
		for (Map<String, String> map : maplist) {
			UserInfoVO userInfoVO = new UserInfoVO();
			BeanRefUtil.setFieldValue(userInfoVO, map);
			if(!StringUtil.isNotNull(userInfoVO.getUiid())){
				userInfoVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(userInfoVO);
		}
		return this.userInfoDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【用户信息管理】信息
	 * @param obj 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(UserInfoVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【用户信息管理】信息
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(UserInfoVO userInfoVO) {
		if(!StringUtil.isNull(userInfoVO)){
			if(StringUtil.isNotNull(userInfoVO.getUiid())){
				return this.userInfoDao.update(userInfoVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【用户信息管理】信息
	 * @param map 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		UserInfoVO userInfoVO = new UserInfoVO();
		BeanRefUtil.setFieldValue(userInfoVO, map);
		if(StringUtil.isNotNull(userInfoVO.getUiid())){
			return this.userInfoDao.update(userInfoVO);
		}
		return 0;
	}

	/**
	 * 批量更新【用户信息管理】信息
	 * @param objlist 用户信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<UserInfoVO> objlist) {
		for(UserInfoVO userInfoVO:objlist){
			if(!StringUtil.isNotNull(userInfoVO.getUiid())){
				return 0;
			}
		}
		return this.userInfoDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【用户信息管理】信息
	 * @param maplist 用户信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<UserInfoVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			UserInfoVO userInfoVO = new UserInfoVO();
			BeanRefUtil.setFieldValue(userInfoVO, map);
			objlist.add(userInfoVO);
		}
		for(UserInfoVO userInfoVO:objlist){
			if(!StringUtil.isNotNull(userInfoVO.getUiid())){
				return 0;
			}
		}
		return this.userInfoDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【用户信息管理】信息
	 * @param map 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.userInfoDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 用户信息管理信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						UserInfoVO userInfoVO = userInfoDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(UserInfoVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(UserInfoVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(userInfoVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					UserInfoVO userInfoVO = userInfoDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(UserInfoVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(UserInfoVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(userInfoVO);
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
	 * @param datauiid 用户信息管理信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【用户信息管理】信息
	 * @param userInfoid 用户信息管理信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String userInfoid) {
		if(!StringUtil.isNotNull(userInfoid)){
			return -1;
		}
		this.deletefile(userInfoid);
		this.deleteinvent(userInfoid);
		return this.userInfoDao.delete(userInfoid);
	}
	
	
	/**
	 * 删除一条【用户信息管理】信息
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(UserInfoVO userInfoVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(userInfoVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(userInfoVO.getUiid());
		this.deleteinvent(userInfoVO.getUiid());
		return this.userInfoDao.deleteForObj(userInfoVO);
	}

	/**
	 * 删除一条【用户信息管理】信息
	 * @param map 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("cui_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("cui_uiid"));
		this.deleteinvent(map.get("cui_uiid"));
		return this.userInfoDao.delete(map.get("cui_uiid"));
	}

	/**
	 * 批量删除【用户信息管理】信息
	 * @param userInfoVOlist 用户信息管理信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> userInfoVOlist) throws Exception {
		if(userInfoVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < userInfoVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += userInfoVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.userInfoDao.deleteBatch(userInfoVOlist);
	}

	/**
	 * 批量删除【用户信息管理】信息
	 * @param userInfoVOlist 用户信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<UserInfoVO> userInfoVOlist) throws Exception {
		List<String> userInfoVOlist1 = new ArrayList<String>();
		String stss = "";
		for (UserInfoVO userInfoVO : userInfoVOlist) {
			userInfoVOlist1.add(userInfoVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += userInfoVO.getUiid();
		}
		if(userInfoVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.userInfoDao.deleteBatch(userInfoVOlist1);
	}

	/**
	 * 批量删除【用户信息管理】信息
	 * @param maplist 用户信息管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> userInfoVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			userInfoVOlist1.add(map.get("cui_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("cui_uiid");
		}
		if(userInfoVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.userInfoDao.deleteBatch(userInfoVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 用户信息管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.userInfoDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.userInfoDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【用户信息管理】信息
	 * @param userInfoVOid 用户信息管理信息主键
	 * @return 用户信息管理信息对象
	 */
	@Override
	public UserInfoVO searchById(String userInfoVOid) throws Exception {
		if(!StringUtil.isNotNull(userInfoVOid)){
			throw new Exception("数据空异常");
		}
		return this.userInfoDao.searchById(userInfoVOid);
	}

	/**
	 * 批量查询【用户信息管理】信息
	 * @param uiids 用户信息管理信息主键列表
	 * @return 用户信息管理信息对象列表
	 */
	@Override
	public List<UserInfoVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<UserInfoVO> userInfoListtemp = this.userInfoDao.searchBatch(list);
		List<UserInfoVO> userInfoList = new ArrayList<UserInfoVO>();
		for(String uu : u){
			UserInfoVO userInfoVO = null;
			for(int i = 0 ; i < userInfoListtemp.size() ; i ++){
				userInfoVO = userInfoListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(userInfoVO.getUiid())){
					userInfoList.add(userInfoVO);
				}
			}
		}
		return userInfoList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 用户信息管理信息对象列表
	 */
	@Override
	public List<UserInfoVO> searchByMoreId(UserInfoVO userInfoVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 用户信息管理json信息对象
	 * @return 用户信息管理信息对象列表
	 */
	@Override
	public List<UserInfoVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 用户信息管理map信息对象
	 * @return 用户信息管理信息对象列表
	 */
	@Override
	public List<UserInfoVO> searchByMoreId(Map<String,Object> map) {
		return this.userInfoDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(UserInfoVO userInfoVO) {
		return this.userInfoDao.searchCountByObj(userInfoVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 用户信息管理信息对象
	 */
	@Override
	public UserInfoVO searchObjByObj(UserInfoVO userInfoVO) {
		return this.userInfoDao.searchObjByObj(userInfoVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param userInfoVO 用户信息管理信息对象
	 * @return 用户信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<UserInfoVO> searchListByObj(UserInfoVO userInfoVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<UserInfoVO> list = this.userInfoDao.searchListByObj(userInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<UserInfoVO> page = new PageInfo<UserInfoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 用户信息管理map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<UserInfoVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		UserInfoVO userInfoVO = new UserInfoVO();
		BeanRefUtil.setFieldValue(userInfoVO, map);
		return searchListPageByObj(userInfoVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userInfoVO 用户信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<UserInfoVO> searchListPageByObj(UserInfoVO userInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<UserInfoVO> list = this.userInfoDao.searchListPageByObj(userInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<UserInfoVO> page = new PageInfo<UserInfoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userInfoVO 用户信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<UserInfoVO> searchListPageByObjOr(UserInfoVO userInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<UserInfoVO> list = this.userInfoDao.searchListPageByObjOr(userInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<UserInfoVO> page = new PageInfo<UserInfoVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userInfoVO 用户信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(UserInfoVO userInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.userInfoDao.searchListPageByObjRefin(userInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userInfoVO 用户信息管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户信息管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(UserInfoVO userInfoVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.userInfoDao.searchListPageByObjReftable(userInfoVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【用户信息管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 用户信息管理信息对象
	 * userInfoVO
	 * pageNo
	 * pageSize
	 * @return 用户信息管理信息对象列表，含分页对象
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
