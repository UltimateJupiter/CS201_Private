import java.util.Arrays;
import java.util.Comparator;

public class Dirsort {
	
	public class Dircomp implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			String[] a = o1.split("/");
			String[] b = o2.split("/");
			
			if (a.length != b.length) return a.length - b.length;
			
			for (int i = 0; i < a.length; i++) {
				if (a[i].compareTo(b[i]) != 0) {
					System.out.println(a[i] + b[i]);
					return a[i].compareTo(b[i]);
				}
			}
			return 0;
		}

	}
    public String[] sort(String[] dirs) {
        Arrays.sort(dirs, new Dircomp());
        return dirs;
    }
}