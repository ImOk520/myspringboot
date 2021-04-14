package im.ok.config;

import lombok.Data;

import java.io.Serializable;

/**
 * Feng, Ge 2021/4/14 0014 14:48
 */
@Data
public class AccountProfile implements Serializable {
    private Long id;
    private String username;
    private String avatar;
}

