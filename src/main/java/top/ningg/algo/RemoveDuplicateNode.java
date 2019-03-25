package top.ningg.algo;

import java.util.HashSet;
import java.util.Set;
import top.ningg.algo.common.ListUtils;
import top.ningg.algo.model.Node;

/**
 * 题目：删除链表中，重复节点
 *
 * 步骤：
 *
 * 1. 借助 Set
 *
 * 2. 遍历一遍，如果节点存在，则，跳过当前节点(需要保留上一个节点地址)
 */
public class RemoveDuplicateNode {

    public static void main(String[] args) {
        // 1. 构造 List
        Node originalList = ListUtils.constructNodeList(10);
        ListUtils.printList(originalList);

        // 2. 去重 List
        Node result = removeDuplicateNode(originalList);
        ListUtils.printList(result);
    }

    /**
     *
     */
    public static Node removeDuplicateNode(Node head) {
        // 边界检查
        if (null == head || null == head.next) {
            return head;
        }

        // 1. 集合: 记录所有的取值
        Set<Integer> valueSet = new HashSet<>();

        // 2. 去重: 遍历一遍, 进行去重
        Node preNode = null;
        Node currNode = head;

        while (null != currNode) {

            // a. 首次处理数据
            if (null == preNode){
                valueSet.add(currNode.value);
                preNode = currNode;
                currNode = currNode.next;
                continue;
            }

            // b. 非首次处理数据
            if (valueSet.contains(currNode.value)) {
                // 重复节点: preNode 指针不变, currNode 下移
                preNode.next = currNode.next;
                currNode = currNode.next;
            } else {
                // 非重复节点: currNode 赋值给 preNode, currNode 下移
                valueSet.add(currNode.value);
                preNode = currNode;
                currNode = currNode.next;
            }
        }

        return head;
    }

}
