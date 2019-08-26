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
import wo.develop.a4dao.IAProductReleaseDao;
import wo.develop.a5vo.AProductReleaseVO;
import wo.develop.a3service.IAProductReleaseService;
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
 * 产品发布管理信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("aProductReleaseService")
public class AProductReleaseServiceImpl implements IAProductReleaseService {
	private static Logger log = LoggerFactory.getLogger(AProductReleaseServiceImpl.class);

	@Resource
	private IAProductReleaseDao aProductReleaseDao;

	/**
	 * 插入一条【产品发布管理】信息
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(AProductReleaseVO aProductReleaseVO) {
		if(!StringUtil.isNotNull(aProductReleaseVO.getUiid())){
			aProductReleaseVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.aProductReleaseDao.insert(aProductReleaseVO);
	}

	/**
	 * 插入一条【产品发布管理】信息
	 * @param map 产品发布管理信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		AProductReleaseVO aProductReleaseVO = new AProductReleaseVO();
		BeanRefUtil.setFieldValue(aProductReleaseVO, map);
		if(!StringUtil.isNotNull(aProductReleaseVO.getUiid())){
			aProductReleaseVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.aProductReleaseDao.insert(aProductReleaseVO);
	}

	/**
	 * 插入一条【产品发布管理】信息
	 * @param json 产品发布管理信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		AProductReleaseVO aProductReleaseVO = (AProductReleaseVO )JsonHelper.jsonToObj(AProductReleaseVO.class.getName(), json);
		if(!StringUtil.isNull(aProductReleaseVO)){
			if(!StringUtil.isNotNull(aProductReleaseVO.getUiid())){
				aProductReleaseVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.aProductReleaseDao.insert(aProductReleaseVO);
		}
		return 0;
	}

	/**
	 * 批量插入【产品发布管理】信息
	 * @param objlist 产品发布管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<AProductReleaseVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			AProductReleaseVO aProductReleaseVO = objlist.get(i);
			if(!StringUtil.isNotNull(aProductReleaseVO.getUiid())){
				aProductReleaseVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.aProductReleaseDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【产品发布管理】信息
	 * @param maplist 产品发布管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<AProductReleaseVO> objlist = new ArrayList<AProductReleaseVO>();
		for (Map<String, String> map : maplist) {
			AProductReleaseVO aProductReleaseVO = new AProductReleaseVO();
			BeanRefUtil.setFieldValue(aProductReleaseVO, map);
			if(!StringUtil.isNotNull(aProductReleaseVO.getUiid())){
				aProductReleaseVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(aProductReleaseVO);
		}
		return this.aProductReleaseDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【产品发布管理】信息
	 * @param obj 产品发布管理信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(AProductReleaseVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【产品发布管理】信息
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(AProductReleaseVO aProductReleaseVO) {
		if(!StringUtil.isNull(aProductReleaseVO)){
			if(StringUtil.isNotNull(aProductReleaseVO.getUiid())){
				return this.aProductReleaseDao.update(aProductReleaseVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【产品发布管理】信息
	 * @param map 产品发布管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		AProductReleaseVO aProductReleaseVO = new AProductReleaseVO();
		BeanRefUtil.setFieldValue(aProductReleaseVO, map);
		if(StringUtil.isNotNull(aProductReleaseVO.getUiid())){
			return this.aProductReleaseDao.update(aProductReleaseVO);
		}
		return 0;
	}

	/**
	 * 批量更新【产品发布管理】信息
	 * @param objlist 产品发布管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<AProductReleaseVO> objlist) {
		for(AProductReleaseVO aProductReleaseVO:objlist){
			if(!StringUtil.isNotNull(aProductReleaseVO.getUiid())){
				return 0;
			}
		}
		return this.aProductReleaseDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【产品发布管理】信息
	 * @param maplist 产品发布管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<AProductReleaseVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			AProductReleaseVO aProductReleaseVO = new AProductReleaseVO();
			BeanRefUtil.setFieldValue(aProductReleaseVO, map);
			objlist.add(aProductReleaseVO);
		}
		for(AProductReleaseVO aProductReleaseVO:objlist){
			if(!StringUtil.isNotNull(aProductReleaseVO.getUiid())){
				return 0;
			}
		}
		return this.aProductReleaseDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【产品发布管理】信息
	 * @param map 产品发布管理信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.aProductReleaseDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 产品发布管理信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						AProductReleaseVO aProductReleaseVO = aProductReleaseDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AProductReleaseVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(AProductReleaseVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(aProductReleaseVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					AProductReleaseVO aProductReleaseVO = aProductReleaseDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AProductReleaseVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(AProductReleaseVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(aProductReleaseVO);
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
	 * @param datauiid 产品发布管理信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【产品发布管理】信息
	 * @param aProductReleaseid 产品发布管理信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String aProductReleaseid) {
		if(!StringUtil.isNotNull(aProductReleaseid)){
			return -1;
		}
		this.deletefile(aProductReleaseid);
		this.deleteinvent(aProductReleaseid);
		return this.aProductReleaseDao.delete(aProductReleaseid);
	}
	
	
	/**
	 * 删除一条【产品发布管理】信息
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(AProductReleaseVO aProductReleaseVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(aProductReleaseVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(aProductReleaseVO.getUiid());
		this.deleteinvent(aProductReleaseVO.getUiid());
		return this.aProductReleaseDao.deleteForObj(aProductReleaseVO);
	}

	/**
	 * 删除一条【产品发布管理】信息
	 * @param map 产品发布管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("capr_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("capr_uiid"));
		this.deleteinvent(map.get("capr_uiid"));
		return this.aProductReleaseDao.delete(map.get("capr_uiid"));
	}

	/**
	 * 批量删除【产品发布管理】信息
	 * @param aProductReleaseVOlist 产品发布管理信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> aProductReleaseVOlist) throws Exception {
		if(aProductReleaseVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < aProductReleaseVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += aProductReleaseVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.aProductReleaseDao.deleteBatch(aProductReleaseVOlist);
	}

	/**
	 * 批量删除【产品发布管理】信息
	 * @param aProductReleaseVOlist 产品发布管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<AProductReleaseVO> aProductReleaseVOlist) throws Exception {
		List<String> aProductReleaseVOlist1 = new ArrayList<String>();
		String stss = "";
		for (AProductReleaseVO aProductReleaseVO : aProductReleaseVOlist) {
			aProductReleaseVOlist1.add(aProductReleaseVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += aProductReleaseVO.getUiid();
		}
		if(aProductReleaseVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.aProductReleaseDao.deleteBatch(aProductReleaseVOlist1);
	}

	/**
	 * 批量删除【产品发布管理】信息
	 * @param maplist 产品发布管理信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> aProductReleaseVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			aProductReleaseVOlist1.add(map.get("capr_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("capr_uiid");
		}
		if(aProductReleaseVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.aProductReleaseDao.deleteBatch(aProductReleaseVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 产品发布管理信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.aProductReleaseDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.aProductReleaseDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【产品发布管理】信息
	 * @param aProductReleaseVOid 产品发布管理信息主键
	 * @return 产品发布管理信息对象
	 */
	@Override
	public AProductReleaseVO searchById(String aProductReleaseVOid) throws Exception {
		if(!StringUtil.isNotNull(aProductReleaseVOid)){
			throw new Exception("数据空异常");
		}
		return this.aProductReleaseDao.searchById(aProductReleaseVOid);
	}

	/**
	 * 批量查询【产品发布管理】信息
	 * @param uiids 产品发布管理信息主键列表
	 * @return 产品发布管理信息对象列表
	 */
	@Override
	public List<AProductReleaseVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<AProductReleaseVO> aProductReleaseListtemp = this.aProductReleaseDao.searchBatch(list);
		List<AProductReleaseVO> aProductReleaseList = new ArrayList<AProductReleaseVO>();
		for(String uu : u){
			AProductReleaseVO aProductReleaseVO = null;
			for(int i = 0 ; i < aProductReleaseListtemp.size() ; i ++){
				aProductReleaseVO = aProductReleaseListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(aProductReleaseVO.getUiid())){
					aProductReleaseList.add(aProductReleaseVO);
				}
			}
		}
		return aProductReleaseList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @return 产品发布管理信息对象列表
	 */
	@Override
	public List<AProductReleaseVO> searchByMoreId(AProductReleaseVO aProductReleaseVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 产品发布管理json信息对象
	 * @return 产品发布管理信息对象列表
	 */
	@Override
	public List<AProductReleaseVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 产品发布管理map信息对象
	 * @return 产品发布管理信息对象列表
	 */
	@Override
	public List<AProductReleaseVO> searchByMoreId(Map<String,Object> map) {
		return this.aProductReleaseDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(AProductReleaseVO aProductReleaseVO) {
		return this.aProductReleaseDao.searchCountByObj(aProductReleaseVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @return 产品发布管理信息对象
	 */
	@Override
	public AProductReleaseVO searchObjByObj(AProductReleaseVO aProductReleaseVO) {
		return this.aProductReleaseDao.searchObjByObj(aProductReleaseVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @return 产品发布管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AProductReleaseVO> searchListByObj(AProductReleaseVO aProductReleaseVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AProductReleaseVO> list = this.aProductReleaseDao.searchListByObj(aProductReleaseVO);
		// 用PageInfo对结果进行包装
		PageInfo<AProductReleaseVO> page = new PageInfo<AProductReleaseVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 产品发布管理map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 产品发布管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AProductReleaseVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		AProductReleaseVO aProductReleaseVO = new AProductReleaseVO();
		BeanRefUtil.setFieldValue(aProductReleaseVO, map);
		return searchListPageByObj(aProductReleaseVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 产品发布管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AProductReleaseVO> searchListPageByObj(AProductReleaseVO aProductReleaseVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AProductReleaseVO> list = this.aProductReleaseDao.searchListPageByObj(aProductReleaseVO);
		// 用PageInfo对结果进行包装
		PageInfo<AProductReleaseVO> page = new PageInfo<AProductReleaseVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 产品发布管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AProductReleaseVO> searchListPageByObjOr(AProductReleaseVO aProductReleaseVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AProductReleaseVO> list = this.aProductReleaseDao.searchListPageByObjOr(aProductReleaseVO);
		// 用PageInfo对结果进行包装
		PageInfo<AProductReleaseVO> page = new PageInfo<AProductReleaseVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 产品发布管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(AProductReleaseVO aProductReleaseVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.aProductReleaseDao.searchListPageByObjRefin(aProductReleaseVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param aProductReleaseVO 产品发布管理信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 产品发布管理信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(AProductReleaseVO aProductReleaseVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.aProductReleaseDao.searchListPageByObjReftable(aProductReleaseVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【产品发布管理】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 产品发布管理信息对象
	 * aProductReleaseVO
	 * pageNo
	 * pageSize
	 * @return 产品发布管理信息对象列表，含分页对象
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
