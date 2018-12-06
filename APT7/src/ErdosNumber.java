import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class ErdosNumber {
    
    TreeMap<String, Integer> name2level = new TreeMap<String, Integer>();
    HashMap<String, HashSet<String>> name2fellow = new HashMap<String, HashSet<String>>();
    
    public void pubs2fellow(String[] pubs) {
        for (String ls: pubs) {
            String[] names = ls.split("\\s+");
            HashSet<String> names_set = new HashSet<String>(Arrays.asList(names));
            for (String name: names) {
                name2level.putIfAbsent(name, -1);
                name2fellow.putIfAbsent(name, new HashSet<String>());
                name2fellow.get(name).addAll(names_set);
            }
        }
        for (String name: name2fellow.keySet()) {
            name2fellow.get(name).remove(name);
        }
    }
    
    
    public void bfs(String name_in) {
        Queue<String> qu = new LinkedList<String>();
        qu.add(name_in);
        name2level.put(name_in, 0);
        while(qu.size() > 0) {
            String name = qu.remove();
            for (String peer: name2fellow.get(name)) {
                if (name2level.get(peer) == -1) {
                    name2level.put(peer, 1 + name2level.get(name));
                    qu.add(peer);
                }
            }
        }
    }
    
    public String[] calculateNumbers(String[] pubs) {
        pubs2fellow(pubs);
        int size = name2level.size();
        String[] ret = new String[size];
        bfs("ERDOS");
        
        int cnt = 0;
        
        System.out.println(name2level.toString());
        for (String name: name2level.keySet()) {
            if (name2level.get(name) != -1) name = name + " " + Integer.toString(name2level.get(name));
            ret[cnt] = name;
            cnt += 1;
        }
        return ret;
    }
}