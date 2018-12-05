public class FindPath {
    
    String ret  = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    
    public void trace(TreeNode node, int target, String record) {
        if (node == null) return;
        if (node.info == target) {
            if (ret.length() > record.length()) ret = record;
        }
        trace(node.left, target, record + "0");
        trace(node.right, target, record + "1");
    }
    
    public String path(TreeNode root, int target) {
        trace(root, target, "");
        if   (ret.equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) return "nopath";
        return ret;
    }
}
