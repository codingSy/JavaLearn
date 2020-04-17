package com.codingsy.javalearn.enums;

/**
 * @author shaoying
 */
public enum  ErrorDtlEnum {
    /**
     * 正常
     */
    ERR_OK("00000000", "ok", ResultCodeEnum.ERR_OK),

    /**
     * 参数校验错误
     */
    PARA_NOT_VALID("00001001", "参数不合法", ResultCodeEnum.ERR_INVALID_PARAM),
    PARA_NOT_BLANK("00001002", "必填参数不能为空", ResultCodeEnum.ERR_EMPTY_PARAM),
    USERID_NOT_VALID("00001003", "用户ID非法", ResultCodeEnum.ERR_INVALID_PARAM),
    APPID_NOT_VALID("00001004", "应用ID非法", ResultCodeEnum.ERR_INVALID_PARAM),
    PLATFORM_NOT_VALID("00001005", "平台类型错误", ResultCodeEnum.ERR_INVALID_PARAM),
    PAYCHANNEL_NOT_VALID("00001006", "支付渠道非法", ResultCodeEnum.PARAM_NOT_VALID),
    PAYMODEL_NOT_VALID("00001007", "支付方式非法", ResultCodeEnum.PARAM_NOT_VALID),
    PERMISSION_DENIED("00001008", "权限不足", ResultCodeEnum.PERMISSION_DENIED),

    // ~~~~~~~~~~~~~~~~~~~~~~ 2001~9999之间序号表示业务错误 ~~~~~~~~~~~~~~~~~~~~
    UNKNOWN_ERROR("00009999","未知异常",ResultCodeEnum.ERR_UNKNOWN),
    ;

    // ~~~~~~~~~~~~~~~~~~ 枚举的成员变量 ~~~~~~~~~~~~~~~~~~~
    /**错误码 */
    private String errCode;

    /**错误描述 */
    private String errDesc;

    /** 返回码的枚举 **/
    private ResultCodeEnum resultCodeEnum;

    /**
     * 构造方法
     * @param errCode
     * @param errDesc
     * @param resultCodeEnum
     */
    ErrorDtlEnum(String errCode, String errDesc, ResultCodeEnum resultCodeEnum) {
        this.errCode = errCode;
        this.errDesc = errDesc;
        this.resultCodeEnum = resultCodeEnum;
    }

    public ResultCodeEnum getResultCodeEnum() {
        return resultCodeEnum;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }
}
