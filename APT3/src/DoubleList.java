public class DoubleList {
    public ListNode bigify(ListNode list) {
    	if (list == null) return list;
    	ListNode first = list;
    	
    	while (list != null) {
    		list.next = new ListNode(list.info, list.next);
    		list = list.next.next;
    	}
        // replace statement below with code you write
        return first;
    }
}