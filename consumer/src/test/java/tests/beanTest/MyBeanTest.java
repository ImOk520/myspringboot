package tests.beanTest;

import entity.PrescribingExtendInfo;
import org.junit.Test;

import java.lang.reflect.Field;


/**
 * Lambda 示例代码
 * Feng, Ge 2020年01月16日14:42:43
 */

public class MyBeanTest {

    @Test
    public void test1() {
        PrescribingExtendInfo p = new PrescribingExtendInfo();
        p.setEmergencyFlag("666");
        Field[] declaredFields = p.getClass().getDeclaredFields();
        for (Field field: declaredFields) {
            System.out.println(field);

        }
        System.out.println(declaredFields);
    }

    private boolean judgeExtendPropertiesNull(PrescribingExtendInfo prescribingInfo) {
        // 以下扩展信息均为空则不入库
        if (prescribingInfo.getMedicalcareNo() == null
                && prescribingInfo.getPersonnelTypeCode() == null
                && prescribingInfo.getPersonnelTypeName() == null
                && prescribingInfo.getMedicalcareHospNo() == null
                && prescribingInfo.getMedicalcareHospName() == null
                && prescribingInfo.getEmergencyFlag() == null
                && prescribingInfo.getMedicalTypeCode() == null
                && prescribingInfo.getMedicalTypeName() == null
                && prescribingInfo.getTreatmentTypeCode() == null
                && prescribingInfo.getTreatmentTypeName() == null
                && prescribingInfo.getMainDiagnosticCode() == null
                && prescribingInfo.getMainDiagnosticName() == null
                && prescribingInfo.getPhysicianCode() == null
        ) {
            return false;
        } else {
            return true;
        }
    }

}
