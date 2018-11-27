import java.util.HashMap;

public class HuffmanDecoding {
	public String decode(String archive, String[] dictionary) {
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < dictionary.length; i++) {
			char tmp = (char) ('A' + i);
			String str = Character.toString(tmp);
			map.put(dictionary[i], str);
		}
		String ret = "";
		while (archive.length() > 0) {
			int l = 1;
			while (! map.containsKey(archive.substring(0, l))) {
				l += 1;
			}
			ret += map.get(archive.substring(0, l));
			archive = archive.substring(l, archive.length());
		}
		return ret;
	}
}
