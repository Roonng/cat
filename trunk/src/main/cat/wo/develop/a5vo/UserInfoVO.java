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
 * @ClassName: UserInfoVO
 * @Description: 用户信息管理
 * @author 彭羽飞
 */
public class UserInfoVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_user_info";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "cui_uiid";
	
	/**
	 * 用户主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 推荐人名称，关联用户主键
	 * @autocreate=true
	 */
	private String recomid;
	/**
	 * 用户名称
	 * @autocreate=true
	 */
	private String name;
	/**
	 * 用户电话
	 * @autocreate=true
	 */
	private String mobile;
	/**
	 * 用户设备号
	 * @autocreate=true
	 */
	private String deviceid;
	/**
	 * 用户密码
	 * @autocreate=true
	 */
	private String pass;
	/**
	 * 注册时间
	 * @autocreate=true
	 */
	private java.util.Date starttime;
	/**
	 * 调试权限，1拥有0无权限
	 * @autocreate=true
	 */
	private String debugrole;
	/**
	 * 自动化权限，1拥有0无权限
	 * @autocreate=true
	 */
	private String autorole;
	/**
	 * 用户角色编码
	 * @autocreate=true
	 */
	private String menurole;
	/**
	 * 支付系统账户号
	 * @autocreate=true
	 */
	private String payaccountno;
	
	/**
	 * 默认构造函数
	 */
	public UserInfoVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public UserInfoVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性用户主键的值
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
	* @Description: 设置属性用户主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	/**
	* @Title: getRecomid 
	* @Description: 获取属性推荐人名称，关联用户主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getRecomid() {
		return recomid;
	}

	/**
	* @Title: setRecomid
	* @Description: 设置属性推荐人名称，关联用户主键的值
	* @param recomid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setRecomid(String recomid) {
		this.recomid = recomid;
	}
	/**
	* @Title: getName 
	* @Description: 获取属性用户名称的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getName() {
		return name;
	}

	/**
	* @Title: setName
	* @Description: 设置属性用户名称的值
	* @param name
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	* @Title: getMobile 
	* @Description: 获取属性用户电话的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	* @Title: setMobile
	* @Description: 设置属性用户电话的值
	* @param mobile
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	* @Title: getDeviceid 
	* @Description: 获取属性用户设备号的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getDeviceid() {
		return deviceid;
	}

	/**
	* @Title: setDeviceid
	* @Description: 设置属性用户设备号的值
	* @param deviceid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	/**
	* @Title: getPass 
	* @Description: 获取属性用户密码的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getPass() {
		return pass;
	}

	/**
	* @Title: setPass
	* @Description: 设置属性用户密码的值
	* @param pass
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	* @Title: getStarttime 
	* @Description: 获取属性注册时间的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public java.util.Date getStarttime() {
		return starttime;
	}

	/**
	* @Title: setStarttime
	* @Description: 设置属性注册时间的值
	* @param starttime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}
	/**
	* @Title: getDebugrole 
	* @Description: 获取属性调试权限，1拥有0无权限的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getDebugrole() {
		return debugrole;
	}

	/**
	* @Title: setDebugrole
	* @Description: 设置属性调试权限，1拥有0无权限的值
	* @param debugrole
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDebugrole(String debugrole) {
		this.debugrole = debugrole;
	}
	/**
	* @Title: getAutorole 
	* @Description: 获取属性自动化权限，1拥有0无权限的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAutorole() {
		return autorole;
	}

	/**
	* @Title: setAutorole
	* @Description: 设置属性自动化权限，1拥有0无权限的值
	* @param autorole
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAutorole(String autorole) {
		this.autorole = autorole;
	}
	/**
	* @Title: getMenurole 
	* @Description: 获取属性用户角色编码的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getMenurole() {
		return menurole;
	}

	/**
	* @Title: setMenurole
	* @Description: 设置属性用户角色编码的值
	* @param menurole
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMenurole(String menurole) {
		this.menurole = menurole;
	}
	/**
	* @Title: getPayaccountno 
	* @Description: 获取属性支付系统账户号的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getPayaccountno() {
		return payaccountno;
	}

	/**
	* @Title: setPayaccountno
	* @Description: 设置属性支付系统账户号的值
	* @param payaccountno
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPayaccountno(String payaccountno) {
		this.payaccountno = payaccountno;
	}
}