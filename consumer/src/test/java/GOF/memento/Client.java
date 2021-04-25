package GOF.memento;

/**
 * Feng, Ge 2021/4/25 0025 9:48
 */
public class Client {
    public static void main(String[] args) {
        // 构建考试系统对象（Originator）
        ExaminationSystem examination = new ExaminationSystem();
        //开始考试
        examination.startTest();
        //构建caretaker，用于试卷存档
        Caretaker caretaker = new Caretaker();
        //通过考试系统本身创建备忘录，caretaker执行存档操作
        caretaker.archive(examination.createMemoto());
        //退出考试
        examination.quit();
        //重新开启考试，并通过caretaker恢复考试进度
        ExaminationSystem examination_new = new ExaminationSystem();
        examination_new.restore(caretaker.getMemoto());
    }
}
