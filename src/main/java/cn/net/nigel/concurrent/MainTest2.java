package cn.net.nigel.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest2 {

    public static void main(String[] args) {
        SynchronizedDemo1 demo1 = new SynchronizedDemo1(1, "name1");
        ExecutorService servicePool = Executors.newCachedThreadPool();
        servicePool.execute(demo1::innerPrint);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo1.printName();
        System.out.println("first-printName");


//        servicePool.execute(demo1::innerPrint);
//        servicePool.execute(demo1::innerPrint);
//        servicePool.execute(demo1::innerPrint);
//        servicePool.execute(demo1::innerPrint);
//        servicePool.execute(demo1::innerPrint);
//        System.out.println("printName");
//        servicePool.execute(demo1::printName);
//        servicePool.execute(demo1::printName);
//        servicePool.execute(demo1::printName);
//        servicePool.execute(demo1::printName);
//        servicePool.execute(demo1::printName);
//        servicePool.execute(demo1::innerPrint);
        servicePool.shutdown();
    }
}
