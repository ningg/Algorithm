package top.ningg.algo.list;

import top.ningg.algo.model.Node;

/**
 * 题目：单链表表示的两个数字相加
 *
 * 参考资料：
 *
 * - https://leetcode.com/problems/add-two-numbers/discuss/1059/My-accepted-Java-solution
 * - https://blog.csdn.net/PengXR2017/article/details/56490567
 */
public class AddTwoNumbers {

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node pre = new Node(0);
        Node head = pre;

        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            Node currNode = new Node(0);

            int sum = ((l1 == null) ? 0 : l1.value) + ((l2 == null) ? 0 : l2.value) + carry;
            currNode.value = sum % 10;
            carry = sum / 10;

            pre.next = currNode;
            pre = currNode;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }

        return head.next;
    }

}
