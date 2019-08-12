package com.xjm.spike.result;

public class Result<T> {

    private int code;
    private String msg;
    private T data;


    public int getStatus() {
        return code;
    }

    public void setStatus(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
     *  成功时候的调用
     * */
    public static  <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     *  失败时候的调用
     * */
    public static  <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }


    /**
     *  失败时候的调用
     * */
    public static  <T> Result<T> error(int code, String msg){

        return new Result<T>(code,msg);
    }

    private Result(T data) {
        this.data = data;
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(CodeMsg codeMsg) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMessage();
        }
    }

}
