package top.ningg.algo.list;

import top.ningg.algo.common.ListUtils;
import top.ningg.algo.model.Node;

/**
 * 题目: 合并两个有序链表。(假设升序)
 *
 * 分析方法的: 输入参数、返回参数.
 *
 * 基本思路: 2 个
 *
 * 1. 迭代方式: 两个链表, 从头部分别放置一个指针,
 *
 * a. 判断出哪个节点是头节点, 移动当前链表的指针, 迭代下去, 作为子问题
 *
 * b. 中止条件: 有任何一个指针为 null, 则, 另一个指针就是当前子问题的头结点;
 *
 *
 * 2. 循环方式: 两个链表, 从头部分别放置一个指针,
 *
 * a. 找出头指针:标记出来, 勇于最终返回;
 *
 * b. 指针遍历: 3 个指针, 最终链表的当前节点, 原始链表的当前节点;
 *
 * c. 尾部追加: 最后较长的链表, 追加到尾部
 */
public class MergeSortedList {

    public static void main(String[] args) {
        Node firstSortedList = ListUtils.constructSortedNodeList(5);
        Node secondSortedList = ListUtils.constructSortedNodeList(3);

        // 输出 2 个链表
        ListUtils.printList(firstSortedList);
        ListUtils.printList(secondSortedList);

//    Node mergeSortedList = mergeSortedList(firstSortedList, secondSortedList);
        Node mergeSortedList = mergeSortedListLoop(firstSortedList, secondSortedList);
        // 输出归并排序的结果
        ListUtils.printList(mergeSortedList);
    }


    // 方案 A: 迭代方法, 设置好「终止条件」, 同时, 将问题转换为「子问题」
    public static Node mergeSortedList(Node firstNode, Node secondNode) {

        // 终止条件
        if (null == firstNode) {
            return secondNode;
        }

        if (null == secondNode) {
            return firstNode;
        }

        // 迭代解决
        if (firstNode.value <= secondNode.value) {
            firstNode.next = mergeSortedList(firstNode.next, secondNode);
            return firstNode;
        } else {
            secondNode.next = mergeSortedList(firstNode, secondNode.next);
            return secondNode;
        }

    }

    public static Node mergeSortedListLoop(Node firstNode, Node secondNode) {

        // 边界判断
        if (null == firstNode) {
            return secondNode;
        }
        if (null == secondNode) {
            return firstNode;
        }

        // 1. 找出头部指针
        Node headNode = null;
        if (firstNode.value <= secondNode.value) {
            headNode = firstNode;
            firstNode = firstNode.next;
        } else {
            headNode = secondNode;
            secondNode = secondNode.next;
        }

        // 2. 设置 3 个指针, 逐次移动
        Node currNode = headNode;
        while (firstNode != null && secondNode != null) {
            if (firstNode.value <= secondNode.value) {
                currNode.next = firstNode;
                firstNode = firstNode.next;
            } else {
                currNode.next = secondNode;
                secondNode = secondNode.next;
            }

            // 调整 currNode 指针
            currNode = currNode.next;
        }

        // 3. 尾部追加
        if (null != firstNode) {
            currNode.next = firstNode;
        } else {
            currNode.next = secondNode;
        }

        return headNode;
    }
}
