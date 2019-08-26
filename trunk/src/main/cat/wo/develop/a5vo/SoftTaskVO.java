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
 * @ClassName: SoftTaskVO
 * @Description: 软件业务管理
 * @author 彭羽飞
 */
public class SoftTaskVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_soft_task";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "cst_uiid";
	
	/**
	 * 软件业务主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 软件名称，关联软件主键
	 * @autocreate=true
	 */
	private String csiuiid;
	/**
	 * 业务名称
	 * @autocreate=true
	 */
	private String title;
	/**
	 * 业务编码
	 * @autocreate=true
	 */
	private String code;
	/**
	 * 业务描述
	 * @autocreate=true
	 */
	private String desp;
	/**
	 * 支持版本信息，多个之间逗号分隔
	 * @autocreate=true
	 */
	private String versionstr;
	/**
	 * 最大版本号
	 * @autocreate=true
	 */
	private Integer minversion;
	/**
	 * 最小版本号
	 * @autocreate=true
	 */
	private Integer maxversion;
	/**
	 * 显示次序
	 * @autocreate=true
	 */
	private Integer sort;
	
	/**
	 * 默认构造函数
	 */
	public SoftTaskVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public SoftTaskVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性软件业务主键的值
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
	* @Description: 设置属性软件业务主键的值
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
	* @Title: getTitle 
	* @Description: 获取属性业务名称的值
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
	* @Description: 设置属性业务名称的值
	* @param title
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	* @Title: getCode 
	* @Description: 获取属性业务编码的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCode() {
		return code;
	}

	/**
	* @Title: setCode
	* @Description: 设置属性业务编码的值
	* @param code
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	* @Title: getDesp 
	* @Description: 获取属性业务描述的值
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
	* @Description: 设置属性业务描述的值
	* @param desp
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDesp(String desp) {
		this.desp = desp;
	}
	/**
	* @Title: getVersionstr 
	* @Description: 获取属性支持版本信息，多个之间逗号分隔的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getVersionstr() {
		return versionstr;
	}

	/**
	* @Title: setVersionstr
	* @Description: 设置属性支持版本信息，多个之间逗号分隔的值
	* @param versionstr
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setVersionstr(String versionstr) {
		this.versionstr = versionstr;
	}
	/**
	* @Title: getMinversion 
	* @Description: 获取属性最大版本号的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getMinversion() {
		return minversion;
	}

	/**
	* @Title: setMinversion
	* @Description: 设置属性最大版本号的值
	* @param minversion
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMinversion(Integer minversion) {
		this.minversion = minversion;
	}
	/**
	* @Title: getMaxversion 
	* @Description: 获取属性最小版本号的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getMaxversion() {
		return maxversion;
	}

	/**
	* @Title: setMaxversion
	* @Description: 设置属性最小版本号的值
	* @param maxversion
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMaxversion(Integer maxversion) {
		this.maxversion = maxversion;
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
}