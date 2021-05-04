package GOF.bridge;

import cn.hutool.core.lang.Console;

public class SelectHeater {

    public void doSelect(int brand, int type) {
        // 海尔
        if (brand == 1) {
            Console.log("挑选海尔旗下热水器");
            if (type == 1) {
                Console.log("燃气热水器");
            } else if (type == 2) {
                Console.log("电热水器");
            } else if (type == 3) {
                Console.log("太阳能热水器");
            }
        // 格力
        } else if (brand == 2) {
            Console.log("挑选格力旗下热水器");
            if (type == 1) {
                Console.log("燃气热水器");
            } else if (type == 2) {
                Console.log("电热水器");
            } else if (type == 3) {
                Console.log("太阳能热水器");
            }
        }
    }
}
