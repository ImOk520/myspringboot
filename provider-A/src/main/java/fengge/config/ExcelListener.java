package fengge.config;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import fengge.DTO.ExcelEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Feng, Ge 2021/5/30 0030 10:51
 */
public class ExcelListener extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> datas = new ArrayList<Object>();
    public void invoke(Object object, AnalysisContext context) {
//        System.out.println("当前行："+context.getCurrentRowNum());
        ExcelEntity entity = (ExcelEntity) object;


        System.out.println(entity.getCity() + JSONUtil.toJsonStr(object));
        datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(object);//根据自己业务做处理
    }
    private void doSomething(Object object) {
        ExcelEntity excel = (ExcelEntity) object;
        //1、入库调用接口

    }
    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源
    }
    public List<Object> getDatas() {
        return datas;
    }
    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}

