package GOF.adapterPattern;

/**
 * 适配器模式 客户端
 */
public class Client {
    public static void main(String[] args) {
        Adapter adapter  = new Adapter(new HDMIDataLine());
        OldMonitor oldMonitor = new OldMonitor();
        oldMonitor.setVgaInterface(adapter);
        oldMonitor.show();
    }

}
