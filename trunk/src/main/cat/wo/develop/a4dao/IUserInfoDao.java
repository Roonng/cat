/*
 * @ClassName UserInfoDao
 * @Description 
 * @version 1.0
 * @Date 2017-06-04 01:01:19
 */
package wo.develop.a4dao;

import java.util.List;
import java.util.Map;

import wo.develop.a5vo.UserInfoVO;

/**
 * 用户信息管理dao接口类
 * @author 彭羽飞
 *
 */
public interface IUserInfoDao {
	
	/**
	 * 新增一条用户信息管理信息
	 * @param userInfo 用户信息管理对象
	 * @return 成功更新条数
	 */
    int insert(UserInfoVO userInfo);

	/**
     * 批量新增用户信息管理信息
     * @param userInfolist 用户信息管理对象列表
     * @return 成功更新条数
     */
    int insertBatch(List<UserInfoVO> userInfolist);

	/**
     * 更新一条用户信息管理信息
     * @param userInfo 用户信息管理对象
     * @return 成功更新条数
     */
    int update(UserInfoVO userInfo);
    
	/**
     * 批量更新用户信息管理信息
     * @param userInfolist 用户信息管理对象列表
     * @return 成功更新条数
     */
    int updateBatch(List<UserInfoVO> userInfolist);
    
	/**
     * 批量更新用户信息管理信息
     * @param datamap 用户信息管理对象Map列表
     * @return 成功更新条数
     */
    int updateBatchForMapList(List<Map> datamap);
    
    /**
     * 删除一条用户信息管理信息
     * @param userInfoid 用户信息管理信息主键
     * @return 成功更新条数
     */
    int delete(String userInfoid);
    
    /**
     * 删除符合用户信息管理条件的全部信息
     * @param userInfo 用户信息管理对象
     * @return 成功更新条数
     */
    int deleteForObj(UserInfoVO userInfo);

	/**
     * 批量删除用户信息管理信息，通过in数据主键
     * @param userInfolist 用户信息管理信息主键列表
     * @return 成功更新条数
     */
    int deleteBatch(List<String> userInfolist);

	/**
     * 批量删除用户信息管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 用户信息管理信息map对象
     * @return 成功更新条数
     */
    int deleteBatchByMoreAtt(Map<String,Object> map);

	/**
     * 批量删除用户信息管理指定一个或多个属性通过逗号分隔的符合条件的数据
     * @param map 用户信息管理信息map对象
     * @return 成功更新条数
     */
    int deleteAll(Map<String,Object> map);

	/**
     * 查询一条用户信息管理的详情信息
     * @param userInfoid 用户信息管理信息主键
     * @return 用户信息管理信息对象
     */
    UserInfoVO searchById(String userInfoid);

	/**
     * 查询一条用户信息管理的详情信息，实现数据行锁定
     * @param userInfoid 用户信息管理信息主键
     * @return 用户信息管理信息对象
     */
    UserInfoVO searchByIdUpdate(String userInfoid);

	/**
     * 批量查询用户信息管理信息，通过in数据主键
     * @param userInfolist 用户信息管理信息主键列表
     * @return 用户信息管理信息对象列表
     */
    List<UserInfoVO> searchBatch(List<String> userInfolist);

	/**
     * 获取用户信息管理指定一个或多个属性，同一属性多个值通过逗号分隔的数据查询多条数据
     * @param map 用户信息管理信息map对象
     * @return 用户信息管理信息对象列表
     */
    List<UserInfoVO> searchByMoreId(Map<String,Object> map);

	/**
     * 获取符合条件的一条用户信息管理信息表信息，=条件判断符
     * @param userInfo 用户信息管理信息对象
     * @return 用户信息管理信息对象
     */
    UserInfoVO searchObjByObj(UserInfoVO userInfo);

	/**
     * 获取符合条件的用户信息管理信息条数，like条件判断符，支持单属性多个值，之间通过逗号隔开
     * @param userInfo 用户信息管理信息对象
     * @return 符合结果的信息条数
     */
    int searchCountByObj(UserInfoVO userInfo);

	/**
     * 获取符合条件的全部用户信息管理信息，=条件判断符
     * @param userInfo 用户信息管理信息对象
     * @return 用户信息管理信息对象列表
     */
    List<UserInfoVO> searchListByObj(UserInfoVO userInfo);
	
    /**
     * 获取符合条件的全部用户信息管理信息，支持动态关联分页查询
     * @param userInfo 用户信息管理信息对象
     * @return 用户信息管理信息对象列表
     */
    List<UserInfoVO> searchListPageByObj(UserInfoVO userInfo);
	
    /**
     * 获取符合条件的全部用户信息管理信息，支持动态关联分页查询
     * @param userInfo 用户信息管理信息对象
     * @return 用户信息管理信息对象列表
     */
    List<UserInfoVO> searchListPageByObjOr(UserInfoVO userInfo);
	
    /**
     * 获取符合条件的全部用户信息管理信息，支持动态关联分页查询
     * @param userInfo 用户信息管理信息对象
     * @return 用户信息管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjRefin(UserInfoVO userInfo);
	
    /**
     * 获取符合条件的全部用户信息管理信息，支持动态关联分页查询
     * @param userInfo 用户信息管理信息对象
     * @return 用户信息管理信息对象列表
     */
    List<Map<String,Object>> searchListPageByObjReftable(UserInfoVO userInfo);
    
}