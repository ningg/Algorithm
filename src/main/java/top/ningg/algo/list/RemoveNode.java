package top.ningg.algo.list;

import top.ningg.algo.common.ListUtils;
import top.ningg.algo.model.Node;

/**
 * 题目: 删除指定的节点
 *
 * 分析:
 *
 * 1. 中间节点
 * 2. 头结点 or 尾节点
 *
 * 动作:
 *
 * 1. 删除: 将下一个节点内容, 赋值给当前节点(取值和 next 节点引用)
 *
 */
public class RemoveNode {


    /**
     * 删除指定节点
     *
     * @param pHead 链表的头节点
     * @param toBeRemoved 需要被删除的节点
     */
    public static void removeNode(Node pHead, Node toBeRemoved) {
        // 1. 边界判断
        if (null == pHead || null == toBeRemoved) {
            return;
        }

        // 2. 删除节点
        // a. 头部节点: 直接指向「下一个节点」
        // note: 需要借助「头节点」
        if (pHead == toBeRemoved) {
            pHead = pHead.next;
            return;
        }

        // b. 尾部节点: 从前遍历, 到倒数第二个节点, 然后, 删除最后一个
        // note: 需要借助「头节点」
        if (toBeRemoved.next == null) {
            Node pCurr = pHead;
            while (pCurr.next != toBeRemoved) {
                pCurr = pCurr.next;
            }
            pCurr.next = null;
            return;
        }

        // c. 中间节点: 非头部、非尾部节点
        // note: 不需要借助「头结点」
        toBeRemoved.value = toBeRemoved.next.value;
        toBeRemoved.next = toBeRemoved.next.next;
    }


    public static void main(String[] args) {
        // construct List
        Node pRoot = ListUtils.constructNodeList(5);

        ListUtils.printList(pRoot);

        // get Node
        Node toBeRemoved = pRoot;
        for (int i = 0; i < 3; i++) {
            toBeRemoved = toBeRemoved.next;
        }

        // remove node
        removeNode(pRoot, toBeRemoved);

        ListUtils.printList(pRoot);
    }
}
