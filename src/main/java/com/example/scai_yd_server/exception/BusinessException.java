package com.example.scai_yd_server.exception;

import com.example.scai_yd_server.enums.ResultEnum;
import lombok.*;

/**
 * 业务异常
 *
 * @author csc
 * @date 2018/3/22
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    /**
     * 异常代码
     */
    private int errorCode = ResultEnum.SERVER_ERROR.getCode();
    /**
     * 异常信息
     */
    private String errorMessage;

    public BusinessException(String errorMessage) {
        this.errorCode = ResultEnum.SERVER_ERROR.getCode();
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorCode = ResultEnum.SERVER_ERROR.getCode();
    }

    public BusinessException(int errorCode, String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorCode = errorCode;
    }

}
