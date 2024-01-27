package com.codecart.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Result <T>{
    private Integer code;
    private String message;
    private T data;
    /**
     * 创建成功结果
     *
     * @param data 结果数据
     * @return 成功结果
     */
    public static <E> Result<E> success(E data){
        return new Result<>(200,"success",data);
    }
    /**
     * 创建成功结果
     *
     * @return 成功结果
     */
    public static Result success(){
        return new Result<>(200,"success",null);
    }
    /**
     * 创建错误结果
     * @param message 结果信息
     * @return 错误结果
     */
    public static Result error(String message){
        return new Result<>(500,message,null);
    }
}
