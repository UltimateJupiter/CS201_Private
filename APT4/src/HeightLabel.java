public class HeightLabel {
	
	private int level(TreeNode t) {
		if (t == null) return 0;
		if (t.left == null && t.right == null) return 1;
		return Math.max(level(t.right), level(t.left)) + 1;
	}
	
    public TreeNode rewire(TreeNode t) {
        if (t == null) return null;
    	t.info = level(t);
    	rewire(t.left);
    	rewire(t.right);
        return t;
    }
}