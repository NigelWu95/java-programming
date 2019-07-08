package cn.net.nigel.concurrent;

public class SynchronizedDemo1 {

    private int statId;
    private String name;

    public SynchronizedDemo1(int statId, String name) {
        this.statId = statId;
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
        System.out.println(statId++);
    }

    public synchronized void printName() {
        statId++;
        System.out.println(name);
    }

    public void print() {
        System.out.println("Id: " + statId++ + ", name: " + name);
    }
}
