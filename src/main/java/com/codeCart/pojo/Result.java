package com.codeCart.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//不添加@Data注解,就不能够使用set,get方法,框架将Controller中的方法映射到Result中不知道如何转换了
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
        return new Result<>(666,message,null);
    }
}
