import java.util.Arrays;

public class FloodRelief {
	
	int[][] map, water;
	int rows, cols;
	int[] rd = {-1,0,1,0};
    int[] cd = {0,1,0,-1};
    
    public boolean inside(int r, int c) {
    	if (r > -1 && r < rows && c > -1 && c < cols) return true;
    	else return false;
    }
	
	public int[][] hasWater(int[][] water){
		int[][] ret = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
        	for (int c = 0; c < cols; c++) {		
        		if (water[r][c] > 0) ret[r][c] = 1;
        		else ret[r][c] = 0;
        	}
		}
		return ret;
	}
    
	public int[][] waterflow(int[][] water){
		int[][] ret = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
        	for (int c = 0; c < cols; c++) {
        		
        		int pix = water[r][c];
        		if (pix == 0) continue;
        		
        		for (int i = 0; i < 4; i++) {
                	int pr = r + rd[i];
                	int pc = c + cd[i];
                	if (inside(pr, pc)) {
                		if (map[pr][pc] < map[r][c]) {
                			pix = 0;
                			ret[pr][pc] += 1;
                		}
                		if (pix > 0) {
                			if (map[pr][pc] == map[r][c] && water[r][c] > water[pr][pc]) {
                				if (water[pr][pc] == 0) {
                					pix = 0;
                				}
                			}
                		}
                	}
        		}
        		ret[r][c] = pix;
        	}
		}
		return ret;
	}
	
	
	public void vis(int[][] board) {
		System.out.print("\n");
		for (int[] row: board) {
			for (int k: row) {
				if (k == 0) System.out.print("-");
				else System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	
	public void clean(int r, int c) {
		water[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int pr = r + rd[i];
			int pc = c + cd[i];
			if (inside(pr, pc) && water[pr][pc] == 1) clean(pr, pc);
		}
	}
	
    public int minimumPumps(String[] heights){
        rows = heights.length;
        cols = heights[0].length();
    	map = new int[rows][cols];
        water = new int[rows][cols];
        
        for (int r = 0; r < rows; r++) {
        	System.out.println(heights[r]);
        	for (int c = 0; c < cols; c++) {
        		water[r][c] = 1;
        		map[r][c] = heights[r].charAt(c);
        	}
        }
        
        vis(water);
        while(! Arrays.deepEquals(hasWater(water), hasWater(waterflow(water)))) {
        	water = waterflow(water);
        }
        vis(water);
        water = hasWater(water);
        
        int cnt = 0;
        
        for (int r = 0; r < rows; r++) {
        	for (int c = 0; c < cols; c++) {
        		if (water[r][c] == 1) {
        			clean(r, c);
        			cnt += 1;
        		}
        	}
        }

        return cnt;
    }
}
