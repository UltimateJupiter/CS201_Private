public class SumTwoTrees {
    public TreeNode add(TreeNode a, TreeNode b) {
        if (a == null) return b;
        if (b == null) return a;
        return new TreeNode(a.info + b.info, add(a.left, b.left), add(a.right, b.right));
    }
}