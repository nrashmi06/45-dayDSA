package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ll=new ArrayList<>();
        int sr=0;
        int sc=0;
        int er=matrix.length-1;
        int ec=matrix[0].length-1;

        while(sr<=er && sc<=ec){
            for(int i =sc;i<=ec;i++){
                ll.add(matrix[sr][i]);
            }
            for(int i=sr+1;i<=er;i++){
                ll.add(matrix[i][ec]);
            }
            for(int i=ec-1;i>=sc;i--){
                if(sr==er){
                    break;
                }
                ll.add(matrix[er][i]);
            }
            for(int i=er-1;i>=sr+1;i--){
                if(sc==ec){
                    break;
                }
                ll.add(matrix[i][sc]);
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
        return ll;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
