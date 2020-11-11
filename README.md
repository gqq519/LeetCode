#### 数组 & 链表 & 字符串

| 题号 |                          标题&描述                           |                        本仓库题解代码                        |                         优秀题解描述                         | 难度 |                           解题思路                           |
| :--: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :--: | :----------------------------------------------------------: |
|  1   | [两数之和](https://leetcode-cn.com/problems/two-sum/description/) | [LC206.java](https://github.com/gqq519/LeetCode/blob/master/app/src/main/java/com/gqq/leetcode/interview/LC206.java) | [Solutions](https://leetcode-cn.com/problems/reverse-linked-list/solution/) | 简单 | 1、迭代的方式：利用while循环，借助一个null作为pre，记录反转前的当前节点、上一个节点、下一个节点，迭代结束的条件即next为空 <br>2、递归的方式：每次递归反转两个元素，直到链表反转结束，思想其实跟迭代的方式很类似 |
|  2   | [两数相加](https://leetcode-cn.com/problems/add-two-numbers/) | [LC002.java](https://github.com/gqq519/LeetCode/blob/master/app/src/main/java/com/gqq/leetcode/difficulty/medium/LC002.java) | [Solutions](https://leetcode-cn.com/problems/add-two-numbers/solution/) | 中等 | 两个链表都是逆序存储数据位数的，所以相同位置的数字是可以直接相加的，进位的话需要向链表下一位进位+1 |
|  3   | [[无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/) | [LC003.java](https://github.com/gqq519/LeetCode/blob/master/app/src/main/java/com/gqq/leetcode/difficulty/medium/LC003.java) | [Solutions](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/) | 中等 | 借助双重for循环和List 第一层for循环：从哪里开始截取的子串长度最大 第二层for循环：从其实位置往后查找最大的子串 |
|      |                                                              |                                                              |                                                              |      |                                                              |
|      |                                                              |                                                              |                                                              |      |                                                              |
|      |                                                              |                                                              |                                                              |      |                                                              |
|      |                                                              |                                                              |                                                              |      |                                                              |
|      |                                                              |                                                              |                                                              |      |                                                              |
| 206  | [反转链表](https://leetcode-cn.com/problems/reverse-linked-list/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china) | [LC206.java](https://github.com/gqq519/LeetCode/blob/master/app/src/main/java/com/gqq/leetcode/interview/LC206.java) | [Solutions](https://leetcode-cn.com/problems/reverse-linked-list/solution/) | 简单 | 1、迭代的方式：利用while循环，借助一个null作为pre，记录反转前的当前节点、上一个节点、下一个节点，迭代结束的条件即next为空 <br>2、递归的方式：每次递归反转两个元素，直到链表反转结束，思想其实跟迭代的方式很类似 |





#### 数组 & 链表

- https://leetcode.com/problems/reverse-linked-list/ （反转链表）
- https://leetcode.com/problems/linked-list-cycle （环形链表）
    - HashSet 记录走过的节点
    - 快慢指针
    - 标记法 -- 把特定节点标记成特殊元素
- https://leetcode.com/problems/swap-nodes-in-pairs/ （交换链表中节点）
- https://leetcode.com/problems/linked-list-cycle-ii （环形链表入环的第一个节点）
    - HashSet 记录走过的节点
    - 快慢指针
- https://leetcode.com/problems/reverse-nodes-in-k-group/ （-------hard: TODO----）

#### 堆栈 & 队列

- https://leetcode.com/problems/implement-queue-using-stacks （栈实现队列）
- https://leetcode.com/problems/implement-stack-using-queues/description/ （队列实现栈）
- https://leetcode.com/problems/valid-parentheses/description/ （借助栈匹配字符）
##### 优先队列
- https://leetcode.com/problems/kth-largest-element-in-a-stream/ (第K大数据，优先级队列：最小堆)
- https://leetcode.com/problems/sliding-window-maximum/ （-------hard: TODO-------）
#### 哈希表
- https://leetcode.com/problems/valid-anagram/description/ （借助长度26的数组）
- https://leetcode.com/problems/two-sum/description/ （借助HashMap及其Api）
- https://leetcode.com/problems/3sum/description/ （借助快慢指针的方式）
- https://leetcode.com/problems/4sum/ （-----------hard: TODO ---------）
- https://leetcode.com/problems/group-anagrams/description/ （借助HashMap和数组的排序）
#### 树、二叉树、二叉搜索树
- https://leetcode.com/problems/validate-binary-search-tree （递归判断是否符合二叉搜索树）
- https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ （递归判断）
- https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/ （递归判断）
#### 递归 & 分治
- https://leetcode.com/problems/powx-n/description/ （-------------TODO-----------）
- https://leetcode.com/problems/majority-element/description/ （排序）
- https://leetcode.com/problems/valid-anagram/#/description （借助长度26的数组）
- https://leetcode.com/problems/find-all-anagrams-in-a-string/#/description （滑动窗口）
#### 贪心算法
- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/ 
    - （最大收益，[1 2 5] -- 5-1 == 2-1+5-2 实现思想）
- https://leetcode.com/problems/jump-game/ 
    - （利用可到达的最大位置及数组索引）
- https://leetcode.com/problems/jump-game-ii/
    - （利用可到达的最大位置及数组索引）
- https://leetcode.com/problems/gas-station/ 
    - （循环遍历、双向指针）
- https://leetcode.com/problems/lemonade-change/description/
- https://leetcode.com/problems/assign-cookies/description/
- https://leetcode.com/problems/walking-robot-simulation/description/
#### 广度/深度优先搜索
- https://leetcode.com/problems/symmetric-tree/ （二叉树镜像，递归判断）
- https://leetcode.com/problems/binary-tree-level-order-traversal/  （二叉树广度优先遍历，借助队列）
- https://leetcode.com/problems/maximum-depth-of-binary-tree/ (树的最大深度，递归子树深度 + 1)
- https://leetcode.com/problems/minimum-depth-of-binary-tree/description/ (树的最小深度，递归子树深度 + 1)
- https://leetcode.com/problems/word-ladder/
- https://leetcode.com/problems/generate-parentheses/
- https://leetcode.com/problems/path-sum/ （深度优先遍历，递归实现）
#### 剪枝
- https://leetcode.com/problems/n-queens/
- https://leetcode.com/problems/n-queens-ii/
- https://leetcode.com/problems/valid-sudoku/description/
- https://leetcode.com/problems/sudoku-solver/#/description
#### 二分查找
- https://leetcode.com/problems/sqrtx/
- https://leetcode.com/problems/valid-perfect-square/
- https://www.beyod.com/content/articles/8/
#### 字典树
- https://leetcode.com/problems/implement-trie-prefifix-tree/#/description
- https://leetcode.com/problems/word-search-ii/
#### 位运算
- https://leetcode.com/problems/number-of-1-bits/  (计算1的个数，减1取 与 )
- https://leetcode.com/problems/subsets/
- https://leetcode.com/problems/power-of-two/
- https://leetcode.com/problems/counting-bits/description/
- https://leetcode.com/problems/n-queens-ii/description/
#### 动态规划
- https://leetcode.com/problems/maximum-subarray/description/ （最大子串和）
- https://leetcode.com/problems/climbing-stairs/description/
- https://leetcode.com/problems/triangle/description/
- https://leetcode.com/problems/maximum-product-subarray/description/
- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
- https://leetcode.com/problems/longest-increasing-subsequence
- https://leetcode.com/problems/coin-change/
- https://leetcode.com/problems/edit-distance/
#### 并查集
- https://leetcode.com/problems/number-of-islands/
- https://leetcode.com/problems/friend-circles/
#### LRU Cache
- https://leetcode.com/problems/lru-cache/#/- 