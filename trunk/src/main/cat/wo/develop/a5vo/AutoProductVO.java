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
 * @ClassName: AutoProductVO
 * @Description: 产品管理
 * @author 彭羽飞
 */
public class AutoProductVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "com_auto_product";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "cap_uiid";
	
	/**
	 * 产品主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 产品名称
	 * @autocreate=true
	 */
	private String name;
	/**
	 * 产品编码
	 * @autocreate=true
	 */
	private String code;
	/**
	 * 产品LOGO
	 * @autocreate=true
	 */
	private String logoimg;
	/**
	 * 公开状态，1公开0私有
	 * @autocreate=true
	 */
	private String publicsta;
	/**
	 * 产品说明
	 * @autocreate=true
	 */
	private String desp;
	/**
	 * 下载完整地址
	 * @autocreate=true
	 */
	private String downloadurl;
	/**
	 * 完整地址二维码
	 * @autocreate=true
	 */
	private String downloadcode;
	/**
	 * 产品短码地址
	 * @autocreate=true
	 */
	private String shorturl;
	/**
	 * 下载短码二维码
	 * @autocreate=true
	 */
	private String shortcode;
	/**
	 * 测试完整地址
	 * @autocreate=true
	 */
	private String testurl;
	/**
	 * 视频标题
	 * @autocreate=true
	 */
	private String vidiotitle;
	/**
	 * 介绍视频
	 * @autocreate=true
	 */
	private String vidiourl;
	/**
	 * 显示次序
	 * @autocreate=true
	 */
	private Integer sort;
	
	/**
	 * 默认构造函数
	 */
	public AutoProductVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public AutoProductVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性产品主键的值
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
	* @Description: 设置属性产品主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	/**
	* @Title: getName 
	* @Description: 获取属性产品名称的值
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
	* @Description: 设置属性产品名称的值
	* @param name
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	* @Title: getCode 
	* @Description: 获取属性产品编码的值
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
	* @Description: 设置属性产品编码的值
	* @param code
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	* @Title: getLogoimg 
	* @Description: 获取属性产品LOGO的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getLogoimg() {
		return logoimg;
	}

	/**
	* @Title: setLogoimg
	* @Description: 设置属性产品LOGO的值
	* @param logoimg
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setLogoimg(String logoimg) {
		this.logoimg = logoimg;
	}
	/**
	* @Title: getPublicsta 
	* @Description: 获取属性公开状态，1公开0私有的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getPublicsta() {
		return publicsta;
	}

	/**
	* @Title: setPublicsta
	* @Description: 设置属性公开状态，1公开0私有的值
	* @param publicsta
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPublicsta(String publicsta) {
		this.publicsta = publicsta;
	}
	/**
	* @Title: getDesp 
	* @Description: 获取属性产品说明的值
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
	* @Description: 设置属性产品说明的值
	* @param desp
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDesp(String desp) {
		this.desp = desp;
	}
	/**
	* @Title: getDownloadurl 
	* @Description: 获取属性下载完整地址的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getDownloadurl() {
		return downloadurl;
	}

	/**
	* @Title: setDownloadurl
	* @Description: 设置属性下载完整地址的值
	* @param downloadurl
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDownloadurl(String downloadurl) {
		this.downloadurl = downloadurl;
	}
	/**
	* @Title: getDownloadcode 
	* @Description: 获取属性完整地址二维码的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getDownloadcode() {
		return downloadcode;
	}

	/**
	* @Title: setDownloadcode
	* @Description: 设置属性完整地址二维码的值
	* @param downloadcode
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDownloadcode(String downloadcode) {
		this.downloadcode = downloadcode;
	}
	/**
	* @Title: getShorturl 
	* @Description: 获取属性产品短码地址的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getShorturl() {
		return shorturl;
	}

	/**
	* @Title: setShorturl
	* @Description: 设置属性产品短码地址的值
	* @param shorturl
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setShorturl(String shorturl) {
		this.shorturl = shorturl;
	}
	/**
	* @Title: getShortcode 
	* @Description: 获取属性下载短码二维码的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getShortcode() {
		return shortcode;
	}

	/**
	* @Title: setShortcode
	* @Description: 设置属性下载短码二维码的值
	* @param shortcode
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}
	/**
	* @Title: getTesturl 
	* @Description: 获取属性测试完整地址的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getTesturl() {
		return testurl;
	}

	/**
	* @Title: setTesturl
	* @Description: 设置属性测试完整地址的值
	* @param testurl
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTesturl(String testurl) {
		this.testurl = testurl;
	}
	/**
	* @Title: getVidiotitle 
	* @Description: 获取属性视频标题的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getVidiotitle() {
		return vidiotitle;
	}

	/**
	* @Title: setVidiotitle
	* @Description: 设置属性视频标题的值
	* @param vidiotitle
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setVidiotitle(String vidiotitle) {
		this.vidiotitle = vidiotitle;
	}
	/**
	* @Title: getVidiourl 
	* @Description: 获取属性介绍视频的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getVidiourl() {
		return vidiourl;
	}

	/**
	* @Title: setVidiourl
	* @Description: 设置属性介绍视频的值
	* @param vidiourl
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setVidiourl(String vidiourl) {
		this.vidiourl = vidiourl;
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