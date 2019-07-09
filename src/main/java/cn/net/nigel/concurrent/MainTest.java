package cn.net.nigel.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {

    public static void main(String[] args) {
//        instanceTest();
        staticTest();
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

    public static void instanceTest() {
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
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        servicePool.execute(demo1::print);
        servicePool.execute(demo1::printId);
        servicePool.execute(demo1::printName);
        demo1.sleep();
        servicePool.shutdown();
    }
}
