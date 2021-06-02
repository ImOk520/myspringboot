package fengge.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 叶超
 * @version 1.0
 * @date 2020/9/7 17:12
 */
@Data
public class DataEntity implements Serializable {

    private String id;
    private String description;
    private String type;
    private String sort;
    private String data;
}
