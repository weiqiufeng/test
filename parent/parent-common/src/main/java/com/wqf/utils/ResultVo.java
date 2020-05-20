package com.wqf.utils;



public class ResultVo {

    private Integer code;

    private String msg;

    private Object data;

    private Boolean flag;


    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultVo() {

    }

    public ResultVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;

    }

//    public ResultVo(Boolean flag, Enums enums, Object data) {
//        this.code = enums.getCode();
//        this.msg = enums.getMessage();
//        this.data = data;
//        this.flag= flag;
//    }

    public ResultVo(Boolean flag,Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.flag= flag;
    }

    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", flag=" + flag +
                '}';
    }
}
