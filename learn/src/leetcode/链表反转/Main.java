package leetcode.链表反转;


public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        show(l1);
        reverseIt(l1);
        show(l1);
    }


    public static void reverseIt(ListNode l1) {

        if (l1.next != null){
            reverseIt(l1.next);
        }

    }
    public static void show(ListNode l1) {

        if (l1.next != null){
            reverseIt(l1.next);
        }
        System.out.println(l1.val);

    }
}
