package com.stylefeng.guns.modular.sysFile.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.SysFile;
import com.stylefeng.guns.modular.sysFile.service.ISysFileService;

/**
 * sysFile控制器
 *
 * @author fengshuonan
 * @Date 2018-06-28 16:05:12
 */
@Controller
@RequestMapping("/sysFile")
public class SysFileController extends BaseController {

    private String PREFIX = "/sysFile/sysFile/";

    @Autowired
    private ISysFileService sysFileService;

    /**
     * 跳转到sysFile首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysFile.html";
    }

    /**
     * 跳转到添加sysFile
     */
    @RequestMapping("/sysFile_add")
    public String sysFileAdd() {
        return PREFIX + "sysFile_add.html";
    }

    /**
     * 跳转到修改sysFile
     */
    @RequestMapping("/sysFile_update/{sysFileId}")
    public String sysFileUpdate(@PathVariable Integer sysFileId, Model model) {
        SysFile sysFile = sysFileService.selectById(sysFileId);
        model.addAttribute("item",sysFile);
        LogObjectHolder.me().set(sysFile);
        return PREFIX + "sysFile_edit.html";
    }

    /**
     * 获取sysFile列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return sysFileService.selectList(null);
    }

    /**
     * 新增sysFile
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(SysFile sysFile) {
        sysFileService.insert(sysFile);
        return SUCCESS_TIP;
    }

    /**
     * 删除sysFile
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer sysFileId) {
        sysFileService.deleteById(sysFileId);
        return SUCCESS_TIP;
    }

    /**
     * 修改sysFile
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SysFile sysFile) {
        sysFileService.updateById(sysFile);
        return SUCCESS_TIP;
    }

    /**
     * sysFile详情
     */
    @RequestMapping(value = "/detail/{sysFileId}")
    @ResponseBody
    public Object detail(@PathVariable("sysFileId") Integer sysFileId) {
        return sysFileService.selectById(sysFileId);
    }

    /**
     * 获取组织生活会的文件列表
     */
    @RequestMapping(value = "/fileList")
    @ResponseBody
    public Object fileList(Integer fileType,String fileId) {
        /*EntityWrapper<SysFile> sysFileEntityWrapper = new EntityWrapper<>();
        Wrapper<SysFile> sysFileWrapper = sysFileEntityWrapper.eq("file_id",fileId);*/
        return sysFileService.getSysFileByFileId(fileId);
    }
}
