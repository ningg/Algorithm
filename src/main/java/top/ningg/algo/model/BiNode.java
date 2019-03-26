package top.ningg.algo.model;

/**
 * 双向链表.
 */
public class BiNode {

    // key
    public String key;
    // 值
    public Object value;
    // 前一个节点
    public BiNode pre;
    // 后一个节点
    public BiNode next;

    public BiNode(String key, Object value) {
        this.key = key;
        this.value = value;

        this.pre = null;
        this.next = null;
    }

}
