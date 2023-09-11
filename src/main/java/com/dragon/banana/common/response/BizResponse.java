package com.dragon.banana.common.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author liulongxiang
 * @Date 2023/9/9 09:47
 * @Description 实体对象 1.0.0
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel
public class BizResponse<T> {
    private boolean success;
    private String message;
    private Integer code;
    private T data;
    private Object extend;

    /**
     * 实例化对象
     *
     * @return BizResponse 对象
     */
    public static <T> BizResponse<T> builder(T data){
        return new BizResponse<T>().setData(data);
    }

    public static BizResponse<Void> builder(){
        return new BizResponse<>();
    }

    public static BizResponse<Void> ok(){
        return builder()
                .setSuccess(true)
                .setCode(ResultCode.SUCCESS.code())
                .setMessage("成功");
    }

    public static BizResponse<Void> okWithBadMessage(String message){
        return builder().setSuccess(true)
                .setCode(ResultCode.SUCCESS.code())
                .setMessage(message);
    }

    public static <T> BizResponse<T> okWithBadMessage(T data, String message){
        return builder(data).setSuccess(true)
                .setCode(ResultCode.PARAM_IS_INVALID.code())
                .setMessage(message);
    }

    public static <T> BizResponse<T> ok(T data){
        return builder(data).setSuccess(true)
                .setCode(ResultCode.SUCCESS.code())
                .setMessage("成功");
    }

    public static <T> BizResponse<T> ok(T data, String message){
        return ok(data).setMessage(message);
    }

    public static <T> BizResponse<T> ok(T data, int code){
        return ok(data).setCode(code);
    }

    public static BizResponse ok(ResultCode resultCode){
        return ok().setCode(resultCode.code())
                .setMessage(resultCode.message());
    }

    public static <T> BizResponse<T> ok(T data, ResultCode resultCode){
        return ok(data).setCode(resultCode.code())
                .setMessage(resultCode.message());
    }

    public static BizResponse<?> fail(){
        return builder()
                .setSuccess(false)
                .setCode(ResultCode.SYSTEM_INNER_BUSY.code())
                .setMessage(ResultCode.SYSTEM_INNER_BUSY.message());
    }

    public static BizResponse<?> fail(String message){
        return fail().setMessage(message);
    }

    public static <T> BizResponse<T> fail(T data){
        return builder(data).setSuccess(false)
                .setCode(ResultCode.SYSTEM_INNER_BUSY.code())
                .setMessage(ResultCode.SYSTEM_INNER_BUSY.message());
    }

    public static <T> BizResponse<T> fail(String message, T data){
        return fail(data).setMessage(message);
    }

    public static BizResponse<?> fail(String message, int code){
        return fail(message).setCode(code);
    }

    public static BizResponse<?> fail(ResultCode resultCode) {
        return fail()
                .setCode(resultCode.code())
                .setMessage(resultCode.message());
    }


    public BizResponse<T> withExtends(Object extend) {
        this.extend = extend;
        return this;
    }

    public static <T> BizResponse<T> ofResultPair(ResultPair<T> resultPair, String badMessage) {
        if (resultPair.isOk()) {
            return BizResponse.ok(resultPair.getResult());
        }
        return BizResponse.ok((T) null)
                .setCode(ResultCode.PARAM_IS_INVALID.code())
                .setMessage(badMessage);
    }

}
