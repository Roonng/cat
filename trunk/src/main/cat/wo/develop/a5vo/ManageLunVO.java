/**
 * 文档说明及编辑注意事项：
 * 该文档为系统自动生成的源码文档，请尽量不要修改该文档，如确实需要修改请遵循如下规范：
 * 1、新增行代码，不受影响；
 * 2、编辑行代码，已有行代码不支持编辑，如确实需要编辑，
 * 请通过/ * 我是原有脚本代码   * /范围注释符注释掉需要修改的内容，在另起新行重写代码
 * 3、删除行代码，用户自行添加代码可随意删除；
 * 系统自动生成代码只能通过/ * 我是原有脚本代码   * /范围注释符注释掉，如直接删除，二次刷新代码将重新生成
 * 
 */
package wo.develop.a5vo;

import java.util.HashMap;

import wo.develop.util.BeanRefUtil;

/**
 * 
 * @ClassName: ManageLunVO
 * @Description: 轮播图
 * @author 彭羽飞
 */
public class ManageLunVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "com_manage_lun";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "cml_uiid";
	
	/**
	 * 轮播图主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 产品编码
	 * @autocreate=true
	 */
	private String ptype;
	/**
	 * 轮播图标题
	 * @autocreate=true
	 */
	private String title;
	/**
	 * 显示标题
	 * @autocreate=true
	 */
	private String showtitle;
	/**
	 * 轮播图图片，关联文件主键
	 * @autocreate=true
	 */
	private String imgs;
	/**
	 * 轮播图视频
	 * @autocreate=true
	 */
	private String vidios;
	/**
	 * 指向地址
	 * @autocreate=true
	 */
	private String urls;
	/**
	 * 查看次数
	 * @autocreate=true
	 */
	private Integer viewcount;
	/**
	 * 显示栏位 1首页2其他
	 * @autocreate=true
	 */
	private String showloc;
	/**
	 * 发布状态，0草稿1发布中2已下架
	 * @autocreate=true
	 */
	private String state;
	/**
	 * 显示次序
	 * @autocreate=true
	 */
	private Integer sort;
	/**
	 * 动态参数
	 * @autocreate=true
	 */
	private String params;
	/**
	 * 资源类型，1图片2视频3音频
	 * @autocreate=true
	 */
	private String sourcetype;
	/**
	 * 显示类型，1轮播图2弹屏3轮播图+弹屏
	 * @autocreate=true
	 */
	private String showtype;
	/**
	 * 弹屏图片，关联文件主键
	 * @autocreate=true
	 */
	private String showimg;
	/**
	 * 请求地址
	 * @autocreate=true
	 */
	private String requrl;
	
	/**
	 * 默认构造函数
	 */
	public ManageLunVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public ManageLunVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性轮播图主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getUiid() {
		return uiid;
	}

	/**
	* @Title: setUiid
	* @Description: 设置属性轮播图主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	/**
	* @Title: getPtype 
	* @Description: 获取属性产品编码的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getPtype() {
		return ptype;
	}

	/**
	* @Title: setPtype
	* @Description: 设置属性产品编码的值
	* @param ptype
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	/**
	* @Title: getTitle 
	* @Description: 获取属性轮播图标题的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getTitle() {
		return title;
	}

	/**
	* @Title: setTitle
	* @Description: 设置属性轮播图标题的值
	* @param title
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	* @Title: getShowtitle 
	* @Description: 获取属性显示标题的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getShowtitle() {
		return showtitle;
	}

	/**
	* @Title: setShowtitle
	* @Description: 设置属性显示标题的值
	* @param showtitle
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setShowtitle(String showtitle) {
		this.showtitle = showtitle;
	}
	/**
	* @Title: getImgs 
	* @Description: 获取属性轮播图图片，关联文件主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getImgs() {
		return imgs;
	}

	/**
	* @Title: setImgs
	* @Description: 设置属性轮播图图片，关联文件主键的值
	* @param imgs
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	/**
	* @Title: getVidios 
	* @Description: 获取属性轮播图视频的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getVidios() {
		return vidios;
	}

	/**
	* @Title: setVidios
	* @Description: 设置属性轮播图视频的值
	* @param vidios
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setVidios(String vidios) {
		this.vidios = vidios;
	}
	/**
	* @Title: getUrls 
	* @Description: 获取属性指向地址的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getUrls() {
		return urls;
	}

	/**
	* @Title: setUrls
	* @Description: 设置属性指向地址的值
	* @param urls
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUrls(String urls) {
		this.urls = urls;
	}
	/**
	* @Title: getViewcount 
	* @Description: 获取属性查看次数的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getViewcount() {
		return viewcount;
	}

	/**
	* @Title: setViewcount
	* @Description: 设置属性查看次数的值
	* @param viewcount
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}
	/**
	* @Title: getShowloc 
	* @Description: 获取属性显示栏位 1首页2其他的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getShowloc() {
		return showloc;
	}

	/**
	* @Title: setShowloc
	* @Description: 设置属性显示栏位 1首页2其他的值
	* @param showloc
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setShowloc(String showloc) {
		this.showloc = showloc;
	}
	/**
	* @Title: getState 
	* @Description: 获取属性发布状态，0草稿1发布中2已下架的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getState() {
		return state;
	}

	/**
	* @Title: setState
	* @Description: 设置属性发布状态，0草稿1发布中2已下架的值
	* @param state
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	* @Title: getSort 
	* @Description: 获取属性显示次序的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	* @Title: setSort
	* @Description: 设置属性显示次序的值
	* @param sort
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	* @Title: getParams 
	* @Description: 获取属性动态参数的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getParams() {
		return params;
	}

	/**
	* @Title: setParams
	* @Description: 设置属性动态参数的值
	* @param params
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setParams(String params) {
		this.params = params;
	}
	/**
	* @Title: getSourcetype 
	* @Description: 获取属性资源类型，1图片2视频3音频的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getSourcetype() {
		return sourcetype;
	}

	/**
	* @Title: setSourcetype
	* @Description: 设置属性资源类型，1图片2视频3音频的值
	* @param sourcetype
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	/**
	* @Title: getShowtype 
	* @Description: 获取属性显示类型，1轮播图2弹屏3轮播图+弹屏的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getShowtype() {
		return showtype;
	}

	/**
	* @Title: setShowtype
	* @Description: 设置属性显示类型，1轮播图2弹屏3轮播图+弹屏的值
	* @param showtype
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}
	/**
	* @Title: getShowimg 
	* @Description: 获取属性弹屏图片，关联文件主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getShowimg() {
		return showimg;
	}

	/**
	* @Title: setShowimg
	* @Description: 设置属性弹屏图片，关联文件主键的值
	* @param showimg
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setShowimg(String showimg) {
		this.showimg = showimg;
	}
	/**
	* @Title: getRequrl 
	* @Description: 获取属性请求地址的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getRequrl() {
		return requrl;
	}

	/**
	* @Title: setRequrl
	* @Description: 设置属性请求地址的值
	* @param requrl
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setRequrl(String requrl) {
		this.requrl = requrl;
	}
}