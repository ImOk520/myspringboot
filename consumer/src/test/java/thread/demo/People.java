package thread.demo;

class People extends Thread {
    @Override
    public void run() {
        //收信
        GuardedObject02 guardedObject = Mailboxes.createGuardedObject();
        System.out.println("开始收信id： " +  guardedObject.getId());
        Object o = guardedObject.get(5*1000);
        System.out.println("收到信id： " + guardedObject.getId() + " " + o );
    }
}
