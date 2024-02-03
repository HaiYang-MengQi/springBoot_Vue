package com.codeCart.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message<T> {
    private Integer code;
    private Integer fromName;
    private Integer toName;
    private T data;
    public static <E> Message<E> success(Integer fromName,Integer toName,E data){
        return new Message<>(200, fromName, toName, data);
    }
    public static <String> Message<String> error(String message){
        return new Message<>(-1,null,null,message);
    }
}
