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
 * @ClassName: SoftTaskRuleVO
 * @Description: 步骤查找规则
 * @author 彭羽飞
 */
public class SoftTaskRuleVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_soft_task_rule";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "cstr_uiid";
	
	/**
	 * 规则主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 步骤标题，关联步骤主键
	 * @autocreate=true
	 */
	private String cstsuiid;
	/**
	 * 位置编码
	 * @autocreate=true
	 */
	private String loccode;
	/**
	 * ID等于内容
	 * @autocreate=true
	 */
	private String idcon1;
	/**
	 * ID包含内容
	 * @autocreate=true
	 */
	private String idcon2;
	/**
	 * 标题等于内容
	 * @autocreate=true
	 */
	private String titlecon2;
	/**
	 * 标题包含内容，多个内容通过逗号隔开
	 * @autocreate=true
	 */
	private String titlecon1;
	/**
	 * 描述等于内容
	 * @autocreate=true
	 */
	private String despcon2;
	/**
	 * 描述包含内容，多个内容通过逗号隔开
	 * @autocreate=true
	 */
	private String despcon1;
	/**
	 * 控件类名称
	 * @autocreate=true
	 */
	private String claname;
	/**
	 * 最小层级数，多少层级关系以下控件有效
	 * @autocreate=true
	 */
	private Integer minlevel;
	/**
	 * 最大层级数，多少层级关系以上控件有效
	 * @autocreate=true
	 */
	private Integer maxlevel;
	/**
	 * 循环位置编码
	 * @autocreate=true
	 */
	private String agloccode;
	/**
	 * 循环ID等于
	 * @autocreate=true
	 */
	private String agidcon1;
	/**
	 * 循环ID包含
	 * @autocreate=true
	 */
	private String agidcon2;
	/**
	 * 循环标题等于
	 * @autocreate=true
	 */
	private String agtitle1;
	/**
	 * 循环标题包含
	 * @autocreate=true
	 */
	private String agtitle2;
	/**
	 * 循环描述等于
	 * @autocreate=true
	 */
	private String agdesp1;
	/**
	 * 循环描述包含
	 * @autocreate=true
	 */
	private String agdesp2;
	/**
	 * 循环类名称
	 * @autocreate=true
	 */
	private String agclaname;
	/**
	 * 状态，0草稿1有效2无效
	 * @autocreate=true
	 */
	private String state;
	/**
	 * 相对定位，1是0否，默认0
	 * @autocreate=true
	 */
	private String locrel;
	/**
	 * 显示次序
	 * @autocreate=true
	 */
	private Integer sort;
	
	/**
	 * 默认构造函数
	 */
	public SoftTaskRuleVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public SoftTaskRuleVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性规则主键的值
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
	* @Description: 设置属性规则主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	/**
	* @Title: getCstsuiid 
	* @Description: 获取属性步骤标题，关联步骤主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCstsuiid() {
		return cstsuiid;
	}

	/**
	* @Title: setCstsuiid
	* @Description: 设置属性步骤标题，关联步骤主键的值
	* @param cstsuiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCstsuiid(String cstsuiid) {
		this.cstsuiid = cstsuiid;
	}
	/**
	* @Title: getLoccode 
	* @Description: 获取属性位置编码的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getLoccode() {
		return loccode;
	}

	/**
	* @Title: setLoccode
	* @Description: 设置属性位置编码的值
	* @param loccode
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setLoccode(String loccode) {
		this.loccode = loccode;
	}
	/**
	* @Title: getIdcon1 
	* @Description: 获取属性ID等于内容的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getIdcon1() {
		return idcon1;
	}

	/**
	* @Title: setIdcon1
	* @Description: 设置属性ID等于内容的值
	* @param idcon1
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setIdcon1(String idcon1) {
		this.idcon1 = idcon1;
	}
	/**
	* @Title: getIdcon2 
	* @Description: 获取属性ID包含内容的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getIdcon2() {
		return idcon2;
	}

	/**
	* @Title: setIdcon2
	* @Description: 设置属性ID包含内容的值
	* @param idcon2
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setIdcon2(String idcon2) {
		this.idcon2 = idcon2;
	}
	/**
	* @Title: getTitlecon2 
	* @Description: 获取属性标题等于内容的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getTitlecon2() {
		return titlecon2;
	}

	/**
	* @Title: setTitlecon2
	* @Description: 设置属性标题等于内容的值
	* @param titlecon2
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTitlecon2(String titlecon2) {
		this.titlecon2 = titlecon2;
	}
	/**
	* @Title: getTitlecon1 
	* @Description: 获取属性标题包含内容，多个内容通过逗号隔开的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getTitlecon1() {
		return titlecon1;
	}

	/**
	* @Title: setTitlecon1
	* @Description: 设置属性标题包含内容，多个内容通过逗号隔开的值
	* @param titlecon1
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTitlecon1(String titlecon1) {
		this.titlecon1 = titlecon1;
	}
	/**
	* @Title: getDespcon2 
	* @Description: 获取属性描述等于内容的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getDespcon2() {
		return despcon2;
	}

	/**
	* @Title: setDespcon2
	* @Description: 设置属性描述等于内容的值
	* @param despcon2
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDespcon2(String despcon2) {
		this.despcon2 = despcon2;
	}
	/**
	* @Title: getDespcon1 
	* @Description: 获取属性描述包含内容，多个内容通过逗号隔开的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getDespcon1() {
		return despcon1;
	}

	/**
	* @Title: setDespcon1
	* @Description: 设置属性描述包含内容，多个内容通过逗号隔开的值
	* @param despcon1
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDespcon1(String despcon1) {
		this.despcon1 = despcon1;
	}
	/**
	* @Title: getClaname 
	* @Description: 获取属性控件类名称的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getClaname() {
		return claname;
	}

	/**
	* @Title: setClaname
	* @Description: 设置属性控件类名称的值
	* @param claname
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setClaname(String claname) {
		this.claname = claname;
	}
	/**
	* @Title: getMinlevel 
	* @Description: 获取属性最小层级数，多少层级关系以下控件有效的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getMinlevel() {
		return minlevel;
	}

	/**
	* @Title: setMinlevel
	* @Description: 设置属性最小层级数，多少层级关系以下控件有效的值
	* @param minlevel
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMinlevel(Integer minlevel) {
		this.minlevel = minlevel;
	}
	/**
	* @Title: getMaxlevel 
	* @Description: 获取属性最大层级数，多少层级关系以上控件有效的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getMaxlevel() {
		return maxlevel;
	}

	/**
	* @Title: setMaxlevel
	* @Description: 设置属性最大层级数，多少层级关系以上控件有效的值
	* @param maxlevel
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMaxlevel(Integer maxlevel) {
		this.maxlevel = maxlevel;
	}
	/**
	* @Title: getAgloccode 
	* @Description: 获取属性循环位置编码的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAgloccode() {
		return agloccode;
	}

	/**
	* @Title: setAgloccode
	* @Description: 设置属性循环位置编码的值
	* @param agloccode
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAgloccode(String agloccode) {
		this.agloccode = agloccode;
	}
	/**
	* @Title: getAgidcon1 
	* @Description: 获取属性循环ID等于的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAgidcon1() {
		return agidcon1;
	}

	/**
	* @Title: setAgidcon1
	* @Description: 设置属性循环ID等于的值
	* @param agidcon1
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAgidcon1(String agidcon1) {
		this.agidcon1 = agidcon1;
	}
	/**
	* @Title: getAgidcon2 
	* @Description: 获取属性循环ID包含的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAgidcon2() {
		return agidcon2;
	}

	/**
	* @Title: setAgidcon2
	* @Description: 设置属性循环ID包含的值
	* @param agidcon2
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAgidcon2(String agidcon2) {
		this.agidcon2 = agidcon2;
	}
	/**
	* @Title: getAgtitle1 
	* @Description: 获取属性循环标题等于的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAgtitle1() {
		return agtitle1;
	}

	/**
	* @Title: setAgtitle1
	* @Description: 设置属性循环标题等于的值
	* @param agtitle1
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAgtitle1(String agtitle1) {
		this.agtitle1 = agtitle1;
	}
	/**
	* @Title: getAgtitle2 
	* @Description: 获取属性循环标题包含的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAgtitle2() {
		return agtitle2;
	}

	/**
	* @Title: setAgtitle2
	* @Description: 设置属性循环标题包含的值
	* @param agtitle2
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAgtitle2(String agtitle2) {
		this.agtitle2 = agtitle2;
	}
	/**
	* @Title: getAgdesp1 
	* @Description: 获取属性循环描述等于的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAgdesp1() {
		return agdesp1;
	}

	/**
	* @Title: setAgdesp1
	* @Description: 设置属性循环描述等于的值
	* @param agdesp1
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAgdesp1(String agdesp1) {
		this.agdesp1 = agdesp1;
	}
	/**
	* @Title: getAgdesp2 
	* @Description: 获取属性循环描述包含的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAgdesp2() {
		return agdesp2;
	}

	/**
	* @Title: setAgdesp2
	* @Description: 设置属性循环描述包含的值
	* @param agdesp2
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAgdesp2(String agdesp2) {
		this.agdesp2 = agdesp2;
	}
	/**
	* @Title: getAgclaname 
	* @Description: 获取属性循环类名称的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAgclaname() {
		return agclaname;
	}

	/**
	* @Title: setAgclaname
	* @Description: 设置属性循环类名称的值
	* @param agclaname
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAgclaname(String agclaname) {
		this.agclaname = agclaname;
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
	* @Title: getLocrel 
	* @Description: 获取属性相对定位，1是0否，默认0的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getLocrel() {
		return locrel;
	}

	/**
	* @Title: setLocrel
	* @Description: 设置属性相对定位，1是0否，默认0的值
	* @param locrel
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setLocrel(String locrel) {
		this.locrel = locrel;
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