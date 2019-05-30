package top.ningg.algo.list;

import top.ningg.algo.model.Node;

public class RemoveNodeTest {


    public static Node removeNode(Node head, Node toBeRemove) {
        // 边界判断
        if (null == head || null == toBeRemove) {
            return head;
        }

        // 1. 头结点
        if (head == toBeRemove) {
            toBeRemove.next = null;
            head = head.next;
            return head;
        }

        // 2. 尾节点
        if (null == toBeRemove.next) {
            // 找到倒数第 2 个节点
            Node curr = head;
            while (curr.next != toBeRemove) {
                curr = curr.next;
            }

            curr.next = null;
            return head;
        }

        // 3. 中间节点
        Node nextNode = toBeRemove.next;
        toBeRemove.value = nextNode.value;
        toBeRemove.next = nextNode.next;

        return head;
    }

}
