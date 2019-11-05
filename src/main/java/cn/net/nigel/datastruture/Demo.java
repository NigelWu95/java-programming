package cn.net.nigel.datastruture;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.subList(0, 1));
//        list.subList(1, 3).clear();
//        System.out.println(list.subList(1, 3));
        for (int i = 1; i < -1; i++) {
            System.out.println(list.get(i));
        }

        StringBuilder builder = new StringBuilder("procedure");
        System.out.println(builder.delete(9, 10));
        System.out.println(builder);
    }

}
