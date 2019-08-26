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
 * @ClassName: DeviceInfoVO
 * @Description: 设备信息管理
 * @author 彭羽飞
 */
public class DeviceInfoVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_device_info";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "cdi_uiid";
	
	/**
	 * 设备识别码
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 设备型号
	 * @autocreate=true
	 */
	private String spec;
	/**
	 * 设备标题
	 * @autocreate=true
	 */
	private String title;
	/**
	 * 设备说明
	 * @autocreate=true
	 */
	private String desp;
	/**
	 * 在线状态，1在线0离线
	 * @autocreate=true
	 */
	private String onlinesta;
	/**
	 * 工作开始时间
	 * @autocreate=true
	 */
	private java.util.Date starttime;
	/**
	 * 工作结束时间
	 * @autocreate=true
	 */
	private java.util.Date endtime;
	
	/**
	 * 默认构造函数
	 */
	public DeviceInfoVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public DeviceInfoVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性设备识别码的值
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
	* @Description: 设置属性设备识别码的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	/**
	* @Title: getSpec 
	* @Description: 获取属性设备型号的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getSpec() {
		return spec;
	}

	/**
	* @Title: setSpec
	* @Description: 设置属性设备型号的值
	* @param spec
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}
	/**
	* @Title: getTitle 
	* @Description: 获取属性设备标题的值
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
	* @Description: 设置属性设备标题的值
	* @param title
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	* @Title: getDesp 
	* @Description: 获取属性设备说明的值
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
	* @Description: 设置属性设备说明的值
	* @param desp
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDesp(String desp) {
		this.desp = desp;
	}
	/**
	* @Title: getOnlinesta 
	* @Description: 获取属性在线状态，1在线0离线的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getOnlinesta() {
		return onlinesta;
	}

	/**
	* @Title: setOnlinesta
	* @Description: 设置属性在线状态，1在线0离线的值
	* @param onlinesta
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setOnlinesta(String onlinesta) {
		this.onlinesta = onlinesta;
	}
	/**
	* @Title: getStarttime 
	* @Description: 获取属性工作开始时间的值
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
	* @Description: 设置属性工作开始时间的值
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
	* @Description: 获取属性工作结束时间的值
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
	* @Description: 设置属性工作结束时间的值
	* @param endtime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}
}