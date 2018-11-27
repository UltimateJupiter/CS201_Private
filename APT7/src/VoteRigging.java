import java.util.Arrays;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
    	
    	if (votes.length == 1) return 0;
    	
        int fav = votes[0];
        int[] rem = Arrays.copyOfRange(votes, 1, votes.length);
        Arrays.sort(rem);
        int cnt = 0;
        while (rem[rem.length - 1] >= fav) {
        	
        	rem[rem.length - 1] -= 1;
        	fav += 1;
        	cnt += 1;
        	Arrays.sort(rem);
        }
        return cnt;
    }
}