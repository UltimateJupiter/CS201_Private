
public class RemoveMin {
    public ListNode remove (ListNode list) {
    	int min = list.info;
    	ListNode s = list;
    	ListNode list1 = list;
    	while (list != null) {
    		if (list.info < min) min = list.info;
    		list = list.next;
    	}
    	
    	if(list1.info == min) return list1.next;
    	
    	while (list1 != null) {
    		if (list1.next.info == min) {
    			list1.next = list1.next.next;
    			break;
    		}    			
    		list1 = list1.next;
    	}
    	return s;	
    }
}
