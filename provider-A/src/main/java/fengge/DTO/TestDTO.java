package fengge.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * Feng, Ge 2021/5/27 0027 14:41
 */
@Data
public class TestDTO implements Serializable {


    /**
     * templateId : 101
     * mainSuit : 咽部异物感1月
     * illnessHistory : 患者1月前无明显诱因下出现咽部异物感，有时轻度咽痛、咽干、咽痒。无发热、头痛及吞咽困难。
     * previousHistory : null
     * checkup : 一般情况好。耳：双耳廓对称无畸形，外耳道无红肿，双鼓膜完整、标志清，乳突无压痛。鼻：外鼻无畸形，鼻前庭正常，鼻腔黏膜无充血、肿胀，双下鼻甲无肿大，鼻腔内无新生物及脓性分泌物。咽：鼻咽黏膜光滑，咽隐窝无新生物。口咽黏膜充血，咽后壁淋巴滤泡明显增生，咽侧索肥厚。双扁桃体无肿大，表面无分泌物，舌扁桃体增生。双侧梨状窝清晰。喉：会厌正常，双室带对称，双声带无充血肿胀、运动好。颈部淋巴结：未及肿大淋巴结
     * diagnose : 咽炎
     * score : 15
     * department : 耳鼻喉科
     */

    private String templateId;
    private String mainSuit;
    private String illnessHistory;
    private Object previousHistory;
    private String checkup;
    private String diagnose;
    private int score;
    private String department;
}
