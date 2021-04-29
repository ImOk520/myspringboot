package fengge.annotation;

import cn.hutool.core.lang.Console;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Feng, Ge 2021/4/29 0029 17:03
 */
public class SelfConstraintValidator implements ConstraintValidator<SelfConstraint, Object> {
    private long max = 1;
    private long min = 1;


    public void initialize(SelfConstraint constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
        Console.log("SelfConstraintValidator初始化max=" + max + "和min=" + min);
    }

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(o == null){
            Console.log("参数" + o.toString() + "为空！合法！");
            return true;
        }
        if(o.toString().trim().length()>=min && o.toString().trim().length()<=max) {
            Console.log("参数" + o.toString() + "合法！");
            return true;
        }
        Console.log("参数" + o.toString() + "不合法！");
        return false;
    }
}
