package top.ningg.algo.model;

/**
 * 单向链表的节点.
 *
 * note: 为了方便书写, 直接将 field 设置为 public。
 */
public class Node {

    public int value;

    public Node next;

    public Node(int value) {
        this.value = value;
    }
}
