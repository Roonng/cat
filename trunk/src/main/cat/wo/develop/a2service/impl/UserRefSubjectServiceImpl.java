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
import wo.develop.a4dao.IUserRefSubjectDao;
import wo.develop.a5vo.UserRefSubjectVO;
import wo.develop.a3service.IUserRefSubjectService;
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
 * 用户主题管理信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("userRefSubjectService")
public class UserRefSubjectServiceImpl implements IUserRefSubjectService {
	private static Logger log = LoggerFactory.getLogger(UserRefSubjectServiceImpl.class);

	@Resource
	private IUserRefSubjectDao userRefSubjectDao;

	/**
	 * 插入一条【用户主题管理】信息
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(UserRefSubjectVO userRefSubjectVO) {
		if(!StringUtil.isNotNull(userRefSubjectVO.getUiid())){
			userRefSubjectVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.userRefSubjectDao.insert(userRefSubjectVO);
	}

	/**
	 * 插入一条【用户主题管理】信息
	 * @param map 用户主题管理信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		UserRefSubjectVO userRefSubjectVO = new UserRefSubjectVO();
		BeanRefUtil.setFieldValue(userRefSubjectVO, map);
		if(!StringUtil.isNotNull(userRefSubjectVO.getUiid())){
			userRefSubjectVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.userRefSubjectDao.insert(userRefSubjectVO);
	}

	/**
	 * 插入一条【用户主题管理】信息
	 * @param json 用户主题管理信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		UserRefSubjectVO userRefSubjectVO = (UserRefSubjectVO )JsonHelper.jsonToObj(UserRefSubjectVO.class.getName(), json);
		if(!StringUtil.isNull(userRefSubjectVO)){
			if(!StringUtil.isNotNull(userRefSubjectVO.getUiid())){
				userRefSubjectVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.userRefSubjectDao.insert(userRefSubjectVO);
		}
		return 0;
	}

	/**
	 * 批量插入【用户主题管理】信息
	 * @param objlist 用户主题管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<UserRefSubjectVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			UserRefSubjectVO userRefSubjectVO = objlist.get(i);
			if(!StringUtil.isNotNull(userRefSubjectVO.getUiid())){
				userRefSubjectVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.userRefSubjectDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【用户主题管理】信息
	 * @param maplist 用户主题管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<UserRefSubjectVO> objlist = new ArrayList<UserRefSubjectVO>();
		for (Map<String, String> map : maplist) {
			UserRefSubjectVO userRefSubjectVO = new UserRefSubjectVO();
			BeanRefUtil.setFieldValue(userRefSubjectVO, map);
			if(!StringUtil.isNotNull(userRefSubjectVO.getUiid())){
				userRefSubjectVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(userRefSubjectVO);
		}
		return this.userRefSubjectDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【用户主题管理】信息
	 * @param obj 用户主题管理信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(UserRefSubjectVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【用户主题管理】信息
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(UserRefSubjectVO userRefSubjectVO) {
		if(!StringUtil.isNull(userRefSubjectVO)){
			if(StringUtil.isNotNull(userRefSubjectVO.getUiid())){
				return this.userRefSubjectDao.update(userRefSubjectVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【用户主题管理】信息
	 * @param map 用户主题管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		UserRefSubjectVO userRefSubjectVO = new UserRefSubjectVO();
		BeanRefUtil.setFieldValue(userRefSubjectVO, map);
		if(StringUtil.isNotNull(userRefSubjectVO.getUiid())){
			return this.userRefSubjectDao.update(userRefSubjectVO);
		}
		return 0;
	}

	/**
	 * 批量更新【用户主题管理】信息
	 * @param objlist 用户主题管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<UserRefSubjectVO> objlist) {
		for(UserRefSubjectVO userRefSubjectVO:objlist){
			if(!StringUtil.isNotNull(userRefSubjectVO.getUiid())){
				return 0;
			}
		}
		return this.userRefSubjectDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【用户主题管理】信息
	 * @param maplist 用户主题管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<UserRefSubjectVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			UserRefSubjectVO userRefSubjectVO = new UserRefSubjectVO();
			BeanRefUtil.setFieldValue(userRefSubjectVO, map);
			objlist.add(userRefSubjectVO);
		}
		for(UserRefSubjectVO userRefSubjectVO:objlist){
			if(!StringUtil.isNotNull(userRefSubjectVO.getUiid())){
				return 0;
			}
		}
		return this.userRefSubjectDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【用户主题管理】信息
	 * @param map 用户主题管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.userRefSubjectDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 用户主题管理信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						UserRefSubjectVO userRefSubjectVO = userRefSubjectDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(UserRefSubjectVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(UserRefSubjectVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(userRefSubjectVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					UserRefSubjectVO userRefSubjectVO = userRefSubjectDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(UserRefSubjectVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(UserRefSubjectVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(userRefSubjectVO);
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
	 * @param datauiid 用户主题管理信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【用户主题管理】信息
	 * @param userRefSubjectid 用户主题管理信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String userRefSubjectid) {
		if(!StringUtil.isNotNull(userRefSubjectid)){
			return -1;
		}
		this.deletefile(userRefSubjectid);
		this.deleteinvent(userRefSubjectid);
		return this.userRefSubjectDao.delete(userRefSubjectid);
	}
	
	
	/**
	 * 删除一条【用户主题管理】信息
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(UserRefSubjectVO userRefSubjectVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(userRefSubjectVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(userRefSubjectVO.getUiid());
		this.deleteinvent(userRefSubjectVO.getUiid());
		return this.userRefSubjectDao.deleteForObj(userRefSubjectVO);
	}

	/**
	 * 删除一条【用户主题管理】信息
	 * @param map 用户主题管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("curs_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("curs_uiid"));
		this.deleteinvent(map.get("curs_uiid"));
		return this.userRefSubjectDao.delete(map.get("curs_uiid"));
	}

	/**
	 * 批量删除【用户主题管理】信息
	 * @param userRefSubjectVOlist 用户主题管理信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> userRefSubjectVOlist) throws Exception {
		if(userRefSubjectVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < userRefSubjectVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += userRefSubjectVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.userRefSubjectDao.deleteBatch(userRefSubjectVOlist);
	}

	/**
	 * 批量删除【用户主题管理】信息
	 * @param userRefSubjectVOlist 用户主题管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<UserRefSubjectVO> userRefSubjectVOlist) throws Exception {
		List<String> userRefSubjectVOlist1 = new ArrayList<String>();
		String stss = "";
		for (UserRefSubjectVO userRefSubjectVO : userRefSubjectVOlist) {
			userRefSubjectVOlist1.add(userRefSubjectVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += userRefSubjectVO.getUiid();
		}
		if(userRefSubjectVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.userRefSubjectDao.deleteBatch(userRefSubjectVOlist1);
	}

	/**
	 * 批量删除【用户主题管理】信息
	 * @param maplist 用户主题管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> userRefSubjectVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			userRefSubjectVOlist1.add(map.get("curs_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("curs_uiid");
		}
		if(userRefSubjectVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.userRefSubjectDao.deleteBatch(userRefSubjectVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 用户主题管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.userRefSubjectDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.userRefSubjectDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【用户主题管理】信息
	 * @param userRefSubjectVOid 用户主题管理信息主键
	 * @return 用户主题管理信息对象
	 */
	@Override
	public UserRefSubjectVO searchById(String userRefSubjectVOid) throws Exception {
		if(!StringUtil.isNotNull(userRefSubjectVOid)){
			throw new Exception("数据空异常");
		}
		return this.userRefSubjectDao.searchById(userRefSubjectVOid);
	}

	/**
	 * 批量查询【用户主题管理】信息
	 * @param uiids 用户主题管理信息主键列表
	 * @return 用户主题管理信息对象列表
	 */
	@Override
	public List<UserRefSubjectVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<UserRefSubjectVO> userRefSubjectListtemp = this.userRefSubjectDao.searchBatch(list);
		List<UserRefSubjectVO> userRefSubjectList = new ArrayList<UserRefSubjectVO>();
		for(String uu : u){
			UserRefSubjectVO userRefSubjectVO = null;
			for(int i = 0 ; i < userRefSubjectListtemp.size() ; i ++){
				userRefSubjectVO = userRefSubjectListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(userRefSubjectVO.getUiid())){
					userRefSubjectList.add(userRefSubjectVO);
				}
			}
		}
		return userRefSubjectList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @return 用户主题管理信息对象列表
	 */
	@Override
	public List<UserRefSubjectVO> searchByMoreId(UserRefSubjectVO userRefSubjectVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 用户主题管理json信息对象
	 * @return 用户主题管理信息对象列表
	 */
	@Override
	public List<UserRefSubjectVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 用户主题管理map信息对象
	 * @return 用户主题管理信息对象列表
	 */
	@Override
	public List<UserRefSubjectVO> searchByMoreId(Map<String,Object> map) {
		return this.userRefSubjectDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(UserRefSubjectVO userRefSubjectVO) {
		return this.userRefSubjectDao.searchCountByObj(userRefSubjectVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @return 用户主题管理信息对象
	 */
	@Override
	public UserRefSubjectVO searchObjByObj(UserRefSubjectVO userRefSubjectVO) {
		return this.userRefSubjectDao.searchObjByObj(userRefSubjectVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @return 用户主题管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<UserRefSubjectVO> searchListByObj(UserRefSubjectVO userRefSubjectVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<UserRefSubjectVO> list = this.userRefSubjectDao.searchListByObj(userRefSubjectVO);
		// 用PageInfo对结果进行包装
		PageInfo<UserRefSubjectVO> page = new PageInfo<UserRefSubjectVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 用户主题管理map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户主题管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<UserRefSubjectVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		UserRefSubjectVO userRefSubjectVO = new UserRefSubjectVO();
		BeanRefUtil.setFieldValue(userRefSubjectVO, map);
		return searchListPageByObj(userRefSubjectVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户主题管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<UserRefSubjectVO> searchListPageByObj(UserRefSubjectVO userRefSubjectVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<UserRefSubjectVO> list = this.userRefSubjectDao.searchListPageByObj(userRefSubjectVO);
		// 用PageInfo对结果进行包装
		PageInfo<UserRefSubjectVO> page = new PageInfo<UserRefSubjectVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户主题管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<UserRefSubjectVO> searchListPageByObjOr(UserRefSubjectVO userRefSubjectVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<UserRefSubjectVO> list = this.userRefSubjectDao.searchListPageByObjOr(userRefSubjectVO);
		// 用PageInfo对结果进行包装
		PageInfo<UserRefSubjectVO> page = new PageInfo<UserRefSubjectVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户主题管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(UserRefSubjectVO userRefSubjectVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.userRefSubjectDao.searchListPageByObjRefin(userRefSubjectVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param userRefSubjectVO 用户主题管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 用户主题管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(UserRefSubjectVO userRefSubjectVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.userRefSubjectDao.searchListPageByObjReftable(userRefSubjectVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【用户主题管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 用户主题管理信息对象
	 * userRefSubjectVO
	 * pageNo
	 * pageSize
	 * @return 用户主题管理信息对象列表，含分页对象
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
			List<UserRefSubjectVO> userRefSubjectVOlist = new ArrayList<UserRefSubjectVO>();
			for(int i = 0 ; i < uiids.length ; i ++){
				if(StringUtil.isNotNull(uiids[i])){
					UserRefSubjectVO userRefSubjectVO = new UserRefSubjectVO();
					userRefSubjectVO.setUiid(uiids[i]);
					userRefSubjectVO.setSort(i*10 + 10);
					userRefSubjectVOlist.add(userRefSubjectVO);
				}
			}
			return this.userRefSubjectDao.updateBatch(userRefSubjectVOlist);
		}else{
			throw new Exception("排序数据为空");
		}
	}
	
	
	
	
	
}
