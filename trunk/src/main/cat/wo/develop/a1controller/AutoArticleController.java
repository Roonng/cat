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
import wo.develop.a5vo.AutoArticleVO;
import wo.develop.a3service.IAutoArticleService;

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
 * 发帖数据信息管理服务请求跳转控制类
 *
 */
@Controller
@RequestMapping("/autoArticle")
public class AutoArticleController {
	private static Logger log = LoggerFactory.getLogger(AutoArticleController.class);
	
	@Resource
	private IAutoArticleService autoArticleService;

	/**
	 * 新增【发帖数据】信息保存，数据唯一标识符默认必须为空，如已存在请通过uiidnotnull=1属性指定
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/save")
	
	public Map<String, Object> toSaveAutoArticle(HttpServletRequest request) {
		Map<String, Object> errormap = toSaveAutoArticleReturnVO(request);
		if (errormap.containsKey("data"))
			errormap.remove("data");
		return errormap;
	}

	/**
	 * 新增【发帖数据】信息保存并返回本次新增数据的唯一标识符，数据唯一标识符默认必须为空，如已存在请通过uiidnotnull=1属性指定
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/savereturnid")
	
	public Map<String, Object> toSaveAutoArticleReturnID(HttpServletRequest request) {
		Map<String, Object> errormap = toSaveAutoArticleReturnVO(request);
		if (errormap.containsKey("data")) {
			String uiid = ((AutoArticleVO) errormap.get("data")).getUiid();
			errormap.remove("data");
			errormap.put("data", uiid);
		}
		return errormap;
	}

	/**
	 * 新增【发帖数据】信息保存并返回本次新增的数据对象，数据唯一标识符默认必须为空，如已存在请通过uiidnotnull=1属性指定
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/savereturnobj")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toSaveAutoArticleReturnVO(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_add);
			String uiid = "";
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据toSaveAutoArticleReturnVO，提交的参数："+map.toString());
			if (StringUtil.isNotNull(autoArticleVO.getUiid())) {
				if(StringUtil.isNotNull(map.get("uiidnotnull").toString())){
					if (this.autoArticleService.insertForObj(autoArticleVO) > 0) {
						map.put(CommonExecuteImpl.data, autoArticleVO);
						returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
						if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
						autoArticleVO.setUiid(uiid);
						map.put(CommonExecuteImpl.data, autoArticleVO);
						returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
						if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
						return ResultUtil.ok(autoArticleVO);
					} else {
						return ResultUtil.error(30002, "数据新增失败");
					}
				}else{
					return ResultUtil.error(30001, "未指定uiidnotnull属性");
				}
			} else {
				uiid = UniqueUtil.getUniqueID() + "";
				autoArticleVO.setUiid(uiid);
				if (this.autoArticleService.insertForObj(autoArticleVO) > 0) {
					map.put(CommonExecuteImpl.data, autoArticleVO);
					returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					autoArticleVO.setUiid(uiid);
					map.put(CommonExecuteImpl.data, autoArticleVO);
					returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					return ResultUtil.ok(autoArticleVO);
				} else {
					return ResultUtil.error(30002, "数据新增失败");
				}
			}
		} catch (Exception e) {
			log.error("  新增【发帖数据】信息保存并返回本次新增的数据对象，数据唯一标识符默认必须为空，如已存在请通过uiidnotnull=1属性指定",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 批量新增【发帖数据】信息保存，数据唯一标识符默认必须为空
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/savebatch")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toSaveAutoArticleBatch(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_add);
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据toSaveAutoArticleBatch，提交的参数："+map.toString());
			if (StringUtil.isNotNull(autoArticleVO.getUiid())) {
				return ResultUtil.error(30001, "数据唯一标识符非空");
			} else {
				if (this.autoArticleService.insertBatchForObj(autoArticleVO) > 0) {
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
			log.error("  批量新增【发帖数据】信息保存，数据唯一标识符默认必须为空",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【发帖数据】编辑数据，参数为唯一标识数据数据项的标识符
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
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据toEditData，提交的参数："+map.toString());
			if (!StringUtil.isNotNull(autoArticleVO.getUiid())) {
				return ResultUtil.error(30004, "数据唯一标识符空异常");
			} else {
				Object autoArticle = this.autoArticleService.searchById(autoArticleVO.getUiid());
				returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				return ResultUtil.ok(autoArticle);
			}
		} catch (Exception e) {
			log.error("  获取【发帖数据】编辑数据，参数为唯一标识数据数据项的标识符",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 编辑【发帖数据】信息保存，数据唯一标识符不能为空
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/edit")
	
	public Map<String, Object> toEditAutoArticle(HttpServletRequest request) {
		Map<String, Object> errormap = toEditAutoArticleReturnVO(request);
		if (errormap.containsKey("data"))
			errormap.remove("data");
		return errormap;
	}

	/**
	 * 编辑【发帖数据】信息保存并返回本次更新的数据对象，数据唯一标识符不能为空
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/editreturnobj")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toEditAutoArticleReturnVO(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sbfmsg = new StringBuffer();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_edit);
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据toEditAutoArticleReturnVO，提交的参数："+map.toString());
			if (!StringUtil.isNotNull(autoArticleVO.getUiid())) {
				return ResultUtil.error(30006, "数据唯一标识符空异常");	
			} else {
				if (this.autoArticleService.updateForObj(autoArticleVO) > 0) {
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
			log.error("  编辑【发帖数据】信息保存并返回本次更新的数据对象，数据唯一标识符不能为空",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}
	
	/**
	 * 批量编辑【发帖数据】信息保存，数据唯一标识符不能为空
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
			BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, null);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("数据表管理toEditSysTableReturnVO，提交的参数："+map.toString());
			if (this.autoArticleService.updateBatchForMapList(map) > 0) {
				returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				return ResultUtil.ok();
			} else {
				return ResultUtil.error(30002, "更新的数据保存异常");
			}
		} catch (Exception e) {
			log.error("  编辑【发帖数据】信息保存，数据唯一标识符不能为空",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 智能数据新增编辑【发帖数据】接口，存在id执行更新，不存在id执行新增，已存在id数据新增请调用save接口
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/addedit")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toAddEditAutoArticle(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sbfmsg = new StringBuffer();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_add);
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据toAddEditAutoArticle，提交的参数："+map.toString());
			String uiid = "";
			// 验证请求的参数是否正确
			if (!StringUtil.isNotNull(autoArticleVO.getUiid())) {
				uiid = UniqueUtil.getUniqueID() + "";
				autoArticleVO.setUiid(uiid);
				if (this.autoArticleService.insertForObj(autoArticleVO) > 0) {
					returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					autoArticleVO.setUiid(uiid);
					returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					return ResultUtil.ok(autoArticleVO);
				} else {
					return ResultUtil.error(30002, "新增的数据保存异常");
				}
			} else {
				if (this.autoArticleService.updateForObj(autoArticleVO) > 0) {
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
			log.error("  智能数据新增编辑【发帖数据】接口，存在id执行更新，不存在id执行新增，已存在id数据新增请调用save接口",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 通过主键删除一到多条【发帖数据】信息，支持删除一条或多条数据，多个数据唯一标识之间通过逗号分隔
	 * @param request uiid 数据主键，多个之间通过逗号分隔
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toDeleteAutoArticle(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_delte);
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据toDeleteAutoArticle，提交的参数："+map.toString());
			// 验证请求的参数是否正确
			if (!StringUtil.isNotNull(autoArticleVO.getUiid())) {
				return ResultUtil.error(30004, "数据唯一标识符空异常");
			} else {
				if (autoArticleVO.getUiid().indexOf(",") != -1) {
					List<String> result = Arrays.asList(autoArticleVO.getUiid().split(","));
					if (this.autoArticleService.deleteBatchById(result) >= 0) {
						returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
						if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
						returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
						if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
						return ResultUtil.ok();
					} else {
						return ResultUtil.error(30002, "数据批量删除失败");
					}
				} else {
					if (this.autoArticleService.deleteById(autoArticleVO.getUiid()) > 0) {
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
			log.error("  通过主键删除一到多条【发帖数据】信息，支持删除一条或多条数据，多个数据唯一标识之间通过逗号分隔",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 通过其他数据项条件删除【发帖数据】信息，如果全部参数为空，系统将抛出30007异常
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/deletea")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toDeleteAutoArticle1(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_delte);
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据toDeleteAutoArticle1，提交的参数："+map.toString());
			if (BeanRefUtil.checkObjNull(autoArticleVO)) {
				if (this.autoArticleService.deleteByObj(autoArticleVO) >= 0) {
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
			log.error("  通过其他数据项条件删除【发帖数据】信息，如果全部参数为空，系统将抛出30007异常",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 清空【发帖数据】信息中的全部数据
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("/deleteall")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public Map<String, Object> toDeleteAutoArticle2(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IExecute iExecute = ExecuteHelper.get(Thread.currentThread().getStackTrace()[1]);
			map.put(CommonExecuteImpl.req, request);
			Map<String, Object> returnmap = (Map<String, Object> )ExecuteHelper.before(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			map.remove(CommonExecuteImpl.req);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			if (this.autoArticleService.deleteAll() > 0) {
				returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				return ResultUtil.ok();
			} else {
				return ResultUtil.error(30002, "数据删除失败");
			}
		} catch (Exception e) {
			log.error("  清空【发帖数据】信息中的全部数据",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【发帖数据】列表信息并返回JSON数据，=条件标识符，支持多条件查询
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
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据tolistdataequal，提交的参数："+map.toString());
			String pagenum = map.containsKey("pageNum")?map.get("pageNum").toString():"";
			pagenum = StringUtil.isNotNull(pagenum) ? pagenum : "1";
			String pageSize = map.containsKey("pageSize")?map.get("pageSize").toString():"";
			pageSize = StringUtil.isNotNull(pageSize) ? pageSize : "100";
			PageInfo<AutoArticleVO> pageinfo = this.autoArticleService.searchListByObj(autoArticleVO, Integer.parseInt(pagenum),Integer.parseInt(pageSize));
			map.put(CommonExecuteImpl.page, pageinfo);
			returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			return ResultUtil.ok(pageinfo);
		} catch (Exception e) {
			log.error("  获取【发帖数据】列表信息并返回JSON数据，=条件标识符，支持多条件查询",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【发帖数据】列表信息并返回JSON数据,like条件分隔符，支持多条件查询
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
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据tolistdata，提交的参数："+map.toString());
			String pagenum = map.containsKey("pageNum")?map.get("pageNum").toString():"";
			pagenum = StringUtil.isNotNull(pagenum) ? pagenum : "1";
			String pageSize = map.containsKey("pageSize")?map.get("pageSize").toString():"";
			pageSize = StringUtil.isNotNull(pageSize) ? pageSize : "100";
			PageInfo<AutoArticleVO> pageinfo = this.autoArticleService.searchListPageByObj(autoArticleVO, Integer.parseInt(pagenum),Integer.parseInt(pageSize));
			map.put(CommonExecuteImpl.page, pageinfo);
			returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			PageInfo<Map<String, Object>> pageinfo2 = DevelopDataUtil.outcheck2(pageinfo, "caa");
			map.put(CommonExecuteImpl.page, pageinfo2);
			returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			return ResultUtil.ok(pageinfo2);
		} catch (Exception e) {
			log.error("  获取【发帖数据】列表信息并返回JSON数据,like条件分隔符，支持多条件查询",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【发帖数据】列表信息并返回JSON数据,like条件分隔符，支持多条件查询
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
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据tolistdata，提交的参数："+map.toString());
			String pagenum = map.containsKey("pageNum")?map.get("pageNum").toString():"";
			pagenum = StringUtil.isNotNull(pagenum) ? pagenum : "1";
			String pageSize = map.containsKey("pageSize")?map.get("pageSize").toString():"";
			pageSize = StringUtil.isNotNull(pageSize) ? pageSize : "100";
			PageInfo<AutoArticleVO> pageinfo = this.autoArticleService.searchListPageByObjOr(autoArticleVO, Integer.parseInt(pagenum),Integer.parseInt(pageSize));
			map.put(CommonExecuteImpl.page, pageinfo);
			returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			PageInfo<Map<String, Object>> pageinfo2 = DevelopDataUtil.outcheck2(pageinfo, "caa");
			map.put(CommonExecuteImpl.page, pageinfo2);
			returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			return ResultUtil.ok(pageinfo2);
		} catch (Exception e) {
			log.error("  获取【发帖数据】列表信息并返回JSON数据,like条件分隔符，支持多条件查询",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 通过数据唯一标识符查询一条【发帖数据】数据
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
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据searchById，提交的参数："+map.toString());
			if (!StringUtil.isNotNull(autoArticleVO.getUiid())) {
				return ResultUtil.error(30004, "数据唯一标识符不能为空");
			} else {
				AutoArticleVO _autoArticleVO = this.autoArticleService.searchById(autoArticleVO.getUiid());
				if (_autoArticleVO != null && StringUtil.isNotNull(_autoArticleVO.getUiid())) {
					returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
					if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
					return ResultUtil.ok(_autoArticleVO);
				} else {
					return ResultUtil.error(30008, "数据未找到");
				}
			}
		} catch (Exception e) {
			log.error("  通过数据唯一标识符查询一条【发帖数据】数据",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 通过多个数据唯一标识符查询多条【发帖数据】数据，多个数据唯一标识之间通过逗号分隔
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
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据searchBatchById，提交的参数："+map.toString());
			if (!StringUtil.isNotNull(autoArticleVO.getUiid())) {
				return ResultUtil.error(30004, "数据唯一标识符不能为空");
			} else {
				List<AutoArticleVO> pageinfo = this.autoArticleService.searchBatchById(autoArticleVO.getUiid());
				map.put(CommonExecuteImpl.page, pageinfo);
				returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
				List<Map<String, Object>> pageinfo2 = DevelopDataUtil.outcheck(JsonHelper.toMapList1(pageinfo), "caa");
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
			log.error("  通过多个数据唯一标识符查询多条【发帖数据】数据，多个数据唯一标识之间通过逗号分隔",e);
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
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			log.debug("发帖数据searchCountByObj，提交的参数："+map.toString());
			int pageinfo = this.autoArticleService.searchCountByObj(autoArticleVO);
			return ResultUtil.ok(pageinfo);
		} catch (Exception e) {
			log.error("  获取当前符合条件的数据条数",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【发帖数据】列表信息并返回JSON数据，存在一对多关系，一个字段存储有多个id的时候适用该方式获取关系数据
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
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			map.put(CommonExecuteImpl.pobj, autoArticleVO);
			returnmap = (Map<String, Object> )ExecuteHelper.beforeEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			log.debug("发帖数据tolistdatarefin，提交的参数："+map.toString());
			String pagenum = map.containsKey("pageNum")?map.get("pageNum").toString():"";
			pagenum = StringUtil.isNotNull(pagenum) ? pagenum : "1";
			String pageSize = map.containsKey("pageSize")?map.get("pageSize").toString():"";
			pageSize = StringUtil.isNotNull(pageSize) ? pageSize : "100";
			PageInfo<Map<String, Object>> pageinfo = this.autoArticleService.searchListPageByObjRefin(
					autoArticleVO, Integer.parseInt(pagenum), Integer.parseInt(pageSize));
				map.put(CommonExecuteImpl.page, pageinfo);
				returnmap = (Map<String, Object> )ExecuteHelper.after(iExecute,map);
				if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			pageinfo = DevelopDataUtil.outcheck1(pageinfo, "caa");
			map.put(CommonExecuteImpl.page, pageinfo);
			returnmap = (Map<String, Object> )ExecuteHelper.afterEnd(iExecute,map);
			if(null != returnmap && returnmap.containsKey(CommonExecuteImpl.exist)){return returnmap;}
			return ResultUtil.ok(pageinfo);
		} catch (Exception e) {
			log.error("  获取【发帖数据】列表信息并返回JSON数据，存在一对多关系，一个字段存储有多个id的时候适用该方式获取关系数据",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【发帖数据】列表信息并返回JSON数据，标准的left outer join关联查询，不支持一个字段存储多个id
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
			AutoArticleVO autoArticleVO = (AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			log.debug("发帖数据tolistdatareftable，提交的参数："+map.toString());
			String pagenum = map.containsKey("pageNum")?map.get("pageNum").toString():"";
			pagenum = StringUtil.isNotNull(pagenum) ? pagenum : "1";
			String pageSize = map.containsKey("pageSize")?map.get("pageSize").toString():"";
			pageSize = StringUtil.isNotNull(pageSize) ? pageSize : "100";
			PageInfo<Map<String, Object>> pageinfo = this.autoArticleService.searchListPageByObjReftable(
					autoArticleVO, Integer.parseInt(pagenum), Integer.parseInt(pageSize));
			pageinfo = DevelopDataUtil.outcheck1(pageinfo, "caa");
			return ResultUtil.ok(pageinfo);
		} catch (Exception e) {
			log.error("  获取【发帖数据】列表信息并返回JSON数据，标准的left outer join关联查询，不支持一个字段存储多个id",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【发帖数据】列表信息并返回JSON数据，通过逗号分隔的主键，一次查询多条数据；
	 * @param request uiid 数据主键，多个之间通过逗号分隔
	 */
	@ResponseBody
	@RequestMapping("/tolistdatamorebyid")
	
	public HashMap<String, Object> tolistdatamorebyid(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO(), map);
			List<AutoArticleVO> pageinfo = this.autoArticleService.searchBatchById((String )map.get("uiid"));
			List<Map<String, Object>> pageinfo1 = DevelopDataUtil.outcheck(JsonHelper.toMapList1(pageinfo), "caa");
			return ResultUtil.ok(pageinfo1);
		} catch (Exception e) {
			log.error("  获取【发帖数据】列表信息并返回JSON数据，通过逗号分隔的主键，一次查询多条数据；",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 获取【发帖数据】列表信息并返回JSON数据
	 * @param request uiid 数据主键，多个之间通过逗号分隔
	 */
	//@ResponseBody
	//@RequestMapping("/tolistdatamore")
	//
	public HashMap<String, Object> tolistdatamore(HttpServletRequest request) {
		try {
			// 验证请求的参数是否正确
			List<AutoArticleVO> pageinfo = this.autoArticleService.searchByMoreId(
					(AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO()));
			List<Map<String, Object>> pageinfo1 = DevelopDataUtil.outcheck(JsonHelper.toMapList1(pageinfo), "caa");
			return ResultUtil.ok(pageinfo1);
		} catch (Exception e) {
			log.error("  获取【发帖数据】列表信息并返回JSON数据；",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}

	/**
	 * 搜索符合条件的【发帖数据】信息
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
				Object pageinfo = this.autoArticleService.searchListPageByObj(
						(AutoArticleVO) BeanRefUtil.setvalueFromRequest(request, new AutoArticleVO()), 1, 10);
				errormap.put("error", P.g("10000"));
			}
		} catch (Exception e) {
		}
		return ResultUtil.error(30003, "数据查询失败");
	}

	/**
	 * 自定义搜索【发帖数据】信息，请通过service中拦截开发，传入查询sql语句
	 * @param request sql 切片方式传入sql语句及自定义查询条件参数
	 */
	@ResponseBody
	@RequestMapping("/extendsearch")
	
	public HashMap<String, Object> extendsearch(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			map.put(OperateTypeUtil.otype, OperateTypeUtil.otype_search);
			map = RequestUtil.getParameterMap(request, map);
            log.info("发帖数据extendsearch，提交的参数："+map.toString());
			PageInfo<Map<String, Object>> pageinfo = this.autoArticleService.extendsearch(map);
			return ResultUtil.ok(pageinfo);
		} catch (Exception e) {
			log.error("  自定义搜索【发帖数据】信息，请通过service中拦截开发，传入查询sql语句",e);
			return ResultUtil.error(19999, e.getMessage());
		}
	}


}