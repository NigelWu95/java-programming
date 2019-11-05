package cn.net.nigel.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        shutdownNowTest();
//        instanceTest();
//        staticTest();
    }

    public static void staticTest() {
        ExecutorService servicePool = Executors.newCachedThreadPool();
        TestUtils.sleep();
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::sleep);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::print);
        servicePool.execute(TestUtils::printId);
        servicePool.execute(TestUtils::printId);
        servicePool.shutdown();
    }

    public static void instanceTest() throws InterruptedException {
        SynchronizedDemo1 demo1 = new SynchronizedDemo1(1, "name1");
        ExecutorService servicePool = Executors.newCachedThreadPool();
        servicePool.execute(demo1::sleep);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::sleep);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::sleep);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
//        demo1.sleep();
//        servicePool.shutdown();
        servicePool.shutdownNow();
//        System.out.println(servicePool.isTerminated());
    }

    public static void shutdownNowTest() throws InterruptedException {
        ExecutorService servicePool = Executors.newCachedThreadPool();
        servicePool.execute(new SynchronizedDemo1(1, "name1")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(2, "name2")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(3, "name3")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(4, "name4")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(5, "name5")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(6, "name6")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(7, "name7")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(8, "name8")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(9, "name9")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(10, "name10")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(11, "name11")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(12, "name12")::testAlwaysRun);
        servicePool.execute(new SynchronizedDemo1(13, "name13")::testAlwaysRun);
        servicePool.shutdown();
        servicePool.shutdownNow();
        System.out.println("shutdown");
//        System.exit(0);
    }
}
