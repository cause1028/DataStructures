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
        File file = new File("map.data");
        file.createNewFile();
        FileWriter fos = new FileWriter(file);

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                fos.write(sparseArr[i][j]);
                fos.write("\t");
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

        System.out.println("------------------------");
        //稀疏矩阵转换成原始矩阵
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int[] arr : chessArr2) {
            for (int i : arr) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }

    }
}
