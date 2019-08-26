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
import wo.develop.a4dao.IAutoAnswerLogDao;
import wo.develop.a5vo.AutoAnswerLogVO;
import wo.develop.a3service.IAutoAnswerLogService;
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
 * 帖子回复日志信息信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("autoAnswerLogService")
public class AutoAnswerLogServiceImpl implements IAutoAnswerLogService {
	private static Logger log = LoggerFactory.getLogger(AutoAnswerLogServiceImpl.class);

	@Resource
	private IAutoAnswerLogDao autoAnswerLogDao;

	/**
	 * 插入一条【帖子回复日志信息】信息
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(AutoAnswerLogVO autoAnswerLogVO) {
		if(!StringUtil.isNotNull(autoAnswerLogVO.getUiid())){
			autoAnswerLogVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.autoAnswerLogDao.insert(autoAnswerLogVO);
	}

	/**
	 * 插入一条【帖子回复日志信息】信息
	 * @param map 帖子回复日志信息信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		AutoAnswerLogVO autoAnswerLogVO = new AutoAnswerLogVO();
		BeanRefUtil.setFieldValue(autoAnswerLogVO, map);
		if(!StringUtil.isNotNull(autoAnswerLogVO.getUiid())){
			autoAnswerLogVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.autoAnswerLogDao.insert(autoAnswerLogVO);
	}

	/**
	 * 插入一条【帖子回复日志信息】信息
	 * @param json 帖子回复日志信息信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		AutoAnswerLogVO autoAnswerLogVO = (AutoAnswerLogVO )JsonHelper.jsonToObj(AutoAnswerLogVO.class.getName(), json);
		if(!StringUtil.isNull(autoAnswerLogVO)){
			if(!StringUtil.isNotNull(autoAnswerLogVO.getUiid())){
				autoAnswerLogVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.autoAnswerLogDao.insert(autoAnswerLogVO);
		}
		return 0;
	}

	/**
	 * 批量插入【帖子回复日志信息】信息
	 * @param objlist 帖子回复日志信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<AutoAnswerLogVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			AutoAnswerLogVO autoAnswerLogVO = objlist.get(i);
			if(!StringUtil.isNotNull(autoAnswerLogVO.getUiid())){
				autoAnswerLogVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.autoAnswerLogDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【帖子回复日志信息】信息
	 * @param maplist 帖子回复日志信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<AutoAnswerLogVO> objlist = new ArrayList<AutoAnswerLogVO>();
		for (Map<String, String> map : maplist) {
			AutoAnswerLogVO autoAnswerLogVO = new AutoAnswerLogVO();
			BeanRefUtil.setFieldValue(autoAnswerLogVO, map);
			if(!StringUtil.isNotNull(autoAnswerLogVO.getUiid())){
				autoAnswerLogVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(autoAnswerLogVO);
		}
		return this.autoAnswerLogDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【帖子回复日志信息】信息
	 * @param obj 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(AutoAnswerLogVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【帖子回复日志信息】信息
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(AutoAnswerLogVO autoAnswerLogVO) {
		if(!StringUtil.isNull(autoAnswerLogVO)){
			if(StringUtil.isNotNull(autoAnswerLogVO.getUiid())){
				return this.autoAnswerLogDao.update(autoAnswerLogVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【帖子回复日志信息】信息
	 * @param map 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		AutoAnswerLogVO autoAnswerLogVO = new AutoAnswerLogVO();
		BeanRefUtil.setFieldValue(autoAnswerLogVO, map);
		if(StringUtil.isNotNull(autoAnswerLogVO.getUiid())){
			return this.autoAnswerLogDao.update(autoAnswerLogVO);
		}
		return 0;
	}

	/**
	 * 批量更新【帖子回复日志信息】信息
	 * @param objlist 帖子回复日志信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<AutoAnswerLogVO> objlist) {
		for(AutoAnswerLogVO autoAnswerLogVO:objlist){
			if(!StringUtil.isNotNull(autoAnswerLogVO.getUiid())){
				return 0;
			}
		}
		return this.autoAnswerLogDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【帖子回复日志信息】信息
	 * @param maplist 帖子回复日志信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<AutoAnswerLogVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			AutoAnswerLogVO autoAnswerLogVO = new AutoAnswerLogVO();
			BeanRefUtil.setFieldValue(autoAnswerLogVO, map);
			objlist.add(autoAnswerLogVO);
		}
		for(AutoAnswerLogVO autoAnswerLogVO:objlist){
			if(!StringUtil.isNotNull(autoAnswerLogVO.getUiid())){
				return 0;
			}
		}
		return this.autoAnswerLogDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【帖子回复日志信息】信息
	 * @param map 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.autoAnswerLogDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 帖子回复日志信息信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						AutoAnswerLogVO autoAnswerLogVO = autoAnswerLogDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AutoAnswerLogVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(AutoAnswerLogVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(autoAnswerLogVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					AutoAnswerLogVO autoAnswerLogVO = autoAnswerLogDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AutoAnswerLogVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(AutoAnswerLogVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(autoAnswerLogVO);
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
	 * @param datauiid 帖子回复日志信息信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【帖子回复日志信息】信息
	 * @param autoAnswerLogid 帖子回复日志信息信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String autoAnswerLogid) {
		if(!StringUtil.isNotNull(autoAnswerLogid)){
			return -1;
		}
		this.deletefile(autoAnswerLogid);
		this.deleteinvent(autoAnswerLogid);
		return this.autoAnswerLogDao.delete(autoAnswerLogid);
	}
	
	
	/**
	 * 删除一条【帖子回复日志信息】信息
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(AutoAnswerLogVO autoAnswerLogVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(autoAnswerLogVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(autoAnswerLogVO.getUiid());
		this.deleteinvent(autoAnswerLogVO.getUiid());
		return this.autoAnswerLogDao.deleteForObj(autoAnswerLogVO);
	}

	/**
	 * 删除一条【帖子回复日志信息】信息
	 * @param map 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("caal_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("caal_uiid"));
		this.deleteinvent(map.get("caal_uiid"));
		return this.autoAnswerLogDao.delete(map.get("caal_uiid"));
	}

	/**
	 * 批量删除【帖子回复日志信息】信息
	 * @param autoAnswerLogVOlist 帖子回复日志信息信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> autoAnswerLogVOlist) throws Exception {
		if(autoAnswerLogVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < autoAnswerLogVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += autoAnswerLogVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoAnswerLogDao.deleteBatch(autoAnswerLogVOlist);
	}

	/**
	 * 批量删除【帖子回复日志信息】信息
	 * @param autoAnswerLogVOlist 帖子回复日志信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<AutoAnswerLogVO> autoAnswerLogVOlist) throws Exception {
		List<String> autoAnswerLogVOlist1 = new ArrayList<String>();
		String stss = "";
		for (AutoAnswerLogVO autoAnswerLogVO : autoAnswerLogVOlist) {
			autoAnswerLogVOlist1.add(autoAnswerLogVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += autoAnswerLogVO.getUiid();
		}
		if(autoAnswerLogVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoAnswerLogDao.deleteBatch(autoAnswerLogVOlist1);
	}

	/**
	 * 批量删除【帖子回复日志信息】信息
	 * @param maplist 帖子回复日志信息信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> autoAnswerLogVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			autoAnswerLogVOlist1.add(map.get("caal_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("caal_uiid");
		}
		if(autoAnswerLogVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoAnswerLogDao.deleteBatch(autoAnswerLogVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 帖子回复日志信息信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.autoAnswerLogDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.autoAnswerLogDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【帖子回复日志信息】信息
	 * @param autoAnswerLogVOid 帖子回复日志信息信息主键
	 * @return 帖子回复日志信息信息对象
	 */
	@Override
	public AutoAnswerLogVO searchById(String autoAnswerLogVOid) throws Exception {
		if(!StringUtil.isNotNull(autoAnswerLogVOid)){
			throw new Exception("数据空异常");
		}
		return this.autoAnswerLogDao.searchById(autoAnswerLogVOid);
	}

	/**
	 * 批量查询【帖子回复日志信息】信息
	 * @param uiids 帖子回复日志信息信息主键列表
	 * @return 帖子回复日志信息信息对象列表
	 */
	@Override
	public List<AutoAnswerLogVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<AutoAnswerLogVO> autoAnswerLogListtemp = this.autoAnswerLogDao.searchBatch(list);
		List<AutoAnswerLogVO> autoAnswerLogList = new ArrayList<AutoAnswerLogVO>();
		for(String uu : u){
			AutoAnswerLogVO autoAnswerLogVO = null;
			for(int i = 0 ; i < autoAnswerLogListtemp.size() ; i ++){
				autoAnswerLogVO = autoAnswerLogListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(autoAnswerLogVO.getUiid())){
					autoAnswerLogList.add(autoAnswerLogVO);
				}
			}
		}
		return autoAnswerLogList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 帖子回复日志信息信息对象列表
	 */
	@Override
	public List<AutoAnswerLogVO> searchByMoreId(AutoAnswerLogVO autoAnswerLogVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 帖子回复日志信息json信息对象
	 * @return 帖子回复日志信息信息对象列表
	 */
	@Override
	public List<AutoAnswerLogVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 帖子回复日志信息map信息对象
	 * @return 帖子回复日志信息信息对象列表
	 */
	@Override
	public List<AutoAnswerLogVO> searchByMoreId(Map<String,Object> map) {
		return this.autoAnswerLogDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(AutoAnswerLogVO autoAnswerLogVO) {
		return this.autoAnswerLogDao.searchCountByObj(autoAnswerLogVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 帖子回复日志信息信息对象
	 */
	@Override
	public AutoAnswerLogVO searchObjByObj(AutoAnswerLogVO autoAnswerLogVO) {
		return this.autoAnswerLogDao.searchObjByObj(autoAnswerLogVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @return 帖子回复日志信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoAnswerLogVO> searchListByObj(AutoAnswerLogVO autoAnswerLogVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoAnswerLogVO> list = this.autoAnswerLogDao.searchListByObj(autoAnswerLogVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoAnswerLogVO> page = new PageInfo<AutoAnswerLogVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 帖子回复日志信息map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子回复日志信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoAnswerLogVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		AutoAnswerLogVO autoAnswerLogVO = new AutoAnswerLogVO();
		BeanRefUtil.setFieldValue(autoAnswerLogVO, map);
		return searchListPageByObj(autoAnswerLogVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子回复日志信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoAnswerLogVO> searchListPageByObj(AutoAnswerLogVO autoAnswerLogVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoAnswerLogVO> list = this.autoAnswerLogDao.searchListPageByObj(autoAnswerLogVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoAnswerLogVO> page = new PageInfo<AutoAnswerLogVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子回复日志信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoAnswerLogVO> searchListPageByObjOr(AutoAnswerLogVO autoAnswerLogVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoAnswerLogVO> list = this.autoAnswerLogDao.searchListPageByObjOr(autoAnswerLogVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoAnswerLogVO> page = new PageInfo<AutoAnswerLogVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子回复日志信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(AutoAnswerLogVO autoAnswerLogVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.autoAnswerLogDao.searchListPageByObjRefin(autoAnswerLogVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerLogVO 帖子回复日志信息信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子回复日志信息信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(AutoAnswerLogVO autoAnswerLogVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.autoAnswerLogDao.searchListPageByObjReftable(autoAnswerLogVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【帖子回复日志信息】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 帖子回复日志信息信息对象
	 * autoAnswerLogVO
	 * pageNo
	 * pageSize
	 * @return 帖子回复日志信息信息对象列表，含分页对象
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
