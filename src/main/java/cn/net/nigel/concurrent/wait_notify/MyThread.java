package cn.net.nigel.concurrent.wait_notify;

class MyThread implements Runnable {

    private final Object object;
    private boolean flag;

    public MyThread(Object object, boolean flag) {
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
        if(flag){
            this.waitMethod();
        }else{
            this.notifyMethod();
        }
    }
}

class Test {

    public static void main(String[] args) throws InterruptedException {

        final Object obj = new Object();

        // #1
//        MyThread thread1 = new MyThread(obj, true);
//        MyThread thread2 = new MyThread(obj, false);
//        Thread waitThread = new Thread(thread1, "等待线程");
//        Thread notifyThread = new Thread(thread2, "唤醒线程");
//        waitThread.start();
//        Thread.sleep(1000);
//        notifyThread.start();

        // #2
//        MyThread thread1 = new MyThread(obj,true);
//        MyThread thread2 = new MyThread(obj,false);
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
        MyThread thread1 = new MyThread(obj,true);
        MyThread thread2 = new MyThread(obj,false);
        for(int i = 0; i<5; i++) {
            Thread threadI = new Thread(thread1, "等待线程" + i);
            threadI.start();
        }
        Thread.sleep(1000);
        thread2.notifyAllMethod();
    }
}