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
import wo.develop.a4dao.ISoftAccountDao;
import wo.develop.a5vo.SoftAccountVO;
import wo.develop.a3service.ISoftAccountService;
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
 * 登录帐号信息信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("softAccountService")
public class SoftAccountServiceImpl implements ISoftAccountService {
	private static Logger log = LoggerFactory.getLogger(SoftAccountServiceImpl.class);

	@Resource
	private ISoftAccountDao softAccountDao;

	/**
	 * 插入一条【登录帐号信息】信息
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(SoftAccountVO softAccountVO) {
		if(!StringUtil.isNotNull(softAccountVO.getUiid())){
			softAccountVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.softAccountDao.insert(softAccountVO);
	}

	/**
	 * 插入一条【登录帐号信息】信息
	 * @param map 登录帐号信息信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		SoftAccountVO softAccountVO = new SoftAccountVO();
		BeanRefUtil.setFieldValue(softAccountVO, map);
		if(!StringUtil.isNotNull(softAccountVO.getUiid())){
			softAccountVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.softAccountDao.insert(softAccountVO);
	}

	/**
	 * 插入一条【登录帐号信息】信息
	 * @param json 登录帐号信息信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		SoftAccountVO softAccountVO = (SoftAccountVO )JsonHelper.jsonToObj(SoftAccountVO.class.getName(), json);
		if(!StringUtil.isNull(softAccountVO)){
			if(!StringUtil.isNotNull(softAccountVO.getUiid())){
				softAccountVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.softAccountDao.insert(softAccountVO);
		}
		return 0;
	}

	/**
	 * 批量插入【登录帐号信息】信息
	 * @param objlist 登录帐号信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<SoftAccountVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			SoftAccountVO softAccountVO = objlist.get(i);
			if(!StringUtil.isNotNull(softAccountVO.getUiid())){
				softAccountVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.softAccountDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【登录帐号信息】信息
	 * @param maplist 登录帐号信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<SoftAccountVO> objlist = new ArrayList<SoftAccountVO>();
		for (Map<String, String> map : maplist) {
			SoftAccountVO softAccountVO = new SoftAccountVO();
			BeanRefUtil.setFieldValue(softAccountVO, map);
			if(!StringUtil.isNotNull(softAccountVO.getUiid())){
				softAccountVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(softAccountVO);
		}
		return this.softAccountDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【登录帐号信息】信息
	 * @param obj 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(SoftAccountVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【登录帐号信息】信息
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(SoftAccountVO softAccountVO) {
		if(!StringUtil.isNull(softAccountVO)){
			if(StringUtil.isNotNull(softAccountVO.getUiid())){
				return this.softAccountDao.update(softAccountVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【登录帐号信息】信息
	 * @param map 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		SoftAccountVO softAccountVO = new SoftAccountVO();
		BeanRefUtil.setFieldValue(softAccountVO, map);
		if(StringUtil.isNotNull(softAccountVO.getUiid())){
			return this.softAccountDao.update(softAccountVO);
		}
		return 0;
	}

	/**
	 * 批量更新【登录帐号信息】信息
	 * @param objlist 登录帐号信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<SoftAccountVO> objlist) {
		for(SoftAccountVO softAccountVO:objlist){
			if(!StringUtil.isNotNull(softAccountVO.getUiid())){
				return 0;
			}
		}
		return this.softAccountDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【登录帐号信息】信息
	 * @param maplist 登录帐号信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<SoftAccountVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			SoftAccountVO softAccountVO = new SoftAccountVO();
			BeanRefUtil.setFieldValue(softAccountVO, map);
			objlist.add(softAccountVO);
		}
		for(SoftAccountVO softAccountVO:objlist){
			if(!StringUtil.isNotNull(softAccountVO.getUiid())){
				return 0;
			}
		}
		return this.softAccountDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【登录帐号信息】信息
	 * @param map 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.softAccountDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 登录帐号信息信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						SoftAccountVO softAccountVO = softAccountDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(SoftAccountVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(SoftAccountVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(softAccountVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					SoftAccountVO softAccountVO = softAccountDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(SoftAccountVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(SoftAccountVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(softAccountVO);
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
	 * @param datauiid 登录帐号信息信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【登录帐号信息】信息
	 * @param softAccountid 登录帐号信息信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String softAccountid) {
		if(!StringUtil.isNotNull(softAccountid)){
			return -1;
		}
		this.deletefile(softAccountid);
		this.deleteinvent(softAccountid);
		return this.softAccountDao.delete(softAccountid);
	}
	
	
	/**
	 * 删除一条【登录帐号信息】信息
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(SoftAccountVO softAccountVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(softAccountVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(softAccountVO.getUiid());
		this.deleteinvent(softAccountVO.getUiid());
		return this.softAccountDao.deleteForObj(softAccountVO);
	}

	/**
	 * 删除一条【登录帐号信息】信息
	 * @param map 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("csa_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("csa_uiid"));
		this.deleteinvent(map.get("csa_uiid"));
		return this.softAccountDao.delete(map.get("csa_uiid"));
	}

	/**
	 * 批量删除【登录帐号信息】信息
	 * @param softAccountVOlist 登录帐号信息信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> softAccountVOlist) throws Exception {
		if(softAccountVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < softAccountVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += softAccountVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softAccountDao.deleteBatch(softAccountVOlist);
	}

	/**
	 * 批量删除【登录帐号信息】信息
	 * @param softAccountVOlist 登录帐号信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<SoftAccountVO> softAccountVOlist) throws Exception {
		List<String> softAccountVOlist1 = new ArrayList<String>();
		String stss = "";
		for (SoftAccountVO softAccountVO : softAccountVOlist) {
			softAccountVOlist1.add(softAccountVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += softAccountVO.getUiid();
		}
		if(softAccountVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softAccountDao.deleteBatch(softAccountVOlist1);
	}

	/**
	 * 批量删除【登录帐号信息】信息
	 * @param maplist 登录帐号信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> softAccountVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			softAccountVOlist1.add(map.get("csa_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("csa_uiid");
		}
		if(softAccountVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softAccountDao.deleteBatch(softAccountVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 登录帐号信息信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.softAccountDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.softAccountDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【登录帐号信息】信息
	 * @param softAccountVOid 登录帐号信息信息主键
	 * @return 登录帐号信息信息对象
	 */
	@Override
	public SoftAccountVO searchById(String softAccountVOid) throws Exception {
		if(!StringUtil.isNotNull(softAccountVOid)){
			throw new Exception("数据空异常");
		}
		return this.softAccountDao.searchById(softAccountVOid);
	}

	/**
	 * 批量查询【登录帐号信息】信息
	 * @param uiids 登录帐号信息信息主键列表
	 * @return 登录帐号信息信息对象列表
	 */
	@Override
	public List<SoftAccountVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<SoftAccountVO> softAccountListtemp = this.softAccountDao.searchBatch(list);
		List<SoftAccountVO> softAccountList = new ArrayList<SoftAccountVO>();
		for(String uu : u){
			SoftAccountVO softAccountVO = null;
			for(int i = 0 ; i < softAccountListtemp.size() ; i ++){
				softAccountVO = softAccountListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(softAccountVO.getUiid())){
					softAccountList.add(softAccountVO);
				}
			}
		}
		return softAccountList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 登录帐号信息信息对象列表
	 */
	@Override
	public List<SoftAccountVO> searchByMoreId(SoftAccountVO softAccountVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 登录帐号信息json信息对象
	 * @return 登录帐号信息信息对象列表
	 */
	@Override
	public List<SoftAccountVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 登录帐号信息map信息对象
	 * @return 登录帐号信息信息对象列表
	 */
	@Override
	public List<SoftAccountVO> searchByMoreId(Map<String,Object> map) {
		return this.softAccountDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(SoftAccountVO softAccountVO) {
		return this.softAccountDao.searchCountByObj(softAccountVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 登录帐号信息信息对象
	 */
	@Override
	public SoftAccountVO searchObjByObj(SoftAccountVO softAccountVO) {
		return this.softAccountDao.searchObjByObj(softAccountVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param softAccountVO 登录帐号信息信息对象
	 * @return 登录帐号信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftAccountVO> searchListByObj(SoftAccountVO softAccountVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftAccountVO> list = this.softAccountDao.searchListByObj(softAccountVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftAccountVO> page = new PageInfo<SoftAccountVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 登录帐号信息map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 登录帐号信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftAccountVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		SoftAccountVO softAccountVO = new SoftAccountVO();
		BeanRefUtil.setFieldValue(softAccountVO, map);
		return searchListPageByObj(softAccountVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softAccountVO 登录帐号信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 登录帐号信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftAccountVO> searchListPageByObj(SoftAccountVO softAccountVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftAccountVO> list = this.softAccountDao.searchListPageByObj(softAccountVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftAccountVO> page = new PageInfo<SoftAccountVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softAccountVO 登录帐号信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 登录帐号信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftAccountVO> searchListPageByObjOr(SoftAccountVO softAccountVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftAccountVO> list = this.softAccountDao.searchListPageByObjOr(softAccountVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftAccountVO> page = new PageInfo<SoftAccountVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softAccountVO 登录帐号信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 登录帐号信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(SoftAccountVO softAccountVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.softAccountDao.searchListPageByObjRefin(softAccountVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softAccountVO 登录帐号信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 登录帐号信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(SoftAccountVO softAccountVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.softAccountDao.searchListPageByObjReftable(softAccountVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【登录帐号信息】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 登录帐号信息信息对象
	 * softAccountVO
	 * pageNo
	 * pageSize
	 * @return 登录帐号信息信息对象列表，含分页对象
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
