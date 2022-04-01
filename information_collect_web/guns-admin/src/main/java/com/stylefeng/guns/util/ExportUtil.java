package com.stylefeng.guns.util;

import com.stylefeng.guns.core.util.FileUtil;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Auther: biu
 * @Date: 2021/9/15 16:55
 * @Description:
 */
public class ExportUtil {

    private static final List<String> CELL_HEAD_CN;
    private static final List<String> CELL_HEAD_EN;
    private static final int ZIP_BUFFER_SIZE = 8192;
    private static final String FILE_PATH = System.getProperty("java.io.tmpdir") + File.separator;
    static{
        CELL_HEAD_CN=new ArrayList<>();     CELL_HEAD_EN=new ArrayList<>();

        CELL_HEAD_CN.add("工单状态");                   CELL_HEAD_EN.add("order_state");
        CELL_HEAD_CN.add("当前环节");                      CELL_HEAD_EN.add("current_process");
        CELL_HEAD_CN.add("全业务工单号（必须）");                     CELL_HEAD_EN.add("full_service_no");
        CELL_HEAD_CN.add("项目名称");                     CELL_HEAD_EN.add("project_name");
        CELL_HEAD_CN.add("线上系统工单号");                     CELL_HEAD_EN.add("online_system_no");
        CELL_HEAD_CN.add("产品编号");                     CELL_HEAD_EN.add("product_no");
        CELL_HEAD_CN.add("ESOP订单编号");                     CELL_HEAD_EN.add("esop_no");
        CELL_HEAD_CN.add("工单类型");                     CELL_HEAD_EN.add("order_type");
        CELL_HEAD_CN.add("提单人");                     CELL_HEAD_EN.add("user_name");

        CELL_HEAD_CN.add("业务接入地址");                     CELL_HEAD_EN.add("address");
        CELL_HEAD_CN.add("业务发起分公司");                     CELL_HEAD_EN.add("bussiness_apply_company");
        CELL_HEAD_CN.add("业务接入区域");                     CELL_HEAD_EN.add("bussiness_apply_region");
        CELL_HEAD_CN.add("业务接入片区");                     CELL_HEAD_EN.add("bussiness_apply_network");
        CELL_HEAD_CN.add("业务需求类型");                     CELL_HEAD_EN.add("bussiness_need_type");

        CELL_HEAD_CN.add("施工单位");                     CELL_HEAD_EN.add("construction_unit");
        CELL_HEAD_CN.add("设计单位");                     CELL_HEAD_EN.add("design_unit");
        CELL_HEAD_CN.add("监理单位");                     CELL_HEAD_EN.add("supervision_unit");

        CELL_HEAD_CN.add("网络服务等级");                     CELL_HEAD_EN.add("network_service_level");
        CELL_HEAD_CN.add("客户经理");                     CELL_HEAD_EN.add("client_manager");
        CELL_HEAD_CN.add("客户经理联系方式");                     CELL_HEAD_EN.add("client_manager_phone");
        CELL_HEAD_CN.add("是否大项目");                     CELL_HEAD_EN.add("is_big_project");
        CELL_HEAD_CN.add("大项目名称");                     CELL_HEAD_EN.add("big_project_name");
        CELL_HEAD_CN.add("是否大设备");                     CELL_HEAD_EN.add("big_device");
        CELL_HEAD_CN.add("是否直接装维");                     CELL_HEAD_EN.add("is_directbulid");
        CELL_HEAD_CN.add("X日通");                     CELL_HEAD_EN.add("xday");
        CELL_HEAD_CN.add("资源到达情况");                     CELL_HEAD_EN.add("resource_arrive");
        CELL_HEAD_CN.add("资源标准");                     CELL_HEAD_EN.add("resource_standard");
        CELL_HEAD_CN.add("300/200米内是否有资源");                     CELL_HEAD_EN.add("baimi_is_resource");
        CELL_HEAD_CN.add("驻地网是否需建设管道");                     CELL_HEAD_EN.add("network_build_pipe");
        CELL_HEAD_CN.add("本地网是否需建设管道");                     CELL_HEAD_EN.add("local_build_pipe");
        CELL_HEAD_CN.add("本地网");                     CELL_HEAD_EN.add("local_net");
        CELL_HEAD_CN.add("驻地网");                     CELL_HEAD_EN.add("premise_net");
        CELL_HEAD_CN.add("是否跳纤");                     CELL_HEAD_EN.add("is_tiaoxian");
        CELL_HEAD_CN.add("是否末端光缆施工");                     CELL_HEAD_EN.add("is_end");

        CELL_HEAD_CN.add("管道光缆是否完工（本地网/驻地网）");                     CELL_HEAD_EN.add("pipe_is_finish");

        CELL_HEAD_CN.add("本地预覆盖当前环节");                     CELL_HEAD_EN.add("local_current_process");
        CELL_HEAD_CN.add("驻地预覆盖当前环节");                     CELL_HEAD_EN.add("compound_current_process");

        CELL_HEAD_CN.add("预覆盖施工单位");                     CELL_HEAD_EN.add("cover_work_unit");
        CELL_HEAD_CN.add("预覆盖设计单位");                     CELL_HEAD_EN.add("cover_design_unit");
        CELL_HEAD_CN.add("预覆盖监理单位");                     CELL_HEAD_EN.add("cover_supervise_unit");


        CELL_HEAD_CN.add("ESOP合同是否上传");                     CELL_HEAD_EN.add("esop_contract_is_upload");
        CELL_HEAD_CN.add("创建资源准备单时间");                     CELL_HEAD_EN.add("order_start_time");
        CELL_HEAD_CN.add("资源判断开始时间");                     CELL_HEAD_EN.add("resource_act_time");
        CELL_HEAD_CN.add("资源判断完成时间");                     CELL_HEAD_EN.add("resource_over_time");
        CELL_HEAD_CN.add("铁通资源准备开始时间");                     CELL_HEAD_EN.add("ready_order_tt_act_time");
        CELL_HEAD_CN.add("铁通资源准备完成时间");                     CELL_HEAD_EN.add("ready_order_tt_over_time");
        CELL_HEAD_CN.add("驻地网资源准备开始时间");                     CELL_HEAD_EN.add("ready_order_station_act_time");
        CELL_HEAD_CN.add("驻地网资源准备完成时间");                     CELL_HEAD_EN.add("ready_order_station_over_time");
        CELL_HEAD_CN.add("本地网资源准备开始时间");                     CELL_HEAD_EN.add("ready_order_local_act_time");
        CELL_HEAD_CN.add("本地网资源准备完成时间");                     CELL_HEAD_EN.add("ready_order_local_over_time");
        CELL_HEAD_CN.add("系统设计方案开始时间");                     CELL_HEAD_EN.add("plan_design_act_time");
        CELL_HEAD_CN.add("系统设计方案环节完成时间");                     CELL_HEAD_EN.add("plan_design_over_time");
        CELL_HEAD_CN.add("设计方案开始时间");                     CELL_HEAD_EN.add("design_plan_act_time");
        CELL_HEAD_CN.add("设计方案完成时间");                     CELL_HEAD_EN.add("design_plan_over_time");
        CELL_HEAD_CN.add("跳纤环节到达时间");                     CELL_HEAD_EN.add("jump_line_act_time");
        CELL_HEAD_CN.add("跳纤进场打卡（经纬度）");                     CELL_HEAD_EN.add("problem_feed_back");
        CELL_HEAD_CN.add("跳纤进场时间");                     CELL_HEAD_EN.add("problem_feed_back");
        CELL_HEAD_CN.add("跳纤完成时间");                     CELL_HEAD_EN.add("jump_line_over_time");

        CELL_HEAD_CN.add("光缆施工环节到达时间");                     CELL_HEAD_EN.add("cable_roadwork_act_time");
        CELL_HEAD_CN.add("光缆进场打卡（经纬度）");                     CELL_HEAD_EN.add("cable_work_arrive_latlngx");
        CELL_HEAD_CN.add("光缆进场时间");                     CELL_HEAD_EN.add("cable_work_arrive_time");
        CELL_HEAD_CN.add("光缆施工完成时间");                     CELL_HEAD_EN.add("cable_roadwork_over_time");
        CELL_HEAD_CN.add("安装设备环节到达时间");                     CELL_HEAD_EN.add("install_device_act_time");
        CELL_HEAD_CN.add("设备安装进场打卡（经纬度）");                     CELL_HEAD_EN.add("problem_feed_back");
        CELL_HEAD_CN.add("设备安装进场时间");                     CELL_HEAD_EN.add("problem_feed_back");
        CELL_HEAD_CN.add("设备安装完成时间");                     CELL_HEAD_EN.add("install_device_over_time");
        CELL_HEAD_CN.add("组织交维完成时间");                     CELL_HEAD_EN.add("tissue_code_over_time");
        CELL_HEAD_CN.add("确认交维完成时间");                     CELL_HEAD_EN.add("ensure_code_over_time");


        //预覆盖环节时间
        CELL_HEAD_CN.add("驻地网设计方案开始时间");                     CELL_HEAD_EN.add("design_plan_station_act_time");
        CELL_HEAD_CN.add("驻地网设计方案完成时间");                     CELL_HEAD_EN.add("design_plan_station_over_time");
        CELL_HEAD_CN.add("驻地网管道光缆建设开始时间");                     CELL_HEAD_EN.add("cable_roadwork_station_act_time");
        CELL_HEAD_CN.add("驻地网管道光缆建设完成时间");                     CELL_HEAD_EN.add("cable_roadwork_station_over_time");
        CELL_HEAD_CN.add("驻地网管道打卡时间");                     CELL_HEAD_EN.add("compound_in_time");
        CELL_HEAD_CN.add("驻地网管道光缆完工开始时间");                     CELL_HEAD_EN.add("cable_complete_station_act_time");
        CELL_HEAD_CN.add("驻地网管道光缆完工完成时间");                     CELL_HEAD_EN.add("cable_complete_station_over_time");



        CELL_HEAD_CN.add("挂起发起时间");                     CELL_HEAD_EN.add("hang_up_act_time");
        CELL_HEAD_CN.add("挂起审核完成时间");                     CELL_HEAD_EN.add("hang_up_verify_time");
        CELL_HEAD_CN.add("解挂时间");                     CELL_HEAD_EN.add("relieve_hang_up_time");
        CELL_HEAD_CN.add("资源判断环节时长（天）");                     CELL_HEAD_EN.add("resource_judge_duration");
        CELL_HEAD_CN.add("铁通资源准备单环节时长（天）");                     CELL_HEAD_EN.add("ready_order_tt_duration");
        CELL_HEAD_CN.add("驻地网资源准备单环节时长（天）");                     CELL_HEAD_EN.add("ready_order_station_duration");
        CELL_HEAD_CN.add("本地网网资源准备单环节时长（天）");                     CELL_HEAD_EN.add("ready_order_local_duration");
        CELL_HEAD_CN.add("系统方案设计环节时长（天）");                     CELL_HEAD_EN.add("plan_design_duration");
        CELL_HEAD_CN.add("网管审批环节时长（天）");                     CELL_HEAD_EN.add("net_verify_duration");
        CELL_HEAD_CN.add("创建开通单环节时长（天）");                     CELL_HEAD_EN.add("create_order_duration");
        CELL_HEAD_CN.add("设计方案环节时长（天）");                     CELL_HEAD_EN.add("createorder_design_plan_duration");
        CELL_HEAD_CN.add("审批方案环节时长（天）");                     CELL_HEAD_EN.add("createorder_verify_duration");
        CELL_HEAD_CN.add("核查数据环节时长（天）");                     CELL_HEAD_EN.add("createorder_check_data_duration");
        CELL_HEAD_CN.add("跳纤环节时长（天）");                     CELL_HEAD_EN.add("createorder_jump_line_duration");
        CELL_HEAD_CN.add("末端光缆施工环节时长（天）");                     CELL_HEAD_EN.add("createorder_cable_roadwork_duration");
        CELL_HEAD_CN.add("设备安装环节时长（天）");                     CELL_HEAD_EN.add("createorder_install_device_duration");
        CELL_HEAD_CN.add("组织交维环节时长（天）");                     CELL_HEAD_EN.add("createorder_tissue_code_duration");
        CELL_HEAD_CN.add("确认交维环节时长（天）");                     CELL_HEAD_EN.add("createorder_ensure_code_duration");
        CELL_HEAD_CN.add("本地网覆盖工单环节时长（天）");                     CELL_HEAD_EN.add("coverorder_local_duration");
        CELL_HEAD_CN.add("本地网设计方案环节时长（天）");                     CELL_HEAD_EN.add("coverorder_design_plan_local_duration");
        CELL_HEAD_CN.add("本地网管道施工环节时长（天）");                     CELL_HEAD_EN.add("coverorder_cable_roadwork_local_duration");
        CELL_HEAD_CN.add("本地网管道完成环节时长（天）");                     CELL_HEAD_EN.add("coverorder_cable_complete_local_duration");
        CELL_HEAD_CN.add("驻地网覆盖工单环节时长（天）");                     CELL_HEAD_EN.add("coverorder_station_duration");
        CELL_HEAD_CN.add("驻地网设计方案环节时长（天）");                     CELL_HEAD_EN.add("coverorder_design_plan_station_duration");
        CELL_HEAD_CN.add("驻地网管道施工环节时长（天）");                     CELL_HEAD_EN.add("coverorder_cable_roadwork_station_duration");
        CELL_HEAD_CN.add("驻地网管道完成环节时长（天）");                     CELL_HEAD_EN.add("coverorder_cable_complete_station_duration");
        CELL_HEAD_CN.add("需开通外线数量（铁通直线号码）");                     CELL_HEAD_EN.add("audio_line_number");
        CELL_HEAD_CN.add("需开通外线数量（客户分级号码）");                     CELL_HEAD_EN.add("audio_out_number");
        CELL_HEAD_CN.add("是否保留其他运营商外线数量（电信）");                     CELL_HEAD_EN.add("audio_other_number");
        CELL_HEAD_CN.add("是否做综合集团V网");                     CELL_HEAD_EN.add("audio_is_v");
        CELL_HEAD_CN.add("IP数量需求");                     CELL_HEAD_EN.add("ip_num");
        CELL_HEAD_CN.add("需提供端口类型");                     CELL_HEAD_EN.add("need_provide_type");
        CELL_HEAD_CN.add("是否免费提供路由");                     CELL_HEAD_EN.add("is_provide_route");
        CELL_HEAD_CN.add("接入方式");                     CELL_HEAD_EN.add("implement_type");
        CELL_HEAD_CN.add("上行带宽（M）");                     CELL_HEAD_EN.add("top_band");
        CELL_HEAD_CN.add("下行带宽（M）");                     CELL_HEAD_EN.add("bottom_band");
        CELL_HEAD_CN.add("综合布线");                     CELL_HEAD_EN.add("generic_cabling");
        CELL_HEAD_CN.add("是否有预接入单");                     CELL_HEAD_EN.add("is_have_ready_implement");
        CELL_HEAD_CN.add("业务需求描述");                     CELL_HEAD_EN.add("bussiness_need_remark");
        CELL_HEAD_CN.add("工程信息说明");                     CELL_HEAD_EN.add("engineer_info");
        CELL_HEAD_CN.add("客户管线接入方式");                     CELL_HEAD_EN.add("cilent_pipeline_way");
        CELL_HEAD_CN.add("客户设备接入方式");                     CELL_HEAD_EN.add("cilent_device_way");
        CELL_HEAD_CN.add("Z端机房经度");                     CELL_HEAD_EN.add("z_computer_room_dimension");
        CELL_HEAD_CN.add("Z端机房纬度");                     CELL_HEAD_EN.add("z_computer_room_longitude");
        CELL_HEAD_CN.add("是否新增分光器");                     CELL_HEAD_EN.add("is_new_fgq");
        CELL_HEAD_CN.add("分光器");                     CELL_HEAD_EN.add("fgq");
        CELL_HEAD_CN.add("建设内容");                     CELL_HEAD_EN.add("build_content");
        CELL_HEAD_CN.add("Z端楼宇名称");                     CELL_HEAD_EN.add("z_building_name");
        CELL_HEAD_CN.add("Z端楼宇编码");                     CELL_HEAD_EN.add("z_building_code");
        CELL_HEAD_CN.add("Z端机房详细地址");                     CELL_HEAD_EN.add("z_building_addr");
        CELL_HEAD_CN.add("A端楼宇名称");                     CELL_HEAD_EN.add("a_building_name");
        CELL_HEAD_CN.add("A端楼宇编码");                     CELL_HEAD_EN.add("a_building_code");
        CELL_HEAD_CN.add("A端机房详细地址");                     CELL_HEAD_EN.add("a_building_addr");
        CELL_HEAD_CN.add("挂起类型");                     CELL_HEAD_EN.add("hang_type");
        CELL_HEAD_CN.add("挂起备注");                     CELL_HEAD_EN.add("hang_remark");

        CELL_HEAD_CN.add("资源判断退回用时");                     CELL_HEAD_EN.add("resource_back_total_time");
        CELL_HEAD_CN.add("铁通现场资源准备单退回用时");           CELL_HEAD_EN.add("scene_back_total_time");
        CELL_HEAD_CN.add("本地网现场资源准备单退回用时");                     CELL_HEAD_EN.add("local_back_total_time");
        CELL_HEAD_CN.add("驻地网现场资源准备单退回用时");                     CELL_HEAD_EN.add("compound_back_total_time");
        CELL_HEAD_CN.add("系统方案设计退回用时");                     CELL_HEAD_EN.add("system_back_total_time");
        CELL_HEAD_CN.add("网管审批退回用时");                     CELL_HEAD_EN.add("web_back_total_time");
        CELL_HEAD_CN.add("创建开通单退回用时");                     CELL_HEAD_EN.add("create_back_total_time");

        CELL_HEAD_CN.add("本地网预覆盖工单退回用时");                     CELL_HEAD_EN.add("local_cover_order_back_total_time");
        CELL_HEAD_CN.add("驻地网预覆盖工单退回用时");                     CELL_HEAD_EN.add("compound_cover_order_back_total_time");
        CELL_HEAD_CN.add("本地网预覆盖工单设计方案退回用时");                     CELL_HEAD_EN.add("local_cover_design_back_total_time");
        CELL_HEAD_CN.add("驻地网预覆盖工单设计方案退回用时");                     CELL_HEAD_EN.add("compound_cover_design_back_total_time");
        CELL_HEAD_CN.add("本地网预覆盖工单施工退回用时");                     CELL_HEAD_EN.add("local_cover_pipeline_back_total_time");
        CELL_HEAD_CN.add("驻地网预覆盖工单施工退回用时");                     CELL_HEAD_EN.add("compound_cover_pipeline_back_total_time");
        CELL_HEAD_CN.add("本地网预覆盖工单完工退回用时");                     CELL_HEAD_EN.add("local_cover_over_back_total_time");
        CELL_HEAD_CN.add("驻地网预覆盖工单完工退回用时");                     CELL_HEAD_EN.add("compound_cover_over_back_total_time");
        //挂起用时
        CELL_HEAD_CN.add("资源判断挂起用时");                     CELL_HEAD_EN.add("resource_hang_total_time");
        CELL_HEAD_CN.add("铁通现场资源准备单挂起用时");                     CELL_HEAD_EN.add("scene_hang_total_time");
        CELL_HEAD_CN.add("本地网现场资源准备单挂起用时");                     CELL_HEAD_EN.add("local_hang_total_time");
        CELL_HEAD_CN.add("驻地网现场资源准备单挂起用时");                     CELL_HEAD_EN.add("compound_hang_total_time");
        CELL_HEAD_CN.add("系统方案设计挂起用时");                     CELL_HEAD_EN.add("system_hang_total_time");
        CELL_HEAD_CN.add("网管审批挂起用时");                     CELL_HEAD_EN.add("web_hang_total_time");
        CELL_HEAD_CN.add("创建开通单挂起用时");                     CELL_HEAD_EN.add("create_hang_total_time");
        CELL_HEAD_CN.add("设计方案挂起用时");                     CELL_HEAD_EN.add("design_hang_total_time");
        CELL_HEAD_CN.add("审批方案挂起用时");                     CELL_HEAD_EN.add("verify_hang_total_time");
        CELL_HEAD_CN.add("核查数据挂起用时");                     CELL_HEAD_EN.add("check_hang_total_time");
        CELL_HEAD_CN.add("跳纤挂起用时");                     CELL_HEAD_EN.add("jump_hang_total_time");
        CELL_HEAD_CN.add("末端光缆施工挂起用时");                     CELL_HEAD_EN.add("end_hang_total_time");
        CELL_HEAD_CN.add("安装设备挂起用时");                     CELL_HEAD_EN.add("install_hang_total_time");
        CELL_HEAD_CN.add("组织交维挂起用时");                     CELL_HEAD_EN.add("organization_hang_total_time");
        CELL_HEAD_CN.add("确认交维挂起用时");                     CELL_HEAD_EN.add("confirm_hang_total_time");
        //预覆盖挂起用时
        CELL_HEAD_CN.add("本地网预覆盖工单挂起用时");                     CELL_HEAD_EN.add("local_cover_hang_total_time");
        CELL_HEAD_CN.add("驻地网预覆盖工单挂起用时");                     CELL_HEAD_EN.add("compound_cover_hang_total_time");
        CELL_HEAD_CN.add("本地网预覆盖工单设计方案挂起用时");                     CELL_HEAD_EN.add("local_design_scheme_hang_total_time");
        CELL_HEAD_CN.add("驻地网预覆盖工单设计方案挂起用时");                     CELL_HEAD_EN.add("compound_design_scheme_hang_total_time");
        CELL_HEAD_CN.add("本地网预覆盖工单施工挂起用时");                     CELL_HEAD_EN.add("local_pipeline_construction_hang_total_time");
        CELL_HEAD_CN.add("驻地网预覆盖工单施工挂起用时");                     CELL_HEAD_EN.add("compound_pipeline_construction_hang_total_time");
        CELL_HEAD_CN.add("本地网预覆盖工单完工挂起用时");                     CELL_HEAD_EN.add("local_pipeline_finish_hang_total_time");
        CELL_HEAD_CN.add("驻地网预覆盖工单完工挂起用时");                     CELL_HEAD_EN.add("compound_pipeline_finish_hang_total_time");
    }


    public static Workbook exportData(List<Map<String, Object>> exportList) {
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = buildDataSheet(workbook);
        int rowNum=1;
        for(int i=0;i<exportList.size();i++){
            if(exportList.get(i)==null){
                continue;
            }
            Row row=sheet.createRow(rowNum++);
            convertDataToRow(exportList.get(i),row);
        }
        return workbook;

    }

    /**
     * 设置第一行格式
     *
     * @param workbook
     * @return
     */
    public static CellStyle buildHeadCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        //水平左边对齐
        style.setAlignment(HorizontalAlignment.LEFT);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //字体设置
        Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);
        return style;
    }

    /**
     * 生成sheet表，并写入第一行数据（列头）
     *
     * @param workbook
     * @return
     */
    private static Sheet buildDataSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        //设置默认行高
        sheet.setDefaultRowHeight((short) 400);
        CellStyle cellStyle = buildHeadCellStyle(workbook);
        //设置列头宽度，写入表头
        Row head = sheet.createRow(0);
        for (int i = 0; i < CELL_HEAD_CN.size(); i++) {
            sheet.setColumnWidth(i, 4000);
            Cell cell = head.createCell(i);
            cell.setCellValue(CELL_HEAD_CN.get(i));
            cell.setCellStyle(cellStyle);
            CellStyle textCellStyle = workbook.createCellStyle();
            //将所有列设为字符串格式
            textCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("@"));
            sheet.setDefaultColumnStyle(i, textCellStyle);
        }
        return sheet;
    }

    private static void convertDataToRow(Map<String, Object> data, Row row) {
        int cellNum = 0;
        Cell cell;
        for(int i=0;i<CELL_HEAD_CN.size();i++){
            cell=row.createCell(cellNum++);
            if(data.get(CELL_HEAD_EN.get(i))!=null){
                cell.setCellValue(data.get(CELL_HEAD_EN.get(i)).toString());
            }else{
                cell.setCellValue("--");
            }

        }
    }

    private static String getObjectValue(Object object) {
        String clz = "";
        if (object != null) {
            clz = object.getClass().getName();
            int index = clz.lastIndexOf(".");
            clz = clz.substring(index + 1);
        }
        return clz;
    }

    /**
     * 通过单号判断日期，获取month个月内的所有单号
     *
     * @param dataList
     * @param interval
     * @return
     */
    public static List<String> getLimitTimeOrder(List<String> dataList, int interval) {
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int month;
        List<String> result = new ArrayList<>();
        for (String num : dataList) {
            String[] temp = num.split("-");
            String str = temp[temp.length-2];
            str = str.substring(4, 6);
            month = Integer.parseInt(str);
            if (currentMonth - month < interval) {
                result.add(num);
            }
        }
        return result;
    }



    public static void zipDownload(HttpServletResponse response, String zipFileName, List<File> fileList) {
        // zip文件路径
        String zipPath = FILE_PATH + zipFileName;
        try {
            //创建zip输出流
            try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipPath))) {
                //声明文件集合用于存放文件
                byte[] buffer = new byte[1024];
                //将文件放入zip压缩包
                for (int i = 0; i < fileList.size(); i++) {
                    File file = fileList.get(i);
                    try (FileInputStream fis = new FileInputStream(file)) {
                        out.putNextEntry(new ZipEntry(file.getName()));
                        int len;
                        // 读入需要下载的文件的内容，打包到zip文件
                        while ((len = fis.read(buffer)) > 0) {
                            out.write(buffer, 0, len);
                        }
                        out.closeEntry();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println(FileUtil.delete(file));
                }
            }
            //下载zip文件
            downFile(response, zipFileName);
        } catch (Exception e) {
        } finally {
            // zip文件也删除
            fileList.add(new File(zipPath));
//            deleteFile(fileList);
        }
    }
    private static void downFile(HttpServletResponse response, String zipFileName) {
        try {
            String path = FILE_PATH + zipFileName;
            File file = new File(path);
            if (file.exists()) {
                try (InputStream ins = new FileInputStream(path);
                     BufferedInputStream bins = new BufferedInputStream(ins);
                     OutputStream outs = response.getOutputStream();
                     BufferedOutputStream bouts = new BufferedOutputStream(outs)) {
                    response.setContentType("application/x-download");
                    response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(zipFileName, "UTF-8"));
                    int bytesRead = 0;
                    byte[] buffer = new byte[ZIP_BUFFER_SIZE];
                    while ((bytesRead = bins.read(buffer, 0, ZIP_BUFFER_SIZE)) != -1) {
                        bouts.write(buffer, 0, bytesRead);
                    }
                    bouts.flush();
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * 删除文件
     *
     * @param fileList
     * @return
     */
    public static void deleteFile(List<File> fileList) {
        for (File file : fileList) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
    /**
    *通用导出方法
    **/
    public static Workbook exportDataCommon(List<Map<String, Object>> exportList, List<String> HeadList,List<String> BodyList) {
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = buildDataSheetCommon(workbook,HeadList);
        int rowNum=1;
        for(int i=0;i<exportList.size();i++){
            if(exportList.get(i)==null){
                continue;
            }
            Row row=sheet.createRow(rowNum++);
            convertDataToRowCommon(exportList.get(i),row,HeadList,BodyList);
        }
        return workbook;

    }

    private static Sheet buildDataSheetCommon(Workbook workbook,List<String> HeadList) {
        Sheet sheet = workbook.createSheet();
        //设置默认行高
        sheet.setDefaultRowHeight((short) 400);
        CellStyle cellStyle = buildHeadCellStyle(workbook);
        //设置列头宽度，写入表头
        Row head = sheet.createRow(0);
        for (int i = 0; i < HeadList.size(); i++) {
            sheet.setColumnWidth(i, 4000);
            Cell cell = head.createCell(i);
            cell.setCellValue(HeadList.get(i));
            cell.setCellStyle(cellStyle);
            CellStyle textCellStyle = workbook.createCellStyle();
            //将所有列设为字符串格式
            textCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("@"));
            sheet.setDefaultColumnStyle(i, textCellStyle);
        }
        return sheet;
    }

    private static void convertDataToRowCommon(Map<String, Object> data, Row row, List<String> HeadList,List<String> BodyList) {
        int cellNum = 0;
        Cell cell;
        for(int i=0;i<HeadList.size();i++){
            cell=row.createCell(cellNum++);
            if(data.get(BodyList.get(i))!=null){
                cell.setCellValue(data.get(BodyList.get(i)).toString());
            }else{
                cell.setCellValue("--");
            }

        }
    }
}
