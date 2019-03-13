package leetcode.add_two_numbers;

/***
 * 您将获得两个非空链表，表示两个非负整数。数字以相反的顺序存储，每个节点包含一个数字。添加两个数字并将其作为链接列表返回。
 *
 * 您可以假设这两个数字不包含任何前导零，除了数字0本身。
 */
public class Main {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNodeResult = null;
        while (l1.next == null || l2.next == null){

        }
        return listNodeResult;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode tmp = new Main().addTwoNumbers(l1, l4);
        System.out.println(tmp);

    }
}
