package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */
@TableName("sys_dept")
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 排序
     */
	private Integer num;
    /**
     * 父部门id
     */
	private Integer pid;
    /**
     * 父级ids
     */
	private String pids;
    /**
     * 简称
     */
	private String simplename;
    /**
     * 全称
     */
	private String fullname;
    /**
     * 提示
     */
	private String tips;
    /**
     * 版本（乐观锁保留字段）
     */
	private Integer version;

	/**
	*部门代码
	**/
	private String dept_no;

	private Integer status;
	private String person;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPids() {
		return pids;
	}

	public void setPids(String pids) {
		this.pids = pids;
	}

	public String getSimplename() {
		return simplename;
	}

	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Dept{" +
			"id=" + id +
			", num=" + num +
			", pid=" + pid +
			", pids=" + pids +
			", simplename=" + simplename +
			", fullname=" + fullname +
			", tips=" + tips +
			", version=" + version +
			"}";
	}
}
