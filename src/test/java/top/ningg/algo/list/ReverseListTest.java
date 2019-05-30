package top.ningg.algo.list;

import top.ningg.algo.model.Node;

public class ReverseListTest {


    public static Node reverseList(Node head) {
        // 边界判断
        if (null == head) {
            return head;
        }

        Node pre = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;

            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
