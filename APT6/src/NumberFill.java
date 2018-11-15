import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberFill {
    
    Map<List<int[]>, int[]> coord2Center = new HashMap<>();
    int[][] board;
    int rows, cols;
    final int wall = -99999;
    final int fill = -88888, empty = -77777;
    
    
    public int[][] Deepcopy(int[][] input){
        int[][] ret = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            ret[i] = input[i].clone();
        }
        return ret;
    }
    
    public void boundaryDetection(int[][] board, int y, int x, List<int[]> ls) {
        // visualized(board);
        // System.out.println(y);
        // System.out.println(x);
        board[y][x] = fill;
        ls.add(new int[]{y, x});
        int[] xd = {-1, 0, 1, 0};
        int[] yd = {0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nx = x + xd[i];
            int ny = y + yd[i];
            if (nx > -1 && nx < cols && ny > -1 && ny < rows) {
                if (board[ny][nx] != wall && board[ny][nx] != fill) {
                    
                    boundaryDetection(board, ny, nx, ls);
                }
            }
        }
    }
    
    public void boardInitialize(String[] picture) {
        String base_num = "0123456789";
        String pixel;
        
        rows = picture.length;
        cols = picture[0].length();
        board = new int[rows][cols];
        
        for (int r = 0; r < rows; r++) {
            System.out.println(picture[r]);
            for (int c = 0; c < cols; c++) {
                pixel = picture[r].substring(c, c + 1);
                if (base_num.contains(pixel)) board[r][c] = Integer.parseInt(pixel);
                else if (pixel.equals("X")) board[r][c] = wall;
                else board[r][c] = empty;
            }
        }
    }
    
    public int[] extractMax(int[][] board, List<int[]> block) {
        int max = -9999;
        int c = -9999;
        for (int[] coord: block) {
            
            int pix = board[coord[0]][coord[1]];
            System.out.println(Arrays.toString(coord) + Integer.toString(pix));
            if (pix != fill && pix > max) {
                max = pix;
                c = coord[1];
            }
            if (max == pix) {
                if (coord[1] < c) c = coord[1];
            }
        }
        return new int[] {max, c};
    }
    
    public int calcSum(int[][] board, List<int[]> block) {
        int[] res = extractMax(board, block);
        
        System.out.println(Arrays.toString(res));
        int max = res[0];
        if (max == -9999) return 0;
        int c = res[1];
        int ret = max * block.size();
        
        for (int[] coord: block) {
            ret += (coord[1] - c);
        }
        return ret;
    }
    
    public void visualized(int[][] board) {
        System.out.print("\n");
        for (int[] row: board) {
            for (int k: row) {
                if (k == fill) System.out.print("-");
                else if (k == wall) System.out.print("X");
                else if (k == empty) System.out.print(".");
                else System.out.print(k);
            }
            System.out.print("\n");
        }
    }
    
    public int gradient(String[] picture) {
        System.out.println("================");
        boardInitialize(picture);
        visualized(board);
        List<List<int[]>> blocks = new ArrayList<List<int[]>>();
        int[][] nboard = Deepcopy(board);
        String[] testcase = new String[] {"..X.....", "..X..0..", "1.X.....", "..X.....", "........"};
        System.out.println(picture.toString());
        
        // if (! Arrays.deepEquals(picture, testcase)) return 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] != fill && board[r][c] != wall) {
                    ArrayList<int[]> block = new ArrayList<int[]>();
                    boundaryDetection(board, r, c, block);
                    blocks.add(block);
                    visualized(board);
                }
            }
        }
        int ret = 0;
        System.out.println(blocks.size());
        visualized(nboard);
        for (List<int[]> block: blocks) {
            ret += calcSum(nboard, block);
        }
        
        
        return ret;
        
        
       // fill in this function (and others you can write)
    }
    
}