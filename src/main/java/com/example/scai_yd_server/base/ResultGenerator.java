package com.example.scai_yd_server.base;


import com.example.scai_yd_server.enums.ResultEnum;
import com.example.scai_yd_server.exception.BusinessException;
import com.example.scai_yd_server.model.PicInfoModel;
import com.github.pagehelper.PageInfo;

/**
 * BaseResult生成器
 *
 * @author csc
 * @date 2018/4/1
 */
public class ResultGenerator {

    /**
     * 生成返回结果
     *
     * @param code    返回编码
     * @param message 返回消息
     * @param data    返回数据
     * @param <T>     返回数据类型
     * @return 返回结果
     */
    public static <T> Result<T> generate(final int code, final String message, T data) {
        return new Result<>(code, false, message, data);
    }

    /**
     * 操作成功响应结果， 默认结果
     *
     * @return 操作成功的默认响应结果
     */
    public static <T> Result<T> success() {
        return new Result<>(ResultEnum.SUCCESS.getCode(), true, ResultEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 操作成功响应结果， 默认结果
     *
     * @return 操作成功的默认响应结果
     */
    public static <T> Result<T> successNoData(final String message) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), false, message, null);
    }

    /**
     * 操作成功响应结果， 自定义数据及信息
     *
     * @param message 自定义信息
     * @param data    自定义数据
     * @param <T>     自定义数据类型
     * @return 响应结果
     */
    public static <T> Result<T> success(final String message, final T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), true, message, data);
    }

    /**
     * 操作成功响应结果，自定义数据，默认信息
     *
     * @param data 自定义数据
     * @param <T>  自定义数据类型
     * @return 响应结果
     */
    public static <T> Result<T> success(final T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), true, ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> failure(final T data) {
        return new Result<>(ResultEnum.FAIL.getCode(), true, ResultEnum.FAIL.getMessage(), data);
    }

    /**
     * 操作成功响应结果，自定义信息，无数据
     *
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> Result<T> success4Message(final String message) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), true, message, null);
    }

    /**
     * 操作失败响应结果， 默认结果
     *
     * @return 操作成功的默认响应结果
     */
    public static <T> Result<T> failure() {
        return new Result<>(ResultEnum.FAIL.getCode(), false, ResultEnum.FAIL.getMessage(), null);
    }

    /**
     * 操作失败响应结果， 自定义错误编码及信息
     *
     * @param code    自定义错误编码
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> Result<T> failure(final int code, final String message) {
        return new Result<>(ResultEnum.FAIL.getCode(), false, message, null);
    }

    /**
     * 操作失败响应结果， 自定义错误编码及信息
     *
     * @param code    自定义错误编码
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> Result<T> failure(final int code, final String message, T data) {
        return new Result<>(code, false, message, data);
    }

    /**
     * 操作失败响应结果，自定义错误编码
     *
     * @param baseResultEnum 自定义错误编码枚举
     * @return 响应结果
     */
    public static <T> Result<T> failure(final ResultEnum baseResultEnum) {
        return new Result<>(baseResultEnum.getCode(), false, baseResultEnum.getMessage(), null);
    }

    /**
     * 操作失败响应结果，自定义信息
     *
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> Result<T> failure(final String message) {
        return new Result<>(ResultEnum.FAIL.getCode(), false, message, null);
    }

    /**
     * 异常响应结果， 默认结果
     *
     * @return 操作成功的默认响应结果
     */
    public static <T> Result<T> error() {
        return new Result<>(ResultEnum.SERVER_ERROR.getCode(), false, ResultEnum.SERVER_ERROR.getMessage(), null);
    }

    /**
     * 异常响应结果， 自定义错误编码及信息
     *
     * @param code    自定义错误编码
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> Result<T> error(final int code, final String message) {
        return new Result<>(code, false, message, null);
    }

    /**
     * 异常响应结果，自定义错误编码
     *
     * @param baseResultEnum 自定义错误编码枚举
     * @return 响应结果
     */
    public static <T> Result<T> error(final ResultEnum baseResultEnum) {
        return new Result<>(baseResultEnum.getCode(), false, baseResultEnum.getMessage(), null);
    }

    /**
     * 业务异常响应结果
     *
     * @param be 业务异常
     * @return 响应结果
     */
    public static <T> Result<T> error(final BusinessException be) {
        return new Result<>(ResultEnum.SERVER_ERROR.getCode(), false, be.getErrorMessage(), null);
    }

    /**
     * 异常响应结果，自定义信息
     *
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> Result<T> error(final String message) {
        return new Result<>(ResultEnum.SERVER_ERROR.getCode(), false, message, null);
    }

}
