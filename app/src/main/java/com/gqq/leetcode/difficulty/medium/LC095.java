package com.gqq.leetcode.difficulty.medium;

import com.gqq.leetcode.TreeNode;
import com.gqq.leetcode.tag.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 解题思路：
 * 第一种：递归的方式
 *      n根结点  左子树        右子树
 *      1       []          [2...n]
 *      2       [1]         [3...n]
 *      3       [1.2]       [4...n]
 *      4       [1.2.3]     [5...n]
 *      5       [1...4]     [6...n]
 *      ...
 *      1-n的数每个数作为根结点的时候所有的组合，那么n所有树的组合就是所有的情况加起来
 *
 * 1. 分析：罗列从小到大每个数作为根结点的时候有多少种组合，上图，用于分析出递归循环和递归退出的条件。
 * 2. 递归循环：n的左右区间的所有子树组合，例如4：得到1-3 的所有左子树和5-n的所有右子树，组合即可得到
 * 3. 递归循环退出的条件：1-左右区间没有数据，那么就是所有节点都被构建了，返回null，参考n=1的左子树，剩一条数据时创建一个该数据的节点
 * 4. 构建代码：
 *      外层for循环用于遍历所取区间的所有数作为根结点时的所有组合
 *      获取到所有的左右子树情况，将其组合到一起，利用双层for循环遍历
 *
 * 第二种：动态规划的方式
 * TODO: 后续补
 *
 *
 */
public class LC095 {

    // 第一种
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) return res;
        return getTrees(1, n);

    }

    private List<TreeNode> getTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();

        // 当前没有可创建节点的数据，返回null，参考根结点为1时的左子树
        if (start > end) {
            res.add(null);
            return res;
        }

        // 当前只剩一条数据时，构建成节点，参考根结点为2时的左子树
        if (start == end) {
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }

        // for循环分别遍历所有可能的根结点
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNode = getTrees(start, i - 1);
            List<TreeNode> rightNode = getTrees(i + 1, end);

            // 获取到该根节点所有的左右子树
            for (TreeNode left : leftNode) {
                for (TreeNode right : rightNode) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
