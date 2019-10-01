package cn.net.nigel.algrithom;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Edge {

    char vexa;
    char vexb;
    int weight;

    Edge(char vexa, char vexb, int weight) {
        this.vexa = vexa;
        this.vexb = vexb;
        this.weight = weight;
    }
}

public class MST {
    int n;
    int m;
    Edge[] e ;

    public MST(int n, int m, Edge[] e){
        this.n = n;
        this.m = m;
        this.e = e;
    }

    private int w(int x, int y) {
        char from = (char) (x + 97);
        char to = (char) (y + 97);
        for (int i = 0; i < m; i++) {
            if (e[i].vexa == from && e[i].vexb == to) {
                return e[i].weight;
            }
            if (e[i].vexa == to && e[i].vexb == from) {
                return e[i].weight;
            }
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }

            Edge[] e = new Edge[m];
            for (int i = 0; i < m; ++i) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                e[i] = new Edge((char)(u+97),(char)(v+97),w);
            }

            MST mst = new MST(n,m,e);
            Edge[] ee = mst.prime();
            for (int i = 0; i < n - 1; ++i) {
                System.out.println(ee[i].vexa + " " + ee[i].vexb + " "
                        + ee[i].weight);
            }
        }
    }


    public Edge[] prime() {
        Edge[] e = new Edge[n];
        int[] vex_mst = new int[n];
        for (int i = 0; i < n; i++) {
            vex_mst[i] = 0;
        }
        vex_mst[0] = 1;
        for (int i = 0; i < n-1; i++) {
            int add_vex = 0;
            int min_weight = Integer.MAX_VALUE;
            Edge adde = new Edge(' ', ' ', 0);
            for (int j = 0; j < n; j++)
                if (vex_mst[j] == 1) {
                    for (int k = 0; k < n; k++) {
                        if (vex_mst[k] == 0 && w(j, k) < min_weight) {
                            add_vex = k;
                            min_weight = w(j, k);
                            adde.vexa = (char) (j + 97);
                            adde.vexb = (char) (k + 97);
                            adde.weight = w(j,k);
                        }
                    }
                }
            vex_mst[add_vex] = 1;
            e[i] = adde;
        }
        return e;
    }
}
