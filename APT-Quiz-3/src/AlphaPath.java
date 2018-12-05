import java.util.Arrays;

public class AlphaPath {
    
    int cnt = 0;
    String[][] matrix;
    
    int[] rd = {-1, 0, 1, 0};
    int[] cd = {0, -1, 0, 1};
    
    public String get_char(String in) {
        char now = in.charAt(0);
        now = (char) (now + 1);
        return String.valueOf(now);
    }
    
    public void get_path(int r, int c) {
        if (matrix[r][c].equals("Z")) cnt += 1;
        String target = get_char(matrix[r][c]);
        System.out.println(target);
        // System.out.println(matrix[r][c]);
        // System.out.println(cnt > 0);
        matrix[r][c] = ".";
        for (int i = 0; i < 4; i++) {
            int nr = r + rd[i];
            int nc = c + cd[i];
            if (-1 < nr && nr < matrix.length && -1 < nc && nc < matrix[0].length) {
                if (matrix[nr][nc].equals(target)) get_path(nr, nc);
            }
        }
    }
    
    
    
    public String hasPath(String[] maze) {
        System.out.println("=========");
        int start_r = 0, start_c = 0;
        matrix = new String[maze.length][maze[0].length()];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length(); j++) {
                matrix[i][j] = maze[i].substring(j, j + 1);
                if (matrix[i][j].equals("A")) {
                    start_c = j;
                    start_r = i;
                }
            }
        }
        get_path(start_r, start_c);
        System.out.println(Arrays.deepToString(matrix));
       
        if (cnt > 0) return "YES";
        else return "NO";
    }
} 