import java.util.Arrays;

class Solution {
    public static String makeFancyString(String s) {
        if(s.length()<=2) return s;
        StringBuilder str = new StringBuilder();
       
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int l = str.length();
            if(l>=2&&str.charAt(l-1)==ch&&str.charAt(l-2)==ch){
                continue;
            }
            str.append(ch);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        // System.out.println(makeFancyString("leeetcode"));
        System.out.println(makeFancyString("aaabaaaa"));
        // System.out.println(makeFancyString("aab"));
    }

    // public static void main(String[] args) {
    //     ListNode head = new ListNode(1);
    //     head.next = new ListNode(2);
    //     head.next.next = new ListNode(3);
    //     head.next.next.next = new ListNode(4);
    //     head.next.next.next.next = new ListNode(5);
    //     head.printLinkedList(head.rotateRight(head, 2));
    // }

    @SuppressWarnings("unused")
    private static void printArray(int[][] arr) {
        for (int[] is : arr) {
            System.out.println(Arrays.toString(is));
        }
    }

    @SuppressWarnings("unused")
    private static void sort2d(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public void printLinkedList(ListNode head){
        System.out.println("---------------------------------------");
        ListNode dummy = head;
        while (dummy!=null) {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }
    }
    public int getDecimalValue(ListNode head) {
        ListNode dummy = head;
        StringBuilder n = new StringBuilder();
        while(dummy!=null){
            n.append(dummy.val);
            dummy = dummy.next;
        }
        return Integer.parseInt(n.toString(),2); 
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        int i = 0;
        while(dummy!=null){
            dummy = dummy.next;
            i++;
        }
        i-=n;

        return remove(head, i);
    }
    public ListNode remove(ListNode head, int n) {
        ListNode dummy = head;
        int i = 0;
        while(dummy!=null){
            if(i==n-1){
                dummy.next = dummy.next.next;
                return head;
            }
            dummy = dummy.next;
            i++;
        }
        return head;
    }
     public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode curr = head;
        int i = 1;
        while(curr.next!=null){
            i++;
            curr = curr.next;
        }
        k=k%i;
        if(k==0) return head;
        curr.next = head;
        int rotations = i-k;
        while(rotations>0){
            curr = curr.next;
            rotations-=1;
        }
        head = curr.next;
        curr.next=null;
        return head;
    }
}
