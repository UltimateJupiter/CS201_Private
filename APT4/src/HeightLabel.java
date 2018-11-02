
public class HeightLabel {
    public TreeNode rewire(TreeNode t) {
    	if (t == null) return null;
    	if (t.left == null && t.right == null) return new TreeNode(1);
    	
    	int count = 0;
    	TreeNode newT = new TreeNode(count);
    	newT.left = rewire(t.left);
    	newT.right = rewire(t.right);
        
        
    	if (newT.left == null) count = newT.right.info + 1;
    	else if (newT.right == null) count = newT.left.info + 1;
    	else count = Math.max(newT.right.info, newT.left.info) + 1;
        
        newT.info = count;
        return newT;
    }
}
/*
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
}*/