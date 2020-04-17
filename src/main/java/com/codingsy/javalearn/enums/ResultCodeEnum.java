package com.codingsy.javalearn.enums;

/**
 * @desc 错误码枚举类
 * @author shaoying
 * @date 2019-11-19 18:56:59
 */
public enum ResultCodeEnum {
    /**
     *
     */
    ERR_OK(0, "ok"),

    ERR_INVALID_PARAM(1000, "参数错误"),
    ERR_EMPTY_PARAM(1001, "param is empty"),
    ERR_ACCESS_TOKEN(1002, "未登录，请稍后重试"),
    ERR_ACCESS_SIGN(1003, "验签失败，请稍后重试"),
    ERR_PROCESSING(1004, "处理中"),
    ERR_TIMEOUT(1005, "系统超时"),
    ERR_RECEIVEACCOUNT_CANNOT_IS_MYSELF(1006, "接收方不支持为自己"),
    ORDER_NOT_EXIST(1007, "订单记录不存在"),
    AMOUNT_OVERDUE(1008, "分账金额不足(已经分账完成请勿重复调用)"),


    PERMISSION_DENIED(9995,"权限不足"),
    PARAM_NOT_VALID(9996,"参数非法"),
    ERR_THIRDPAY(9997,"三方接口异常"),
    ERR_SYSTEM(9998,"系统异常,请稍后重试"),
    ERR_UNKNOWN(9999, "未知异常");

    /** 错误码 **/
    private Integer errCode;

    /** 错误信息 **/
    private String msg;

    ResultCodeEnum(Integer errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getMsg() {
        return msg;
    }
}
