public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        if (list == null) return list;
        ListNode begin = list;
        while (list != null) {
        	
        	// ListNode real_next = list.next;
        	for (int i = 0; i < amount - 1; i++) {
        		list.next = new ListNode(list.info, list.next);
        	}
        	for (int i = 0; i < amount; i++) {
        		list = list.next;
        	}
        }
        return begin;
    }
}