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
 * @ClassName: AutoAnswerLogVO
 * @Description: 帖子回复日志信息
 * @author 彭羽飞
 */
public class AutoAnswerLogVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "com_auto_answer_log";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "caal_uiid";
	
	/**
	 * 帖子信息主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 主题名称，关联主题主键
	 * @autocreate=true
	 */
	private String catuiid;
	/**
	 * 用户名称，关联用户主键
	 * @autocreate=true
	 */
	private String cuiuiid;
	/**
	 * 帖子内容
	 * @autocreate=true
	 */
	private String content;
	/**
	 * 帖子回复内容
	 * @autocreate=true
	 */
	private String answer;
	/**
	 * 采集时间
	 * @autocreate=true
	 */
	private java.util.Date addtime;
	/**
	 * 用户名称
	 * @autocreate=true
	 */
	private String username;
	/**
	 * 帖子类型，0未设置1求职2找人3其他
	 * @autocreate=true
	 */
	private String ctype;
	/**
	 * 分析结果，0不符合1符合
	 * @autocreate=true
	 */
	private String ifok;
	/**
	 * 内部主题学习，0未学习1已学习
	 * @autocreate=true
	 */
	private String ifstand;
	/**
	 * 分类信息1
	 * @autocreate=true
	 */
	private String exttype1;
	/**
	 * 分类信息2
	 * @autocreate=true
	 */
	private String exttype2;
	/**
	 * 分类信息3
	 * @autocreate=true
	 */
	private String exttype3;
	/**
	 * 内部主题设置，关联主题主键
	 * @autocreate=true
	 */
	private String catuiid2;
	/**
	 * 扩展数据1
	 * @autocreate=true
	 */
	private String extvalue1;
	/**
	 * 扩展数据2
	 * @autocreate=true
	 */
	private String extvalue2;
	/**
	 * 扩展数据3
	 * @autocreate=true
	 */
	private String extvalue3;
	
	/**
	 * 默认构造函数
	 */
	public AutoAnswerLogVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public AutoAnswerLogVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性帖子信息主键的值
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
	* @Description: 设置属性帖子信息主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
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
	* @Title: getContent 
	* @Description: 获取属性帖子内容的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getContent() {
		return content;
	}

	/**
	* @Title: setContent
	* @Description: 设置属性帖子内容的值
	* @param content
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	* @Title: getAnswer 
	* @Description: 获取属性帖子回复内容的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	* @Title: setAnswer
	* @Description: 设置属性帖子回复内容的值
	* @param answer
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	* @Title: getAddtime 
	* @Description: 获取属性采集时间的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public java.util.Date getAddtime() {
		return addtime;
	}

	/**
	* @Title: setAddtime
	* @Description: 设置属性采集时间的值
	* @param addtime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAddtime(java.util.Date addtime) {
		this.addtime = addtime;
	}
	/**
	* @Title: getUsername 
	* @Description: 获取属性用户名称的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getUsername() {
		return username;
	}

	/**
	* @Title: setUsername
	* @Description: 设置属性用户名称的值
	* @param username
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	* @Title: getCtype 
	* @Description: 获取属性帖子类型，0未设置1求职2找人3其他的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCtype() {
		return ctype;
	}

	/**
	* @Title: setCtype
	* @Description: 设置属性帖子类型，0未设置1求职2找人3其他的值
	* @param ctype
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	/**
	* @Title: getIfok 
	* @Description: 获取属性分析结果，0不符合1符合的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getIfok() {
		return ifok;
	}

	/**
	* @Title: setIfok
	* @Description: 设置属性分析结果，0不符合1符合的值
	* @param ifok
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setIfok(String ifok) {
		this.ifok = ifok;
	}
	/**
	* @Title: getIfstand 
	* @Description: 获取属性内部主题学习，0未学习1已学习的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getIfstand() {
		return ifstand;
	}

	/**
	* @Title: setIfstand
	* @Description: 设置属性内部主题学习，0未学习1已学习的值
	* @param ifstand
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setIfstand(String ifstand) {
		this.ifstand = ifstand;
	}
	/**
	* @Title: getExttype1 
	* @Description: 获取属性分类信息1的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getExttype1() {
		return exttype1;
	}

	/**
	* @Title: setExttype1
	* @Description: 设置属性分类信息1的值
	* @param exttype1
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setExttype1(String exttype1) {
		this.exttype1 = exttype1;
	}
	/**
	* @Title: getExttype2 
	* @Description: 获取属性分类信息2的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getExttype2() {
		return exttype2;
	}

	/**
	* @Title: setExttype2
	* @Description: 设置属性分类信息2的值
	* @param exttype2
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setExttype2(String exttype2) {
		this.exttype2 = exttype2;
	}
	/**
	* @Title: getExttype3 
	* @Description: 获取属性分类信息3的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getExttype3() {
		return exttype3;
	}

	/**
	* @Title: setExttype3
	* @Description: 设置属性分类信息3的值
	* @param exttype3
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setExttype3(String exttype3) {
		this.exttype3 = exttype3;
	}
	/**
	* @Title: getCatuiid2 
	* @Description: 获取属性内部主题设置，关联主题主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCatuiid2() {
		return catuiid2;
	}

	/**
	* @Title: setCatuiid2
	* @Description: 设置属性内部主题设置，关联主题主键的值
	* @param catuiid2
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCatuiid2(String catuiid2) {
		this.catuiid2 = catuiid2;
	}
	/**
	* @Title: getExtvalue1 
	* @Description: 获取属性扩展数据1的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getExtvalue1() {
		return extvalue1;
	}

	/**
	* @Title: setExtvalue1
	* @Description: 设置属性扩展数据1的值
	* @param extvalue1
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setExtvalue1(String extvalue1) {
		this.extvalue1 = extvalue1;
	}
	/**
	* @Title: getExtvalue2 
	* @Description: 获取属性扩展数据2的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getExtvalue2() {
		return extvalue2;
	}

	/**
	* @Title: setExtvalue2
	* @Description: 设置属性扩展数据2的值
	* @param extvalue2
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setExtvalue2(String extvalue2) {
		this.extvalue2 = extvalue2;
	}
	/**
	* @Title: getExtvalue3 
	* @Description: 获取属性扩展数据3的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getExtvalue3() {
		return extvalue3;
	}

	/**
	* @Title: setExtvalue3
	* @Description: 设置属性扩展数据3的值
	* @param extvalue3
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setExtvalue3(String extvalue3) {
		this.extvalue3 = extvalue3;
	}
}