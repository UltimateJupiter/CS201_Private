public class ListShift {
    public ListNode shift(ListNode start, int key) {
        ListNode tmp = start;
        
        ListNode right = null, right_init = null;
        ListNode left = null, left_init = null;
        
        while (tmp != null) {
            if (tmp.info > key) {
                if (left_init == null) {
                    left_init = new ListNode(tmp.info);
                    left = left_init;
                }
                else {
                    left.next = new ListNode(tmp.info);
                    left = left.next;
                }
                
            }
            else {
                if (right_init == null) {
                    right_init = new ListNode(tmp.info);
                    right = right_init;
                }
                else {
                    right.next = new ListNode(tmp.info);
                    right = right.next;
                }
            }
            tmp = tmp.next;
        }
        if (left_init == null) return right_init;
        
        
        left.next = right_init;
        return left_init;
    }
}
