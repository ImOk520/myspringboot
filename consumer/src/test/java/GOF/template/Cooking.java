package GOF.template;

/**
 * 抽象基类，为所有子类提供算法框架
 * （为什么是抽象类而不是接口？ 因为抽象类内允许实现一些共有或通用的方法，这些方法就
 *  无需每个子类再去实现了，如上面的”准备炒锅“和“装盘”是通用无差别的方法，可以直接在
 *  基类实现；而接口内都为抽象方法，不能实现一些通用的方法）
 */
public abstract class Cooking {

    /** 炒菜的步骤模板方法   final修饰说明不可被继承修改，模板方法流程是固定的 */
    public final void doCooking(){
        // 1.准备炒锅
        preparePot();
        // 2.开始炒菜
        startFry();
        // 3.放调料
        addCondiments();
        // 4.装盘
        panning();
    }

    /** 1.准备炒锅（该方法为通用无差别方法，直接在基类里实现，private则子类不可见） */
    private void preparePot(){
        System.out.println("准备炒锅");
    }

    /**
     * 2.开始炒菜
     * （该方法为个性化方法，延迟到子类里实现，定义为抽象方法
     *   因此不能用private修饰，用该为protected或default）
     */
    protected abstract void startFry();

    /**
     * 3.放调料
     * （该方法为个性化方法，延迟到子类里实现，定义为抽象方法
     *   因此不能用private修饰，用该为protected或default）
     */
    protected abstract void addCondiments();

    /** 4.装盘（该方法为通用无差别方法，直接在基类里实现，private则子类不可见） */
    private void panning(){
        System.out.println("装盘");
    }
}