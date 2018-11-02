public class DepthSum {
	
	public TreeNode level(TreeNode t, int level) {
		if (t == null) return null;
		t.left = level(t.left, level + 1);
		t.right = level(t.right, level + 1);
		t.info = t.info * level;
		return t;
	}
	
	public int sum(TreeNode t) {
		if (t == null) return 0;
		return sum(t.left) + sum(t.right) + t.info;
	}
	
    public int value(TreeNode tree){
        // replace with working code
    	tree = level(tree, 1);
        return sum(tree);
    }
}
