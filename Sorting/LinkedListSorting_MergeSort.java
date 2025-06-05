/*
For even nodes in LinkedList the fast pointer will end at null
For odd nodes in LinkedList the fast.next pointer will end at null
*/

class Main {
    public static void main(String[] args) {
        
        Main mObj = new Main();
        ListNode head = mObj.makeALinkedList();
        mObj.printLinkedList(head);
        
        head = mObj.mergeSortLinkedList(head);
        mObj.printLinkedList(head);
        
    }
    
    public ListNode mergeSortLinkedList(ListNode head)
    {
        if(head == null || head.next == null) return head;
        ListNode mid = findMidAndSplit(head);
        ListNode left = mergeSortLinkedList(head);
        ListNode right = mergeSortLinkedList(mid);
        return merger(left, right);
    }
    
    public ListNode findMidAndSplit(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    
    public ListNode merger(ListNode left, ListNode right)
    {
        ListNode dummyHead = new ListNode(-1);
        ListNode workingPointer = dummyHead;
        
        while(left!=null && right!=null){
            if(left.val < right.val)
            {
                workingPointer.next = left;
                left = left.next;
            }
            else
            {
                workingPointer.next = right;
                right = right.next;
            }
            workingPointer = workingPointer.next;     
        }
        if(left!=null)
        {
            workingPointer.next = left;
        }
        if(right!=null)
        {
            workingPointer.next = right;
        }
        return dummyHead.next;
    }
    
    public static void printLinkedList(ListNode head)
    {
        ListNode workingPointer = head;
        while(workingPointer!=null)
        {
            System.out.print(workingPointer.val+" ");
            workingPointer= workingPointer.next;
        }
        System.out.println();
    }
    
    public static ListNode makeALinkedList()
    {
        ListNode workingPointer = null;
        ListNode head = new ListNode(5);
        workingPointer = head;
        workingPointer.next = new ListNode(1);
        workingPointer = workingPointer.next;
        workingPointer.next = new ListNode(3);
        workingPointer = workingPointer.next;
        workingPointer.next = new ListNode(2);
        workingPointer = workingPointer.next;
        workingPointer.next = new ListNode(4);
        workingPointer = workingPointer.next;
        return head;
    }
}
class ListNode
{
    int val;
    ListNode next;
    ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}