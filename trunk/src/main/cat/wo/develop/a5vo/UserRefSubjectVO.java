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
 * @ClassName: UserRefSubjectVO
 * @Description: 用户主题管理
 * @author 彭羽飞
 */
public class UserRefSubjectVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_user_ref_subject";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "curs_uiid";
	
	/**
	 * 用户主题关系
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
	 * 开通状态，0未开通1已开通
	 * @autocreate=true
	 */
	private String openstate;
	/**
	 * 服务到期时间
	 * @autocreate=true
	 */
	private java.util.Date endtime;
	/**
	 * 启用状态，0待启动1执行中
	 * @autocreate=true
	 */
	private String state;
	/**
	 * 启动方式，1开机启动2手动触发3定时启动
	 * @autocreate=true
	 */
	private String starttype;
	/**
	 * 启动时间，多个时间之间请通过英文半角逗号分隔
	 * @autocreate=true
	 */
	private String starttim;
	/**
	 * 扩展参数信息，JSON格式配置需求参数，由自动化业务提供
	 * @autocreate=true
	 */
	private String extparam;
	/**
	 * 包含关键字，多个之间请通过逗号分隔
	 * @autocreate=true
	 */
	private String allowkey;
	/**
	 * 排除关键字，多个之间请通过逗号分隔
	 * @autocreate=true
	 */
	private String delowkey;
	/**
	 * 回复内容选择模式，1随机2均态3次序，默认1
	 * @autocreate=true
	 */
	private String answertype;
	/**
	 * 开通语言机器人，1是0或，默认0
	 * @autocreate=true
	 */
	private String advanchek;
	/**
	 * 开启滤重，1开启0禁用
	 * @autocreate=true
	 */
	private String checkrepeat;
	/**
	 * 滤重时效天数，默认3天
	 * @autocreate=true
	 */
	private Integer repeatday;
	/**
	 * 匹配度分值
	 * @autocreate=true
	 */
	private Integer checscore;
	/**
	 * 显示次序
	 * @autocreate=true
	 */
	private Integer sort;
	/**
	 * 任务目标数量
	 * @autocreate=true
	 */
	private Integer destnum;
	/**
	 * 前端重复计数，1允许0不允许，默认0
	 * @autocreate=true
	 */
	private String repeatin;
	/**
	 * 最大执行时长，单位秒
	 * @autocreate=true
	 */
	private Integer timelength;
	/**
	 * 允许强制启动，1是0否
	 * @autocreate=true
	 */
	private String strongstart;
	/**
	 * 允许强制中断，1是0否
	 * @autocreate=true
	 */
	private String strongend;
	/**
	 * 运行等级，0普通1高2非常高
	 * @autocreate=true
	 */
	private Integer runlevel;
	
	/**
	 * 默认构造函数
	 */
	public UserRefSubjectVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public UserRefSubjectVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性用户主题关系的值
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
	* @Description: 设置属性用户主题关系的值
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
	* @Title: getOpenstate 
	* @Description: 获取属性开通状态，0未开通1已开通的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getOpenstate() {
		return openstate;
	}

	/**
	* @Title: setOpenstate
	* @Description: 设置属性开通状态，0未开通1已开通的值
	* @param openstate
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setOpenstate(String openstate) {
		this.openstate = openstate;
	}
	/**
	* @Title: getEndtime 
	* @Description: 获取属性服务到期时间的值
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
	* @Description: 设置属性服务到期时间的值
	* @param endtime
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}
	/**
	* @Title: getState 
	* @Description: 获取属性启用状态，0待启动1执行中的值
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
	* @Description: 设置属性启用状态，0待启动1执行中的值
	* @param state
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	* @Title: getStarttype 
	* @Description: 获取属性启动方式，1开机启动2手动触发3定时启动的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getStarttype() {
		return starttype;
	}

	/**
	* @Title: setStarttype
	* @Description: 设置属性启动方式，1开机启动2手动触发3定时启动的值
	* @param starttype
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setStarttype(String starttype) {
		this.starttype = starttype;
	}
	/**
	* @Title: getStarttim 
	* @Description: 获取属性启动时间，多个时间之间请通过英文半角逗号分隔的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getStarttim() {
		return starttim;
	}

	/**
	* @Title: setStarttim
	* @Description: 设置属性启动时间，多个时间之间请通过英文半角逗号分隔的值
	* @param starttim
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setStarttim(String starttim) {
		this.starttim = starttim;
	}
	/**
	* @Title: getExtparam 
	* @Description: 获取属性扩展参数信息，JSON格式配置需求参数，由自动化业务提供的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getExtparam() {
		return extparam;
	}

	/**
	* @Title: setExtparam
	* @Description: 设置属性扩展参数信息，JSON格式配置需求参数，由自动化业务提供的值
	* @param extparam
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setExtparam(String extparam) {
		this.extparam = extparam;
	}
	/**
	* @Title: getAllowkey 
	* @Description: 获取属性包含关键字，多个之间请通过逗号分隔的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAllowkey() {
		return allowkey;
	}

	/**
	* @Title: setAllowkey
	* @Description: 设置属性包含关键字，多个之间请通过逗号分隔的值
	* @param allowkey
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAllowkey(String allowkey) {
		this.allowkey = allowkey;
	}
	/**
	* @Title: getDelowkey 
	* @Description: 获取属性排除关键字，多个之间请通过逗号分隔的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getDelowkey() {
		return delowkey;
	}

	/**
	* @Title: setDelowkey
	* @Description: 设置属性排除关键字，多个之间请通过逗号分隔的值
	* @param delowkey
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDelowkey(String delowkey) {
		this.delowkey = delowkey;
	}
	/**
	* @Title: getAnswertype 
	* @Description: 获取属性回复内容选择模式，1随机2均态3次序，默认1的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAnswertype() {
		return answertype;
	}

	/**
	* @Title: setAnswertype
	* @Description: 设置属性回复内容选择模式，1随机2均态3次序，默认1的值
	* @param answertype
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAnswertype(String answertype) {
		this.answertype = answertype;
	}
	/**
	* @Title: getAdvanchek 
	* @Description: 获取属性开通语言机器人，1是0或，默认0的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAdvanchek() {
		return advanchek;
	}

	/**
	* @Title: setAdvanchek
	* @Description: 设置属性开通语言机器人，1是0或，默认0的值
	* @param advanchek
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAdvanchek(String advanchek) {
		this.advanchek = advanchek;
	}
	/**
	* @Title: getCheckrepeat 
	* @Description: 获取属性开启滤重，1开启0禁用的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCheckrepeat() {
		return checkrepeat;
	}

	/**
	* @Title: setCheckrepeat
	* @Description: 设置属性开启滤重，1开启0禁用的值
	* @param checkrepeat
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCheckrepeat(String checkrepeat) {
		this.checkrepeat = checkrepeat;
	}
	/**
	* @Title: getRepeatday 
	* @Description: 获取属性滤重时效天数，默认3天的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getRepeatday() {
		return repeatday;
	}

	/**
	* @Title: setRepeatday
	* @Description: 设置属性滤重时效天数，默认3天的值
	* @param repeatday
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setRepeatday(Integer repeatday) {
		this.repeatday = repeatday;
	}
	/**
	* @Title: getChecscore 
	* @Description: 获取属性匹配度分值的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getChecscore() {
		return checscore;
	}

	/**
	* @Title: setChecscore
	* @Description: 设置属性匹配度分值的值
	* @param checscore
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setChecscore(Integer checscore) {
		this.checscore = checscore;
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
	* @Title: getDestnum 
	* @Description: 获取属性任务目标数量的值
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
	* @Description: 设置属性任务目标数量的值
	* @param destnum
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDestnum(Integer destnum) {
		this.destnum = destnum;
	}
	/**
	* @Title: getRepeatin 
	* @Description: 获取属性前端重复计数，1允许0不允许，默认0的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getRepeatin() {
		return repeatin;
	}

	/**
	* @Title: setRepeatin
	* @Description: 设置属性前端重复计数，1允许0不允许，默认0的值
	* @param repeatin
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setRepeatin(String repeatin) {
		this.repeatin = repeatin;
	}
	/**
	* @Title: getTimelength 
	* @Description: 获取属性最大执行时长，单位秒的值
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
	* @Description: 设置属性最大执行时长，单位秒的值
	* @param timelength
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTimelength(Integer timelength) {
		this.timelength = timelength;
	}
	/**
	* @Title: getStrongstart 
	* @Description: 获取属性允许强制启动，1是0否的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getStrongstart() {
		return strongstart;
	}

	/**
	* @Title: setStrongstart
	* @Description: 设置属性允许强制启动，1是0否的值
	* @param strongstart
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setStrongstart(String strongstart) {
		this.strongstart = strongstart;
	}
	/**
	* @Title: getStrongend 
	* @Description: 获取属性允许强制中断，1是0否的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getStrongend() {
		return strongend;
	}

	/**
	* @Title: setStrongend
	* @Description: 设置属性允许强制中断，1是0否的值
	* @param strongend
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setStrongend(String strongend) {
		this.strongend = strongend;
	}
	/**
	* @Title: getRunlevel 
	* @Description: 获取属性运行等级，0普通1高2非常高的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getRunlevel() {
		return runlevel;
	}

	/**
	* @Title: setRunlevel
	* @Description: 设置属性运行等级，0普通1高2非常高的值
	* @param runlevel
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setRunlevel(Integer runlevel) {
		this.runlevel = runlevel;
	}
}