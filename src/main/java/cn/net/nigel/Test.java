package cn.net.nigel;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {

//        int[][] edges = {{2, 1, 1000}, {3, 4, 299}, {2, 4, 200}, {2, 4, 100}, {3, 2, 300}, {3, 2, 6}};
//        int n = 4;
//        int[][] edges = {{1, 2, 1}, {3, 2, 150}, {4, 3, 99}, {1, 4, 100}, {3, 1, 200}};
//        int n = 4;
        int[][] edges = {{1, 2, 3}, {1, 3, 4}, {4, 2, 6}, {5, 2, 2}, {2, 3, 5}, {3, 5, 7}};
        int n = 5;
//        int[][] edges = {{1, 2, 20}, {1, 3, 50}, {1, 4, 70}, {1, 5, 90}, {2, 3, 30}, {3, 4, 40}, {4, 5, 60}};
//        int n = 5;
        int start = 1;
        int[][] nodes = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            if (edge.length != 3) {
                throw new RuntimeException("wrong edge: " + Arrays.toString(edge));
            } else {
                if (edge[0] > n || edge[1] > n) {
                    throw new RuntimeException("wrong node num: " + edge[0]);
                } else {
                    if (nodes[edge[0]][2] == 0 || edge[2] > nodes[edge[0]][2]) {
                        nodes[edge[0]] = edge;
//                        ok[edge[0]] = edge[1];
                    }
                    if (nodes[edge[1]][2] == 0 || edge[2] > nodes[edge[1]][2]) {
                        nodes[edge[1]] = edge;
//                        ok[edge[1]] = edge[0];
                    }
                }
            }
        }
        int sum = 0;
//        if (n == edges.length) {
//            for (int[] edge : edges) {
//                sum += edge[2];
//            }
//            return sum;
//        }
        int[] ok = new int[n + 1];
        for (int[] edge : edges) {
//            if (nodes[edge[0]][2] == 0) {
//                nodes[edge[0]] = edge;
//                if (ok[edge[0]] > 0) {
//                    ok[ok[edge[0]]] = edge[0];
//                }
//                ok[edge[0]] = edge[1];
//            } else if (nodes[edge[1]][2] == 0) {
//                nodes[edge[1]] = edge;
//                if (ok[edge[1]] > 0) {
//                    ok[ok[edge[1]]] = edge[1];
//                }
//                ok[edge[1]] = edge[0];
//            }
//            if (ok[edge[0]] > 0 && ok[edge[1]] > 0) {
//                ok[ok[edge[0]]] = edge[0];
//                nodes[ok[edge[0]]] = nodes[edge[0]];
//                ok[edge[0]] = 0;
//                nodes[edge[0]] = edge;
//            }
            if (edge[2] < nodes[edge[0]][2]) {
                nodes[edge[0]] = edge;
                if (ok[edge[0]] > 0) {
                    ok[ok[edge[0]]] = edge[0];
                }
                ok[edge[0]] = edge[1];
            } else if (edge[2] < nodes[edge[1]][2]) {
                nodes[edge[1]] = edge;
                if (ok[edge[1]] > 0) {
                    ok[ok[edge[1]]] = edge[1];
                }
                ok[edge[1]] = edge[0];
            } else {
                if (ok[edge[1]] == 0) {
                    ok[edge[1]] = edge[0];
                } else if (ok[edge[0]] == 0) {
                    ok[edge[0]] = edge[1];
                } else {
                    int temp = ok[edge[0]];
                    int[] okT = new int[n + 1];
                    while (ok[temp] > 0 && ok[temp] != edge[0]) {
                        okT[ok[temp]] = temp;
                        temp = ok[temp];
                    }
                    ok[ok[edge[0]]] = edge[0];
                    nodes[ok[edge[0]]] = nodes[edge[0]];
                    ok[edge[0]] = 0;
                    nodes[edge[0]] = edge;
                }
            }
        }
        boolean[] exists = new boolean[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < ok.length; i++) {
//            if (ok[ok[i]] == i) {
//                ok[i] = 0;
//                nodes[i][2] = 0;
//            }
//            set.add(i);
            exists[i] = true;
            start = ok[i];
            while (ok[start] > 0) {
//            set.add(start);
                exists[start] = true;
                start = ok[start];
                if (ok[start] == 0) {
                    start = i;
                    break;
                } else if (
                        exists[ok[start]]
//                        set.contains(ok[start])
                        ) {
//                set.add(start);
                    exists[start] = true;
                    exists[0] = true;
                    i = ok.length;
                    break;
                } else {
//                set.add(start);
                    exists[start] = true;
                    start = ok[start];
                }
            }
        }
        if (exists[0]) {
            int remove = ok[start];
            int max = nodes[ok[start]][2];
            int[] count = new int[n + 1];
            while (true) {
                count[start]++;
                if (count[start] > 1) break;
                start = ok[start];
                if (nodes[ok[start]][2] > max) {
                    remove = ok[start];
                    max = nodes[remove][2];
                }
            }
            nodes[remove] = new int[3];
            System.out.println(start + " " + remove + " " + max);
        }
        for (int[] ne : nodes) {
            sum += ne[2];
        }
        System.out.println(sum);
    }

    public static void test2() {

//        int[][] edges = {{2, 1, 1000}, {3, 4, 299}, {2, 4, 200}, {2, 4, 100}, {3, 2, 300}, {3, 2, 6}};
//        int n = 4;
//        int[][] edges = {{1, 2, 1}, {3, 2, 150}, {4, 3, 99}, {1, 4, 100}, {3, 1, 200}};
//        int n = 4;
        int[][] edges = {{1, 2, 3}, {1, 3, 4}, {4, 2, 6}, {5, 2, 2}, {2, 3, 5}, {3, 5, 7}};
        int n = 5;
//        int[][] edges = {{1, 2, 20}, {1, 3, 50}, {1, 4, 70}, {1, 5, 90}, {2, 3, 30}, {3, 4, 40}, {4, 5, 60}};
//        int n = 5;
        int start = 1;

        Set<Integer> nodeSet = new HashSet<Integer>(){{ add(start); }};
        Set<int[]> edgeSet = new HashSet<>();
        Set<int[]> toRmEdges = new HashSet<>();
        for (int[] edge : edges) {
            if (edge.length != 3) {
                throw new RuntimeException("wrong edge: " + Arrays.toString(edge));
            } else {
                if (edge[0] > n || edge[1] > n) {
                    throw new RuntimeException("wrong node num: " + edge[0]);
                } else {
                    edgeSet.add(edge);
                }
            }
        }
        int sum = 0;
        int min;
        int minIndex = 0;
        int[] minEdge = new int[3];
        for (int i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;
            toRmEdges.clear();
            for (int id : nodeSet) {
                for (int[] edge : edgeSet) {
                    if (nodeSet.contains(edge[1]) && nodeSet.contains(edge[0])) {
                        toRmEdges.add(edge);
                        continue;
                    }
                    if (edge[2] < min) {
                        if (edge[0] == id) {
                            min = edge[2];
                            minIndex = edge[1];
                            minEdge = edge;
                        } else if (edge[1] == id) {
                            min = edge[2];
                            minIndex = edge[0];
                            minEdge = edge;
                        }
                    }
                }
            }
            sum += min;
            nodeSet.add(minIndex);
            edgeSet.remove(minEdge);
            edgeSet.removeAll(toRmEdges);
        }
        System.out.println(sum);
    }
}
