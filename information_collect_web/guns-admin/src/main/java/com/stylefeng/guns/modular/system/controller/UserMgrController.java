package com.stylefeng.guns.modular.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.code.kaptcha.Constants;
import com.stylefeng.guns.config.properties.GunsProperties;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.common.annotion.BussinessLog;
import com.stylefeng.guns.core.common.annotion.Permission;
import com.stylefeng.guns.core.common.constant.Const;
import com.stylefeng.guns.core.common.constant.dictmap.UserDict;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.core.common.constant.state.ManagerStatus;
import com.stylefeng.guns.core.common.exception.BizExceptionEnum;
import com.stylefeng.guns.core.datascope.DataScope;
import com.stylefeng.guns.core.db.Db;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.factory.UserFactory;
import com.stylefeng.guns.modular.system.model.Role;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IRoleService;
import com.stylefeng.guns.modular.system.service.IUserService;
import com.stylefeng.guns.modular.system.transfer.UserDto;
import com.stylefeng.guns.modular.system.warpper.UserWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.*;

/**
 * ????????????????????????
 *
 * @author fengshuonan
 * @Date 2017???1???11??? ??????1:08:17
 */
@Controller
@RequestMapping("/mgr")
public class UserMgrController extends BaseController {

    private static String PREFIX = "/system/user/";

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    /**
     * ???????????????????????????????????????
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "user.html";
    }

    /**
     * ???????????????????????????????????????
     */
    @RequestMapping("/user_add")
    public String addView() {

        return PREFIX + "user_add.html";
    }

    /**
     * ???????????????????????????
     */
    //@RequiresPermissions("/mgr/role_assign")  //??????shiro?????????????????????
//    @Permission
    @RequestMapping("/role_assign/{userId}")
    public String roleAssign(@PathVariable Integer userId, Model model) {
        if (ToolUtil.isEmpty(userId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        User user = (User) Db.create(UserMapper.class).selectOneByCon("id", userId);
        model.addAttribute("userId", userId);
        model.addAttribute("userAccount", user.getAccount());
        return PREFIX + "user_roleassign.html";
    }

    /**
     * ??????????????????????????????
     */
    @Permission
    @RequestMapping("/user_edit/{userId}")
    public String userEdit(@PathVariable Integer userId, Model model) {
        if (ToolUtil.isEmpty(userId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        assertAuth(userId);
        User user = this.userService.selectById(userId);
        model.addAttribute(user);
        model.addAttribute("roleName", ConstantFactory.me().getRoleName(user.getRoleid()));
        model.addAttribute("deptName", ConstantFactory.me().getDeptName(user.getDeptid()));
        LogObjectHolder.me().set(user);
        return PREFIX + "user_edit.html";
    }

    /**
     * ?????????????????????????????????
     */
    @RequestMapping("/user_info")
    public String userInfo(Model model) {
        Integer userId = ShiroKit.getUser().getId();
        if (ToolUtil.isEmpty(userId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        User user = this.userService.selectById(userId);
        model.addAttribute(user);
        model.addAttribute("roleName", ConstantFactory.me().getRoleName(user.getRoleid()));
        model.addAttribute("deptName", ConstantFactory.me().getDeptName(user.getDeptid()));
        LogObjectHolder.me().set(user);
        return PREFIX + "user_view.html";
    }

    /**
     * ???????????????????????????
     */
    @RequestMapping("/user_chpwd")
    public String chPwd() {
        return PREFIX + "user_chpwd.html";
    }

    /**
     * ???????????????????????????
     */
    @RequestMapping("/changePwd")
    @ResponseBody
    public Object changePwd(@RequestParam String oldPwd, @RequestParam String newPwd, @RequestParam String rePwd) {
        if (!newPwd.equals(rePwd)) {
            throw new GunsException(BizExceptionEnum.TWO_PWD_NOT_MATCH);
        }
        Integer userId = ShiroKit.getUser().getId();
        User user = userService.selectById(userId);
        String oldMd5 = ShiroKit.md5(oldPwd, user.getSalt());
        if (user.getPassword().equals(oldMd5)) {
            String newMd5 = ShiroKit.md5(newPwd, user.getSalt());
            user.setPassword(newMd5);
            user.updateById();
            return SUCCESS_TIP;
        } else {
            throw new GunsException(BizExceptionEnum.OLD_PWD_NOT_RIGHT);
        }
    }

    /**
     * ?????????????????????
     */
    @RequestMapping("/list")
    @Permission
    @ResponseBody
    public Object list(@RequestParam(required = false) String name, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime, @RequestParam(required = false) Integer deptid) {
        if (ShiroKit.isAdmin()) {
            List<Map<String, Object>> users = userService.selectUsers(null, name, beginTime, endTime, deptid);
            return  users;
        } else {
            DataScope dataScope = new DataScope(ShiroKit.getDeptDataScope());
            List<Map<String, Object>> users = userService.selectUsers(dataScope, name, beginTime, endTime, deptid);
            return users;
        }

    }
    @RequestMapping("/businessUserList")
    @ResponseBody
    public Object businessUserList(@RequestParam(required = false) String name,@RequestParam(required = false) Integer deptid) {
        List<Map<String, Object>> users = userService.selectBusinessUsers(name,deptid);
        return  users;
    }


    /**
     * ???????????????
     */
    @RequestMapping("/add")
    @BussinessLog(value = "???????????????", key = "account", dict = UserDict.class)
//    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Tip add(@Valid UserDto user, BindingResult result) {
        if (result.hasErrors()) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }

        // ????????????????????????
        User theUser = userService.getByAccount(user.getAccount());
        if (theUser != null) {
            throw new GunsException(BizExceptionEnum.USER_ALREADY_REG);
        }

        // ??????????????????
        user.setSalt("rfil5");
        user.setPassword(ShiroKit.md5("Z7gy3060d*",user.getSalt()));
//        user.setSalt(ShiroKit.getRandomSalt(5));
//        user.setPassword(ShiroKit.md5(user.getPassword(), user.getSalt()));
        user.setStatus(ManagerStatus.OK.getCode());
        user.setCreatetime(new Date());
        this.userService.insert(UserFactory.createUser(user));
        return SUCCESS_TIP;
    }

    /**
     * ???????????????
     *
     * @throws NoPermissionException
     */
    @RequestMapping("/edit")
    @BussinessLog(value = "???????????????", key = "account", dict = UserDict.class)
    @ResponseBody
    public Tip edit(@Valid UserDto user, BindingResult result) throws NoPermissionException {
        if (result.hasErrors()) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
//        if (ShiroKit.hasRole(Const.ADMIN_NAME)) {
//            this.userService.updateById(UserFactory.createUser(user));
//            return SUCCESS_TIP;
//        }
        else {
//            assertAuth(user.getId());
            ShiroUser shiroUser = ShiroKit.getUser();
//            if (shiroUser.getId().equals(user.getId())) {
                this.userService.updateById(UserFactory.createUser(user));
                return SUCCESS_TIP;
//            } else {
//                throw new GunsException(BizExceptionEnum.NO_PERMITION);
//            }
        }
    }

    /**
     * ?????????????????????????????????
     */
    @RequestMapping("/delete")
    @BussinessLog(value = "???????????????", key = "userId", dict = UserDict.class)
//    @Permission
    @ResponseBody
    public Tip delete(@RequestParam Integer userId) {
        if (ToolUtil.isEmpty(userId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        //???????????????????????????
        if (userId.equals(Const.ADMIN_ID)) {
            throw new GunsException(BizExceptionEnum.CANT_DELETE_ADMIN);
        }
//        assertAuth(userId);
        this.userService.setStatus(userId, ManagerStatus.DELETED.getCode());
        return SUCCESS_TIP;
    }

    /**
     * ?????????????????????
     */
    @RequestMapping("/view/{userId}")
    @ResponseBody
    public User view(@PathVariable Integer userId) {
        if (ToolUtil.isEmpty(userId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        assertAuth(userId);
        return this.userService.selectById(userId);
    }

    /**
     * ????????????????????????
     */
    @RequestMapping("/reset")
    @BussinessLog(value = "?????????????????????", key = "userId", dict = UserDict.class)
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Tip reset(@RequestParam Integer userId) {
        if (ToolUtil.isEmpty(userId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        assertAuth(userId);
        User user = this.userService.selectById(userId);
        user.setSalt(ShiroKit.getRandomSalt(5));
        user.setPassword(ShiroKit.md5(Const.DEFAULT_PWD, user.getSalt()));
        this.userService.updateById(user);
        return SUCCESS_TIP;
    }

    /**
     * ????????????
     */
    @RequestMapping("/freeze")
    @BussinessLog(value = "????????????", key = "userId", dict = UserDict.class)
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Tip freeze(@RequestParam Integer userId) {
        if (ToolUtil.isEmpty(userId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        //???????????????????????????
        if (userId.equals(Const.ADMIN_ID)) {
            throw new GunsException(BizExceptionEnum.CANT_FREEZE_ADMIN);
        }
        assertAuth(userId);
        this.userService.setStatus(userId, ManagerStatus.FREEZED.getCode());
        return SUCCESS_TIP;
    }

    /**
     * ??????????????????
     */
    @RequestMapping("/unfreeze")
    @BussinessLog(value = "??????????????????", key = "userId", dict = UserDict.class)
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Tip unfreeze(@RequestParam Integer userId) {
        if (ToolUtil.isEmpty(userId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        assertAuth(userId);
        this.userService.setStatus(userId, ManagerStatus.OK.getCode());
        return SUCCESS_TIP;
    }

    /**
     * ????????????
     */
    @RequestMapping("/setRole")
    @BussinessLog(value = "????????????", key = "userId,roleIds", dict = UserDict.class)
//    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Tip setRole(@RequestParam("userId") Integer userId, @RequestParam("roleIds") String roleIds) {
        if (ToolUtil.isOneEmpty(userId, roleIds)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        //???????????????????????????
        if (userId.equals(Const.ADMIN_ID)) {
            throw new GunsException(BizExceptionEnum.CANT_CHANGE_ADMIN);
        }
//        assertAuth(userId);
        this.userService.setRoles(userId, roleIds);
        return SUCCESS_TIP;
    }

    @RequestMapping("/setBusinessRole")
    @ResponseBody
    public Tip setBusinessRole(@RequestParam("userId") Integer userId, @RequestParam("businessRoleId") Integer businessRoleId) {

        User user = new User();
        user.setId(userId);
        user.setBid(businessRoleId);
        userService.updateById(user);
        return SUCCESS_TIP;
    }


    /**
     * ????????????(??????????????????webapp/static/img)
     */
    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    @ResponseBody
    public String upload(@RequestPart("file") MultipartFile picture) {
        String pictureName = UUID.randomUUID().toString() + ".jpg";
        try {
            String fileSavePath = gunsProperties.getFileUploadPath();
            picture.transferTo(new File(fileSavePath + pictureName));
        } catch (Exception e) {
            throw new GunsException(BizExceptionEnum.UPLOAD_ERROR);
        }
        return pictureName;
    }

    /**
     * ???????????????????????????????????????????????????????????????
     */
    private void assertAuth(Integer userId) {
        if (ShiroKit.isAdmin()) {
            return;
        }
        List<Integer> deptDataScope = ShiroKit.getDeptDataScope();
        User user = this.userService.selectById(userId);
        Integer deptid = user.getDeptid();
        if (deptDataScope.contains(deptid)) {
            return;
        } else {
            throw new GunsException(BizExceptionEnum.NO_PERMITION);
        }

    }
    @RequestMapping("/user_forget")
    public String user_forget() {
        return PREFIX + "user_forget.html";
    }

    @RequestMapping("/changePassWord")
    @ResponseBody
    public String changePassWord(String account, String password, String code, String kaptchaInput, HttpServletRequest request){
        EntityWrapper<User> wrapper=new EntityWrapper<>();
        HttpSession session=request.getSession();
        String imgCode=session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
        if(session.getAttribute(account)==null){
            return "?????????????????????";
        }else{
            String verifyCode=session.getAttribute(account).toString();
            if(code.equals(verifyCode) && kaptchaInput.equals(imgCode)){
                wrapper.eq("account",account);
                User user=new User();
                user.setSalt(ShiroKit.getRandomSalt(5));
                user.setPassword(ShiroKit.md5(password, user.getSalt()));
                userService.update(user,wrapper);
                return "success";
            }else{
                return "??????????????????????????????";
            }
        }

    }

}
