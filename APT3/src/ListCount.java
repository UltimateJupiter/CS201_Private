public class ListCount {
    public int count (ListNode list) {
    	int i = 0;
        while (list != null) {
        	i += 1;
        	list = list.next;
        }
    	return i;
    }
}