package com.stylefeng.guns.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.core.node.ZTreeNode;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.modular.system.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 角色相关业务
 *
 * @author fengshuonan
 * @Date 2017年1月10日 下午9:11:57
 */
public interface IRoleService extends IService<Role> {

    /**
     * 设置某个角色的权限
     *
     * @param roleId 角色id
     * @param ids    权限的id
     * @date 2017年2月13日 下午8:26:53
     */
    void setAuthority(Integer roleId, String ids);

    /**
     * 删除角色
     *
     * @author stylefeng
     * @Date 2017/5/5 22:24
     */
    void delRoleById(Integer roleId);

    /**
     * 根据条件查询角色列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectRoles(@Param("condition") String condition);

    /**
     * 删除某个角色的所有权限
     *
     * @param roleId 角色id
     * @return
     * @date 2017年2月13日 下午7:57:51
     */
    int deleteRolesById(@Param("roleId") Integer roleId);

    /**
     * 获取角色列表树
     *
     * @return
     * @date 2017年2月18日 上午10:32:04
     */
    List<ZTreeNode> roleTreeList();

    /**
     * 获取角色列表树
     *
     * @return
     * @date 2017年2月18日 上午10:32:04
     */
    List<ZTreeNode> roleTreeListByRoleId(String[] roleId);

    List<ZTreeNode> roleTreeBusinessList();

    List<ZTreeNode> roleTreeBusinessListByRoleId(Integer bid);

    List<Map<String, Object>> selectBusinessDatas(String roleid, Integer id);

    List<ZTreeNode> getManagerRoleList();

    /**
     * 通过客户经理名称模糊查找
     * @param managerName
     * @return
     */
    List<ZTreeNode> searchManagerByNameLike(String managerName);

    /**
     * 搜索上级单位
     * @return
     */
    List<ZTreeNode> searchRole();

    /**
     * 获取角色的string拼接
     * */
    String getUsetStr(ShiroUser shiroUser,String roleTreeName);

}
