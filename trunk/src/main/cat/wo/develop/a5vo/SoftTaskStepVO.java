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
 * @ClassName: SoftTaskStepVO
 * @Description: 业务操作步骤
 * @author 彭羽飞
 */
public class SoftTaskStepVO  {
	/**
	 * 当前VO类对应数据表名称
	 */
	public final static String table_name = "con_soft_task_step";
	/**
	 * 当前VO类对应数据表主键字段名称
	 */
	public final static String table_uiid = "csts_uiid";
	
	/**
	 * 步骤主键
	 * @autocreate=true
	 */
	private String uiid;
	/**
	 * 业务名称，关联业务主键
	 * @autocreate=true
	 */
	private String cstuiid;
	/**
	 * 上步骤名称，关联步骤主键
	 * @autocreate=true
	 */
	private String precstsuiid;
	/**
	 * 步骤标题
	 * @autocreate=true
	 */
	private String title;
	/**
	 * 步骤业务，1单一寻址2循环寻址3事务操作
	 * @autocreate=true
	 */
	private String tasktype;
	/**
	 * 具体操作，1取值2赋值3滑动4单击5回退6循环
	 * @autocreate=true
	 */
	private String opetype;
	/**
	 * 单击技术，1单击2长按3滑动4滑动长按
	 * @autocreate=true
	 */
	private String clicktype;
	/**
	 * 循环模式，1单次0无限次
	 * @autocreate=true
	 */
	private String agmodel;
	/**
	 * 循环次数
	 * @autocreate=true
	 */
	private Integer agcount;
	/**
	 * 滑动阀值
	 * @autocreate=true
	 */
	private Integer movesize;
	/**
	 * 页面模式，1新页面0原页面
	 * @autocreate=true
	 */
	private String pagemodel;
	/**
	 * 步骤说明
	 * @autocreate=true
	 */
	private String desp;
	/**
	 * 状态，0草稿1有效2无效
	 * @autocreate=true
	 */
	private String state;
	/**
	 * 数据上报，1是0否
	 * @autocreate=true
	 */
	private String submitdata;
	/**
	 * 执行前延时
	 * @autocreate=true
	 */
	private Integer predelay;
	/**
	 * 执行后延时
	 * @autocreate=true
	 */
	private Integer aftdelay;
	/**
	 * 忽略状态，1允许0必须，默认0
	 * @autocreate=true
	 */
	private String ingoresta;
	/**
	 * 辅助次数
	 * @autocreate=true
	 */
	private Integer extracount;
	/**
	 * 可标记完成，1是0否
	 * @autocreate=true
	 */
	private String iffinish;
	/**
	 * 滑动方向，1下滑动2上滑动3左滑动4右滑动5自主上下6自主左右
	 * @autocreate=true
	 */
	private String moveto;
	/**
	 * 显示次序
	 * @autocreate=true
	 */
	private Integer sort;
	
	/**
	 * 默认构造函数
	 */
	public SoftTaskStepVO(){
	
	}
	
	/**
	 * 传入对象的json字符串,自动构造当前类的对象
	 * @param objjson
	 */
	public SoftTaskStepVO(String objjson){
		BeanRefUtil.setvalueFromJson(objjson,this);
	}

	/**
	* @Title: getUiid 
	* @Description: 获取属性步骤主键的值
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
	* @Description: 设置属性步骤主键的值
	* @param uiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	/**
	* @Title: getCstuiid 
	* @Description: 获取属性业务名称，关联业务主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getCstuiid() {
		return cstuiid;
	}

	/**
	* @Title: setCstuiid
	* @Description: 设置属性业务名称，关联业务主键的值
	* @param cstuiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setCstuiid(String cstuiid) {
		this.cstuiid = cstuiid;
	}
	/**
	* @Title: getPrecstsuiid 
	* @Description: 获取属性上步骤名称，关联步骤主键的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getPrecstsuiid() {
		return precstsuiid;
	}

	/**
	* @Title: setPrecstsuiid
	* @Description: 设置属性上步骤名称，关联步骤主键的值
	* @param precstsuiid
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPrecstsuiid(String precstsuiid) {
		this.precstsuiid = precstsuiid;
	}
	/**
	* @Title: getTitle 
	* @Description: 获取属性步骤标题的值
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
	* @Description: 设置属性步骤标题的值
	* @param title
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	* @Title: getTasktype 
	* @Description: 获取属性步骤业务，1单一寻址2循环寻址3事务操作的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getTasktype() {
		return tasktype;
	}

	/**
	* @Title: setTasktype
	* @Description: 设置属性步骤业务，1单一寻址2循环寻址3事务操作的值
	* @param tasktype
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}
	/**
	* @Title: getOpetype 
	* @Description: 获取属性具体操作，1取值2赋值3滑动4单击5回退6循环的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getOpetype() {
		return opetype;
	}

	/**
	* @Title: setOpetype
	* @Description: 设置属性具体操作，1取值2赋值3滑动4单击5回退6循环的值
	* @param opetype
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setOpetype(String opetype) {
		this.opetype = opetype;
	}
	/**
	* @Title: getClicktype 
	* @Description: 获取属性单击技术，1单击2长按3滑动4滑动长按的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getClicktype() {
		return clicktype;
	}

	/**
	* @Title: setClicktype
	* @Description: 设置属性单击技术，1单击2长按3滑动4滑动长按的值
	* @param clicktype
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setClicktype(String clicktype) {
		this.clicktype = clicktype;
	}
	/**
	* @Title: getAgmodel 
	* @Description: 获取属性循环模式，1单次0无限次的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getAgmodel() {
		return agmodel;
	}

	/**
	* @Title: setAgmodel
	* @Description: 设置属性循环模式，1单次0无限次的值
	* @param agmodel
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAgmodel(String agmodel) {
		this.agmodel = agmodel;
	}
	/**
	* @Title: getAgcount 
	* @Description: 获取属性循环次数的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getAgcount() {
		return agcount;
	}

	/**
	* @Title: setAgcount
	* @Description: 设置属性循环次数的值
	* @param agcount
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAgcount(Integer agcount) {
		this.agcount = agcount;
	}
	/**
	* @Title: getMovesize 
	* @Description: 获取属性滑动阀值的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getMovesize() {
		return movesize;
	}

	/**
	* @Title: setMovesize
	* @Description: 设置属性滑动阀值的值
	* @param movesize
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMovesize(Integer movesize) {
		this.movesize = movesize;
	}
	/**
	* @Title: getPagemodel 
	* @Description: 获取属性页面模式，1新页面0原页面的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getPagemodel() {
		return pagemodel;
	}

	/**
	* @Title: setPagemodel
	* @Description: 设置属性页面模式，1新页面0原页面的值
	* @param pagemodel
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPagemodel(String pagemodel) {
		this.pagemodel = pagemodel;
	}
	/**
	* @Title: getDesp 
	* @Description: 获取属性步骤说明的值
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
	* @Description: 设置属性步骤说明的值
	* @param desp
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setDesp(String desp) {
		this.desp = desp;
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
	* @Title: getSubmitdata 
	* @Description: 获取属性数据上报，1是0否的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getSubmitdata() {
		return submitdata;
	}

	/**
	* @Title: setSubmitdata
	* @Description: 设置属性数据上报，1是0否的值
	* @param submitdata
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setSubmitdata(String submitdata) {
		this.submitdata = submitdata;
	}
	/**
	* @Title: getPredelay 
	* @Description: 获取属性执行前延时的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getPredelay() {
		return predelay;
	}

	/**
	* @Title: setPredelay
	* @Description: 设置属性执行前延时的值
	* @param predelay
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setPredelay(Integer predelay) {
		this.predelay = predelay;
	}
	/**
	* @Title: getAftdelay 
	* @Description: 获取属性执行后延时的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getAftdelay() {
		return aftdelay;
	}

	/**
	* @Title: setAftdelay
	* @Description: 设置属性执行后延时的值
	* @param aftdelay
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setAftdelay(Integer aftdelay) {
		this.aftdelay = aftdelay;
	}
	/**
	* @Title: getIngoresta 
	* @Description: 获取属性忽略状态，1允许0必须，默认0的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getIngoresta() {
		return ingoresta;
	}

	/**
	* @Title: setIngoresta
	* @Description: 设置属性忽略状态，1允许0必须，默认0的值
	* @param ingoresta
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setIngoresta(String ingoresta) {
		this.ingoresta = ingoresta;
	}
	/**
	* @Title: getExtracount 
	* @Description: 获取属性辅助次数的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public Integer getExtracount() {
		return extracount;
	}

	/**
	* @Title: setExtracount
	* @Description: 设置属性辅助次数的值
	* @param extracount
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setExtracount(Integer extracount) {
		this.extracount = extracount;
	}
	/**
	* @Title: getIffinish 
	* @Description: 获取属性可标记完成，1是0否的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getIffinish() {
		return iffinish;
	}

	/**
	* @Title: setIffinish
	* @Description: 设置属性可标记完成，1是0否的值
	* @param iffinish
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setIffinish(String iffinish) {
		this.iffinish = iffinish;
	}
	/**
	* @Title: getMoveto 
	* @Description: 获取属性滑动方向，1下滑动2上滑动3左滑动4右滑动5自主上下6自主左右的值
	* @param
	* @return String    返回类型 
	* @throws
	* @autocreate=true
	 */
	public String getMoveto() {
		return moveto;
	}

	/**
	* @Title: setMoveto
	* @Description: 设置属性滑动方向，1下滑动2上滑动3左滑动4右滑动5自主上下6自主左右的值
	* @param moveto
	* @return void
	* @throws
	* @autocreate=true
	 */
	public void setMoveto(String moveto) {
		this.moveto = moveto;
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