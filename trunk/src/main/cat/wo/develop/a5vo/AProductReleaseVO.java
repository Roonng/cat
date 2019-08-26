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
 * @ClassName: AProductReleaseVO
 * @Description: 产品发布管理
 * @author 彭羽飞
 */
public class AProductReleaseVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "com_a_product_release";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "capr_uiid";
	
	/**
	 * 产品主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 产品名称，关联产品主键
	 * @autocreate=true
	 */
	private String capuiid;
	/**
	 * 发布人，关联用户主键
	 * @autocreate=true
	 */
	private String cuiuiid;
	/**
	 * 发布时间
	 * @autocreate=true
	 */
	private java.util.Date releasetime;
	/**
	 * 发布状态，1已发布0待发布
	 * @autocreate=true
	 */
	private String state;
	/**
	 * 生效时间
	 * @autocreate=true
	 */
	private java.util.Date activitytime;
	/**
	 * 安装包
	 * @autocreate=true
	 */
	private String downurl;
	/**
	 * 版本号，数字
	 * @autocreate=true
	 */
	private Integer ver;
	/**
	 * 版本号，字符串
	 * @autocreate=true
	 */
	private String version;
	/**
	 * 类别，1生成包0测试包
	 * @autocreate=true
	 */
	private String ptype;
	
	/**
	 * 默认构造函数
	 */
	public AProductReleaseVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public AProductReleaseVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性产品主键的值
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
	* @Description: 设置属性产品主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	/**
	* @Title: getCapuiid 
	* @Description: 获取属性产品名称，关联产品主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCapuiid() {
		return capuiid;
	}

	/**
	* @Title: setCapuiid
	* @Description: 设置属性产品名称，关联产品主键的值
	* @param capuiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCapuiid(String capuiid) {
		this.capuiid = capuiid;
	}
	/**
	* @Title: getCuiuiid 
	* @Description: 获取属性发布人，关联用户主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCuiuiid() {
		return cuiuiid;
	}

	/**
	* @Title: setCuiuiid
	* @Description: 设置属性发布人，关联用户主键的值
	* @param cuiuiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCuiuiid(String cuiuiid) {
		this.cuiuiid = cuiuiid;
	}
	/**
	* @Title: getReleasetime 
	* @Description: 获取属性发布时间的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public java.util.Date getReleasetime() {
		return releasetime;
	}

	/**
	* @Title: setReleasetime
	* @Description: 设置属性发布时间的值
	* @param releasetime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setReleasetime(java.util.Date releasetime) {
		this.releasetime = releasetime;
	}
	/**
	* @Title: getState 
	* @Description: 获取属性发布状态，1已发布0待发布的值
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
	* @Description: 设置属性发布状态，1已发布0待发布的值
	* @param state
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	* @Title: getActivitytime 
	* @Description: 获取属性生效时间的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public java.util.Date getActivitytime() {
		return activitytime;
	}

	/**
	* @Title: setActivitytime
	* @Description: 设置属性生效时间的值
	* @param activitytime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setActivitytime(java.util.Date activitytime) {
		this.activitytime = activitytime;
	}
	/**
	* @Title: getDownurl 
	* @Description: 获取属性安装包的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getDownurl() {
		return downurl;
	}

	/**
	* @Title: setDownurl
	* @Description: 设置属性安装包的值
	* @param downurl
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDownurl(String downurl) {
		this.downurl = downurl;
	}
	/**
	* @Title: getVer 
	* @Description: 获取属性版本号，数字的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getVer() {
		return ver;
	}

	/**
	* @Title: setVer
	* @Description: 设置属性版本号，数字的值
	* @param ver
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setVer(Integer ver) {
		this.ver = ver;
	}
	/**
	* @Title: getVersion 
	* @Description: 获取属性版本号，字符串的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getVersion() {
		return version;
	}

	/**
	* @Title: setVersion
	* @Description: 设置属性版本号，字符串的值
	* @param version
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	* @Title: getPtype 
	* @Description: 获取属性类别，1生成包0测试包的值
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
	* @Description: 设置属性类别，1生成包0测试包的值
	* @param ptype
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
}