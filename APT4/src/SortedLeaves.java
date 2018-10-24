import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedLeaves {
	
    private List<String> mask(TreeNode tree){
    	List<String> ls = new ArrayList<String>();
    	if (tree == null) return ls;
    	if (tree.left == null && tree.right == null) {
    		ls.add(Character.toString((char) tree.info));
    		return ls;
    	}
        ls.addAll(mask(tree.left));
        ls.addAll(mask(tree.right));
        return ls;
    }
	
    public String[] values(TreeNode tree) {
    	List<String> ls;
    	ls = mask(tree);
    	System.out.println(ls);
    	String[] ret = new String[ls.size()];
    	ret = ls.toArray(ret);
    	Arrays.sort(ret);
    	return ret;
    }
}