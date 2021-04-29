package fengge.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Feng, Ge 2021/4/29 0029 17:00
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SelfConstraintValidator.class)
public @interface SelfConstraint {
    String message() default "参数超出范围，校验不通过";;
    long min();
    long max();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}