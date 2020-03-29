package com.devglan.matrix;

public class Addition {

    public static void main(String[] args){
        int[][] matrix = new int[3][4];
        int rowNum = matrix.length;
        int columnNum = matrix[2].length;
        int num = 1;
        for(int row = 0; row < rowNum; row++){
            for(int col = 0; col < columnNum; col++){
                matrix[row][col] = ++num;
            }
        }
        int[][] sum = new int[rowNum][columnNum];
        for(int row = 0; row < sum.length; row++){
            for(int col = 0; col < sum[0].length; col ++){
                sum[row][col] = matrix[row][col] + matrix[row][col];
            }
        }
        for(int i = 0; i< rowNum; i++){
            for (int j =0; j < columnNum; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i< rowNum; i++){
            for (int j =0; j < columnNum; j++){
                System.out.print(sum[i][j]);
            }
            System.out.println();
        }
    }
}
