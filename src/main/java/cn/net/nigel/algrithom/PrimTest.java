package cn.net.nigel.algrithom;

import java.util.Arrays;

public class PrimTest{

    private int[][] arr;
    private boolean flag[];
    private int n;
    private int sum;
    static final int maxInt = Integer.MAX_VALUE;

    public PrimTest(int[][] arr,int n){
        this.arr = arr;
        this.n = n;
        flag = new boolean[n];
    }

    public static void main(String[] args) {
        int n = 7;
        int arr[][] = {
                {maxInt, 28, maxInt, maxInt, maxInt, 10, maxInt},
                {28, maxInt, 16, maxInt, maxInt, maxInt, 14},
                {maxInt, 16, maxInt, 12, maxInt, maxInt, maxInt},
                {maxInt, maxInt, 12, maxInt, 22, maxInt, 18},
                {maxInt, maxInt, maxInt, 22, maxInt, 25, 24},
                {10, maxInt, maxInt, maxInt, 25, maxInt, maxInt},
                {maxInt, 14, maxInt, 18, 24, maxInt, maxInt}
        };
        System.out.println(new PrimTest(arr, n).prim());
    }
//7 18
//1 2 28
//1 6 10
//2 1 28
//2 3 16
//2 7 14
//3 2 16
//3 4 12
//4 3 12
//4 5 22
//4 7 18
//5 4 22
//5 6 25
//5 7 24
//6 1 10
//6 5 25
//7 2 14
//7 4 18
//7 5 24
//1

    public int prim() {
        sum = 0;
        flag[0] = true;
        int mst[] = new int[n];
        Arrays.fill(mst,0);

        for (int k = 1; k < n; k++) {
            int min = maxInt, min_i = 0;
            for (int i = 0; i < n; i++) {
                if (!flag[i] && arr[0][i] < min) {
                    min = arr[0][i];
                    min_i = i;
                }
            }

            flag[min_i] = true;
            System.out.print(mst[min_i] + "-" + min_i);

            for (int i = 0; i < n; i++) {
                if (!flag[i] && arr[0][i] > arr[min_i][i]) {
                    arr[0][i] = arr[min_i][i];
                    mst[i] = min_i;
                }
            }
            System.out.println("--" + arr[0][min_i]);
            sum += arr[0][min_i];
        }

        return sum;
    }

}