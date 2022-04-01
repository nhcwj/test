package com.stylefeng.guns.modular.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.code.kaptcha.Constants;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.exception.InvalidKaptchaException;
import com.stylefeng.guns.core.log.LogManager;
import com.stylefeng.guns.core.log.factory.LogTaskFactory;
import com.stylefeng.guns.core.node.MenuNode;
import com.stylefeng.guns.core.result.ActionResult;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.core.util.ApiMenuFilter;
import com.stylefeng.guns.core.util.KaptchaUtil;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.system.dao.RoleMapper;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.IctCountMapper;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.model.informationCollect.IctCount;
import com.stylefeng.guns.modular.system.service.IDeptService;
import com.stylefeng.guns.modular.system.service.IMenuService;
import com.stylefeng.guns.modular.system.service.IUserService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.stylefeng.guns.core.support.HttpKit.getIp;

/**
 * 登录控制器
 *
 * @author fengshuonan
 * @Date 2017年1月10日 下午8:25:24
 */
@Controller
public class LoginController extends BaseController {

    static List<String> MENU_LIST = new ArrayList<>(16);

    static{
        MENU_LIST.add("1017312761643802784");//待修改（新增申报）
        MENU_LIST.add("1017312761643802786");//待核实（新增申报）
        MENU_LIST.add("1017312761643802785");//待审核（新增申报）
        MENU_LIST.add("1017312761643802790");//待修改（业绩申报）
        MENU_LIST.add("1017312761643802789");//待审核（业绩申报）
        MENU_LIST.add("1017312761643802776");//待评估价格
        MENU_LIST.add("1017312761643802777");//待评选
        MENU_LIST.add("1017312761643802792");//待审核（帐号申请）
        MENU_LIST.add("1017312761643802793");//待核实（业绩申报）
    }

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IUserService userService;


    @Autowired
    private IDeptService deptService;

    /**
     * 跳转到主页
     *  task_num_1 待修改（新增申报）
     *  task_num_2 待核实（新增申报）
     *  task_num_3 待审核（新增申报）
     *  task_num_4 待修改（业绩申报）
     *  task_num_5 待审核（业绩申报）
     *  task_num_6 待评估价格
     *  task_num_7 待评选
     *  task_num_8 待审核（帐号申请）
     *  task_num_9 待核实（业绩申报）
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        //获取菜单列表
        List<Integer> roleList = ShiroKit.getUser().getRoleList();
        String roleNames=ShiroKit.getUser().getRoleNames().get(0);
        if (roleList == null || roleList.size() == 0) {
            ShiroKit.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "/login.html";
        }

        List<MenuNode> menus = menuService.getMenusByRoleIds(roleList);
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        titles = ApiMenuFilter.build(titles);

        model.addAttribute("titles", titles);

        //获取用户头像
        Integer id = ShiroKit.getUser().getId();
        User user = userService.selectById(id);
        String avatar = user.getAvatar();
        model.addAttribute("avatar", avatar);

        return "/index.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return REDIRECT + "/";
        } else {
            return "/login.html";
        }
    }
    @RequestMapping(value = "/qywapp/normalLogin", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ActionResult appRegisterUser(String username, String password){
        ActionResult ac = new ActionResult();

        if (KaptchaUtil.getKaptchaOnOff()) {
            String kaptcha = super.getPara("kaptcha").trim();
            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
                throw new InvalidKaptchaException();
            }
        }
        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
        try{
            currentUser.login(token);

            ShiroUser shiroUser = ShiroKit.getUser();
            super.getSession().setAttribute("shiroUser", shiroUser);
            super.getSession().setAttribute("username", shiroUser.getAccount());

            LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));

            ShiroKit.getSession().setAttribute("sessionFlag", true);

            User user = userService.selectById(ShiroKit.getUser().id);
            ac.setData(user);
            ac.setMsg("success");
            ac.setOk(true);
            return ac;
        }catch (Exception e){
            System.out.println("账号或密码错误");
            ac.setMsg("账号或密码错误");
            ac.setOk(false);
            return ac;
        }
    }

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private IctCountMapper ictCountMapper;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/qywapp/normalLogin_manager")
    @ResponseBody
    @CrossOrigin
    public Map appRegisterUser_manager(String phone){
        EntityWrapper<User> userEntityWrapper = new EntityWrapper();
        userEntityWrapper.eq("phone",phone);
        List<User> userList = userMapper.selectList(userEntityWrapper);
        Map<String,Object>map = new HashMap<>();
        if(userList.size()>0){
            for(User user : userList){
                String rolestr = "";
                List<String> rolelist = Arrays.asList(user.getRoleid().split(","));
                for (String role : rolelist) {
                    rolestr += roleMapper.selectById(role);
                }
                if(rolestr.contains("客户经理")){
                    map.put("user_id",user.getId());
                    map.put("role","客户经理");
                    return map;
                }
                map.put("role","客户");
            }
        }

        return map;

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginVali(HttpServletResponse response, HttpServletRequest request) {

        String username = super.getPara("username").trim();
        String password = super.getPara("password").trim();
        String remember = super.getPara("remember");

        //验证验证码是否正确
        if (KaptchaUtil.getKaptchaOnOff()) {
            String kaptcha = super.getPara("kaptcha").trim();
            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
                throw new InvalidKaptchaException();
            }
        }

        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());

        if ("on".equals(remember)) {
//            token.setRememberMe(true);
            Cookie ckUsername = new Cookie("nms_username", username);
            ckUsername.setMaxAge(60*60*24*30);
            response.addCookie(ckUsername);
            Cookie ckPassword = new Cookie("nms_password", password);
            ckPassword.setMaxAge(60*60*24*30);
            response.addCookie(ckPassword);
            Cookie ckRemember = new Cookie("nms_remember", "1");
            ckRemember.setMaxAge(60*60*24*30);
            response.addCookie(ckRemember);
        } else {
//            token.setRememberMe(false);
            Cookie[] cookies = request.getCookies();
            if(cookies != null) {
                for(Cookie cookie : cookies) {
                    if("nms_username".equals(cookie.getName()) || "nms_password".equals(cookie.getName())
                            || "nms_remember".equals(cookie.getName())) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
        }

        currentUser.login(token);

        ShiroUser shiroUser = ShiroKit.getUser();
        super.getSession().setAttribute("shiroUser", shiroUser);
        super.getSession().setAttribute("username", shiroUser.getAccount());

        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));

        ShiroKit.getSession().setAttribute("sessionFlag", true);

        //增加cookie


        return REDIRECT + "/";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), getIp()));
        ShiroKit.getSubject().logout();
        return REDIRECT + "/login";
    }
}
