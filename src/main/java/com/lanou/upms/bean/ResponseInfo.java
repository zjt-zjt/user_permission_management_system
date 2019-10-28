package com.lanou.upms.bean;

public class ResponseInfo {
    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {

        String dataJson = null;
        if(getData() instanceof String) {

            dataJson = (String) getData();

            if(dataJson.startsWith("{")) {

            } else {
                dataJson = "\""+getData()+"\"";
            }
        }
        return "{\"code\":" + code + ", \"message\":\"" + message + "\", \"data\":" + dataJson + "}";
    }

}