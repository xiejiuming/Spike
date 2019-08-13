package com.xjm.spike.common.exception;

import com.xjm.spike.result.CodeMsg;

/**
 * 封装Spike的异常
 *
 * @author xjm
 * @Date 2019/08/04 下午10:32
 */
public class SpikeException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public SpikeException(ServiceExceptionEnum serviceExceptionEnum) {
       super(serviceExceptionEnum.toString());
       this.cm =(CodeMsg)serviceExceptionEnum;
    }


    @Override
    public String getMessage() {
        return cm.getMessage();
    }

    public CodeMsg getCm() {
        return cm;
    }
}
