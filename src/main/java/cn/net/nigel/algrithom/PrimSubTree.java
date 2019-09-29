package cn.net.nigel.algrithom;

import java.util.*;

public class PrimSubTree {

    // Complete the prims function below.
    static int prim(int n, int[][] edges, int start) {
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
        int[] step;
        int[] ok = new int[n + 1];
        boolean[] exists = new boolean[n + 1];
        for (int i = 1; i < n;) {
            step = new int[3];
            for (int[] edge : set) {
                if (step[2] == 0 || edge[2] < step[2]) {
                    start = edge[0];
                    while (start > 0) {
                        if (ok[start] == 0) {
                            start = edge[0];
                            break;
                        } else if (ok[start] == edge[1]) {
                            start = 0;
                        } else {
                            start = ok[start];
                        }
                    }
                    step = edge;
                }
            }
            if (start == step[0]) {
                if (ok[start] > 0) {
                    ok[ok[start]] = start;
                }
                if (exists[step[1]]) {
                    ok[step[1]] = start;
                } else {
                    ok[start] = step[1];
                    exists[step[1]] = true;
                }
                exists[start] = true;
                i++;
                sum += step[2];
            } else if (start == step[1]) {
                if (ok[start] > 0) {
                    ok[ok[start]] = start;
                }
                if (exists[step[1]]) {
                    ok[step[0]] = start;
                } else {
                    ok[start] = step[0];
                    exists[step[0]] = true;
                }
                exists[start] = true;
                i++;
                sum += step[2];
            }
            set.remove(step);
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int edgesItem = Integer.parseInt(edgesRowItems[j]);
                edges[i][j] = edgesItem;
            }
        }

        int start = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(prim(n, edges, start));
        scanner.close();
    }
}

