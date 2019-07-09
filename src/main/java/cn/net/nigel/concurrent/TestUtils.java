package cn.net.nigel.concurrent;

public class TestUtils {

    private static int startId = 0;

    public static synchronized void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void printId() {
        System.out.println(startId++);
    }

    public static void print() {
        System.out.println(startId++);
    }
}
