package wo.develop.a1controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wo.develop.run.a2service.impl.CommonExecuteImpl;
import wo.develop.run.a2service.impl.ExecuteHelper;
import wo.develop.run.a3service.IExecute;
import wo.develop.run.runutil.DevelopDataUtil;
import wo.develop.a5vo.ManageLunVO;
import wo.develop.a3service.IManageLunService;

import wo.develop.util.BeanRefUtil;
import wo.develop.util.DateHelper;
import wo.develop.util.JsonHelper;
import wo.develop.util.OperateTypeUtil;
import wo.develop.util.P;
import wo.develop.util.RequestUtil;
import wo.develop.util.ResultUtil;
import wo.develop.util.StringUtil;
import wo.develop.util.UniqueUtil;

import com.github.pagehelper.PageInfo;


/**
 * 轮播图信息管理服务请求跳转控制类
 *
 */
@Controller
@RequestMapping("/manageLun")
public class ManageLunController {
	private static Logger log = LoggerFactory.getLogger(ManageLunController.class);
	
	@Resource
	private IManageLunService manageLunService;

	/**
	 * 新增【轮播图】信息保存，数据唯一标识符默认必须为空，如已存在请通过uiidnotnull=1属性指定
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/save")
	
	public Map<String, Object> toSaveManageLun(HttpServletRequest request) {
		Map<String, Object> errormap = toSaveManageLunReturnVO(request);
		if (errormap.containsKey("data"))
			errormap.remove("data");
		return errormap;
	}

	/**
	 * 新增【轮播图】信息保存并返回本次新增数据的唯一标识符，数据唯一标识符默认必须为空，如已存在请通过uiidnotnull=1属性指定
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/savereturnid")
	
	public Map<String, Object> toSaveManageLunReturnID(HttpServletRequest request) {
		Map<String, Object> errormap = toSaveManageLunReturnVO(request);
		if (errormap.containsKey("data")) {
			String uiid = ((ManageLunVO) errormap.get("data")).getUiid();
			errormap.remove("data");
			errormap.put("data", uiid);
		}
		return errormap;
	}

	/**
	 * 新增【轮播图】信息保存并返回本次新增的数据对象，数据唯一标识符默认必须为空，如已存在请通过uiidnotnull=1属性指定
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/savereturnobj")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toSaveManageLunReturnVO(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_add);
			String uiid = "";
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图toSaveManageLunReturnVO，提交的参数："+map.toString());
			if (StringUtil.isNotNull(manageLunVO.getUiid())) {
				if(StringUtil.isNotNull(map.get("uiidnotnull").toString())){
					if (this.manageLunService.insertForObj(manageLunVO) > 0) {
						map.put(CommonExecuteImpl.data, manageLunVO);
						returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
						if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
						manageLunVO.setUiid(uiid);
						map.put(CommonExecuteImpl.data, manageLunVO);
						returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
						if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
						return ResultUtil.ok(manageLunVO);
					} else {
						return ResultUtil.error(30002, "数据新增失败");
					}
				}else{
					return ResultUtil.error(30001, "未指定uiidnotnull属性");
				}
			} else {
				uiid = UniqueUtil.getUniqueID() + "";
				manageLunVO.setUiid(uiid);
				if (this.manageLunService.insertForObj(manageLunVO) > 0) {
					map.put(CommonExecuteImpl.data, manageLunVO);
					returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					manageLunVO.setUiid(uiid);
					map.put(CommonExecuteImpl.data, manageLunVO);
					returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					return ResultUtil.ok(manageLunVO);
				} else {
					return ResultUtil.error(30002, "数据新增失败");
				}
			}
		} catch (Exception e) {
			log.error("  新增【轮播图】信息保存并返回本次新增的数据对象，数据唯一标识符默认必须为空，如已存在请通过uiidnotnull=1属性指定",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 批量新增【轮播图】信息保存，数据唯一标识符默认必须为空
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/savebatch")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toSaveManageLunBatch(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_add);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图toSaveManageLunBatch，提交的参数："+map.toString());
			if (StringUtil.isNotNull(manageLunVO.getUiid())) {
				return ResultUtil.error(30001, "数据唯一标识符非空");
			} else {
				if (this.manageLunService.insertBatchForObj(manageLunVO) > 0) {
					returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					return ResultUtil.ok();
				} else {
					return ResultUtil.error(30002, "数据新增失败");
				}
			}
		} catch (Exception e) {
			log.error("  批量新增【轮播图】信息保存，数据唯一标识符默认必须为空",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【轮播图】编辑数据，参数为唯一标识数据数据项的标识符
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/toEditData")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toEditData(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图toEditData，提交的参数："+map.toString());
			if (!StringUtil.isNotNull(manageLunVO.getUiid())) {
				return ResultUtil.error(30004, "数据唯一标识符空异常");
			} else {
				Object manageLun = this.manageLunService.searchById(manageLunVO.getUiid());
				returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				return ResultUtil.ok(manageLun);
			}
		} catch (Exception e) {
			log.error("  获取【轮播图】编辑数据，参数为唯一标识数据数据项的标识符",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 编辑【轮播图】信息保存，数据唯一标识符不能为空
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/edit")
	
	public Map<String, Object> toEditManageLun(HttpServletRequest request) {
		Map<String, Object> errormap = toEditManageLunReturnVO(request);
		if (errormap.containsKey("data"))
			errormap.remove("data");
		return errormap;
	}

	/**
	 * 编辑【轮播图】信息保存并返回本次更新的数据对象，数据唯一标识符不能为空
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/editreturnobj")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toEditManageLunReturnVO(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sbfmsg = new StringBuffer();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_edit);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图toEditManageLunReturnVO，提交的参数："+map.toString());
			if (!StringUtil.isNotNull(manageLunVO.getUiid())) {
				return ResultUtil.error(30006, "数据唯一标识符空异常");	
			} else {
				if (this.manageLunService.updateForObj(manageLunVO) > 0) {
					returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					return ResultUtil.ok();
				} else {
					return ResultUtil.error(30002, "更新的数据保存异常");
				}
			}
		} catch (Exception e) {
			log.error("  编辑【轮播图】信息保存并返回本次更新的数据对象，数据唯一标识符不能为空",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}
	
	/**
	 * 批量编辑【轮播图】信息保存，数据唯一标识符不能为空
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/editbatch")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> updateBatchForMapList(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_edit);
			BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, null);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("数据表管理toEditSysTableReturnVO，提交的参数："+map.toString());
			if (this.manageLunService.updateBatchForMapList(map) > 0) {
				returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				return ResultUtil.ok();
			} else {
				return ResultUtil.error(30002, "更新的数据保存异常");
			}
		} catch (Exception e) {
			log.error("  编辑【轮播图】信息保存，数据唯一标识符不能为空",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 智能数据新增编辑【轮播图】接口，存在id执行更新，不存在id执行新增，已存在id数据新增请调用save接口
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/addedit")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toAddEditManageLun(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sbfmsg = new StringBuffer();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_add);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图toAddEditManageLun，提交的参数："+map.toString());
			String uiid = "";
			// 验证请求的参数是否正确
			if (!StringUtil.isNotNull(manageLunVO.getUiid())) {
				uiid = UniqueUtil.getUniqueID() + "";
				manageLunVO.setUiid(uiid);
				if (this.manageLunService.insertForObj(manageLunVO) > 0) {
					returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					manageLunVO.setUiid(uiid);
					returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					return ResultUtil.ok(manageLunVO);
				} else {
					return ResultUtil.error(30002, "新增的数据保存异常");
				}
			} else {
				if (this.manageLunService.updateForObj(manageLunVO) > 0) {
					returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					return ResultUtil.ok();
				} else {
					return ResultUtil.error(30002, "更新的数据保存异常");
				}
			}
		} catch (Exception e) {
			log.error("  智能数据新增编辑【轮播图】接口，存在id执行更新，不存在id执行新增，已存在id数据新增请调用save接口",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 通过主键删除一到多条【轮播图】信息，支持删除一条或多条数据，多个数据唯一标识之间通过逗号分隔
	 * @param request uiid 数据主键，多个之间通过逗号分隔
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toDeleteManageLun(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_delte);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图toDeleteManageLun，提交的参数："+map.toString());
			// 验证请求的参数是否正确
			if (!StringUtil.isNotNull(manageLunVO.getUiid())) {
				return ResultUtil.error(30004, "数据唯一标识符空异常");
			} else {
				if (manageLunVO.getUiid().indexOf(",") != -1) {
					List<String> result = Arrays.asList(manageLunVO.getUiid().split(","));
					if (this.manageLunService.deleteBatchById(result) >= 0) {
						returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
						if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
						returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
						if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
						return ResultUtil.ok();
					} else {
						return ResultUtil.error(30002, "数据批量删除失败");
					}
				} else {
					if (this.manageLunService.deleteById(manageLunVO.getUiid()) > 0) {
						returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
						if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
						returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
						if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
						return ResultUtil.ok();
					} else {
						return ResultUtil.error(30002, "数据删除失败");
					}
				}
			}
		} catch (Exception e) {
			log.error("  通过主键删除一到多条【轮播图】信息，支持删除一条或多条数据，多个数据唯一标识之间通过逗号分隔",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 通过其他数据项条件删除【轮播图】信息，如果全部参数为空，系统将抛出30007异常
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/deletea")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toDeleteManageLun1(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_delte);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图toDeleteManageLun1，提交的参数："+map.toString());
			if (BeanRefUtil.checkObjNull(manageLunVO)) {
				if (this.manageLunService.deleteByObj(manageLunVO) >= 0) {
					returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					return ResultUtil.ok();
				} else {
					return ResultUtil.error(30002, "数据删除失败");
				}
			} else {
				return ResultUtil.error(30004, "对象属性空异常");
			}
		} catch (Exception e) {
			log.error("  通过其他数据项条件删除【轮播图】信息，如果全部参数为空，系统将抛出30007异常",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 清空【轮播图】信息中的全部数据
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/deleteall")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toDeleteManageLun2(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			if (this.manageLunService.deleteAll() > 0) {
				returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				return ResultUtil.ok();
			} else {
				return ResultUtil.error(30002, "数据删除失败");
			}
		} catch (Exception e) {
			log.error("  清空【轮播图】信息中的全部数据",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【轮播图】列表信息并返回JSON数据，=条件标识符，支持多条件查询
	 * @param request
	 *  pageNum 页码
	 *  pageSize 页显示数
	 */
	@ResponseBody
	@RequestMapping("/tolist")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> tolist(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图tolistdataequal，提交的参数："+map.toString());
			String pagenum = map.containsKey("pageNum")?map.get("pageNum").toString():"";
			pagenum = StringUtil.isNotNull(pagenum) ? pagenum : "1";
			String pageSize = map.containsKey("pageSize")?map.get("pageSize").toString():"";
			pageSize = StringUtil.isNotNull(pageSize) ? pageSize : "100";
			PageInfo<ManageLunVO> pageinfo = this.manageLunService.searchListByObj(manageLunVO, Integer.parseInt(pagenum),Integer.parseInt(pageSize));
			map.put(CommonExecuteImpl.page, pageinfo);
			returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			return ResultUtil.ok(pageinfo);
		} catch (Exception e) {
			log.error("  获取【轮播图】列表信息并返回JSON数据，=条件标识符，支持多条件查询",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【轮播图】列表信息并返回JSON数据,like条件分隔符，支持多条件查询
	 * @param request
	 *  pageNum 页码
	 *  pageSize 页显示数
	 */
	@ResponseBody
	@RequestMapping("/tolistdata")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> tolistdata(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图tolistdata，提交的参数："+map.toString());
			String pagenum = map.containsKey("pageNum")?map.get("pageNum").toString():"";
			pagenum = StringUtil.isNotNull(pagenum) ? pagenum : "1";
			String pageSize = map.containsKey("pageSize")?map.get("pageSize").toString():"";
			pageSize = StringUtil.isNotNull(pageSize) ? pageSize : "100";
			PageInfo<ManageLunVO> pageinfo = this.manageLunService.searchListPageByObj(manageLunVO, Integer.parseInt(pagenum),Integer.parseInt(pageSize));
			map.put(CommonExecuteImpl.page, pageinfo);
			returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			PageInfo<Map<String, Object>> pageinfo2 = DevelopDataUtil.outcheck2(pageinfo, "cml");
			map.put(CommonExecuteImpl.page, pageinfo2);
			returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			return ResultUtil.ok(pageinfo2);
		} catch (Exception e) {
			log.error("  获取【轮播图】列表信息并返回JSON数据,like条件分隔符，支持多条件查询",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【轮播图】列表信息并返回JSON数据,like条件分隔符，支持多条件查询
	 * @param request
	 *  pageNum 页码
	 *  pageSize 页显示数
	 */
	@ResponseBody
	@RequestMapping("/tolistdataor")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> tolistdataor(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图tolistdata，提交的参数："+map.toString());
			String pagenum = map.containsKey("pageNum")?map.get("pageNum").toString():"";
			pagenum = StringUtil.isNotNull(pagenum) ? pagenum : "1";
			String pageSize = map.containsKey("pageSize")?map.get("pageSize").toString():"";
			pageSize = StringUtil.isNotNull(pageSize) ? pageSize : "100";
			PageInfo<ManageLunVO> pageinfo = this.manageLunService.searchListPageByObjOr(manageLunVO, Integer.parseInt(pagenum),Integer.parseInt(pageSize));
			map.put(CommonExecuteImpl.page, pageinfo);
			returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			PageInfo<Map<String, Object>> pageinfo2 = DevelopDataUtil.outcheck2(pageinfo, "cml");
			map.put(CommonExecuteImpl.page, pageinfo2);
			returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			return ResultUtil.ok(pageinfo2);
		} catch (Exception e) {
			log.error("  获取【轮播图】列表信息并返回JSON数据,like条件分隔符，支持多条件查询",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 通过数据唯一标识符查询一条【轮播图】数据
	 * @param request uiid 数据主键
	 */
	@ResponseBody
	@RequestMapping("/searchById")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> searchById(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图searchById，提交的参数："+map.toString());
			if (!StringUtil.isNotNull(manageLunVO.getUiid())) {
				return ResultUtil.error(30004, "数据唯一标识符不能为空");
			} else {
				ManageLunVO _manageLunVO = this.manageLunService.searchById(manageLunVO.getUiid());
				if (_manageLunVO != null && StringUtil.isNotNull(_manageLunVO.getUiid())) {
					returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					return ResultUtil.ok(_manageLunVO);
				} else {
					return ResultUtil.error(30008, "数据未找到");
				}
			}
		} catch (Exception e) {
			log.error("  通过数据唯一标识符查询一条【轮播图】数据",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 通过多个数据唯一标识符查询多条【轮播图】数据，多个数据唯一标识之间通过逗号分隔
	 * @param request uiid 数据主键，多个之间通过逗号分隔
	 */
	@ResponseBody
	@RequestMapping("/searchBatchById")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> searchBatchById(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图searchBatchById，提交的参数："+map.toString());
			if (!StringUtil.isNotNull(manageLunVO.getUiid())) {
				return ResultUtil.error(30004, "数据唯一标识符不能为空");
			} else {
				List<ManageLunVO> pageinfo = this.manageLunService.searchBatchById(manageLunVO.getUiid());
				map.put(CommonExecuteImpl.page, pageinfo);
				returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				List<Map<String, Object>> pageinfo2 = DevelopDataUtil.outcheck(JsonHelper.toMapList1(pageinfo), "cml");
				map.put(CommonExecuteImpl.page, pageinfo2);
				returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				if (pageinfo != null && pageinfo.size() != 0) {
					return ResultUtil.ok(pageinfo2);
				} else {
					return ResultUtil.error(30008, "数据未找到");
				}
			}
		} catch (Exception e) {
			log.error("  通过多个数据唯一标识符查询多条【轮播图】数据，多个数据唯一标识之间通过逗号分隔",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取当前符合条件的数据条数
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/searchCountByObj")
	
	public HashMap<String, Object> searchCountByObj(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			log.debug("轮播图searchCountByObj，提交的参数："+map.toString());
			int pageinfo = this.manageLunService.searchCountByObj(manageLunVO);
			return ResultUtil.ok(pageinfo);
		} catch (Exception e) {
			log.error("  获取当前符合条件的数据条数",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【轮播图】列表信息并返回JSON数据，存在一对多关系，一个字段存储有多个id的时候适用该方式获取关系数据
	 * @param request
	 *  pageNum 页码
	 *  pageSize 页显示数
	 */
	@ResponseBody
	@RequestMapping("/tolistdatarefin")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> tolistdatarefin(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			map.put(CommonExecuteImpl.pobj, manageLunVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("轮播图tolistdatarefin，提交的参数："+map.toString());
			String pagenum = map.containsKey("pageNum")?map.get("pageNum").toString():"";
			pagenum = StringUtil.isNotNull(pagenum) ? pagenum : "1";
			String pageSize = map.containsKey("pageSize")?map.get("pageSize").toString():"";
			pageSize = StringUtil.isNotNull(pageSize) ? pageSize : "100";
			PageInfo<Map<String, Object>> pageinfo = this.manageLunService.searchListPageByObjRefin(
					manageLunVO, Integer.parseInt(pagenum), Integer.parseInt(pageSize));
				map.put(CommonExecuteImpl.page, pageinfo);
				returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			pageinfo = DevelopDataUtil.outcheck1(pageinfo, "cml");
			map.put(CommonExecuteImpl.page, pageinfo);
			returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			return ResultUtil.ok(pageinfo);
		} catch (Exception e) {
			log.error("  获取【轮播图】列表信息并返回JSON数据，存在一对多关系，一个字段存储有多个id的时候适用该方式获取关系数据",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【轮播图】列表信息并返回JSON数据，标准的left outer join关联查询，不支持一个字段存储多个id
	 * @param request
	 *  pageNum 页码
	 *  pageSize 页显示数
	 */
	@ResponseBody
	@RequestMapping("/tolistdatareftable")
	
	public HashMap<String, Object> tolistdatareftable(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			ManageLunVO manageLunVO = (ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			log.debug("轮播图tolistdatareftable，提交的参数："+map.toString());
			String pagenum = map.containsKey("pageNum")?map.get("pageNum").toString():"";
			pagenum = StringUtil.isNotNull(pagenum) ? pagenum : "1";
			String pageSize = map.containsKey("pageSize")?map.get("pageSize").toString():"";
			pageSize = StringUtil.isNotNull(pageSize) ? pageSize : "100";
			PageInfo<Map<String, Object>> pageinfo = this.manageLunService.searchListPageByObjReftable(
					manageLunVO, Integer.parseInt(pagenum), Integer.parseInt(pageSize));
			pageinfo = DevelopDataUtil.outcheck1(pageinfo, "cml");
			return ResultUtil.ok(pageinfo);
		} catch (Exception e) {
			log.error("  获取【轮播图】列表信息并返回JSON数据，标准的left outer join关联查询，不支持一个字段存储多个id",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【轮播图】列表信息并返回JSON数据，通过逗号分隔的主键，一次查询多条数据；
	 * @param request uiid 数据主键，多个之间通过逗号分隔
	 */
	@ResponseBody
	@RequestMapping("/tolistdatamorebyid")
	
	public HashMap<String, Object> tolistdatamorebyid(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			BeanRefUtil.setvalueFromRequest(request, new ManageLunVO(), map);
			List<ManageLunVO> pageinfo = this.manageLunService.searchBatchById((String )map.get("uiid"));
			List<Map<String, Object>> pageinfo1 = DevelopDataUtil.outcheck(JsonHelper.toMapList1(pageinfo), "cml");
			return ResultUtil.ok(pageinfo1);
		} catch (Exception e) {
			log.error("  获取【轮播图】列表信息并返回JSON数据，通过逗号分隔的主键，一次查询多条数据；",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【轮播图】列表信息并返回JSON数据
	 * @param request uiid 数据主键，多个之间通过逗号分隔
	 */
	//@ResponseBody
	//@RequestMapping("/tolistdatamore")
	//
	public HashMap<String, Object> tolistdatamore(HttpServletRequest request) {
		try {
			// 验证请求的参数是否正确
			List<ManageLunVO> pageinfo = this.manageLunService.searchByMoreId(
					(ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO()));
			List<Map<String, Object>> pageinfo1 = DevelopDataUtil.outcheck(JsonHelper.toMapList1(pageinfo), "cml");
			return ResultUtil.ok(pageinfo1);
		} catch (Exception e) {
			log.error("  获取【轮播图】列表信息并返回JSON数据；",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 搜索符合条件的【轮播图】信息
	 * @param request
	 */
	//@ResponseBody
	//@RequestMapping("/tosearch")
	//
	public HashMap<String, Object> tosearch(HttpServletRequest request) {
		HashMap<String, Object> errormap = new HashMap<String, Object>();
		try {
			// 验证请求的参数是否正确
			if (false) {
				// sbfmsg.append("");
				// errormap.put("error_code", 10016);
				// errormap.put("error", P.g("10016")+" "+sbfmsg.toString());
				// model.addAttribute("error_msg", errormap);
				// return PublicPageConfig.alertpage;
			} else {
				Object pageinfo = this.manageLunService.searchListPageByObj(
						(ManageLunVO) BeanRefUtil.setvalueFromRequest(request, new ManageLunVO()), 1, 10);
				errormap.put("error", P.g("10000"));
			}
		} catch (Exception e) {
		}
		return ResultUtil.error(30003, "数据查询失败");
	}

	/**
	 * 自定义搜索【轮播图】信息，请通过service中拦截开发，传入查询sql语句
	 * @param request sql 切片方式传入sql语句及自定义查询条件参数
	 */
	@ResponseBody
	@RequestMapping("/extendsearch")
	
	public HashMap<String, Object> extendsearch(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			map = RequestUtil.getParameterMap(request, map);
            log.info("轮播图extendsearch，提交的参数："+map.toString());
			PageInfo<Map<String, Object>> pageinfo = this.manageLunService.extendsearch(map);
			return ResultUtil.ok(pageinfo);
		} catch (Exception e) {
			log.error("  自定义搜索【轮播图】信息，请通过service中拦截开发，传入查询sql语句",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}


	/**
	 * 数据排序 轮播图
	 * @param request sort 排序数据的uiid，多个之间通过逗号分隔
	 */
	@ResponseBody
	@RequestMapping("/sort")
	
	public HashMap<String, Object> toSortManageLun(HttpServletRequest request) {
		try {
			if(StringUtil.isNotNull(request.getParameter("type")) && "tree".equals(request.getParameter("type"))){
				if(StringUtil.isNotNull(request.getParameter("sort"))){
				}
			}else{
				String sort = request.getParameter("sort");
				if (!StringUtil.isNotNull(sort)) {
					return ResultUtil.error(30002, "排序数据id空异常");
				}else{
					if(this.manageLunService.listsort(sort) > 0){
						return ResultUtil.ok();
					}else{
						return ResultUtil.error(30002, "数据排序失败");
					}
				}
			}
		} catch (Exception e) {
			log.error("【轮播图】数据排序异常",e);
			return ResultUtil.error(19999, e.getMessage());
		}
		return ResultUtil.error(19999,"数据排序失败");
	}
}