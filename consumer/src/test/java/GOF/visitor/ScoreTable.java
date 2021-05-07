package GOF.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 评分表 —— ObjectStructure，这个结构应该相对稳定，不经常修改
 */
public class ScoreTable {
    private List<SonInLaw> sonInLaws = new ArrayList<>();

    public ScoreTable() {
        sonInLaws.add(new RichSonInLaw("女婿一：金龟婿"));
        sonInLaws.add(new RichSonInLaw("女婿二：金龟婿"));
        sonInLaws.add(new PersonalitySonInLaw("女婿三：靠谱婿"));
        sonInLaws.add(new PersonalitySonInLaw("女婿四：靠谱婿"));
    }

    public void showScoredTable(Visitor visitor) {
        for (SonInLaw sonInLaw : sonInLaws) {
            sonInLaw.accept(visitor);
        }
    }
}
