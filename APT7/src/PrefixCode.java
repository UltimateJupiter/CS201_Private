public class PrefixCode {
	public String isOne(String[] words) {
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (j  == i) continue;
				String thi = words[i], tha = words[j];
				if (thi.length() >= tha.length()) continue;
				String tha_top = tha.substring(0, thi.length());
				if (tha_top.equals(thi)) return "No, " + Integer.toString(i);
			}
		}
		return "Yes";
	}
}