import java.util.ArrayList;
import java.util.HashSet;

public class FriendScore {
	public int highestScore(String[] friends) {
		ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < friends.length; i++) {
			map.add(new ArrayList<Integer>());
			for (int j = 0; j < friends.length; j++) {
				if (friends[i].substring(j, j + 1).equals("Y")) {
					map.get(i).add(j);
				}
			}
		}
		ArrayList<ArrayList<Integer>> map2 = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < friends.length; i++) {
			map2.add(new ArrayList<Integer>());
			for (int f: map.get(i)) {
				map2.get(i).add(f);
				for (int f2: map.get(f)) {
					if (f2 != i) {
						map2.get(i).add(f2);
					}
				}
			}
		}
		System.out.println(map2.toString());
		int mark = 0; int max = 0;
		for (int i = 0; i < friends.length; i++) {
			if (new HashSet(map2.get(i)).size() > max) {
				max = new HashSet(map2.get(i)).size();
				mark = i;
			}
		}
		return max;
	}
}
