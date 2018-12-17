import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AllWordLadders {
    
    HashMap<String, ArrayList<String>> myGraph = new HashMap<String, ArrayList<String>>();
    
    private boolean oneLetterAway(String a, String b) {
        if (a.length() != b.length()) return false;
        int diff_count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (! a.substring(i, i + 1).equals(b.substring(i, i + 1))) diff_count += 1;
        }
        if (diff_count == 1) return true;
        return false;
    }
    
    private void makeMap(String[] words) {
        for (String w: words) {
            myGraph.put(w, new ArrayList<String>());
            for (String j: words) {
                if (oneLetterAway(w, j)) {
                    myGraph.get(w).add(j);
                }
            }
        }
    }
    
    private ArrayList<String> exists(String[] words, String target) {
        ArrayList<String> ret = new ArrayList<String>();
        for (String w: words) {
            if (oneLetterAway(w, target)) {
                ret.add(w);
            }
        }
        return ret;
    }
    
    public int[] solve(String[] words, String from, String to) {
        int[] blank = {0, 0};
        // System.out.println("----");
       
        makeMap(words);
       
        ArrayList<String> tmp = exists(words, to);
        if (tmp.size() < 0) return blank;
        tmp = exists(words, from);
        if (tmp.size() < 0) return blank;
        myGraph.put(from, tmp);
        
        Queue<String> myQueue = new LinkedList<String> ();
        HashSet<String> checked = new HashSet<String>();
        HashMap<String, Integer> str2int = new HashMap<String, Integer>();
        str2int.put(from, 0);
        
        myQueue.add(from);
        int mark = 0;
        int cnt = 0;
        while (myQueue.size() > 0) {
            String target = myQueue.remove();
            if (str2int.get(target) > mark && mark != 0) break;
            for (String s: myGraph.get(target)) {
                if (oneLetterAway(s, to)) {
                    mark = str2int.get(target);
                    // System.out.println(mark);
                    cnt += 1;
                }
                
                if (! checked.contains(s)) {
                    myQueue.add(s);
                    checked.add(s);
                    str2int.put(s, str2int.get(target) + 1);
                }
            }
        }
        int[] ret = {mark + 3, cnt};
        
        if (cnt == 0)return blank;
        else return ret;
    }
}
