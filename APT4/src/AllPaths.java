import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPaths {
	
	private List<String> ls = new ArrayList<String>();
	
	private void mask(TreeNode t, String ind){
    	
    	if (t == null) return;
    	if (ind == "") ind = Integer.toString(t.info);
    	else ind = ind + "->" + Integer.toString(t.info);
    	
    	if (t.left == null && t.right == null) {
    		ls.add(ind);
    		return;
    	}
        mask(t.left, ind);
        mask(t.right, ind);
    }
	
    public String[] paths(TreeNode t) {
        mask(t, "");
        String[] ret = new String[ls.size()];
    	ret = ls.toArray(ret);
    	Arrays.sort(ret);
    	return ret;
    }
}