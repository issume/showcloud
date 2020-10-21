package com.showcloud.core.annotate;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @author hym
 * @date 2020/10/21 17:10
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Task {
    String value() default "";
    String key() default "";

}
