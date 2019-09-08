package cn.net.nigel.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleTest2 {

    public static void main(String[] args) {
//        ScheduledThreadPoolExecutor executor;
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("scheduleWithFixedDelay");
        }, 0, 2, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("scheduleAtFixedRate");
        }, 0, 2, TimeUnit.SECONDS);
//        executorService.shutdown();
    }
}
