package cn.net.nigel.concurrent;

public class SynchronizedDemo1 {

    private int startId;
    private int nameId;
    private String name;

    public SynchronizedDemo1(int startId, String name) {
        this.startId = startId;
        this.name = name;
    }

    public synchronized void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printId() {
        System.out.println(startId++);
    }

    public synchronized void printName() {
        nameId++;
        System.out.println("printName: " + Thread.currentThread());
        print();
        System.out.println(nameId + "-" + name + " " + Thread.currentThread());
    }

    public void print() {
        System.out.print("enter print. " + Thread.currentThread());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Id: " + startId++ + ", name: " + name);
    }

    public synchronized void innerPrint() {
        System.out.println("innerPrint: " + Thread.currentThread());
        print();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("innerEnd: " + Thread.currentThread());
    }

    public void testAlwaysRun() {
        long i = 0;
        try {
            while (i < Long.MAX_VALUE) {
                i++;
                System.out.println(i);
            }
        } finally {
            System.out.println("max: " + i);
        }
    }
}
