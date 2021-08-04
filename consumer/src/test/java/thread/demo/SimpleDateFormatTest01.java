package thread.demo;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class SimpleDateFormatTest01 {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    ConsoleUtil.print(dtf.parse("1951-04-21").toString());
                } catch (Exception e) {
                    ConsoleUtil.print(e.toString());
                }
            }).start();
        }
    }
}
