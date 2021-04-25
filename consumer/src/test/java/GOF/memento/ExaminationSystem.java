package GOF.memento;

import cn.hutool.core.lang.Console;
import lombok.ToString;

/**
 * Originator 创建者
 * 其内部可以实现备忘录的创建以及恢复
 * 负责创建一个备忘录，用来记录、恢复自身的内部状态。同时根据需要决定Memento存储自身的那些状态
 *
 * 考试系统（Originator）
 */
@ToString
public class ExaminationSystem {
    // 题目序号
    private int topicNum = 1;
    // 剩余时间
    private int remainingTime = 120;
    // 答案缓存
    private String answer = "";

    // 开始答题
    public void startTest(){
        Console.log("开始答题：" + String.format("第%d题", topicNum));
        remainingTime -=10;
        Console.log("时间还剩" + remainingTime + "分钟");
        answer = "答案1";
        topicNum++;
        Console.log("开始做"+String.format("第%d题", topicNum));
    }

    // 退出考试
    public void quit(){
        Console.log("---------------------");
        Console.log("退出前的情况："+this.toString());
        Console.log("退出考试");
        Console.log("---------------------");
    }

    // 创建备忘录
    public Memento createMemoto(){
        Memento memento = new Memento();
        memento.topicNum = topicNum;
        memento.remainingTime = remainingTime;
        memento.answer = answer;
        return memento;
    }

    // 获取备忘录，恢复当时的对象状态
    public void restore(Memento memento){
        this.topicNum = memento.topicNum;
        this.remainingTime = memento.remainingTime;
        this.answer = memento.answer;
        System.out.println("恢复后的考试属性："+this.toString());
    }

}