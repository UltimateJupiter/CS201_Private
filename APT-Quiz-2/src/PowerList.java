public class PowerList {
    public ListNode create(int n) {
    	
    	if (n <= 1) return null;
    	
        ListNode first = new ListNode(1);
        
        ListNode last = first;
        
        while (last.info * 2 < n) {
        	last.next = new ListNode(last.info * 2);
        	last = last.next;
        }
        
        return first;
    }
}