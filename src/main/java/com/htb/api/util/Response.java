package com.htb.api.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {
    private int code;
    private Object data;
    private String msg;


    public Response(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static Response buildSuccess(Object data) {
        return new Response(0, data);
    }

    public static Response buildError(String msg) {
        return new Response(-1, "", msg);
    }

    public static Response buildError(int code, String msg) {
        return new Response(code, "", msg);
    }

}
