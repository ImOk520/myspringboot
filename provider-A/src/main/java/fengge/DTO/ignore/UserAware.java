package fengge.DTO.ignore;

/**
 * Feng, Ge 2021/6/7 0007 10:04
 */

public interface UserAware {

    //这个接口类用来测试ignoreDependencyInterface方法，看能否注入User
    void setUser(User user);
}
