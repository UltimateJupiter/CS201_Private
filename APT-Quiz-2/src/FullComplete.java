public class FullComplete {
    public TreeNode create(int n) {
        if (n == 0) return null;
        return new TreeNode(2, create(n - 1), create(n - 1));
    }
}