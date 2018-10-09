public class ListsEqual {
    public int equal (ListNode a1, ListNode a2) {
        
    	
    	while (true) {
    		if (a1 == null && a2 == null) return 1;
    		if ((a1 == null || a2 == null) && a1 != a2) return 0;
        	if (a1.info != a2.info) return 0;
        	if ((a1.next == null || a2.next == null) && a2.next != a1.next) return 0;
        	if (a1.next == null || a2.next == null) return 1;
        	a1 = a1.next;
        	a2 = a2.next;
        }
    }
}