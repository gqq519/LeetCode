package com.gqq.leetcode.difficulty.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 */
public class LC387 {

    public static void main(String[] args) {
        int loveleetcode = firstUniqChar("loveleetcode");
        System.out.println(loveleetcode);
    }

    public static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Character character : hashMap.keySet()) {
            if (hashMap.get(character) == 1) {
                return s.indexOf(character);
            }
        }
        return -1;
    }
}
