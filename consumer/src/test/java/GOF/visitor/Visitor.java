package GOF.visitor;

/**
 * 抽象访问者接口
 */
public interface Visitor {
    void visit(PersonalitySonInLaw personalitySonInLaw);

    void visit(RichSonInLaw richSonInLaw);
}
