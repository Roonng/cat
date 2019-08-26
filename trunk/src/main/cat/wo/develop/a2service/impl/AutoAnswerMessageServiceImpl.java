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
import wo.develop.a4dao.IAutoAnswerMessageDao;
import wo.develop.a5vo.AutoAnswerMessageVO;
import wo.develop.a3service.IAutoAnswerMessageService;
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
 * 帖子留言回复数据信息管理接口实现类
 * @author 彭羽飞
 *
 */
@Service("autoAnswerMessageService")
public class AutoAnswerMessageServiceImpl implements IAutoAnswerMessageService {
	private static Logger log = LoggerFactory.getLogger(AutoAnswerMessageServiceImpl.class);

	@Resource
	private IAutoAnswerMessageDao autoAnswerMessageDao;

	/**
	 * 插入一条【帖子留言回复数据】信息
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForObj(AutoAnswerMessageVO autoAnswerMessageVO) {
		if(!StringUtil.isNotNull(autoAnswerMessageVO.getUiid())){
			autoAnswerMessageVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.autoAnswerMessageDao.insert(autoAnswerMessageVO);
	}

	/**
	 * 插入一条【帖子留言回复数据】信息
	 * @param map 帖子留言回复数据信息map对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForMap(Map<String, String> map) {
		AutoAnswerMessageVO autoAnswerMessageVO = new AutoAnswerMessageVO();
		BeanRefUtil.setFieldValue(autoAnswerMessageVO, map);
		if(!StringUtil.isNotNull(autoAnswerMessageVO.getUiid())){
			autoAnswerMessageVO.setUiid(UniqueUtil.getUniqueID()+"");
		}
		return this.autoAnswerMessageDao.insert(autoAnswerMessageVO);
	}

	/**
	 * 插入一条【帖子留言回复数据】信息
	 * @param json 帖子留言回复数据信息json对象
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertForJson(String json) {
		AutoAnswerMessageVO autoAnswerMessageVO = (AutoAnswerMessageVO )JsonHelper.jsonToObj(AutoAnswerMessageVO.class.getName(), json);
		if(!StringUtil.isNull(autoAnswerMessageVO)){
			if(!StringUtil.isNotNull(autoAnswerMessageVO.getUiid())){
				autoAnswerMessageVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			return this.autoAnswerMessageDao.insert(autoAnswerMessageVO);
		}
		return 0;
	}

	/**
	 * 批量插入【帖子留言回复数据】信息
	 * @param objlist 帖子留言回复数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(List<AutoAnswerMessageVO> objlist) {
		for(int i = 0 ; i < objlist.size() ; i ++){
			AutoAnswerMessageVO autoAnswerMessageVO = objlist.get(i);
			if(!StringUtil.isNotNull(autoAnswerMessageVO.getUiid())){
				autoAnswerMessageVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
		}
		return this.autoAnswerMessageDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【帖子留言回复数据】信息
	 * @param maplist 帖子留言回复数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public int insertBatchForMap(List<Map> maplist) throws Exception {
		List<AutoAnswerMessageVO> objlist = new ArrayList<AutoAnswerMessageVO>();
		for (Map<String, String> map : maplist) {
			AutoAnswerMessageVO autoAnswerMessageVO = new AutoAnswerMessageVO();
			BeanRefUtil.setFieldValue(autoAnswerMessageVO, map);
			if(!StringUtil.isNotNull(autoAnswerMessageVO.getUiid())){
				autoAnswerMessageVO.setUiid(UniqueUtil.getUniqueID()+"");
			}
			objlist.add(autoAnswerMessageVO);
		}
		return this.autoAnswerMessageDao.insertBatch(objlist);
	}

	/**
	 * 批量插入【帖子留言回复数据】信息
	 * @param obj 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	@Override
            @Transactional(rollbackFor = Exception.class)
	public int insertBatchForObj(AutoAnswerMessageVO obj) throws Exception{
		List<Map> objlist = new ArrayList<Map>();
		Map<String, String> _map = JsonHelper.toMap(obj);
		objlist = BeanRefUtil.convertOneToMultiObj(_map,objlist);
		return insertBatchForMap(objlist);
	}

	/**
	 * 更新一条【帖子留言回复数据】信息
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForObj(AutoAnswerMessageVO autoAnswerMessageVO) {
		if(!StringUtil.isNull(autoAnswerMessageVO)){
			if(StringUtil.isNotNull(autoAnswerMessageVO.getUiid())){
				return this.autoAnswerMessageDao.update(autoAnswerMessageVO);
			}
		}
		return 0;
	}

	/**
	 * 更新一条【帖子留言回复数据】信息
	 * @param map 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateForMap(Map<String, String> map) {
		AutoAnswerMessageVO autoAnswerMessageVO = new AutoAnswerMessageVO();
		BeanRefUtil.setFieldValue(autoAnswerMessageVO, map);
		if(StringUtil.isNotNull(autoAnswerMessageVO.getUiid())){
			return this.autoAnswerMessageDao.update(autoAnswerMessageVO);
		}
		return 0;
	}

	/**
	 * 批量更新【帖子留言回复数据】信息
	 * @param objlist 帖子留言回复数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                @Transactional(rollbackFor = Exception.class)
	public int updateBatchForObj(List<AutoAnswerMessageVO> objlist) {
		for(AutoAnswerMessageVO autoAnswerMessageVO:objlist){
			if(!StringUtil.isNotNull(autoAnswerMessageVO.getUiid())){
				return 0;
			}
		}
		return this.autoAnswerMessageDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【帖子留言回复数据】信息
	 * @param maplist 帖子留言回复数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
                    @Transactional(rollbackFor = Exception.class)
	public int updateBatchForList(List<Map> maplist) {
		List<AutoAnswerMessageVO> objlist = new ArrayList<>();
		for (Map<String, String> map : maplist) {
			AutoAnswerMessageVO autoAnswerMessageVO = new AutoAnswerMessageVO();
			BeanRefUtil.setFieldValue(autoAnswerMessageVO, map);
			objlist.add(autoAnswerMessageVO);
		}
		for(AutoAnswerMessageVO autoAnswerMessageVO:objlist){
			if(!StringUtil.isNotNull(autoAnswerMessageVO.getUiid())){
				return 0;
			}
		}
		return this.autoAnswerMessageDao.updateBatch(objlist);
	}

	/**
	 * 批量更新【帖子留言回复数据】信息
	 * @param map 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	@Override
                            @Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("rawtypes")
	public int updateBatchForMapList(Map map) throws Exception {
		List<Map> objlist = new ArrayList<>();
		BeanRefUtil.convertOneToMultiObj(map, objlist);
		return this.autoAnswerMessageDao.updateBatchForMapList(objlist);
	}

	
	/**
	 * 删除当前数据表的全部附件
	 * @param datauiid 帖子留言回复数据信息主键，多个之间逗号分隔
	 * @return 删除成功状态
	 */
	private boolean deletefile(String datauiid){
		try{
			if(StringUtil.isNotNull(datauiid)){
				if(datauiid.indexOf(",") != -1){
					String datauiids[] = datauiid.split(",");
					for(int j = 0 ; j < datauiids.length ; j ++){
						AutoAnswerMessageVO autoAnswerMessageVO = autoAnswerMessageDao.searchById(datauiids[j]);//获取当前待删除的数据对象
						List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AutoAnswerMessageVO.table_name);//获取当前数据表的附件字段列表
						/**
						 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
						 */
						for(int i = 0 ; i < fieldlist.size() ; i ++){
							SysFieldVO sysfeildvo = fieldlist.get(i);
							Method method = RunModel.findGetMethod(AutoAnswerMessageVO.table_name, sysfeildvo.getFieldname());
							String filevalue = (String) method.invoke(autoAnswerMessageVO);
							if(!UploadServiceImpl.deletefile(filevalue)){
								log.warn("附件删除失败");
							}
						}
					}
				}else{
					AutoAnswerMessageVO autoAnswerMessageVO = autoAnswerMessageDao.searchById(datauiid);//获取当前待删除的数据对象
					List<SysFieldVO> fieldlist = RunModel.getFileFieldList(AutoAnswerMessageVO.table_name);//获取当前数据表的附件字段列表
					/**
					 * 遍历当前数据表的附件字段，从当前待删除数据对象中逐个获取附件数据并执行删除
					 */
					for(int i = 0 ; i < fieldlist.size() ; i ++){
						SysFieldVO sysfeildvo = fieldlist.get(i);
						Method method = RunModel.findGetMethod(AutoAnswerMessageVO.table_name, sysfeildvo.getFieldname());
						String filevalue = (String) method.invoke(autoAnswerMessageVO);
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
	 * @param datauiid 帖子留言回复数据信息主键，多个之间逗号分隔
	 * @return 从表数据删除成功状态
	 */
	private boolean deleteinvent(String datauiid){
		if(StringUtil.isNotNull(datauiid)){
		}
		return true;
	}
	

	/**
	 * 删除一条【帖子留言回复数据】信息
	 * @param autoAnswerMessageid 帖子留言回复数据信息主键
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteById(String autoAnswerMessageid) {
		if(!StringUtil.isNotNull(autoAnswerMessageid)){
			return -1;
		}
		this.deletefile(autoAnswerMessageid);
		this.deleteinvent(autoAnswerMessageid);
		return this.autoAnswerMessageDao.delete(autoAnswerMessageid);
	}
	
	
	/**
	 * 删除一条【帖子留言回复数据】信息
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByObj(AutoAnswerMessageVO autoAnswerMessageVO) {
		Map<String,String> map = JsonHelper.toMapIngoreNull(autoAnswerMessageVO);
		if(map.isEmpty()){
			return -1;
		}
		this.deletefile(autoAnswerMessageVO.getUiid());
		this.deleteinvent(autoAnswerMessageVO.getUiid());
		return this.autoAnswerMessageDao.deleteForObj(autoAnswerMessageVO);
	}

	/**
	 * 删除一条【帖子留言回复数据】信息
	 * @param map 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteByMap(Map<String, String> map) throws Exception {
		if(!StringUtil.isNotNull(map.get("caam_uiid"))){
			throw new Exception("数据空异常");
		}
		this.deletefile(map.get("caam_uiid"));
		this.deleteinvent(map.get("caam_uiid"));
		return this.autoAnswerMessageDao.delete(map.get("caam_uiid"));
	}

	/**
	 * 批量删除【帖子留言回复数据】信息
	 * @param autoAnswerMessageVOlist 帖子留言回复数据信息主键列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchById(List<String> autoAnswerMessageVOlist) throws Exception {
		if(autoAnswerMessageVOlist.size() == 0){
			throw new Exception("数据空异常");
		}
		String stss = "";
		for(int i = 0 ; i < autoAnswerMessageVOlist.size() ; i ++){
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += autoAnswerMessageVOlist.get(i);
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoAnswerMessageDao.deleteBatch(autoAnswerMessageVOlist);
	}

	/**
	 * 批量删除【帖子留言回复数据】信息
	 * @param autoAnswerMessageVOlist 帖子留言回复数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByObj(List<AutoAnswerMessageVO> autoAnswerMessageVOlist) throws Exception {
		List<String> autoAnswerMessageVOlist1 = new ArrayList<String>();
		String stss = "";
		for (AutoAnswerMessageVO autoAnswerMessageVO : autoAnswerMessageVOlist) {
			autoAnswerMessageVOlist1.add(autoAnswerMessageVO.getUiid());
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += autoAnswerMessageVO.getUiid();
		}
		if(autoAnswerMessageVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoAnswerMessageDao.deleteBatch(autoAnswerMessageVOlist1);
	}

	/**
	 * 批量删除【帖子留言回复数据】信息
	 * @param maplist 帖子留言回复数据信息对象列表
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMap(List<Map<String, String>> maplist) throws Exception {
		List<String> autoAnswerMessageVOlist1 = new ArrayList<String>();
		String stss = "";
		for (Map<String, String> map : maplist) {
			autoAnswerMessageVOlist1.add(map.get("caam_uiid"));
			if(StringUtil.isNotNull(stss)){
				stss += ",";
			}
			stss += map.get("caam_uiid");
		}
		if(autoAnswerMessageVOlist1.size() == 0){
			throw new Exception("数据空异常");
		}
		this.deletefile(stss);
		this.deleteinvent(stss);
		return this.autoAnswerMessageDao.deleteBatch(autoAnswerMessageVOlist1);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @param map 帖子留言回复数据信息对象
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteBatchByMoreAtt(Map<String,Object> map) throws Exception {
		if(map.isEmpty()){
			throw new Exception("数据空异常");
		}
		return this.autoAnswerMessageDao.deleteBatchByMoreAtt(map);
	}

	/**
	 * 批量删除指定一个或多个属性通过逗号分隔的符合条件的数据
	 * @return 成功更新条数
	 */
	@Override
	@Transactional
	public int deleteAll() {
		return this.autoAnswerMessageDao.deleteAll(new HashMap<String,Object>());
	}
	
	/**
	 * 通过主键获取一条【帖子留言回复数据】信息
	 * @param autoAnswerMessageVOid 帖子留言回复数据信息主键
	 * @return 帖子留言回复数据信息对象
	 */
	@Override
	public AutoAnswerMessageVO searchById(String autoAnswerMessageVOid) throws Exception {
		if(!StringUtil.isNotNull(autoAnswerMessageVOid)){
			throw new Exception("数据空异常");
		}
		return this.autoAnswerMessageDao.searchById(autoAnswerMessageVOid);
	}

	/**
	 * 批量查询【帖子留言回复数据】信息
	 * @param uiids 帖子留言回复数据信息主键列表
	 * @return 帖子留言回复数据信息对象列表
	 */
	@Override
	public List<AutoAnswerMessageVO> searchBatchById(String uiids) {
		List<String> list = new ArrayList<String>();
		String u []=uiids.split(",");
		for(String uu : u){
			list.add(uu);
		}
		List<AutoAnswerMessageVO> autoAnswerMessageListtemp = this.autoAnswerMessageDao.searchBatch(list);
		List<AutoAnswerMessageVO> autoAnswerMessageList = new ArrayList<AutoAnswerMessageVO>();
		for(String uu : u){
			AutoAnswerMessageVO autoAnswerMessageVO = null;
			for(int i = 0 ; i < autoAnswerMessageListtemp.size() ; i ++){
				autoAnswerMessageVO = autoAnswerMessageListtemp.get(i);
				if(StringUtil.isNotNull(uu) && uu.equals(autoAnswerMessageVO.getUiid())){
					autoAnswerMessageList.add(autoAnswerMessageVO);
				}
			}
		}
		return autoAnswerMessageList;
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 帖子留言回复数据信息对象列表
	 */
	@Override
	public List<AutoAnswerMessageVO> searchByMoreId(AutoAnswerMessageVO autoAnswerMessageVO) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param json 帖子留言回复数据json信息对象
	 * @return 帖子留言回复数据信息对象列表
	 */
	@Override
	public List<AutoAnswerMessageVO> searchByMoreId(String json) {
		return searchByMoreId(new HashMap<String,Object>());
	}

	/**
	 * 获取附件信息表指定一个或多个属性通过逗号分隔的数据查询多条数据
	 * @param map 帖子留言回复数据map信息对象
	 * @return 帖子留言回复数据信息对象列表
	 */
	@Override
	public List<AutoAnswerMessageVO> searchByMoreId(Map<String,Object> map) {
		return this.autoAnswerMessageDao.searchByMoreId(map);
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 符合条件的数据条数
	 */
	@Override
	public int searchCountByObj(AutoAnswerMessageVO autoAnswerMessageVO) {
		return this.autoAnswerMessageDao.searchCountByObj(autoAnswerMessageVO);
	}

	/**
	 * 查询符合条件的一条数据
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 帖子留言回复数据信息对象
	 */
	@Override
	public AutoAnswerMessageVO searchObjByObj(AutoAnswerMessageVO autoAnswerMessageVO) {
		return this.autoAnswerMessageDao.searchObjByObj(autoAnswerMessageVO);
	}

	/**
	 * 查询符合条件的全部数据
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @return 帖子留言回复数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoAnswerMessageVO> searchListByObj(AutoAnswerMessageVO autoAnswerMessageVO,Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoAnswerMessageVO> list = this.autoAnswerMessageDao.searchListByObj(autoAnswerMessageVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoAnswerMessageVO> page = new PageInfo<AutoAnswerMessageVO>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	/**
	 * 分页，查询所有符合条件的数据
	 * @param map 帖子留言回复数据map信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子留言回复数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoAnswerMessageVO> searchListPageByMap(Map<String, String> map,
			Integer pageNo, Integer pageSize) {
		AutoAnswerMessageVO autoAnswerMessageVO = new AutoAnswerMessageVO();
		BeanRefUtil.setFieldValue(autoAnswerMessageVO, map);
		return searchListPageByObj(autoAnswerMessageVO, pageNo, pageSize);
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子留言回复数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoAnswerMessageVO> searchListPageByObj(AutoAnswerMessageVO autoAnswerMessageVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoAnswerMessageVO> list = this.autoAnswerMessageDao.searchListPageByObj(autoAnswerMessageVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoAnswerMessageVO> page = new PageInfo<AutoAnswerMessageVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子留言回复数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<AutoAnswerMessageVO> searchListPageByObjOr(AutoAnswerMessageVO autoAnswerMessageVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<AutoAnswerMessageVO> list = this.autoAnswerMessageDao.searchListPageByObjOr(autoAnswerMessageVO);
		// 用PageInfo对结果进行包装
		PageInfo<AutoAnswerMessageVO> page = new PageInfo<AutoAnswerMessageVO>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子留言回复数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjRefin(AutoAnswerMessageVO autoAnswerMessageVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.autoAnswerMessageDao.searchListPageByObjRefin(autoAnswerMessageVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}

	/**
	 * 分页查询，传入对象参数，动态构建查询条件
	 * @param autoAnswerMessageVO 帖子留言回复数据信息对象
	 * @param pageNo 当前显示页数
	 * @param pageSize 当前页显示数据条数
	 * @return 帖子留言回复数据信息对象列表，含分页参数
	 */
	@Override
	public PageInfo<Map<String, Object>> searchListPageByObjReftable(AutoAnswerMessageVO autoAnswerMessageVO, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = this.autoAnswerMessageDao.searchListPageByObjReftable(autoAnswerMessageVO);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		// 测试PageInfo全部属性
		return page;
	}
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 自定义搜索【帖子留言回复数据】信息，请通过service中拦截开发，传入查询sql语句
	 * @param extendmap 帖子留言回复数据信息对象
	 * autoAnswerMessageVO
	 * pageNo
	 * pageSize
	 * @return 帖子留言回复数据信息对象列表，含分页对象
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
