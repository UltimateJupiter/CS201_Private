public class LevelLabel {
    public TreeNode h(TreeNode t, int level) {
    	if (t == null) return null;
        return new TreeNode(level + 1, h(t.left, level + 1), h(t.right, level + 1));
    }
    public TreeNode recharge(TreeNode t) {return h(t, 0);}
}