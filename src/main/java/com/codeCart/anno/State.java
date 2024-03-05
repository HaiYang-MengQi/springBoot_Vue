package com.codeCart.anno;

import com.codeCart.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})//标注注解应用范围
@Retention(RetentionPolicy.RUNTIME) //元注解,运行时注解
@Documented //元注解,可以抽取到帮助文档里面
@Constraint(
        validatedBy = {StateValidation.class}
)
public @interface State {
    //提供校验失败的信息
    String message() default "文章必须是:已发布或草稿";
    //指定分组
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
