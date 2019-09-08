package cn.net.nigel.concurrent;

import java.util.concurrent.*;

public class ScheduleTest2 {

    public static void main(String[] args) throws InterruptedException {
//        ScheduledThreadPoolExecutor executor;
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        executorService.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("scheduleWithFixedDelay: " + System.currentTimeMillis());
        }, 0, 2, TimeUnit.SECONDS);

        ScheduledFuture future =
        executorService.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("scheduleAtFixedRate: " + System.currentTimeMillis());
        }, 0, 2, TimeUnit.SECONDS);

//        executorService.scheduleAtFixedRate(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("scheduleAtFixedRate2: " + System.currentTimeMillis());
//        }, 0, 2, TimeUnit.SECONDS);

//            try {
//                System.out.println(future.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//      # 1
//        Thread.sleep(1000);
//        executorService.shutdown();
//      # 2
//        while (future.isDone()) {
//            System.out.println(future.isDone());
//            System.out.println(future.isCancelled());
//            Thread.sleep(1000);
//        }
//      # 3
    }
}
