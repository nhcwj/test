package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.core.node.ZTreeNode;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.core.util.Convert;
import com.stylefeng.guns.modular.system.dao.RelationMapper;
import com.stylefeng.guns.modular.system.dao.RoleMapper;
import com.stylefeng.guns.modular.system.model.Relation;
import com.stylefeng.guns.modular.system.model.Role;
import com.stylefeng.guns.modular.system.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RelationMapper relationMapper;

    @Override
    @Transactional(readOnly = false)
    public void setAuthority(Integer roleId, String ids) {

        // 删除该角色所有的权限
        this.roleMapper.deleteRolesById(roleId);

        // 添加新的权限
        for (Long id : Convert.toLongArray(true, Convert.toStrArray(",", ids))) {
            Relation relation = new Relation();
            relation.setRoleid(roleId);
            relation.setMenuid(id);
            this.relationMapper.insert(relation);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void delRoleById(Integer roleId) {
        //删除角色
        this.roleMapper.deleteById(roleId);

        // 删除该角色所有的权限
        this.roleMapper.deleteRolesById(roleId);
    }

    @Override
    public List<Map<String, Object>> selectRoles(String condition) {
        return this.baseMapper.selectRoles(condition);
    }

    @Override
    public int deleteRolesById(Integer roleId) {
        return this.baseMapper.deleteRolesById(roleId);
    }

    @Override
    public List<ZTreeNode> roleTreeList() {
        return this.baseMapper.roleTreeList();
    }

    @Override
    public List<ZTreeNode> roleTreeListByRoleId(String[] roleId) {
        return this.baseMapper.roleTreeListByRoleId(roleId);
    }

    @Override
    public List<ZTreeNode> roleTreeBusinessList() {
        return this.baseMapper.roleTreeBusinessList();
    }

    @Override
    public List<ZTreeNode> roleTreeBusinessListByRoleId(Integer bid) {
        return this.baseMapper.roleTreeBusinessListByRoleId(bid);
    }

    @Override
    public List<Map<String, Object>> selectBusinessDatas(String roleid, Integer pid) {
        return this.baseMapper.selectBusinessDatas(roleid, pid);
    }

    @Override
    public List<ZTreeNode> getManagerRoleList() {
        return this.baseMapper.getManagerRoleList();
    }

    @Override
    public List<ZTreeNode> searchManagerByNameLike(String managerName) {
        return roleMapper.searchManagerByNameLike(managerName);
    }

    @Override
    public List<ZTreeNode> searchRole() {
        return roleMapper.searchRole();
    }

    @Override
    public String getUsetStr(ShiroUser shiroUser,String roleTreeName) {
        List<Integer> roleList = shiroUser.getRoleList();
        List<Role>  role_list= roleMapper.selectRoleList(roleList,roleTreeName);
        String ref_str="";
        for(Role role : role_list){
            if(ref_str.equals("")){
                ref_str = role.getName();
            }else {
                ref_str = ref_str + "," +role.getName();
            }

        }
        return ref_str;
    }

}
