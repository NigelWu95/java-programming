package cn.net.nigel.util;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTest {

    public static void main(String[] args) {
        LocalDateTime endDateTime = LocalDateTime.now().plusSeconds(30);
        final Object object = new Object();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                synchronized (object) {
                    object.notifyAll();
                    System.out.println("notifyAll1: " + LocalDateTime.now());
                }
            }
        }, 5000, 10000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                synchronized (object) {
                    object.notifyAll();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("notifyAll2: " + LocalDateTime.now());
                }
            }
        }, 5000, 2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                synchronized (object) {
                    object.notifyAll();
                    System.out.println("notifyAll3: " + LocalDateTime.now());
                }
            }
        }, 5000, 5000);
        while (LocalDateTime.now().isBefore(endDateTime));
        timer.cancel();
    }
}
