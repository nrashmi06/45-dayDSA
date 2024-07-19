package Arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] liveCnt = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int row = -1; row <= 1; row++) {
                    for (int col = -1; col <= 1; col++) {
                        if (i + row >= 0 && i + row < m && j + col >= 0 && j + col < n) {
                            if (i + row == i && j + col == j) continue;
                            if (board[i + row][j + col] == 1) liveCnt[i][j]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && (liveCnt[i][j] < 2 || liveCnt[i][j] > 3)) {
                    board[i][j] = 0;
                } else if (board[i][j] == 0 && liveCnt[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife obj = new GameOfLife();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        obj.gameOfLife(board);
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
