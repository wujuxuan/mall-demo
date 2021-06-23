package com.wubaba.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 响应代码
     */
    public Integer code;
    /**
     * 响应数据
     */
    public T data;

    /**
     * 响应消息
     */
    public String msg;
    public R(Integer code , String msg , T data){
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public R(){

    }
    /**
     * 响应成功并携带消息
     * @param msg
     * @param data
     * @param <E>
     * @return
     */
    public static <E> R success(String msg, E data){
        return new R<E>(200,msg,data);
    }

    /**
     * 响应成功不携带数据
     * @param msg
     * @param <E>
     * @return
     */
    public static <E> R success(String msg){
        return new R<E>(200,msg,null);
    }

    /**
     * 失败携带数据
     * @param msg
     * @param data
     * @param <E>
     * @return
     */
    public static <E> R field(String msg, E data){
        return new R<>(200,msg,data);
    }

    /**
     * 失败不携带数据
     * @param msg
     * @param <E>
     * @return
     */
    public static <E> R field(String msg){
        return new R<>(400,msg,null);
    }
    public static <E> R field(Integer code ,String msg){
        return new R<>(code,msg,null);
    }
}
