package top.ningg.algo.list;


import top.ningg.algo.common.ListUtils;
import top.ningg.algo.model.Node;

/**
 * 题目：翻转链表的指定区间。
 */
public class ReverseSegmentList {


    /**
     * 根据给定的位置，进行链表的局部翻转
     *
     * @param head 链表头
     * @param m 第 m 个节点
     * @param n 第 n 个节点
     * @return 翻转之后的节点
     */
    public static Node reverseList(Node head, int m, int n) {
        // 边界判断
        if (null == head) {
            return null;
        }
        if (m >= n) {
            return head;
        }

        // a. 获取 pre 节点
        Node bufNode = new Node(0);
        bufNode.next = head;

        Node pre = bufNode;
        // 特别说明：pre 停留在 m 编号之前
        for (int index = 1; index < m; index++) {
            pre = pre.next;
        }

        // b. 插入法，逐次遍历节点，并插入
        Node start = pre.next;
        Node curr = start.next;
        // 特别说明：插入 n-m 次
        for (int index = m; index < n; index++) {
            start.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;

            curr = start.next;
        }

        return bufNode.next;
    }

    public static void main(String[] args) {
        Node oriList = ListUtils.constructNodeList(8);
        ListUtils.printList(oriList);

        int m = 2;
        int n = 5;

        Node result = reverseList(oriList, m, n);
        ListUtils.printList(result);
    }

}
