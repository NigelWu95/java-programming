package cn.net.nigel;

import java.io.IOException;
import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {

        int[][] edges = {{1, 2, 3}, {1, 3, 4}, {4, 2, 6}, {5, 2, 2}, {2, 3, 5}, {3, 5, 7}};
        int n = 5;
        int start = 1;
        Set<int[]> set = new HashSet<>();
        for (int[] edge : edges) {
            if (edge.length != 3) {
                throw new RuntimeException("wrong edge: " + Arrays.toString(edge));
            } else {
                if (edge[0] > n || edge[1] > n) {
                    throw new RuntimeException("wrong node num: " + edge[0]);
                } else {
                    set.add(edge);
                }
            }
        }
        int sum = 0;
        System.out.println(sum);
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
