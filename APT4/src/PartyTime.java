import java.util.Random;

public class PartyTime {
    Random myRandom;
    
    public long out(TreeNode t) {
    	if (t == null) return 0;
    	return maximalFun(t.left) + maximalFun(t.right);
    }
    
    public long in(TreeNode t) {
    	if (t == null) return 0;
    	return out(t.left) + out(t.right) + t.info;
    }

    public long maximalFun(TreeNode t){
        if (t == null) return 0;
        return Math.max(in(t), out(t));
    }
    
    public TreeNode makeComplete(int level) {
    	if (level == 0) return null;
    	return new TreeNode(myRandom.nextInt(), makeComplete(level - 1), makeComplete(level - 1));
    }

    public long maxFun(int level, int seed) {
        myRandom = new Random(seed);        
        TreeNode t = makeComplete(level);
        return maximalFun(t);
    }
}