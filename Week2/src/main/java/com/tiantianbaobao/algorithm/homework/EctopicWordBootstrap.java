package com.tiantianbaobao.algorithm.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * @description ectopic word
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-28 11:33
 * @since V1.0.0
 */
public class EctopicWordBootstrap {
    public static void main(String[] args) {
        String str1 = "aaabbccc";
        String str2 = "bbccaac";
        System.err.println("str1 is ectopic word of str2 ? " + _ectopicWord(str1, str2));
        System.err.println("str1 is ectopic word of str2 ? " + _ectopicWordByMap(str1, str2));
    }

    /***
     * the better solution of handle {@param str1} and {@param str2} is ectopic word or not
     * complexity is O(N)
     * @param str1
     * @param str2
     * @return
     */
    private static boolean _ectopicWordByMap(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.equals(str2)) {
            return true;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> charMap = new HashMap<>(str1.length());
        for (int i = 0; i < str1.length(); i++) {
            charMap.put(str1.charAt(i), charMap.getOrDefault(str1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            charMap.put(str2.charAt(i), charMap.getOrDefault(str2.charAt(i), 0) -1);
            if (charMap.get(str2.charAt(i)) < 0){
                return false;
            }
        }
        return true;
    }

    /***
     * compare str1 is ectopic word of str2
     * complexity is O(NlogN)
     * @param str1
     * @param str2
     * @return
     */
    private static boolean _ectopicWord(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.equals(str2)) {
            return true;
        }
        char[] str1Char = str1.toLowerCase().toCharArray();
        char[] str2Char = str2.toLowerCase().toCharArray();
        Arrays.sort(str1Char);
        Arrays.sort(str2Char);
        return Arrays.equals(str2Char, str1Char);
    }
}
