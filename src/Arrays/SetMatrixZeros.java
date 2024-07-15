package Arrays;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        setMatrixZeros.setZeroes(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
//public class Solution {
//    public void setZeroes(int[][] matrix) {
//        boolean fr = false,fc = false;
//        for(int i = 0; i < matrix.length; i++) {
//            for(int j = 0; j < matrix[0].length; j++) {
//                if(matrix[i][j] == 0) {
//                    if(i == 0) fr = true;
//                    if(j == 0) fc = true;
//                    matrix[0][j] = 0;
//                    matrix[i][0] = 0;
//                }
//            }
//        }
//        for(int i = 1; i < matrix.length; i++) {
//            for(int j = 1; j < matrix[0].length; j++) {
//                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
//                    matrix[i][j] = 0;
//                }}
//        }
//        if(fr) {
//            for(int j = 0; j < matrix[0].length; j++) {
//                matrix[0][j] = 0;
//            }
//        }
//        if(fc) {
//            for(int i = 0; i < matrix.length; i++) {
//                matrix[i][0] = 0;
//            }
//        }
//    }}