package GOF.visitor;

/**
 * 具体女婿类，人品好的女婿 —— 具体元素
 */
public class PersonalitySonInLaw extends SonInLaw {


    public PersonalitySonInLaw(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getPersonality(){
        return "人品爆表";
    }
}
