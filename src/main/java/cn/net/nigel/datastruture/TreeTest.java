package cn.net.nigel.datastruture;

import sun.misc.SignalHandler;

import javax.swing.tree.TreeNode;

public class TreeTest {

    public static void main(String[] args) throws InterruptedException {
//        TreeNode treeNode = new Tre
        SignalHandler handler = signal -> {
            System.out.println("test");
        };
        // 设置INT信号(Ctrl+C中断执行)交给指定的信号处理器处理，废掉系统自带的功能
        sun.misc.Signal.handle(new sun.misc.Signal("INT"), handler);
        Thread.sleep(100000);
    }
}
