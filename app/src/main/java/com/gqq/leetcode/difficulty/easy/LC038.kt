package com.gqq.leetcode.difficulty.easy

/**
 * Created by gqq on 2019-09-23.
 */

fun main() {
    val countAndSay = countAndSay(6)
    println(countAndSay)

}

fun countAndSay(n: Int): String {
    var num: Int = 1
    var result: String = "1"

    while (num < n) {
        val stringBuilder = StringBuilder()
        var count = 0 // 用于计算某数的个数
        var currentNum = result[0]

        for (i in 0..result.length) {
            if (i != result.length - 1 && result.get(i) === currentNum) {
                count++
            } else {
                stringBuilder.append(count)
                stringBuilder.append(currentNum)

                if (i != result.length - 1) {
                    currentNum = result.get(count)
                    count = 1
                }
            }
        }

        result = stringBuilder.toString()
        num++
    }
    return result
}