import java.util.Arrays;

public class OlympicCandles {
    public int[] light(int num, int[] candles) {
    	int cnt = 0;
    	for (int i = candles.length - 1; i >= 0; i--) {
    		if (candles[i] > 0) {
    			candles[i] = candles[i] - 1;
    			cnt += 1;
    		}
    		
    		if (cnt == num) break;
    	}
    	return candles;
    }
    
    public boolean available(int num, int[] candles) {
    	int cnt = 0;
    	for (int i : candles) {
    		if (i > 0) cnt += 1;
    	}
    	if (cnt >= num) return true;
    	else return false;
    }
    
	public int numberOfNights(int[] candles){
		
		int night = 0;
		while (available(night + 1, candles)) {
			Arrays.sort(candles);
			night += 1;
			candles = light(night, candles);
			System.out.println(Arrays.toString(candles));
		}
		return night;
	}
}
