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
 * @ClassName: SoftInfoVO
 * @Description: 软件管理
 * @author 彭羽飞
 */
public class SoftInfoVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_soft_info";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "csi_uiid";
	
	/**
	 * 软件主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 软件名称
	 * @autocreate=true
	 */
	private String title;
	/**
	 * 软件包名称
	 * @autocreate=true
	 */
	private String pacname;
	/**
	 * 软件启动类名称
	 * @autocreate=true
	 */
	private String flashcla;
	/**
	 * 软件首页类名称
	 * @autocreate=true
	 */
	private String indexcla;
	/**
	 * 显示次序
	 * @autocreate=true
	 */
	private Integer sort;
	/**
	 * 状态，0草稿1有效2无效
	 * @autocreate=true
	 */
	private String state;
	/**
	 * 备注信息
	 * @autocreate=true
	 */
	private String remark;
	
	/**
	 * 默认构造函数
	 */
	public SoftInfoVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public SoftInfoVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性软件主键的值
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
	* @Description: 设置属性软件主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	/**
	* @Title: getTitle 
	* @Description: 获取属性软件名称的值
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
	* @Description: 设置属性软件名称的值
	* @param title
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	* @Title: getPacname 
	* @Description: 获取属性软件包名称的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getPacname() {
		return pacname;
	}

	/**
	* @Title: setPacname
	* @Description: 设置属性软件包名称的值
	* @param pacname
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPacname(String pacname) {
		this.pacname = pacname;
	}
	/**
	* @Title: getFlashcla 
	* @Description: 获取属性软件启动类名称的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getFlashcla() {
		return flashcla;
	}

	/**
	* @Title: setFlashcla
	* @Description: 设置属性软件启动类名称的值
	* @param flashcla
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setFlashcla(String flashcla) {
		this.flashcla = flashcla;
	}
	/**
	* @Title: getIndexcla 
	* @Description: 获取属性软件首页类名称的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getIndexcla() {
		return indexcla;
	}

	/**
	* @Title: setIndexcla
	* @Description: 设置属性软件首页类名称的值
	* @param indexcla
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setIndexcla(String indexcla) {
		this.indexcla = indexcla;
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