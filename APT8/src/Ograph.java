import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Ograph {
    
    HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
    HashSet<Integer> cleared = new HashSet<Integer>();
    ArrayList<Integer> res = new ArrayList<Integer>();
    ArrayList<Integer> initial;
    
    private void getGraph (String[] data) {
        for (int i = 0; i < data.length; i++) {
            String[] sp = data[i].split(" ");
            HashSet<Integer> sp_num = new HashSet<Integer>();
            for (String k: sp) {
                sp_num.add(Integer.parseInt(k));
            }
            graph.putIfAbsent(i, sp_num);
        }
    }
    
    public int[] components(String[] data) {
        
        getGraph(data);
        System.out.println(graph.toString());
        initial = new ArrayList<Integer>(graph.keySet());
        
        while (initial.size() > 0) {
            Queue<Integer> qu = new LinkedList<Integer>();
            HashSet<Integer> checked = new HashSet<Integer>();
            qu.add(initial.get(0)); checked.add(initial.get(0));
            
            while (qu.size() > 0) {
                int target = qu.remove();
                checked.add(target);
                for (int s: graph.get(target)) {
                    if (! checked.contains(s)) {
                        qu.add(s);
                    }
                }
            }
            res.add(checked.size());
            initial.removeAll(checked);
        }
        
        Collections.sort(res); //, Collections.reverseOrder());
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }  
}