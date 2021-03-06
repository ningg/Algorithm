package top.ningg.algo.common;

import java.util.Random;
import top.ningg.algo.model.Node;

/**
 * 链表的工具类.
 */
public class ListUtils {


    /**
     * 构造链表(升序的有序链表)
     *
     * @param num 链表长度
     * @return 链表的头部节点
     */
    public static Node constructSortedNodeList(int num) {
        // 边界判断
        if (num <= 0) {
            return null;
        }

        Node node = null;
        Node currNode = null;
        Random random = new Random();
        for (int index = 0; index < num; index++) {
            int value = random.nextInt(100);
            // 构造升序链表
            if (null != currNode) {
                while (value < currNode.value) {
                    value = random.nextInt(100);
                }
            }
            Node newNode = new Node(value);
            if (node == null) {
                node = newNode;
                currNode = node;
            } else {
                currNode.next = newNode;
                currNode = currNode.next;
            }
        }
        return node;
    }

    /**
     * 构造链表
     *
     * @param num 链表长度
     * @return 链表的头结点
     */
    public static Node constructNodeList(int num) {

        Node node = null;
        Node currNode = null;
        Random random = new Random();
        for (int index = 0; index < num; index++) {
            int value = random.nextInt(10);
            Node newNode = new Node(value);
            if (node == null) {
                node = newNode;
                currNode = node;
            } else {
                currNode.next = newNode;
                currNode = currNode.next;
            }
        }
        return node;
    }


    /**
     * 输出链表
     */
    public static void printList(Node head) {
        // 边界判断
        if (null == head) {
            System.out.println("null");
            return;
        }
        // 输出
        System.out.println();
        StringBuilder resultStr = new StringBuilder();
        for (Node currNode = head; currNode != null; currNode = currNode.next) {
            resultStr.append(String.format("%d-", currNode.value));
        }
        String result = resultStr.substring(0, resultStr.length() - 1);
        System.out.println(result);
    }

}
