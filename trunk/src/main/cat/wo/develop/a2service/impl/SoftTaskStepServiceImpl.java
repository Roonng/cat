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
import wo.develop.a4dao.ISoftTaskStepDao;
import wo.develop.a5vo.SoftTaskStepVO;
import wo.develop.a3service.ISoftTaskStepService;
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
 * 业务操作步骤信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("softTaskStepService")
public class SoftTaskStepServiceImpl implements ISoftTaskStepService {
	private static Logger log = LoggerFactory.getLogger(SoftTaskStepServiceImpl.class);

	@Resource
	private ISoftTaskStepDao softTaskStepDao;

	/**
	 * 插入一条【业务操作步骤】信息
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(SoftTaskStepVO softTaskStepVO) {
		if(!StringUtil.isNotNull(softTaskStepVO.getUiid())){
			softTaskStepVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.softTaskStepDao.insert(softTaskStepVO);
	}

	/**
	 * 插入一条【业务操作步骤】信息
	 * @param map 业务操作步骤信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		SoftTaskStepVO softTaskStepVO = new SoftTaskStepVO();
		BeanRefUtil.setFieldValue(softTaskStepVO, map);
		if(!StringUtil.isNotNull(softTaskStepVO.getUiid())){
			softTaskStepVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.softTaskStepDao.insert(softTaskStepVO);
	}

	/**
	 * 插入一条【业务操作步骤】信息
	 * @param json 业务操作步骤信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		SoftTaskStepVO softTaskStepVO = (SoftTaskStepVO )JsonHelper.jsonToObj(SoftTaskStepVO.class.getName(), json);
		if(!StringUtil.isNull(softTaskStepVO)){
			if(!StringUtil.isNotNull(softTaskStepVO.getUiid())){
				softTaskStepVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.softTaskStepDao.insert(softTaskStepVO);
		}
		return 0;
	}

	/**
	 * 批量插入【业务操作步骤】信息
	 * @param objlist 业务操作步骤信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<SoftTaskStepVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			SoftTaskStepVO softTaskStepVO = objlist.get(i);
			if(!StringUtil.isNotNull(softTaskStepVO.getUiid())){
				softTaskStepVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.softTaskStepDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【业务操作步骤】信息
	 * @param maplist 业务操作步骤信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<SoftTaskStepVO> objlist = new ArrayList<SoftTaskStepVO>();
		for (Map<String, String> map : maplist) {
			SoftTaskStepVO softTaskStepVO = new SoftTaskStepVO();
			BeanRefUtil.setFieldValue(softTaskStepVO, map);
			if(!StringUtil.isNotNull(softTaskStepVO.getUiid())){
				softTaskStepVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(softTaskStepVO);
		}
		return this.softTaskStepDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【业务操作步骤】信息
	 * @param obj 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(SoftTaskStepVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【业务操作步骤】信息
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(SoftTaskStepVO softTaskStepVO) {
		if(!StringUtil.isNull(softTaskStepVO)){
			if(StringUtil.isNotNull(softTaskStepVO.getUiid())){
				return this.softTaskStepDao.update(softTaskStepVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【业务操作步骤】信息
	 * @param map 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		SoftTaskStepVO softTaskStepVO = new SoftTaskStepVO();
		BeanRefUtil.setFieldValue(softTaskStepVO, map);
		if(StringUtil.isNotNull(softTaskStepVO.getUiid())){
			return this.softTaskStepDao.update(softTaskStepVO);
		}
		return 0;
	}

	/**
	 * 批量更新【业务操作步骤】信息
	 * @param objlist 业务操作步骤信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<SoftTaskStepVO> objlist) {
		for(SoftTaskStepVO softTaskStepVO:objlist){
			if(!StringUtil.isNotNull(softTaskStepVO.getUiid())){
				return 0;
			}
		}
		return this.softTaskStepDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【业务操作步骤】信息
	 * @param maplist 业务操作步骤信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<SoftTaskStepVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			SoftTaskStepVO softTaskStepVO = new SoftTaskStepVO();
			BeanRefUtil.setFieldValue(softTaskStepVO, map);
			objlist.add(softTaskStepVO);
		}
		for(SoftTaskStepVO softTaskStepVO:objlist){
			if(!StringUtil.isNotNull(softTaskStepVO.getUiid())){
				return 0;
			}
		}
		return this.softTaskStepDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【业务操作步骤】信息
	 * @param map 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.softTaskStepDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 业务操作步骤信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						SoftTaskStepVO softTaskStepVO = softTaskStepDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(SoftTaskStepVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(SoftTaskStepVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(softTaskStepVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					SoftTaskStepVO softTaskStepVO = softTaskStepDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(SoftTaskStepVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(SoftTaskStepVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(softTaskStepVO);
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
	 * @param datauiid 业务操作步骤信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【业务操作步骤】信息
	 * @param softTaskStepid 业务操作步骤信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String softTaskStepid) {
		if(!StringUtil.isNotNull(softTaskStepid)){
			return -1;
		}
		this.deletefile(softTaskStepid);
		this.deleteinvent(softTaskStepid);
		return this.softTaskStepDao.delete(softTaskStepid);
	}
	
	
	/**
	 * 删除一条【业务操作步骤】信息
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(SoftTaskStepVO softTaskStepVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(softTaskStepVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(softTaskStepVO.getUiid());
		this.deleteinvent(softTaskStepVO.getUiid());
		return this.softTaskStepDao.deleteForObj(softTaskStepVO);
	}

	/**
	 * 删除一条【业务操作步骤】信息
	 * @param map 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("csts_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("csts_uiid"));
		this.deleteinvent(map.get("csts_uiid"));
		return this.softTaskStepDao.delete(map.get("csts_uiid"));
	}

	/**
	 * 批量删除【业务操作步骤】信息
	 * @param softTaskStepVOlist 业务操作步骤信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> softTaskStepVOlist) throws Exception {
		if(softTaskStepVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < softTaskStepVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += softTaskStepVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softTaskStepDao.deleteBatch(softTaskStepVOlist);
	}

	/**
	 * 批量删除【业务操作步骤】信息
	 * @param softTaskStepVOlist 业务操作步骤信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<SoftTaskStepVO> softTaskStepVOlist) throws Exception {
		List<String> softTaskStepVOlist1 = new ArrayList<String>();
		String stss = "";
		for (SoftTaskStepVO softTaskStepVO : softTaskStepVOlist) {
			softTaskStepVOlist1.add(softTaskStepVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += softTaskStepVO.getUiid();
		}
		if(softTaskStepVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softTaskStepDao.deleteBatch(softTaskStepVOlist1);
	}

	/**
	 * 批量删除【业务操作步骤】信息
	 * @param maplist 业务操作步骤信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> softTaskStepVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			softTaskStepVOlist1.add(map.get("csts_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("csts_uiid");
		}
		if(softTaskStepVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.softTaskStepDao.deleteBatch(softTaskStepVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 业务操作步骤信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.softTaskStepDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.softTaskStepDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【业务操作步骤】信息
	 * @param softTaskStepVOid 业务操作步骤信息主键
	 * @return 业务操作步骤信息对象
	 */
	@Override
	public SoftTaskStepVO searchById(String softTaskStepVOid) throws Exception {
		if(!StringUtil.isNotNull(softTaskStepVOid)){
			throw new Exception("数据空异常");
		}
		return this.softTaskStepDao.searchById(softTaskStepVOid);
	}

	/**
	 * 批量查询【业务操作步骤】信息
	 * @param uiids 业务操作步骤信息主键列表
	 * @return 业务操作步骤信息对象列表
	 */
	@Override
	public List<SoftTaskStepVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<SoftTaskStepVO> softTaskStepListtemp = this.softTaskStepDao.searchBatch(list);
		List<SoftTaskStepVO> softTaskStepList = new ArrayList<SoftTaskStepVO>();
		for(String uu : u){
			SoftTaskStepVO softTaskStepVO = null;
			for(int i = 0 ; i < softTaskStepListtemp.size() ; i ++){
				softTaskStepVO = softTaskStepListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(softTaskStepVO.getUiid())){
					softTaskStepList.add(softTaskStepVO);
				}
			}
		}
		return softTaskStepList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 业务操作步骤信息对象列表
	 */
	@Override
	public List<SoftTaskStepVO> searchByMoreId(SoftTaskStepVO softTaskStepVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 业务操作步骤json信息对象
	 * @return 业务操作步骤信息对象列表
	 */
	@Override
	public List<SoftTaskStepVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 业务操作步骤map信息对象
	 * @return 业务操作步骤信息对象列表
	 */
	@Override
	public List<SoftTaskStepVO> searchByMoreId(Map<String,Object> map) {
		return this.softTaskStepDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(SoftTaskStepVO softTaskStepVO) {
		return this.softTaskStepDao.searchCountByObj(softTaskStepVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 业务操作步骤信息对象
	 */
	@Override
	public SoftTaskStepVO searchObjByObj(SoftTaskStepVO softTaskStepVO) {
		return this.softTaskStepDao.searchObjByObj(softTaskStepVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @return 业务操作步骤信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftTaskStepVO> searchListByObj(SoftTaskStepVO softTaskStepVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftTaskStepVO> list = this.softTaskStepDao.searchListByObj(softTaskStepVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftTaskStepVO> page = new PageInfo<SoftTaskStepVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 业务操作步骤map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务操作步骤信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftTaskStepVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		SoftTaskStepVO softTaskStepVO = new SoftTaskStepVO();
		BeanRefUtil.setFieldValue(softTaskStepVO, map);
		return searchListPageByObj(softTaskStepVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务操作步骤信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftTaskStepVO> searchListPageByObj(SoftTaskStepVO softTaskStepVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftTaskStepVO> list = this.softTaskStepDao.searchListPageByObj(softTaskStepVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftTaskStepVO> page = new PageInfo<SoftTaskStepVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务操作步骤信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<SoftTaskStepVO> searchListPageByObjOr(SoftTaskStepVO softTaskStepVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<SoftTaskStepVO> list = this.softTaskStepDao.searchListPageByObjOr(softTaskStepVO);
		// 用PageInfo对结果进行包装
		PageInfo<SoftTaskStepVO> page = new PageInfo<SoftTaskStepVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务操作步骤信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(SoftTaskStepVO softTaskStepVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.softTaskStepDao.searchListPageByObjRefin(softTaskStepVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param softTaskStepVO 业务操作步骤信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 业务操作步骤信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(SoftTaskStepVO softTaskStepVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.softTaskStepDao.searchListPageByObjReftable(softTaskStepVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【业务操作步骤】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 业务操作步骤信息对象
	 * softTaskStepVO
	 * pageNo
	 * pageSize
	 * @return 业务操作步骤信息对象列表，含分页对象
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
			List<SoftTaskStepVO> softTaskStepVOlist = new ArrayList<SoftTaskStepVO>();
			for(int i = 0 ; i < uiids.length ; i ++){
				if(StringUtil.isNotNull(uiids[i])){
					SoftTaskStepVO softTaskStepVO = new SoftTaskStepVO();
					softTaskStepVO.setUiid(uiids[i]);
					softTaskStepVO.setSort(i*10 + 10);
					softTaskStepVOlist.add(softTaskStepVO);
				}
			}
			return this.softTaskStepDao.updateBatch(softTaskStepVOlist);
		}else{
			throw new Exception("排序数据为空");
		}
	}
	
	
	
	
	
}
