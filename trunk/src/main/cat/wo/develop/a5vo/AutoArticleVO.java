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
 * @ClassName: AutoArticleVO
 * @Description: 发帖数据
 * @author 彭羽飞
 */
public class AutoArticleVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_auto_article";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "caa_uiid";
	
	/**
	 * 发帖数据主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 软件名称，关联软件主键
	 * @autocreate=true
	 */
	private String csiuiid;
	/**
	 * 主题名称，关联主题主键
	 * @autocreate=true
	 */
	private String catuiid;
	/**
	 * 帖子标题
	 * @autocreate=true
	 */
	private String title;
	/**
	 * 帖子内容
	 * @autocreate=true
	 */
	private String content;
	/**
	 * 帖子图片
	 * @autocreate=true
	 */
	private String imgs;
	/**
	 * 帖子视频
	 * @autocreate=true
	 */
	private String vidio;
	/**
	 * 显示次序
	 * @autocreate=true
	 */
	private Integer sort;
	/**
	 * 有效状态，0草稿1待审核2审核通过3已下架
	 * @autocreate=true
	 */
	private String state;
	/**
	 * 生效扩展参数
	 * @autocreate=true
	 */
	private String actparam;
	/**
	 * 生效开始时间
	 * @autocreate=true
	 */
	private java.util.Date starttime;
	/**
	 * 生效结束时间
	 * @autocreate=true
	 */
	private java.util.Date endtime;
	
	/**
	 * 默认构造函数
	 */
	public AutoArticleVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public AutoArticleVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性发帖数据主键的值
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
	* @Description: 设置属性发帖数据主键的值
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
	* @Title: getTitle 
	* @Description: 获取属性帖子标题的值
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
	* @Description: 设置属性帖子标题的值
	* @param title
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTitle(String title) {
		this.title = title;
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
	* @Title: getImgs 
	* @Description: 获取属性帖子图片的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getImgs() {
		return imgs;
	}

	/**
	* @Title: setImgs
	* @Description: 设置属性帖子图片的值
	* @param imgs
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	/**
	* @Title: getVidio 
	* @Description: 获取属性帖子视频的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getVidio() {
		return vidio;
	}

	/**
	* @Title: setVidio
	* @Description: 设置属性帖子视频的值
	* @param vidio
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setVidio(String vidio) {
		this.vidio = vidio;
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
	* @Description: 获取属性有效状态，0草稿1待审核2审核通过3已下架的值
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
	* @Description: 设置属性有效状态，0草稿1待审核2审核通过3已下架的值
	* @param state
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	* @Title: getActparam 
	* @Description: 获取属性生效扩展参数的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getActparam() {
		return actparam;
	}

	/**
	* @Title: setActparam
	* @Description: 设置属性生效扩展参数的值
	* @param actparam
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setActparam(String actparam) {
		this.actparam = actparam;
	}
	/**
	* @Title: getStarttime 
	* @Description: 获取属性生效开始时间的值
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
	* @Description: 设置属性生效开始时间的值
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
	* @Description: 获取属性生效结束时间的值
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
	* @Description: 设置属性生效结束时间的值
	* @param endtime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}
}