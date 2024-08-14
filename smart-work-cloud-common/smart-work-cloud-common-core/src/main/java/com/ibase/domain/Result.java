package com.ibase.domain;

import com.ibase.constants.Constants;
import java.io.Serializable;
import java.util.HashMap;

/**
 * 统一消息返回实体类
 *
 * @Date 2024-05-02
 * @Author bobiko
 */
public class Result extends HashMap<String, Object> implements Serializable
{
    /**
     * 私有构造方法
     * @param success 成功标识
     * @param code 状态码
     * @param message 异常消息
     * @param data 返回数据
     */
    private Result(Boolean success, Integer code, String message, Object data)
    {
        super.put(Constants.SUCCESS_TAG, success);
        super.put(Constants.CODE_TAG, code);
        super.put(Constants.MSG_TAG, message);
        super.put(Constants.DATA_TAG, data);
    }
    /**
     * 成功调用方法
     */
    public static Result ok(){
        return new Result(Constants.SUCCESS, Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, null);
    }

    public static Result ok(String message){
        return new Result(Constants.SUCCESS, Constants.SUCCESS_CODE, message, null);
    }
    public static Result ok(Object data){
        return new Result(Constants.SUCCESS, Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, data);
    }

    public static Result ok(String message, Object data){
        return new Result(Constants.SUCCESS, Constants.SUCCESS_CODE, message, data);
    }

    public static Result ok(Integer code, Object data){
        return new Result(Constants.SUCCESS, code, Constants.SUCCESS_MESSAGE, data);
    }

    public static Result ok(Integer code, String message){
        return new Result(Constants.SUCCESS, code, message, null);
    }

    public static Result ok(Integer code, String message, Object data){
        return new Result(Constants.SUCCESS, code, message, data);
    }
    /**
     * 失败调用方法
     */
    public static Result fail(){
        return new Result(Constants.FAIL, Constants.FAIL_CODE, Constants.FAIL_MESSAGE, null);
    }

    public static Result fail(String message){
        return new Result(Constants.FAIL, Constants.FAIL_CODE, message, null);
    }
    public static Result fail(Object data){
        return new Result(Constants.FAIL, Constants.FAIL_CODE, Constants.FAIL_MESSAGE, data);
    }

    public static Result fail(String message, Object data){
        return new Result(Constants.FAIL, Constants.FAIL_CODE, message, data);
    }

    public static Result fail(Integer code, Object data){
        return new Result(Constants.FAIL, code, Constants.FAIL_MESSAGE, data);
    }

    public static Result fail(Integer code, String message){
        return new Result(Constants.FAIL, code, message, null);
    }

    public static Result fail(Integer code, String message, Object data){
        return new Result(Constants.FAIL, code, message, data);
    }

    /**
     * 异常调用方法
     */
    public static Result error(){
        return new Result(Constants.ERROR, Constants.ERROR_CODE, Constants.ERROR_MESSAGE, null);
    }

    public static Result error(String message){
        return new Result(Constants.ERROR, Constants.ERROR_CODE, message, null);
    }
    public static Result error(Object data){
        return new Result(Constants.ERROR, Constants.ERROR_CODE, Constants.ERROR_MESSAGE, data);
    }

    public static Result error(String message, Object data){
        return new Result(Constants.ERROR, Constants.ERROR_CODE, message, data);
    }

    public static Result error(Integer code, Object data){
        return new Result(Constants.ERROR, code, Constants.ERROR_MESSAGE, data);
    }

    public static Result error(Integer code, String message){
        return new Result(Constants.ERROR, code, message, null);
    }

    public static Result error(Integer code, String message, Object data){
        return new Result(Constants.ERROR, code, message, data);
    }

    /**
     * 练市调用提供方法，可以自行设置返回数据
     * @param key 返回数据key
     * @param value 返回数据值
     * @return
     */
    public Result put(String key, Object value){
        super.put(key, value);
        return this;
    }

    public Boolean getSuccess() {
        return (Boolean) get("success");
    }

    public void setSuccess(Boolean success) {
        put("success", success);
    }

    public Integer getCode() {
        return (Integer) get("code");
    }

    public void setCode(Integer code) {
       put("code", code);
    }

    public String getMessage() {
        return get("message").toString();
    }

    public void setMessage(String message) {
        put("message", message);
    }

    public Object getData() {
        return get("data");
    }

    public void setData(Object data) {
        put("data", data);
    }
}
