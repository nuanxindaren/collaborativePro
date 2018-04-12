package com.common.controller;

/**
 * @author renyangze
 * @date 2018/3/21
 */
public class MessageInfo {
    /**
     * -------------------------------------------------------------------------
     * -------------------------成功/失败状态码(KEY-VALUE)-------------------------
     * ---------------------------------------------------------------------------
     */
    // 操作成功/失败状态的Key内容
    public static final String CODE = "code";

    // 操作成功/失败状态的Value内容
    public static final String CODE_FOR_SUCCESS = "1";
    public static final String CODE_FOR_FAILED = "2";

    /**
     * -------------------------------------------------------------------------
     * --------------------------成功/失败信息(KEY-VALUE)--------------------------
     * ---------------------------------------------------------------------------
     */

    // 操作成功/失败提示信息Key值
    public static final String MSG = "message";

    // 操作添加成功/失败提示信息
    public static final String MSG_FOR_ADD_SUCCESS = "添加成功！";
    public static final String MSG_FOR_ADD_FAILED = "添加失败！";

    // 操作修改成功/失败提示信息
    public static final String MSG_FOR_MODIFY_SUCCESS = "修改成功！";
    public static final String MSG_FOR_MODIFY_FAILED = "修改失败！";

    // 操作删除成功/失败提示信息
    public static final String MSG_FOR_DELETE_SUCCESS = "删除成功！";
    public static final String MSG_FOR_DELETE_FAILED = "删除失败！";

    // 查询提示信息
    public static final String MSG_FOR_SELECT_SUCCESS = "您所查询的信息存在！";
    public static final String MSG_FOR_SELECT_FAILED = "您所查询的信息不存在！";

    // 上传成功/失败提示信息
    public static final String MSG_FOR_UPLOAD_SUCCESS = "文件上传成功！";
    public static final String MSG_FOR_UPLOAD_FAILED = "文件上传失败！";

    // 程序执行错误
    public static final String MSG_FOR_ERROR = "程序执行出错，请查看日志信息并进行处理！";

    // 登录用户名或密码错误
    public static final String MSG_FOR_WRONG_USERNAME_PASSWORD = "您输入的用户名或密码错误，请重新输入！";

    // 注册的手机号已存在
    public static final String MSG_FOR_TEL_EXISTS = "您注册的手机号已存在！";

    // 手机号不存在
    public static final String MSG_FOR_TEL_NOT_EXISTS = "您填写的手机号不存在！";

    // 手机号或短信验证码输入错误
    public static final String MSG_FOR_TEL_AND_MESSAGE_WRONG = "您输入的手机号或短信验证码错误！";

    // 短信验证码输入错误
    public static final String MSG_FOR_MESSAGE_WRONG = "您输入短信验证码错误！";

    // 密码输入错误
    public static final String MSG_FOR_WRONG_PASSWORD = "您输入的密码错误，请重新输入！";

    // 当上传项存在空内容时提示以下信息
    public static final String CHOOSE_PIC_NOT_BLANK = "您上传的内容为空，请选择图片进行上传！";
    // 当上传图片格式与要求(参见fileupload.properties内的配置)不配合时提示以下信息
    public static final String CHOOSE_PIC_WITH_PROPER_TYPE = "您上传的文件格式不正确，请选择图片进行上传！";
    // 当上传图片总字节数超出要求(参见fileupload.properties内的配置)提示以下信息
    public static final String CHOOSE_PIC_WITH_PROPER_SIZE = "您上传的图片过大，请选择合适的图片进行上传！";

}
