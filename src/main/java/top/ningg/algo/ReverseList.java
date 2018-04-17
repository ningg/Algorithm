package top.ningg.algo;

import top.ningg.algo.common.ListUtils;
import top.ningg.algo.model.Node;

/**
 * 题目:链表翻转.
 *
 * 分析:
 *
 * 1. 遍历一遍, 直接
 */
public class ReverseList {

    public static void main(String[] args) {
        // 1. 构造链表
        Node originalList = ListUtils.constructNodeList(0);
        ListUtils.printList(originalList);

        // 2. 反转结果
        Node processedResult = reverseList(originalList);
        ListUtils.printList(processedResult);
    }


    private static Node reverseList(Node header) {
        // 边界检查
        if (null == header || null == header.next) {
            return header;
        }

        Node pre = null;
        Node curr = header;
        Node next = null;

        while (null != curr) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
