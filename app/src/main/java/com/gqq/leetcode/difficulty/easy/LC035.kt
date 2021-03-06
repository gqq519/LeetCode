/**
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (40.73%)
 * Likes:    1261
 * Dislikes: 175
 * Total Accepted:    394K
 * Total Submissions: 966.2K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 *
 * Example 4:
 *
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * 解法说明：
 * 循环遍历，对比当前index的数据与target的大小
 * 当前index的值等于target或者大于target，则等于当前index
 *
 */

fun main() {
    val insert = searchInsert(intArrayOf(1, 3, 5, 6), 7)
    print(insert)
}

fun searchInsert(nums: IntArray, target: Int): Int {

    for (index in nums.indices) {
        if (target == nums.get(index) || target < nums.get(index)) {
            return index
        } else if (index == nums.size - 1){
            return index + 1
        }
    }
    return 0
}
