package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * 处方信息
 *
 * @author yangxiao
 * @date Created in 17:02 2019/6/13
 */
@Data
@Accessors(chain = true)
public class PrescribingInfo {

    @ApiModelProperty("处方表ID")
    private String id;

    @ApiModelProperty(value = "厂商来源id")
    private String sourceId;
    private String loginUserId;

    @NotBlank(message = "区县行政区划代码不能为空")
    @Length(max = 32, message = "区县行政区划代码不能大于32位")
    @ApiModelProperty(value = "区县行政区划代码")
    private String areaCodeCounty;

    /*  @NotBlank(message = "医疗机构代码不能为空")
      @Length(max = 100, message = "医疗机构代码不能大于100位")*/
    @ApiModelProperty(value = "医疗机构代码")
    private String orgCode;


    @ApiModelProperty(value = "门诊流水号")
    private String outpatientId;


    @ApiModelProperty(value = "居民患者ID")
    private String patientId;

    @ApiModelProperty(value = "处方开立医生工号")
    private String visitDoctorId;

    @ApiModelProperty(value = "处方开立医生姓名")
    private String visitDoctorName;

    @JsonFormat(pattern = "yyyyMMddHHmmss", timezone = "GMT+8")
    private Date visitTime;

    @ApiModelProperty(value = "处方开立科室代码")
    private String departmentCode;

    @ApiModelProperty(value = "处方开立科室名称")
    private String departmentName;

    @ApiModelProperty(value = "处方编号")
    private String prescriptionId;

    @ApiModelProperty(value = "中西医处方标识")
    private String detailId;

    /**
     * 备用字段1
     */
    @ApiModelProperty(value = "备用字段1")
    @Length(max = 50, message = "backup1不能大于50位")
    private String backup1;

    /**
     * 备用字段2
     */
    @ApiModelProperty(value = "备用字段2")
    @Length(max = 50, message = "backup2不能大于50位")
    private String backup2;

    /**
     * 备用字段3
     */
    @ApiModelProperty(value = "备用字段3")
    @Length(max = 50, message = "backup3不能大于50位")
    private String backup3;

    /**
     * 备用字段4
     */
    @ApiModelProperty(value = "备用字段4")
    @Length(max = 50, message = "backup4不能大于50位")
    private String backup4;

    /**
     * 备用字段5
     */
    @ApiModelProperty(value = "备用字段5")
    @Length(max = 50, message = "backup5不能大于50位")
    private String backup5;

    /**
     * 年龄
     */
    private String age;

    /**
     * 身份证号
     */
    private String certificateId;

    /**
     * 现住地址
     */
    private String residentialAddress;
}
