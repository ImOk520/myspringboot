package fengge.DTO.ignore;

import lombok.ToString;

/**
 * 实现了上面的UserAware接口并实现setUser方法，
 * 并且将User、Admin、Role属性注入
 */

@ToString
public class Person implements UserAware{

    private User user;
    private Admin admin;
    private Role role;

    public User getUser() {
        return user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}