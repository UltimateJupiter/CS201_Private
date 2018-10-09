public class ListLastFirst {
    public ListNode move(ListNode list) {
    	
    	ListNode start = list;
    	if (list == null || list.next == null) return list;
        
    	ListNode first = new ListNode(0, null);
    	while (list != null) {
    		if(list.next.next == null) {
    			first = new ListNode(list.next.info, start);
    			list.next = null;
    			break;
    		}
    		list = list.next;
    	}
		return first;
    }
}