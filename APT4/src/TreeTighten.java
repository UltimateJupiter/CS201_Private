
public class TreeTighten {
    public TreeNode tighten(TreeNode t) {
    	if (t == null) return null;
    	t.left = tighten(t.left);
    	t.right = tighten(t.right);
    	
       	if (t.left == null && t.right == null) return t;
    	if (t.left == null) return t.right;
    	if (t.right == null) return t.left;
    	return t;
    }
}

/*
public class TreeTighten {
	
	private int simp(TreeNode t) {
		if (t == null) return 0;
		if (t.left == null && t.right == null) return 1;
		if (simp(t.left) + simp(t.right) == 1) return 1;
		if (simp(t.left) + simp(t.right) > 1) return -1;
		if (simp(t.left) == -1 || simp(t.right) == -1) return -1;
		return -1;
	}
	
	private int getMax(TreeNode t) {
		if (t == null) return -1;
		if (t.left == null && t.right == null) return t.info;
		return Math.max(getMax(t.left), getMax(t.right));
	}
	
    public TreeNode tighten(TreeNode t) {
        if (t == null) return null;
        // if (t.left == null && t.right == null) return null;
        if (simp(t) == 1) {
        	t.info = getMax(t);
        	t.right = null;
        	t.left = null;
        }
        else {
        	tighten(t.left);
        	tighten(t.right);
        }
        return t;
    }
}*/