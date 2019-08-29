package com.hwua.sparsearray;

import java.io.*;

public class SparseArray {

    public static void main(String[] args) throws Exception {
        //创建一个原始的二维数组11*11
        //0没有棋子，1表示黑子，2表示蓝子

        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        //打印原始矩阵，顺便统计下又几个非0值
        int num = 0;
        for (int[] arr : chessArr1) {
            for (int i : arr) {
                if (i != 0) {
                    num++;
                }
                System.out.printf("%d ", i);
            }
            System.out.println();
        }

        System.out.println("------------------------");
        //转换成稀疏矩阵
        int sparseArr[][] = new int[num + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = num;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //把稀疏矩阵存入本地内存
        FileWriter fos = new FileWriter("map.data");

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                fos.write(sparseArr[i][j] + "\t");
            }
            fos.write("\n");
        }
        fos.close();

        for (int[] arr : sparseArr) {
            for (int i : arr) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        //读取稀疏矩阵
        FileInputStream fr = new FileInputStream("map.data");
        byte[] buff = new byte[64];
        String str = "";
        int len;
        while ((len = fr.read(buff)) != -1) {
            String s = new String(buff, 0, len);
            str += s;
        }
        fr.close();

        String[] split = str.split("\n");
        String[] split1 = split[0].split("\t");
        int[][] sparseArray2 = new int[Integer.valueOf(split1[2]) + 1][3];
        for (int k = 0; k < split.length; k++) {
            String[] ss = split[k].split("\t");
            sparseArray2[k][0] = Integer.valueOf(ss[0]);
            sparseArray2[k][1] = Integer.valueOf(ss[1]);
            sparseArray2[k][2] = Integer.valueOf(ss[2]);
        }

        System.out.println("打印读取的稀疏数组：-----------------");
        for (int[] arr : sparseArray2) {
            for (int i : arr) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        //稀疏矩阵转换成原始矩阵
        int chessArr2[][] = new int[sparseArray2[0][0]][sparseArray2[0][1]];
        for (int i = 1; i < sparseArray2.length; i++) {
            chessArr2[sparseArray2[i][0]][sparseArray2[i][1]] = sparseArray2[i][2];
        }
        System.out.println("打印稀疏数组还原的数组------------------");
        for (int[] arr : chessArr2) {
            for (int i : arr) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }

    }
}
