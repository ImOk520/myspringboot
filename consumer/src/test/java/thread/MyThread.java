package thread;

/**
 * Feng, Ge 2021/7/5 0005 10:18
 */
class MyThread implements Runnable{
    int flag = 1;
    // 必须是静态资源
    static Object o1 = new Object();
    static Object o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag= " + flag);
        if(flag == 1){
            synchronized (o1){
                System.out.println(Thread.currentThread().getName() + "我抢到了o1，还需要o2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("111");
                }
            }
        }
        if(flag == 0){
            synchronized (o2){
                System.out.println(Thread.currentThread().getName() + "我抢到了o2，还需要o1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("222");
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        // 设置线程1先抢占o1
        myThread1.flag = 1;
        // 设置线程1先抢占o2
        myThread2.flag = 0;
        Thread t1 = new Thread(myThread1);
        Thread t2 = new Thread(myThread2);
        t1.start();
        t2.start();
    }
}


