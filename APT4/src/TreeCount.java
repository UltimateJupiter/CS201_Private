
public class TreeCount {
    public int count(TreeNode tree) {
    	if (tree == null) return 0;
    	if (tree.left == null && tree.right == null) return 1;
    	return 1 + count(tree.left) + count(tree.right);
    }
}