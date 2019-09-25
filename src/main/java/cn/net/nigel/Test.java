package cn.net.nigel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        String s = "abc";
        list.add(s);
        s = "def";
        list.add(s);

        String a = "a";
        String b = a;
        a = null;
        System.out.println(b);

        String[] array = new String[]{};
        float c = 0.100000f;
        c++;
        System.out.println(c/2);

        testFinally();
    }

    public static String testFinally() throws IOException {
        try {
            long mi = System.currentTimeMillis();
            System.out.println(mi);
            if (mi % 2 == 0) throw new IOException("");
            else return null;
        } catch (Exception e) {
            System.out.println("exception");
            throw e;
        } finally {
            System.out.println("close");
        }
    }
}
