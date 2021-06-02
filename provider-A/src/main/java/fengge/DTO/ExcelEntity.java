package fengge.DTO;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * 序号	地市	区县	医疗机构	详细地址	经度	纬度	医院等级	24小时咨询电话	备注
 * 1	合肥市	包河区	安徽省儿童医院（新华医院）	包河区望江东路39号	117.286848 	31.833348 	三甲综合医院	0551-62214210
 * 2	合肥市	包河区	合肥滨湖医院	滨湖新区长沙路3200号（徽州大道与紫云路交口）	117.295643 	31.744972	三甲综合医院	0551-65758498
 * 3	合肥市	包河区	合肥市第三人民医院	望江东路204号	117.273955 	31.836323	三级综合医院	0551-63629389
 * 4	合肥市	巢湖市	安徽医科大学附属巢湖医院	巢湖市巢湖北路64号	117.879302 	31.629017 	三甲综合医院	19956075630
 * 5	合肥市	巢湖市	合肥市第八人民医院	巢湖市人民路319号	117.877304 	31.609308	二甲综合医院	13856515908
 * 6	合肥市	巢湖市	宋庆龄爱心医院	巢湖市健康西路28号	117.860384 	31.611951	二甲综合医院	18156546059
 */
@Data
public class ExcelEntity extends BaseRowModel {
    @ExcelProperty(index = 0 , value = "序号")
    private String serialNum;
    @ExcelProperty(index = 1 , value = "地市")
    private String city;
    @ExcelProperty(index = 2 , value = "区县")
    private String county;
    @ExcelProperty(index = 3 , value = "医疗机构")
    private String org;
    @ExcelProperty(index = 4 , value = "详细地址")
    private String addr;
    @ExcelProperty(index = 5 , value = "经度")
    private String jinDu;
    @ExcelProperty(index = 6 , value = "纬度")
    private String weiDu;
    @ExcelProperty(index = 7 , value = "医院等级")
    private String grade;
    @ExcelProperty(index = 7 , value = "24小时咨询电话")
    private String phone;
    @ExcelProperty(index = 7 , value = "备注")
    private String remark;

}