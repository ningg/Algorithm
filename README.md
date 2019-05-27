# Algorithm

基础算法。

几个常识：

> 1. **纸上走读**：代码纸上走读，会发现其`潜在边界` or `核心逻辑`，而且通过反复查看，印象深刻，因为，知识本来就是不平的，有感情、有起伏

> 2. **温故知新**：查看内容，图形化思考，构建知识体系

## 算法

几个常见场景：

数组：

1. 斐波那契数列：`Fibo` [link](src/main/java/top/ningg/algo/array/Fibo.java)
2. 斐波那契数列：数字判断 `FiboContainValue`
3. 数据：二维有序数组, 查询目标数值 `SearchOrderedArray`
4. 数组：2 个有序数组的交集 `TwoSortedArrayIntersection` **+**
5. 数组：TopK 问题, 最大的 k 个数 `TopKth` **+**
6. 数组：子数组和的最大值, `SubArrayMaxSum` **+**
7. 数组：连续子数组的和,为固定值 `SubArraySumKey` **+**
8. 数组：硬币兑换，兑换的硬币数量最小 `CoinChange` **+**
9. 数组：最长递减子序列，序列长度 `SubArrayDescMaxLen` [link](src/main/java/top/ningg/algo/array/SubArrayDescMaxLen.java)

链表：

1. 链表：获取倒数第 k 个节点, `GetLastKthNode`
2. 链表：有序链表归并 `MergeSortedList` **+**
3. 链表：删除重复节点 `RemoveDuplicateNode`
4. 链表：不知道头结点, 删除一个节点 `RemoveNode`
5. 链表：翻转 `ReverseList` **+**
6. 链表：排序 `SortList` **+**
7. 链表：指定区间，翻转链表 `ReverseSegmentList` **+**

搜索：

1. 数组：有序数组, 二分查找, `BinarySearch` **+**
2. 树：二叉查找树, 搜索指定数, `BinarySearchTree` **+**
3. 数组：循环的有序数组, 查找指定值 `RotateOrderedArraySearch`

树：

1. 树：统计「叶子节点」数 `CountLeafNode`
2. 树：统计「节点」数 `CountTreeNode`
3. 树：统计「第 k 层」节点个数 `CountTreeNodeKthLevel`
4. 树：统计「树的深度」 `GetDepth`
5. 树：获取「二叉树」中, 2 个给定节点的「最低公共子节点」 `GetLastCommonNode`
6. 树：层次遍历, `LevelTraverse`
7. 树：二叉树「镜像」 `MirrorTree`
8. 树：两棵二叉树, 是否结构相同 `StructureCmp`
9. 树：给定 2 棵树 A 和 B, 判断 B 是否为 A 的子结构 `SubStructure`
10. 树：树的遍历, 前序、中序、后续 `TraverseTree` [link](src/main/java/top/ningg/algo/tree/TraverseTree.java)
11. 树：节点的最大距离 `MaxDistance` , 其借助了公共变量
12. 树：二叉搜索树，其 2 个节点位置被互换，修正这颗二叉查找树，`RecoverTree`
13. 树：到叶子节点的路径和为指定值，并且，输出路径，`PathSum`

排序：

1. 数组排序：冒泡排序, 两两比较, 大的向后交换 `BubbleSort`
2. 数组排序：归并排序, 二分为子数组, 分别排序后, 借助空间, 进行归并 `MergeSort` **+**
3. 数组排序：快速排序, 选取基准点, 进行就地排序 `QuickSort` **+**
4. 数组排序：选择排序, 从前向后遍历, 每次选择出一个最小值 `SelectionSort` **+**


线程：

1. 线程：三个线程之间协作, 依赖共同的锁和信号(同一个静态变量) `ThreeThread`


字符串：

1. TODO


Map：

1. Map：已知一个 Map，将其转换为 flatten Map `FlattenMap`


二进制, 位(Bit)：

1. 二进制, 位：元素, 全排列, 要求所有元素都得出现, 有顺序要求 `AllRange`
2. 二进制, 位：元素, 全组合, 不要求所有元素都出现, 没有顺序要求 `Combination`
3. 二进制, 位：十进制整数, 统计其「二进制表示」中 1 的数量 `CountOneBit`
4. 二进制, 位：计算整数 base 的整数次幂 exponent `ExponentCalculate`



更多内容, 参考：

* [computer-science-basic](https://github.com/ningg/computer-science-basic)：建议, 以此为准, 同时再来参考 `Algorithm` 中的代码

## 设计模式

1. 单例模式：`SingletonHungry` 和 `Singleton`


## 场景描述

1. 青蛙跳阶梯：`FrogJump`
2. LRU Cache：`LruCacheWithLinkedHashMap` 和 `LruCache`
