package cn.net.nigel.concurrent;

class WaitNotifyTest implements Runnable {

    private final Object object;
    private boolean flag;

    public WaitNotifyTest(Object object, boolean flag) {
        this.object = object;
        this.flag = flag;
    }

    public void waitMethod() {
        synchronized (object) {
            System.out.println("wait方法开始..." + Thread.currentThread().getName());
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait方法结束..." + Thread.currentThread().getName());
        }
    }

    public void notifyMethod() {
        synchronized (object) {
            System.out.println("notify方法开始..." + Thread.currentThread().getName());
            object.notify();
            System.out.println("notify方法结束..." + Thread.currentThread().getName());
        }
    }

    public void notifyAllMethod() {
        synchronized (object) {
            System.out.println("notify方法开始..." + Thread.currentThread().getName());
            object.notifyAll();
            System.out.println("notify方法结束..." + Thread.currentThread().getName());
        }
    }

    public void run() {
        if (flag) {
            this.waitMethod();
        } else {
            this.notifyMethod();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final Object obj = new Object();

        // #1
//        WaitNotifyTest thread1 = new WaitNotifyTest(obj, true);
//        WaitNotifyTest thread2 = new WaitNotifyTest(obj, false);
//        Thread waitThread = new Thread(thread1, "等待线程");
//        Thread notifyThread = new Thread(thread2, "唤醒线程");
//        waitThread.start();
//        Thread.sleep(1000);
//        notifyThread.start();

        // #2
//        WaitNotifyTest thread1 = new WaitNotifyTest(obj,true);
//        WaitNotifyTest thread2 = new WaitNotifyTest(obj,false);
//        for(int i = 0; i<5; i++) {
//            Thread threadI = new Thread(thread1, "等待线程" + i);
//            threadI.start();
//        }
//        Thread.sleep(1000);
//        for(int i = 0; i<5; i++) {
//            Thread notifyThread = new Thread(thread2,"唤醒线程");
//            notifyThread.start();
//        }

        // #3
        WaitNotifyTest thread1 = new WaitNotifyTest(obj,true);
        WaitNotifyTest thread2 = new WaitNotifyTest(obj,false);
        for(int i = 0; i<5; i++) {
            Thread threadI = new Thread(thread1, "等待线程" + i);
            threadI.start();
        }
        Thread.sleep(1000);
//        thread2.notifyAllMethod();
        thread2.run();
        thread2.notifyMethod();
    }
}
