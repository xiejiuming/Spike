package com.xjm.spike.common.exception;

/**
 * 抽象接口
 *
 * @author xjm
 * @Date 2019/08/04 下午10:32
 */
public interface ServiceExceptionEnum {

    /**
     * 获取异常编码
     */
    Integer getCode();

    /**
     * 获取异常信息
     */
    String getMessage();
}
