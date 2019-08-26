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
 * @ClassName: SoftAccountVO
 * @Description: 登录帐号信息
 * @author 彭羽飞
 */
public class SoftAccountVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_soft_account";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "csa_uiid";
	
	/**
	 * 帐号主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 软件名称，关联软件主键
	 * @autocreate=true
	 */
	private String csiuiid;
	/**
	 * 帐号名称
	 * @autocreate=true
	 */
	private String accountname;
	/**
	 * 帐号密码
	 * @autocreate=true
	 */
	private String pass;
	/**
	 * 密保信息
	 * @autocreate=true
	 */
	private String passinfo;
	/**
	 * 安全信息
	 * @autocreate=true
	 */
	private String safeinfo;
	/**
	 * 备注信息
	 * @autocreate=true
	 */
	private String remark;
	
	/**
	 * 默认构造函数
	 */
	public SoftAccountVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public SoftAccountVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性帐号主键的值
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
	* @Description: 设置属性帐号主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
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
	* @Title: getAccountname 
	* @Description: 获取属性帐号名称的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAccountname() {
		return accountname;
	}

	/**
	* @Title: setAccountname
	* @Description: 设置属性帐号名称的值
	* @param accountname
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	/**
	* @Title: getPass 
	* @Description: 获取属性帐号密码的值
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
	* @Description: 设置属性帐号密码的值
	* @param pass
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	* @Title: getPassinfo 
	* @Description: 获取属性密保信息的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getPassinfo() {
		return passinfo;
	}

	/**
	* @Title: setPassinfo
	* @Description: 设置属性密保信息的值
	* @param passinfo
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPassinfo(String passinfo) {
		this.passinfo = passinfo;
	}
	/**
	* @Title: getSafeinfo 
	* @Description: 获取属性安全信息的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getSafeinfo() {
		return safeinfo;
	}

	/**
	* @Title: setSafeinfo
	* @Description: 设置属性安全信息的值
	* @param safeinfo
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setSafeinfo(String safeinfo) {
		this.safeinfo = safeinfo;
	}
	/**
	* @Title: getRemark 
	* @Description: 获取属性备注信息的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getRemark() {
		return remark;
	}

	/**
	* @Title: setRemark
	* @Description: 设置属性备注信息的值
	* @param remark
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}