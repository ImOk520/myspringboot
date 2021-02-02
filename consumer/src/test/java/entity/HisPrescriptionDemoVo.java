package entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 处方演示Vo
 */
@Data
@Builder
@AllArgsConstructor
public class HisPrescriptionDemoVo {

    @ApiModelProperty("处方表ID")
    private String id;

    @ApiModelProperty("处方状态：1暂存2提交3作废")
    private String state;

    @ApiModelProperty("处方编号")
    private String prescriptionId;

    @ApiModelProperty("诊断")
    private String diagnosticName;

    @ApiModelProperty("处方总价")
    private BigDecimal totalsPrice;

}
