package top.ningg.algo.list;

import top.ningg.algo.model.Node;

public class SortListTest {


    public static Node sortList(Node head) {
        if (null == head) {
            return head;
        }

        if (null == head.next) {
            return head;
        }

        // 获取中间节点
        Node middleNode = getMiddleNode(head);

        Node firstNode = head;
        Node secondNode = null;
        if (middleNode != null) {
            secondNode = middleNode.next;
            middleNode.next = null;
        }

        // 递归处理
        firstNode = sortList(firstNode);
        secondNode = sortList(secondNode);

        // 归并
        return mergeSortedList(firstNode, secondNode);
    }

    public static Node getMiddleNode(Node head) {
        if (null == head) {
            return null;
        }

        if (null == head.next || null == head.next.next) {
            return head;
        }

        Node former = head;
        Node latter = head;

        while (former.next != null) {
            former = former.next.next;
            latter = latter.next;
        }

        return latter;
    }

    public static Node mergeSortedList(Node first, Node second) {
        if (null == first) {
            return second;
        }
        if (null == second) {
            return first;
        }

        if (first.value <= second.value) {
            first.next = mergeSortedList(first.next, second);
            return first;
        } else {
            second.next = mergeSortedList(first, second.next);
            return second;
        }
    }
}
