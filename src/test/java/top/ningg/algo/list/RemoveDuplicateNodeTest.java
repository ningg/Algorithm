package top.ningg.algo.list;

import java.util.HashSet;
import java.util.Set;
import top.ningg.algo.model.Node;

public class RemoveDuplicateNodeTest {


    public static Node removeDuplicateNode(Node head) {
        // 边界判断
        if (null == head || null == head.next) {
            return head;
        }

        Node result = head;
        Set<Integer> currSet = new HashSet<>();

        Node pre = null;
        Node curr = head;

        while (curr != null) {
            // 第一个节点
            if (null == pre) {
                currSet.add(curr.value);
                pre = curr;
                curr = curr.next;
                continue;
            }

            if (currSet.contains(curr.value)) {
                pre.next = curr.next;
                curr = curr.next;
            } else {
                currSet.add(curr.value);
                pre = curr;
                curr = curr.next;
            }
        }

        return result;
    }

}
