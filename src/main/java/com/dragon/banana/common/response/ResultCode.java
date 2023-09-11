package com.dragon.banana.common.response;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wnagchao
 * @date: 2018/9/30 11:41
 * @Description: API 统一返回状态码
 */
public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(10000, "成功"),

    /* 参数相关：20001-29999 */
    PARAM_IS_INVALID(20001, "参数无效"),
    PARAM_IS_BLANK(20002, "参数为空"),
    PARAM_TYPE_ERROR(20003, "参数类型错误"),
    PARAM_NOT_COMPLETE(20004, "参数缺失"),
    PARAM_DUPLICATE_KEY(20005, "参数重复"),

    /* 账号相关：30001-39999*/
    USER_NOT_LOGGED_IN(30001, "用户未登录"),
    USER_LOGIN_ERROR(30002, "账号或密码错误"),
    USER_ACCOUNT_LOCKED(30003, "账号已被锁定"),
    USER_NOT_EXIST(30004, "用户不存在"),
    PHONE_HAS_USED(30005, "该手机号已被注册"),
    SMS_CODE_EXPIRE(30006, "短信验证码已失效"),
    SMS_CODE_ERROR(30007, "短信验证码错误"),
    OLD_PASSWORD_ERROR(30008, "旧密码错误"),


    /* 权限错误：40001-49999 */
    PERMISSION_NO_ACCESS(40001, "您没有权限访问"),
    ACCOUNT_REPEAT_LOGIN(40002, "您的账号已在其他设备上重复登录"),
    ACCOUNT_NO_ENOUGH_PERMISSION(40003, "您的账号权限不足"),
    WX_CODE_INVALID(40004, "code无效"),


    /* 业务相关 50001-59999 */
    PLEASE_UNLOCK_LESSON(50001, "请先解锁课程"),
    ALREADY_ENROLL(50002, "该手机号已报名"),
    CLASSNAME_ALREADY_EXIST(50003, "班级名称重复,请修改!"),
    CLASS_PERMISSION_NOTALLOWED(50004, "无法操作其他老师的班级哦"),
    CLASSRECORD_PERMISSION_NOTALLOWED(50005, "无法操作其他老师的上课记录哦"),
    REVISIT_RECORD_NOT_EXIST(50006, "回访记录不存在"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),
    INTERFACE_TALKWORK_ERROR(60007, "话术变量替换失败"),
    INTERFACE_SMSID_ERROR(60008, "短信发送失败"),
    INTERFACE_PROVIDER_ERROR(60009, "服务提供方接口内部异常"),

    /* 系统错误：90001-99999 */
    SYSTEM_INNER_BUSY(90001, "系统繁忙，请稍后重试"),
    SYSTEM_INNER_ERROR(99999, "系统内部异常");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(Integer code) {
        for (ResultCode item : ResultCode.values()) {
            if (item.code().equals(code)) {
                return item.message;
            }
        }
        return null;
    }

    public static Integer getCode(String message) {
        for (ResultCode item : ResultCode.values()) {
            if (item.message().equals(message)) {
                return item.code;
            }
        }
        return PARAM_IS_INVALID.code;
    }

    @Override
    public String toString() {
        return this.name();
    }

    //校验重复的code值
    public static void main(String[] args) {
        ResultCode[] apiResultCodes = ResultCode.values();
        List<Integer> codeList = new ArrayList<Integer>();
        for (ResultCode apiResultCode : apiResultCodes) {
            if (codeList.contains(apiResultCode.code)) {
                System.out.println(apiResultCode.code);
            } else {
                codeList.add(apiResultCode.code());
            }
        }
    }
}
