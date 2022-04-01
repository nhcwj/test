package com.stylefeng.guns.core.exception;

/**
 * Guns异常枚举
 *
 * @author fengshuonan
 * @Date 2017/12/28 下午10:33
 */
public enum SelfExceptionEnum implements ServiceExceptionEnum{

	/**
	 * 其他
	 */
	WRITE_ERROR(500,"渲染界面错误"),
	/**
	*规则有误
	**/
	RULE_ERROE(500,"规则有误"),
	/**
	 * 文件上传
	 */
	FILE_READING_ERROR(400,"FILE_READING_ERROR!"),
	FILE_NOT_FOUND(400,"FILE_NOT_FOUND!"),

	/**
	 * 指派任务异常
	 */
	TASK_EXIST(500, "您选中的记录中存在被指派过的记录，不能重复指派哦");

	SelfExceptionEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	private Integer code;

	private String message;

	@Override
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
