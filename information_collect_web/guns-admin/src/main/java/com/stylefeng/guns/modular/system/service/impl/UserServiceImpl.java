package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.core.datascope.DataScope;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IUserService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-02-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public int setStatus(Integer userId, int status) {
        return this.baseMapper.setStatus(userId, status);
    }

    @Override
    public int changePwd(Integer userId, String pwd) {
        return this.baseMapper.changePwd(userId, pwd);
    }

    @Override
    public List<Map<String, Object>> selectUsers(DataScope dataScope, String name, String beginTime, String endTime, Integer deptid) {
        return this.baseMapper.selectUsers(dataScope, name, beginTime, endTime, deptid);
    }

    @Override
    public List<Map<String, Object>> selectUsersByDeptId(String name, Integer deptid) {
        return this.baseMapper.selectUsersByDeptId(name,  deptid);
    }

    @Override
    public int setRoles(Integer userId, String roleIds) {
        return this.baseMapper.setRoles(userId, roleIds);
    }

    @Override
    public User getByAccount(String account) {
        return this.baseMapper.getByAccount(account);
    }

    @Override
    public List<String> selectRoleMenus(Integer integer) {

        return this.baseMapper.selectRoleMenus(integer);
    }

    @Override
    public List<Map<String, Object>> selectBusinessUsers(String name, Integer deptid) {
        return this.baseMapper.selectBusinessUsers(name, deptid);
    }

    @Override
    public List<Map<String, Object>> selectBusinessUserList(Integer status, Integer business_id) {
        return this.baseMapper.selectBusinessUserList(status, business_id);
    }

    @Override
    public List<User> selectByRoleid(Integer temp) {
        return this.baseMapper.selectByRoleid(temp);
    }

}
