import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
    
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
    
    public String ladderExists(String[] words, 
                               String from, String to) {
        
        makeMap(words);
        
        ArrayList<String> tmp = exists(words, to);
        if (tmp.size() < 0) return "none";
        tmp = exists(words, from);
        if (tmp.size() < 0) return "none";
        myGraph.put(from, tmp);
        
        Queue<String> myQueue = new LinkedList<String> ();
        HashSet<String> checked = new HashSet<String>();
        
        myQueue.add(from);
        
        while (myQueue.size() > 0) {
            String target = myQueue.remove();
            for (String s: myGraph.get(target)) {
                if (oneLetterAway(s, to)) return "ladder";
                if (! checked.contains(s)) {
                    myQueue.add(s);
                    checked.add(s);
                }
            }
        }
        
        return "none";
    }
}