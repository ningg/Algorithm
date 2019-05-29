package top.ningg.algo.list;

import top.ningg.algo.model.Node;

public class MergeSortedListTest {


    // 递归方式
    public static Node mergeSortedList(Node first, Node second) {
        // 边界判断
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

    // 循环方式
    public static Node mergeSortedListLoop(Node first, Node second) {
        // 边界判断
        if (first == null) {
            return first;
        }
        if (second == null) {
            return first;
        }

        // 获取当前 Node 指针
        Node currNode = null;
        Node resultNode = null;
        if (first.value <= second.value) {
            currNode = first;
            resultNode = first;
            first = first.next;
        } else {
            currNode = second;
            resultNode = second;
            second = second.next;
        }

        // 3 个指针遍历读取
        while (first != null && second != null) {
            if (first.value <= second.value) {
                currNode.next = first;
                first = first.next;
            } else {
                currNode.next = second;
                second = second.next;
            }

            currNode = currNode.next;
        }

        // 最后剩余链表内容
        if (first != null) {
            currNode.next = first;
        }
        if (second != null) {
            currNode.next = second;
        }

        return resultNode;
    }
}
