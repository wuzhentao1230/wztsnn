package leetcode.链表的中间结点;

public class Solution {
    //简单的思路  先查长度然后遍历获取中间节点
    public ListNode middleNode(ListNode head) {
        int currNum = 0;
        ListNode tmp1 = head;
        ListNode middleNode = null;
        while(tmp1.next != null){
            tmp1 = tmp1.next;
            currNum ++;
        }
        if (currNum == 0){
            return head;
        }
        int middleNodeNum = currNum/2;
        int isTwo = currNum%2;
        currNum = 0;
        ListNode tmp2 = head;
        while(tmp2.next != null){

            if(middleNodeNum == currNum && isTwo == 0){
                middleNode = tmp2;
                break;
            }else if(middleNodeNum == currNum && isTwo == 1){
                middleNode = tmp2.next;
                break;
            }
            tmp2 = tmp2.next;
            currNum ++;
        }
        return middleNode;
    }

    //快慢指针
    public ListNode middleNodeByFastAndSlow(ListNode head) {
        ListNode fast = head , slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode listNode = new Solution().middleNodeByFastAndSlow(a1);
        System.out.println(listNode.val);


    }
}
