public class TreeSome {
    
    int cnt = 0;
    
    public int ret(int min, int max, int in) {
        if (in <= max && in >= min) return 1;
        else return 0;
    }
    
    public void search(TreeNode node, int min, int max) {
        if (node == null) return;
        cnt += ret(min, max, node.info);
        search(node.left, min, max);
        search(node.right, min, max);
    }
    
    public int count(TreeNode root, int low, int high) {
        search(root, low, high);
        return cnt;
    }
}