import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TournamentRanker {
	HashMap<String, Double> map = new HashMap<String, Double>();
	
	public class weight_comp implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			if (map.get(o2) - map.get(o1) != 0) return (map.get(o2) > map.get(o1))? 1 : -1;
			return - o1.compareTo(o2);
		}
	}
	
	public String[] rankTeams(String[] names, String[] lostTo) {
		System.out.println("=============");
		for (String name: names) {
			map.put(name, 0.0);
		}
		map.put("", 0.0);
		for (String name: lostTo) {
			if (name.equals("")) continue;
			map.put(name, map.get(name) + 100000);
		}
		HashMap<String, String> lose = new HashMap<String, String>();
		for (int i = 0; i < names.length; i++) {
			lose.put(names[i], lostTo[i]);
		}
		
		Arrays.sort(names, new weight_comp());
		
		String[] rep_names = new String[names.length];
		
		while (! Arrays.deepEquals(rep_names, names)) {
			for (int i = 0; i < names.length; i++) {
				rep_names[i] = names[i];
			}
			for (String team: names) {
				map.put(team, (map.get(team) + map.get(lose.get(team)) / 100));
			}
			Arrays.sort(names, new weight_comp());
			System.out.println(map.toString());
		}
		System.out.println(Arrays.toString(names));
		return names;
	}
}
