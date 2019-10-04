package cn.net.nigel.concurrent;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClockExecutorServiceTest {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(() -> {
            LocalDateTime now = LocalDateTime.now(clock);
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "--" + i + ": " + now);
                now = LocalDateTime.now(clock);
            }
        });
        pool.execute(() -> {
            LocalDateTime now = LocalDateTime.now(clock);
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "--" + i + ": " + now);
                now = LocalDateTime.now(clock);
            }
        });
        pool.execute(() -> {
            LocalDateTime now = LocalDateTime.now(clock);
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "--" + i + ": " + now);
                now = LocalDateTime.now(clock);
            }
        });
        pool.shutdown();
    }
}
