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
 * @ClassName: DeviceRefAutoVO
 * @Description: 设备任务安排管理
 * @author 彭羽飞
 */
public class DeviceRefAutoVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_device_ref_auto";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "cdra_uiid";
	
	/**
	 * 设备任务主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 设备名称，关联设备主键
	 * @autocreate=true
	 */
	private String cdiuiid;
	/**
	 * 自动化业务，关联自动化业务主键
	 * @autocreate=true
	 */
	private String catuiid;
	/**
	 * 启动时间
	 * @autocreate=true
	 */
	private java.util.Date starttime;
	/**
	 * 终止时间
	 * @autocreate=true
	 */
	private java.util.Date endtime;
	/**
	 * 执行间隔，单位秒
	 * @autocreate=true
	 */
	private Integer timelength;
	/**
	 * 最多操作次数
	 * @autocreate=true
	 */
	private Integer maxcount;
	
	/**
	 * 默认构造函数
	 */
	public DeviceRefAutoVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public DeviceRefAutoVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性设备任务主键的值
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
	* @Description: 设置属性设备任务主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	/**
	* @Title: getCdiuiid 
	* @Description: 获取属性设备名称，关联设备主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCdiuiid() {
		return cdiuiid;
	}

	/**
	* @Title: setCdiuiid
	* @Description: 设置属性设备名称，关联设备主键的值
	* @param cdiuiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCdiuiid(String cdiuiid) {
		this.cdiuiid = cdiuiid;
	}
	/**
	* @Title: getCatuiid 
	* @Description: 获取属性自动化业务，关联自动化业务主键的值
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
	* @Description: 设置属性自动化业务，关联自动化业务主键的值
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
	* @Description: 获取属性启动时间的值
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
	* @Description: 设置属性启动时间的值
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
	* @Description: 获取属性终止时间的值
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
	* @Description: 设置属性终止时间的值
	* @param endtime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}
	/**
	* @Title: getTimelength 
	* @Description: 获取属性执行间隔，单位秒的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getTimelength() {
		return timelength;
	}

	/**
	* @Title: setTimelength
	* @Description: 设置属性执行间隔，单位秒的值
	* @param timelength
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTimelength(Integer timelength) {
		this.timelength = timelength;
	}
	/**
	* @Title: getMaxcount 
	* @Description: 获取属性最多操作次数的值
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
	* @Description: 设置属性最多操作次数的值
	* @param maxcount
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMaxcount(Integer maxcount) {
		this.maxcount = maxcount;
	}
}