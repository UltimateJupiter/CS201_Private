
public class PairDown {
    public int[] fold(int[] list) {
        int[] new_ls = new int[(list.length + 1) / 2];
        for (int i = 0; i < list.length; i += 2) {
        	if (i == list.length - 1) new_ls[i / 2] = list[i];
        	else new_ls[i / 2] = list[i] + list[i + 1];
        }
        return new_ls;
    }
}