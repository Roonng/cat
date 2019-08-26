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
 * @ClassName: TaskRunLogVO
 * @Description: 任务执行记录
 * @author 彭羽飞
 */
public class TaskRunLogVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_task_run_log";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "ctrl_uiid";
	
	/**
	 * 任务记录主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 用户名称，关联用户主键
	 * @autocreate=true
	 */
	private String cuiuiid;
	/**
	 * 主题名称，关联主题主键
	 * @autocreate=true
	 */
	private String catuiid;
	/**
	 * 执行开始时间
	 * @autocreate=true
	 */
	private java.util.Date starttime;
	/**
	 * 执行结束时间
	 * @autocreate=true
	 */
	private java.util.Date endtime;
	/**
	 * 执行数量
	 * @autocreate=true
	 */
	private Integer destnum;
	/**
	 * 成功状态，1成功0失败
	 * @autocreate=true
	 */
	private String state;
	/**
	 * 执行耗时
	 * @autocreate=true
	 */
	private Integer runtime;
	/**
	 * 失败原因
	 * @autocreate=true
	 */
	private String reason;
	/**
	 * 内部错误
	 * @autocreate=true
	 */
	private String errormsg;
	
	/**
	 * 默认构造函数
	 */
	public TaskRunLogVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public TaskRunLogVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性任务记录主键的值
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
	* @Description: 设置属性任务记录主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	/**
	* @Title: getCuiuiid 
	* @Description: 获取属性用户名称，关联用户主键的值
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
	* @Description: 设置属性用户名称，关联用户主键的值
	* @param cuiuiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCuiuiid(String cuiuiid) {
		this.cuiuiid = cuiuiid;
	}
	/**
	* @Title: getCatuiid 
	* @Description: 获取属性主题名称，关联主题主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCatuiid() {
		return catuiid;
	}

	/**
	* @Title: setCatuiid
	* @Description: 设置属性主题名称，关联主题主键的值
	* @param catuiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCatuiid(String catuiid) {
		this.catuiid = catuiid;
	}
	/**
	* @Title: getStarttime 
	* @Description: 获取属性执行开始时间的值
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
	* @Description: 设置属性执行开始时间的值
	* @param starttime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}
	/**
	* @Title: getEndtime 
	* @Description: 获取属性执行结束时间的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public java.util.Date getEndtime() {
		return endtime;
	}

	/**
	* @Title: setEndtime
	* @Description: 设置属性执行结束时间的值
	* @param endtime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}
	/**
	* @Title: getDestnum 
	* @Description: 获取属性执行数量的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getDestnum() {
		return destnum;
	}

	/**
	* @Title: setDestnum
	* @Description: 设置属性执行数量的值
	* @param destnum
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDestnum(Integer destnum) {
		this.destnum = destnum;
	}
	/**
	* @Title: getState 
	* @Description: 获取属性成功状态，1成功0失败的值
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
	* @Description: 设置属性成功状态，1成功0失败的值
	* @param state
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	* @Title: getRuntime 
	* @Description: 获取属性执行耗时的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getRuntime() {
		return runtime;
	}

	/**
	* @Title: setRuntime
	* @Description: 设置属性执行耗时的值
	* @param runtime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	/**
	* @Title: getReason 
	* @Description: 获取属性失败原因的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getReason() {
		return reason;
	}

	/**
	* @Title: setReason
	* @Description: 设置属性失败原因的值
	* @param reason
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	* @Title: getErrormsg 
	* @Description: 获取属性内部错误的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getErrormsg() {
		return errormsg;
	}

	/**
	* @Title: setErrormsg
	* @Description: 设置属性内部错误的值
	* @param errormsg
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
}