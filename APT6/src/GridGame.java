import java.util.Arrays;

public class GridGame {

    int count = 0;

    public int[][] Deepcopy(int[][] input){
        int[][] ret = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            ret[i] = input[i].clone();
        }
        return ret;
    }

    public int find_sol(int[][] board) {
        int get = 0;
        // if get continues to be 0, then this map can kill the me
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (board[x][y] == 0 && check(board, x, y) == true){
                    int[][] board_copy = Deepcopy(board);
                    board_copy[x][y] = 1;
                    // System.out.println(Arrays.deepToString(board_copy));
                    int tmp = find_sol(board_copy);
                    if (tmp == 0) get += 1;
                }
            }
        }
        // System.out.println("GET:");
        // System.out.println(get);
        return get;
    }

    public boolean check(int[][] board, int x, int y) {

        boolean ret = true;
        int[] xd = {-1, 0, 1, 0};
        int[] yd = {0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int dx = xd[i];
            int dy = yd[i];
            if (0 <= dx + x && dx + x <= 3 && 0 <= dy + y && dy + y <= 3) {
                if (board[dx + x][dy + y] == 1) ret = false;
            }
        }
        return ret;
    }

    public int winningMoves(String[] grid){
        System.out.println("\n\n===================\n");
        int[][] board = new int[4][4];
        int row = 0;
        for (String line: grid) {
            for (int i = 0; i < 4; i++) {
                if (line.substring(i, i + 1).equals("X")) board[row][i] = 1;
            }
            row += 1;
        }

        System.out.println(Arrays.deepToString(board));
        return find_sol(board);
    }
}
