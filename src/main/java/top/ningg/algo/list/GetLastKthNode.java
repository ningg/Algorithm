package top.ningg.algo.list;

import top.ningg.algo.common.ListUtils;
import top.ningg.algo.model.Node;

/**
 * 题目: 获取链表中, 倒数第 k 个节点
 *
 * 分析: 基本思路, 设置 2 个指针, 遍历链表(相距 k-1 个节点)
 *
 * 参考: http://wiki.jikexueyuan.com/project/for-offer/question-fifteen.html
 *
 */
public class GetLastKthNode {

    /**
     * 找出链表中, 倒数第 k 个节点
     *
     * @param head 链表头指针
     * @param k 倒数第 k 个节点
     * @return 找到的目标节点
     */
    public static Node findKthToTail(Node head, int k) {
        // 1. 边界判断
        if (null == head || k <= 0) {
            return null;
        }

        Node pre = new Node(0);
        pre.next = head;

        // 2. 寻找 k-th 节点
        // a. 两个指针, 一个先走(相聚 k+1 个节点)
        Node former = pre;
        Node latter = pre;
        for (int i = 1; i <= k + 1; i++) {
            if (null != former) {
                former = former.next;
            } else {
                return null;
            }
        }

        // b. 先走的节点, 走到 null, 则, 说明后走的节点,
        while (null != former) {
            former = former.next;
            latter = latter.next;
        }

        // 因为间隔 （n + 1），所以，此种方式，删除 Node
        // latter.next = latter.next.next;

        return latter.next;
    }

    public static void main(String[] args) {
        // construct List
        Node pRoot = ListUtils.constructNodeList(5);

        ListUtils.printList(pRoot);

        // get k-th Node
        Node destNode = findKthToTail(pRoot, 4);

        System.out.println(destNode.value);
    }

}
