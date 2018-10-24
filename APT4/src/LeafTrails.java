import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeafTrails {
	
	public Map<String, String> mask(TreeNode t, String index){
		Map<String, String> map = new HashMap<String, String>();
		
		if (t == null) return map;
		if (t.left == null && t.right == null) {
			map.put(Integer.toString(t.info), index);
			return map;
		}
		map.putAll(mask(t.left, index + "0"));
		map.putAll(mask(t.right, index + "1"));
		return map;
	}
	
    public String[] trails(TreeNode tree) {
        
        Map<String, String> map = new HashMap<String, String>();
        map = mask(tree, "");
        Set<String> set = map.keySet();
        String[] keys = set.toArray(new String[set.size()]);
        int[] ints = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
        	ints[i] = Integer.parseInt(keys[i]);
        }
        Arrays.sort(ints);
        
        String[] ret = new String[keys.length];
        for (int i = 0; i < keys.length; i++) {
        	ret[i] = map.get(Integer.toString(ints[i]));
        }
        return ret;
    }
}