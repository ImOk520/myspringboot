package fengge.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * 病例模板实体
 * Feng, Ge 2021年5月26日18:14:18
 */
@Data
public class TemplateMedicalEntity implements Serializable {
    private String templateId;
    private String mainSuit;
    private String illnessHistory;
    private String previousHistory;
    private String diagnose;
    private Double score;
    private String department;
    private String selfHistory;
    private String familyHistory;
    private Double temperature;
    private Integer pulse;
    private Integer high;
    private Integer low;
    private Integer breathCount;
    private Integer bodyHeight;
    private Integer bmi;
    private String checkup;
    private String fzInspect;
}
