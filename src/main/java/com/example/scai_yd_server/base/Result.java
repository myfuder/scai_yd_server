package com.example.scai_yd_server.base;

import com.example.scai_yd_server.enums.ResultEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;

/**
 * 响应结果
 * 如果使用注解@JsonInclude(JsonInclude.Include.NON_NULL)： 则会保证序列化json的时候,如果是null的对象,key也会消失
 *
 * @author csc
 * @date 2018/3/21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private Integer code;

    private boolean success;

    private String message;

    private T data;

    /**
     * 判断是否是成功结果
     * JsonIgnore使之不在json序列化结果当中
     *
     * @return 是否为成功结果
     */
    @JsonIgnore
    public boolean isSuccess() {
        return ResultEnum.SUCCESS.getCode() == this.code;
    }
}

