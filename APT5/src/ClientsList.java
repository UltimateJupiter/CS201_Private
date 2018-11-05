import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {
	
	public class Person{
		String first;
		String last;
		String total;
		public Person(String s) {
			first = s.split(" ")[0];
			last = s.split(" ")[1];
			total = s;
		}
		public String getLast(){
			return last;
		}
		public String getFirst(){
			return first;
		}
		public String getTotal(){
			return total;
		}
	}
	
    public String[] dataCleanup(String[] names) {
        Person[] ls = new Person[names.length];
        for (int i = 0; i < names.length; i++) {
            String str = names[i];
            if (str.contains(",")) {
        		String out = "";
        		String[] tmp = str.split(", ");
        		out += tmp[1].concat(" ").concat(tmp[0]);
        		ls[i] = new Person(out); 
        	}
            else ls[i] = new Person(str);
        }
        
        Comparator<Person> comp = Comparator.comparing(Person::getLast).thenComparing(Person::getFirst);
        Arrays.sort(ls, comp);
        
        String[] ret = new String[names.length];
        for (int i = 0; i < names.length; i++) {
        	ret[i] = ls[i].getTotal();
        }
        return ret;
    }
}