package top.ningg.algo.list;

import top.ningg.algo.model.Node;

public class GetLastKthNodeTest {

    public static Node getLastKthNode(Node head, int k) {
        // 边界判断
        if (head == null || k <= 0) {
            return null;
        }

        Node former = head;
        Node latter = head;

        // 1. 一个指针先走（k-1）步
        for (int i = 1; i < k; i++) {
            former = former.next;
            // 剪枝
            if (null == former) {
                return null;
            }
        }

        // 2. 前一个指针走到「最后一个节点」时，后一个指针就是倒数第 k 个节点
        while (null != former.next) {
            former = former.next;
            latter = latter.next;
        }

        return latter;
    }

}
