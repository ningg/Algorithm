package top.ningg.algo.list;

import top.ningg.algo.common.ListUtils;
import top.ningg.algo.model.Node;

/**
 * 题目：单链表，排序(升序)
 *
 * 分析：
 *
 * 1. 方案A：选择排序，时间复杂度 O(n^2)
 *
 * 2. 方案B：归并排序，时间复杂度 O(nlg(n))
 *
 * 更多细节，参考：http://blog.csdn.net/kerryfish/article/details/24043099
 *
 */
public class SortList {

    public static void main(String[] args) {
        // 1. 构造链表
        Node currList = ListUtils.constructNodeList(8);
        ListUtils.printList(currList);
        // 2. 归并排序
        Node mergeResult = sortList(currList);
        ListUtils.printList(mergeResult);
    }


    /**
     * 列表排序, 基本思路:
     *
     * 1. 归并排序， 时间复杂度 nlg(n)
     *
     * a. 分解: 两个子链表
     *
     * b. 排序: 两个子链表, 分别排序
     *
     * c. 归并: 两个有序的子链表, 归并排序
     *
     * @param head 链表头部节点
     * @return 排序之后的链表头部.
     */
    public static Node sortList(Node head) {

        // 边界检查: 为 null 和 只有一个节点时, 都需要考虑
        if (null == head || null == head.next) {
            return head;
        }

        // 分解: 两个子链表
        // a. 获取中间节点
        Node middleNode = getMiddleNode(head);
        // b. 从中间节点下一个节点断开, 获取 2 个链表
        Node firstList = head;
        Node secondList = null;
        if (middleNode != null) {
            secondList = middleNode.next;
            middleNode.next = null;
        }

        // 迭代: 两个子链表, 分别排序
        firstList = sortList(firstList);
        secondList = sortList(secondList);

        // 归并: 两个有序链表, 归并排序
        return mergeSortedList(firstList, secondList);
    }

    public static Node mergeSortedList(Node first, Node second) {
        // 边界判断
        if (null == first) {
            return second;
        }
        if (null == second) {
            return first;
        }

        // 迭代
        if (first.value <= second.value) {
            first.next = mergeSortedList(first.next, second);
            return first;
        } else {
            second.next = mergeSortedList(first, second.next);
            return second;
        }
    }

    /**
     * 获取链表的中间节点的前一个节点。
     */
    public static Node getMiddleNode(Node head) {

        // 边界检查
        if (null == head || null == head.next) {
            return head;
        }

        // 只有 2 个节点时, 也返回第一个节点
        if (null == head.next.next) {
            return head;
        }

        // 设置 2 个指针:
        // a. 规则: 一个一次走一步, 一个一次走两步
        // b. 技术条件: 仅当快指针为 null 时, 才终止
        Node former = head;
        Node latter = head;
        while (null != latter && null != latter.next) {
            former = former.next;
            latter = latter.next.next;
        }
        return former;
    }

}
