package leetcode.two;

/***
 * 您将获得两个非空链表，表示两个非负整数。数字以相反的顺序存储，每个节点包含一个数字。添加两个数字并将其作为链接列表返回。
 *
 * 您可以假设这两个数字不包含任何前导零，除了数字0本身。
 */
public class Main {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode node = new ListNode(0);
        result = node;

        Boolean isS = true;
        int a, b, sum;

        while ((l1 != null || l2 != null) || !isS) {

            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            } else {
                a = 0;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            } else {
                b = 0;
            }
            sum = a + b;

            if (!isS) {
                sum++;
            }

            ListNode tmp = new ListNode(sum % 10);
            node.next = tmp;
            node = node.next;


            isS = sum > 9 ? false : true;
        }

        return result.next;

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
        while (tmp != null) {
            int x = tmp.val;
            System.out.print(x);
            tmp = tmp.next;
        }
    }
}
