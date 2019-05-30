package top.ningg.algo.list;

import top.ningg.algo.model.Node;

public class ReverseSegmentListTest {


    public static Node reverseSegmentList(Node head, int m, int n) {
        // 边界判断
        if (null == head) {
            return head;
        }

        if (m >= n) {
            return head;
        }

        // 获取第 m -1 个节点
        Node curr = head;
        for (int i = 1; i <= m - 1; i++) {
            if (curr == null) {
                return head;
            }
            curr = curr.next;
        }

        Node pre = curr;
        Node start = curr.next;
        Node next = start.next;

        for (int i = m; i <= n - 1; i++) {
            start.next = next.next;
            next.next = pre.next;
            pre.next = next;

            next = start.next;
        }

        return head;
    }

}
