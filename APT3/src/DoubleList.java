public class DoubleList {
    public ListNode bigify(ListNode list) {
    	if (list == null) return list;
    	while (list != null) {
    		list.next = new ListNode(list.info, bigify(list.next));
    	}
    	// replace statement below with code you write
        return list;
    }
}