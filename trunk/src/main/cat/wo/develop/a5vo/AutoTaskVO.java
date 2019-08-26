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
 * @ClassName: AutoTaskVO
 * @Description: 业务主题设置
 * @author 彭羽飞
 */
public class AutoTaskVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "com_auto_task";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "cat_uiid";
	
	/**
	 * 业务主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 产品编码
	 * @autocreate=true
	 */
	private String ptype;
	/**
	 * 软件名称，关联软件主键
	 * @autocreate=true
	 */
	private String csiuiid;
	/**
	 * 业务名称，关联软件业务主键
	 * @autocreate=true
	 */
	private String cstuiid;
	/**
	 * 业务标题
	 * @autocreate=true
	 */
	private String title;
	/**
	 * 显示标题
	 * @autocreate=true
	 */
	private String showtitle;
	/**
	 * 业务说明
	 * @autocreate=true
	 */
	private String desp;
	/**
	 * 联动账号设置，多个之间通过英文半角逗号分隔
	 * @autocreate=true
	 */
	private String conaccount;
	/**
	 * 最多操作数
	 * @autocreate=true
	 */
	private Integer maxcount;
	/**
	 * 离线缓存回复信息，1缓存0不缓存，默认0
	 * @autocreate=true
	 */
	private String ifcache;
	/**
	 * 扩展参数信息，JSON格式配置需要的参数
	 * @autocreate=true
	 */
	private String extparam;
	/**
	 * 市场价
	 * @autocreate=true
	 */
	private Double marprice;
	/**
	 * 活动价
	 * @autocreate=true
	 */
	private Double actprice;
	/**
	 * 状态，0草稿1有效2无效
	 * @autocreate=true
	 */
	private String state;
	/**
	 * 客户群体
	 * @autocreate=true
	 */
	private String targetuser;
	/**
	 * 显示次序
	 * @autocreate=true
	 */
	private Integer sort;
	/**
	 * 业务价值
	 * @autocreate=true
	 */
	private String taskvalue;
	/**
	 * 活动说明
	 * @autocreate=true
	 */
	private String mardesp;
	
	/**
	 * 默认构造函数
	 */
	public AutoTaskVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public AutoTaskVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性业务主键的值
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
	* @Description: 设置属性业务主键的值
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
	* @Title: getCsiuiid 
	* @Description: 获取属性软件名称，关联软件主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCsiuiid() {
		return csiuiid;
	}

	/**
	* @Title: setCsiuiid
	* @Description: 设置属性软件名称，关联软件主键的值
	* @param csiuiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCsiuiid(String csiuiid) {
		this.csiuiid = csiuiid;
	}
	/**
	* @Title: getCstuiid 
	* @Description: 获取属性业务名称，关联软件业务主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCstuiid() {
		return cstuiid;
	}

	/**
	* @Title: setCstuiid
	* @Description: 设置属性业务名称，关联软件业务主键的值
	* @param cstuiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCstuiid(String cstuiid) {
		this.cstuiid = cstuiid;
	}
	/**
	* @Title: getTitle 
	* @Description: 获取属性业务标题的值
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
	* @Description: 设置属性业务标题的值
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
	* @Title: getDesp 
	* @Description: 获取属性业务说明的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getDesp() {
		return desp;
	}

	/**
	* @Title: setDesp
	* @Description: 设置属性业务说明的值
	* @param desp
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDesp(String desp) {
		this.desp = desp;
	}
	/**
	* @Title: getConaccount 
	* @Description: 获取属性联动账号设置，多个之间通过英文半角逗号分隔的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getConaccount() {
		return conaccount;
	}

	/**
	* @Title: setConaccount
	* @Description: 设置属性联动账号设置，多个之间通过英文半角逗号分隔的值
	* @param conaccount
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setConaccount(String conaccount) {
		this.conaccount = conaccount;
	}
	/**
	* @Title: getMaxcount 
	* @Description: 获取属性最多操作数的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getMaxcount() {
		return maxcount;
	}

	/**
	* @Title: setMaxcount
	* @Description: 设置属性最多操作数的值
	* @param maxcount
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMaxcount(Integer maxcount) {
		this.maxcount = maxcount;
	}
	/**
	* @Title: getIfcache 
	* @Description: 获取属性离线缓存回复信息，1缓存0不缓存，默认0的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getIfcache() {
		return ifcache;
	}

	/**
	* @Title: setIfcache
	* @Description: 设置属性离线缓存回复信息，1缓存0不缓存，默认0的值
	* @param ifcache
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setIfcache(String ifcache) {
		this.ifcache = ifcache;
	}
	/**
	* @Title: getExtparam 
	* @Description: 获取属性扩展参数信息，JSON格式配置需要的参数的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getExtparam() {
		return extparam;
	}

	/**
	* @Title: setExtparam
	* @Description: 设置属性扩展参数信息，JSON格式配置需要的参数的值
	* @param extparam
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setExtparam(String extparam) {
		this.extparam = extparam;
	}
	/**
	* @Title: getMarprice 
	* @Description: 获取属性市场价的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Double getMarprice() {
		return marprice;
	}

	/**
	* @Title: setMarprice
	* @Description: 设置属性市场价的值
	* @param marprice
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMarprice(Double marprice) {
		this.marprice = marprice;
	}
	/**
	* @Title: getActprice 
	* @Description: 获取属性活动价的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Double getActprice() {
		return actprice;
	}

	/**
	* @Title: setActprice
	* @Description: 设置属性活动价的值
	* @param actprice
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setActprice(Double actprice) {
		this.actprice = actprice;
	}
	/**
	* @Title: getState 
	* @Description: 获取属性状态，0草稿1有效2无效的值
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
	* @Description: 设置属性状态，0草稿1有效2无效的值
	* @param state
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	* @Title: getTargetuser 
	* @Description: 获取属性客户群体的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getTargetuser() {
		return targetuser;
	}

	/**
	* @Title: setTargetuser
	* @Description: 设置属性客户群体的值
	* @param targetuser
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTargetuser(String targetuser) {
		this.targetuser = targetuser;
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
	* @Title: getTaskvalue 
	* @Description: 获取属性业务价值的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getTaskvalue() {
		return taskvalue;
	}

	/**
	* @Title: setTaskvalue
	* @Description: 设置属性业务价值的值
	* @param taskvalue
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTaskvalue(String taskvalue) {
		this.taskvalue = taskvalue;
	}
	/**
	* @Title: getMardesp 
	* @Description: 获取属性活动说明的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getMardesp() {
		return mardesp;
	}

	/**
	* @Title: setMardesp
	* @Description: 设置属性活动说明的值
	* @param mardesp
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMardesp(String mardesp) {
		this.mardesp = mardesp;
	}
}