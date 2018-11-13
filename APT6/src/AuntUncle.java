import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AuntUncle {
	
	List<Person> ls = new ArrayList<Person>();
	Map<String, Person> map = new HashMap<String, Person>();
	
    private class Person{
    	public String wo;
    	Person mom, dad;
    	
    	public Set<String> after = new HashSet<String>();
    	
    	public Person(String w) {
    		wo = w;
    		dad = null;
    		mom = null;
    		map.put(w, this);
    		System.out.println(wo + " Initialized");
    	}
    	
    	public void setAfter(String str) {
    		after.add(str);
    	}
    	
    	public Person getDad() {
    		return dad;
    	}
    	
    	public Person getMom() {
    		return mom;
    	}
    	
    	public void setDad(String d) {
    		if (map.keySet().contains(d)) this.dad = map.get(d);
    		else{
    			this.dad = new Person(d);
    			map.put(d, this.dad);
    		}
    		map.get(d).setAfter(this.wo);
    		System.out.println(wo + " Set Dad: " + d);
    	}
    	
    	public void setMom(String m) {
    		if (map.keySet().contains(m)) this.mom = map.get(m);
    		else{
    			this.mom = new Person(m);
    			map.put(m, this.mom);
    		}
    		map.get(m).setAfter(this.wo);
    		System.out.println(wo + " Set mom: " + m);
    	}
    }
    
    public String[] list(String[] parents, String target) {
    	System.out.println("====================\n");
    	Person me;
    	HashSet<String> set = new HashSet<String>();
    	
    	for (String all: parents) {
    		System.out.println(all);
    		String[] splice = all.split(" ");
    		String DAD = splice[0], MOM = splice[1], SELF = splice[2];
    		
    		if (! map.containsKey(SELF)) me = new Person(SELF);
    		else me = map.get(SELF);
    		me.setMom(MOM);
    		me.setDad(DAD);
    	}
    	
    	me = map.get(target);
    	System.out.println("\n\n");
    	Person mom = me.getMom();
    	Person dad = me.getDad();
    	
    	System.out.println(mom);
    	System.out.println(dad);
    	
    	if (mom != null) {
    		System.out.println(me.wo + "'s mom: " + mom.wo);
	    	if (mom.getMom() != null) {
	    		set.addAll(mom.getMom().after);
	    		System.out.println(mom.getMom().after);
	    	}
	    	
	    	if (mom.getDad() != null) {
	    		set.addAll(mom.getDad().after);
	    		System.out.println(mom.getDad().after);
	    	}
    	}
    	
    	if (dad != null) {
    		System.out.println(me.wo + "'s dad: " + dad.wo);
    	    if (dad.getMom() != null) {
    	    	set.addAll(dad.getMom().after);
    	    	System.out.println(dad.getMom().after);
    	    }
    	    if (dad.getDad() != null) {
    	    	set.addAll(dad.getDad().after);
    	    	System.out.println(dad.getDad().after);
    	    }
    	    
    	}
    	if (set.contains(me.wo)) set.remove(me.wo);
    	
    	for (String all: parents) {
    		System.out.println(all);
    		String[] splice = all.split(" ");
    		String DAD = splice[0], MOM = splice[1], SELF = splice[2];
    		
    		if (SELF.equals(target)) {
    			System.out.println(SELF + " Found!!!");
    			if (set.contains(DAD)) set.remove(DAD);
    			if (set.contains(MOM)) set.remove(MOM);
    		}
    	}
    	//if (set.contains(mom.wo)) set.remove(mom.wo);
    	//if (set.contains(dad.wo)) set.remove(dad.wo);
    	
    	String[] ret = new String[set.size()];
    	ret = set.toArray(ret);
    	Arrays.sort(ret);
    	return ret;
    }
}
