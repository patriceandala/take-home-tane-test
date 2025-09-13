
// Question 5: Rotate List
//  Rotate a linked list by moving each element n positions to the right.


public class Question5_RotateList {
    
    /**
     * Node class for the linked list
     */
    static class ListNode {
        String val;
        ListNode next;
        
        ListNode(String val) {
            this.val = val;
            this.next = null;
        }
    }
    
    /**
     * Rotates the linked list to the right by n positions
     */
    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }
        
        // Calculate the length of the list
        int length = getLength(head);
        
        // Calculate effective rotation (n % length)
        int effectiveRotation = n % length;
        
        if (effectiveRotation == 0) {
            return head; // No rotation needed
        }
        
        // Find the new tail (at position length - effectiveRotation - 1)
        ListNode current = head;
        for (int i = 0; i < length - effectiveRotation - 1; i++) {
            current = current.next;
        }
        
        // Split the list at the new tail
        ListNode newTail = current;
        ListNode newHead = current.next;
        
        // Find the original tail to connect it to the original head
        ListNode originalTail = newHead;
        while (originalTail.next != null) {
            originalTail = originalTail.next;
        }
        
        // Reconnect the list
        originalTail.next = head;
        newTail.next = null;
        
        return newHead;
    }
    
    /**
     * Helper method to get the length of the linked list
     */
    private static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    /**
     * Helper method to create a linked list from an array of strings
     */
    public static ListNode createList(String[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }
    
    /**
     * Helper method to print a linked list
     */
    public static String printList(ListNode head) {
        if (head == null) {
            return "null";
        }
        
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append("->");
            } else {
                sb.append("->null");
            }
            current = current.next;
        }
        
        return sb.toString();
    }
    
    /**
     * Helper method to convert linked list to array for comparison
     * @param head Head of the linked list
     * @return Array representation of the list
     */
    public static String[] listToArray(ListNode head) {
        if (head == null) {
            return new String[0];
        }
        
        int length = getLength(head);
        String[] result = new String[length];
        ListNode current = head;
        
        for (int i = 0; i < length; i++) {
            result[i] = current.val;
            current = current.next;
        }
        
        return result;
    }
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        // Test case from the example
        String[] values1 = {"ID_A01", "ID_A02", "ID_A03", "ID_A04", "ID_A05", "ID_A06"};
        ListNode head1 = createList(values1);
        System.out.println("Original list: " + printList(head1));
        
        ListNode rotated1 = rotateRight(head1, 2);
        System.out.println("After rotating by 2: " + printList(rotated1));
        // Expected: "ID_A05"->"ID_A06"->"ID_A01"->"ID_A02"->"ID_A03"->"ID_A04"->null
        
        System.out.println("\n=== Additional Test Cases ===");
        
        // Test case 1: Rotate by 0 (no rotation)
        String[] values2 = {"A", "B", "C", "D"};
        ListNode head2 = createList(values2);
        ListNode rotated2 = rotateRight(head2, 0);
        System.out.println("Rotate by 0: " + printList(rotated2));
        // Expected: "A"->"B"->"C"->"D"->null
        
        // Test case 2: Rotate by list length (no effective rotation)
        String[] values3 = {"X", "Y", "Z"};
        ListNode head3 = createList(values3);
        ListNode rotated3 = rotateRight(head3, 3);
        System.out.println("Rotate by list length (3): " + printList(rotated3));
        // Expected: "X"->"Y"->"Z"->null
        
        // Test case 3: Single element list
        String[] values4 = {"Single"};
        ListNode head4 = createList(values4);
        ListNode rotated4 = rotateRight(head4, 1);
        System.out.println("Single element rotate by 1: " + printList(rotated4));
        // Expected: "Single"->null
        
        // Test case 4: Two elements
        String[] values5 = {"First", "Second"};
        ListNode head5 = createList(values5);
        ListNode rotated5 = rotateRight(head5, 1);
        System.out.println("Two elements rotate by 1: " + printList(rotated5));
        // Expected: "Second"->"First"->null
        
        // Test case 5: Rotate by more than list length
        String[] values6 = {"A", "B", "C"};
        ListNode head6 = createList(values6);
        ListNode rotated6 = rotateRight(head6, 5);
        System.out.println("Rotate by 5 (length 3): " + printList(rotated6));
        // Expected: "B"->"C"->"A"->null (effective rotation = 5 % 3 = 2)
        
        // Test case 6: Empty list
        ListNode head7 = null;
        ListNode rotated7 = rotateRight(head7, 2);
        System.out.println("Empty list: " + printList(rotated7));
        // Expected: null
        
        // Test case 7: Large rotation
        String[] values8 = {"1", "2", "3", "4", "5"};
        ListNode head8 = createList(values8);
        ListNode rotated8 = rotateRight(head8, 7);
        System.out.println("Large rotation (7 on length 5): " + printList(rotated8));
        // Expected: "4"->"5"->"1"->"2"->"3"->null (effective rotation = 7 % 5 = 2)
    }
}
