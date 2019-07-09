package cn.net.nigel.concurrent;

public class SynchronizedDemo1 {

    private int startId;
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
        startId++;
        System.out.println(name);
    }

    public void print() {
        System.out.println("Id: " + startId++ + ", name: " + name);
    }
}
