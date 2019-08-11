package com.xjm.spike.result;

import com.xjm.spike.common.exception.ServiceExceptionEnum;

/**
 * @Description 所有业务异常的枚举
 * @author xjm
 * @date 2019年08月04日 下午5:04:51
 */
public enum CodeMsg implements ServiceExceptionEnum {


	//登录成功
	LOGIN_SYCCESS(200,"登陆成功"),

	//登录成功
	LOGIN_FAIL(100,"登陆失败"),

	//通用的错误码
	SUCCESS(0,"success"),
	SERVER_ERROR(500100,"服务端异常"),
	BIND_ERROR(500101, "参数校验异常：%s"),

	//登录模块 5002XX
	SESSION_ERROR(500210, "Session不存在或者已经失效"),
	PASSWORD_EMPTY(500211, "登录密码不能为空"),
	MOBILE_EMPTY (500212, "手机号不能为空"),
	MOBILE_ERROR (500213, "手机号格式错误"),
	MOBILE_NOT_EXIST (500214, "手机号不存在"),
	PASSWORD_ERROR(500215, "密码错误"),


	//商品模块 5003XX

	//订单模块 5004XX

	//秒杀模块 5005XX

	/**
	 * 字典
	 */
	DICT_EXISTED(400,"字典已经存在"),
	ERROR_CREATE_DICT(500,"创建字典失败"),
	ERROR_WRAPPER_FIELD(500,"包装字典属性失败"),
	ERROR_CODE_EMPTY(500,"字典类型不能为空"),

	/**
	 * 文件上传
	 */
	FILE_READING_ERROR(400,"FILE_READING_ERROR!"),
	FILE_NOT_FOUND(400,"FILE_NOT_FOUND!"),
	UPLOAD_ERROR(500,"上传图片出错"),

	/**
	 * 权限和数据问题
	 */
	DB_RESOURCE_NULL(400,"数据库中没有该资源"),
	NO_PERMITION(405, "权限异常"),
	REQUEST_INVALIDATE(400,"请求数据格式不正确"),
	INVALID_KAPTCHA(400,"验证码不正确"),
	CANT_DELETE_ADMIN(600,"不能删除超级管理员"),
	CANT_FREEZE_ADMIN(600,"不能冻结超级管理员"),
	CANT_CHANGE_ADMIN(600,"不能修改超级管理员角色"),

	/**
	 * 账户问题
	 */
	USER_ALREADY_REG(401,"该用户已经注册"),
	NO_THIS_USER(400,"没有此用户"),
	USER_NOT_EXISTED(400, "没有此用户"),
	ACCOUNT_FREEZED(401, "账号被冻结"),
	OLD_PWD_NOT_RIGHT(402, "原密码不正确"),
	TWO_PWD_NOT_MATCH(405, "两次输入密码不一致"),

	/**
	 * 错误的请求
	 */
	MENU_PCODE_COINCIDENCE(400,"菜单编号和副编号不能一致"),
	EXISTED_THE_MENU(400,"菜单编号重复，不能添加"),
	DICT_MUST_BE_NUMBER(400,"字典的值必须为数字"),
	REQUEST_NULL(400, "请求有错误"),
	SESSION_TIMEOUT(400, "会话超时");

	private CodeMsg(int code, String message) {
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

	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + message + "]";
	}

}
