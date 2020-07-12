package com.example.demo.response;

import lombok.Data;

@Data
public class AjaxResponse {

    private boolean isOk;

    private int code;//200,400,500

    private String message;

    private Object obj;

    private AjaxResponse() {
    }

    public static AjaxResponse successDone() {

        AjaxResponse ajaxResponse = new AjaxResponse();

        ajaxResponse.isOk = true;
        ajaxResponse.code = 200;
        ajaxResponse.message = "请求成功";

        return ajaxResponse;

    }

    public static AjaxResponse successDone(Object obj) {

        AjaxResponse ajaxResponse = new AjaxResponse();

        ajaxResponse.isOk = true;
        ajaxResponse.code = 200;
        ajaxResponse.message = "请求成功";
        ajaxResponse.obj = obj;

        return ajaxResponse;

    }

}
