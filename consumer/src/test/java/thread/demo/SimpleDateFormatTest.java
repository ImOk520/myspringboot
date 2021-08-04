package thread.demo;

import java.text.SimpleDateFormat;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    ConsoleUtil.print(sdf.parse("1951-04-21").toString());
                } catch (Exception e) {
                    ConsoleUtil.print(e.toString());
                }
            }).start();
        }
    }
}
