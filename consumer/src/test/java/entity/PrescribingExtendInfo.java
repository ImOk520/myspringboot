package entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 处方扩展信息
 *
 * @author fengege
 * @date Created in 2020年12月2日11:06:23
 */
@Data
@Accessors(chain = true)
public class PrescribingExtendInfo extends PrescribingInfo{

    @ApiModelProperty("医保个人编号")
    public String medicalcareNo;

    @ApiModelProperty("人员类别代码")
    public String personnelTypeCode;

    @ApiModelProperty("人员类别名称")
    public String personnelTypeName;

    @ApiModelProperty("医保医院编号")
    public String medicalcareHospNo;

    @ApiModelProperty("医保医院名称")
    public String medicalcareHospName;

    @ApiModelProperty("急诊标志")
    public String emergencyFlag;

    @ApiModelProperty("医保医疗类别代码")
    public String medicalTypeCode;

    @ApiModelProperty("医保医疗类别名称")
    public String medicalTypeName;

    @ApiModelProperty("医疗待遇类别代码")
    public String treatmentTypeCode;

    @ApiModelProperty("医疗待遇类别名称")
    public String treatmentTypeName;

    @ApiModelProperty("医保主诊断编码")
    public String mainDiagnosticCode;

    @ApiModelProperty("医保主诊断名称")
    public String mainDiagnosticName;

    @ApiModelProperty("医师服务编码")
    public String physicianCode;

}
