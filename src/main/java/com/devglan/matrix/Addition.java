package com.devglan.matrix;

public class Addition {

    public static void main(String[] args){
       /* int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };*/
        int[][] matrix = new int[3][4];
        int rowNum = matrix.length;
        int columnNum = matrix[2].length; //matrix[1].length
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
