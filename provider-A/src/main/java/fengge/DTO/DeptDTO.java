package fengge.DTO;

import fengge.annotation.SelfConstraint;
import lombok.Data;
import lombok.ToString;

@Data
public class DeptDTO {

    @SelfConstraint(min = 1, max = 3, message = "错误")
    private Long deptNo;

    private String dName;

    private String dbSource;
}
