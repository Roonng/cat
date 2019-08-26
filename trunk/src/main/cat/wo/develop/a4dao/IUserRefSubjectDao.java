/*
 * @ClassName UserRefSubjectDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.UserRefSubjectVO;

/**
 * 用户主题管理dao接口类
 * @author 彭羽飞
 *
 */
public interface IUserRefSubjectDao {
	
	/**
	 * 新增一条用户主题管理信息
	 * @param userRefSubject 用户主题管理对象
	 * @return 成功更新条数
	 */
    int insert(UserRefSubjectVO userRefSubject);

	/**
     * 批量新增用户主题管理信息
     * @param userRefSubjectlist 用户主题管理对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<UserRefSubjectVO> userRefSubjectlist);

	/**
     * 更新一条用户主题管理信息
     * @param userRefSubject 用户主题管理对象
     * @return 成功更新条数
     */
    int update(UserRefSubjectVO userRefSubject);
    
	/**
     * 批量更新用户主题管理信息
     * @param userRefSubjectlist 用户主题管理对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<UserRefSubjectVO> userRefSubjectlist);
    
	/**
     * 批量更新用户主题管理信息
     * @param datamap 用户主题管理对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条用户主题管理信息
     * @param userRefSubjectid 用户主题管理信息主键
     * @return 成功更新条数
     */
    int delete(String userRefSubjectid);
    
    /**
     * 删除符合用户主题管理条件的全部信息
     * @param userRefSubject 用户主题管理对象
     * @return 成功更新条数
     */
    int deleteForObj(UserRefSubjectVO userRefSubject);

	/**
     * 批量删除用户主题管理信息，通过in数据主键
     * @param userRefSubjectlist 用户主题管理信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> userRefSubjectlist);

	/**
     * 批量删除用户主题管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 用户主题管理信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除用户主题管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 用户主题管理信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条用户主题管理的详情信息
     * @param userRefSubjectid 用户主题管理信息主键
     * @return 用户主题管理信息对象
     */
    UserRefSubjectVO searchById(String userRefSubjectid);

	/**
     * 查询一条用户主题管理的详情信息，实现数据行锁定
     * @param userRefSubjectid 用户主题管理信息主键
     * @return 用户主题管理信息对象
     */
    UserRefSubjectVO searchByIdUpdate(String userRefSubjectid);

	/**
     * 批量查询用户主题管理信息，通过in数据主键
     * @param userRefSubjectlist 用户主题管理信息主键列表
     * @return 用户主题管理信息对象列表
     */
    List<UserRefSubjectVO> searchBatch(List<String> userRefSubjectlist);

	/**
     * 获取用户主题管理指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 用户主题管理信息map对象
     * @return 用户主题管理信息对象列表
     */
    List<UserRefSubjectVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条用户主题管理信息表信息，=条件判断符
     * @param userRefSubject 用户主题管理信息对象
     * @return 用户主题管理信息对象
     */
    UserRefSubjectVO searchObjByObj(UserRefSubjectVO userRefSubject);

	/**
     * 获取符合条件的用户主题管理信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param userRefSubject 用户主题管理信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(UserRefSubjectVO userRefSubject);

	/**
     * 获取符合条件的全部用户主题管理信息，=条件判断符
     * @param userRefSubject 用户主题管理信息对象
     * @return 用户主题管理信息对象列表
     */
    List<UserRefSubjectVO> searchListByObj(UserRefSubjectVO userRefSubject);
	
    /**
     * 获取符合条件的全部用户主题管理信息，支持动态关联分页查询
     * @param userRefSubject 用户主题管理信息对象
     * @return 用户主题管理信息对象列表
     */
    List<UserRefSubjectVO> searchListPageByObj(UserRefSubjectVO userRefSubject);
	
    /**
     * 获取符合条件的全部用户主题管理信息，支持动态关联分页查询
     * @param userRefSubject 用户主题管理信息对象
     * @return 用户主题管理信息对象列表
     */
    List<UserRefSubjectVO> searchListPageByObjOr(UserRefSubjectVO userRefSubject);
	
    /**
     * 获取符合条件的全部用户主题管理信息，支持动态关联分页查询
     * @param userRefSubject 用户主题管理信息对象
     * @return 用户主题管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(UserRefSubjectVO userRefSubject);
	
    /**
     * 获取符合条件的全部用户主题管理信息，支持动态关联分页查询
     * @param userRefSubject 用户主题管理信息对象
     * @return 用户主题管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(UserRefSubjectVO userRefSubject);
    
}