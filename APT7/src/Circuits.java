import java.util.ArrayList;
import java.util.Collections;

public class Circuits {
    ArrayList<ArrayList<Integer>> con = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> cos = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> total = new ArrayList<Integer>();
    
    public void calc_remain(int node, int cost) {
        
        if (con.get(node).size() == 0) total.add(cost);
        for (int k = 0; k < con.get(node).size(); k++) {
            int nd = con.get(node).get(k);
            calc_remain(nd, cost + cos.get(node).get(k));
        }
    }
    public int howLong(String[] connects, String[] costs) {
        
        for (int i = 0; i < connects.length; i++) {
            con.add(new ArrayList<Integer>());
            cos.add(new ArrayList<Integer>());
            if (connects[i].equals("")) continue;
            for (String str: connects[i].split("\\s+")) con.get(i).add(Integer.parseInt(str));
            for (String str: costs[i].split("\\s+")) cos.get(i).add(Integer.parseInt(str));
        }
        
        for (int i = 0; i < connects.length; i++) calc_remain(i, 0);
        
        return Collections.max(total);
    }
}