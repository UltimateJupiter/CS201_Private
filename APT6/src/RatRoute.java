import java.util.ArrayList;
import java.util.List;

public class RatRoute {
	
	int rows, cols;
	int yC, xC;
	int counts = 0;
	
	public boolean faroff(int y, int x, int ny, int nx) {
		if (Math.abs(ny - yC) > Math.abs(y - yC) || 
				Math.abs(nx - xC) > Math.abs(x - xC)) return true;
		return false;
	}
	
	public void seek (String[][] board, int y, int x) {
		List<int[]> psbs = valid(board, y, x);
		if (psbs == null) {
			counts += 1;
			return;
		}
		for (int[] pair: psbs) {
			if (! board[y][x].equals("R")) board[y][x] = "X";
			
			seek(board, pair[0], pair[1]);
			if (! board[y][x].equals("R")) board[y][x] = ".";
		}
	}
	
    public int numRoutes(String[] enc) {
    	
        rows = enc.length;
        cols = enc[0].length();
        int yR = 0, xR = 0;
        String[][] board = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
        	board[i] = enc[i].split("");
        	for (int j = 0; j < cols; j++) {
                if (board[i][j].equals("R")) {
                	yR = i;
                	xR = j;
                }
                if (board[i][j].equals("C")) {
                	yC = i;
                	xC = j;
                }
        	}
        }
        seek(board, yR, xR);
        return counts;
    }
    
    public List<int[]> valid(String[][] board, int y, int x) {
    	List<int[]> possibles = new ArrayList<int[]>();
        int nx, ny;
        int[] xd = {-1,0,1,0};
        int[] yd = {0,1,0,-1};
        for (int i = 0; i < 4; i++) {
        	nx = x + xd[i];
        	ny = y + yd[i];
        	if (ny > -1 && ny < rows && nx > -1 && nx < cols) {
        		
        		if (board[ny][nx].equals("C")) return null;
        		// if (board[ny][nx].equals(".")) possibles.add(new int[] {ny, nx});
        		if (! faroff(y, x, ny, nx)) {
        			if (board[ny][nx].equals(".")) possibles.add(new int[] {ny, nx});
        		}
        	}
        }
    	return possibles;
    }
}