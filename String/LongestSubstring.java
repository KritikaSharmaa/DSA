//Given a string s, find the length of the longest substring that contains no repeating characters.

import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        String str = "abba";
        int length = lengthOfLongestSubstring(str);
        System.out.println("Length of Longest Substring without repeating characters: " + length);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map= new HashMap<>();
        int maxLength = 0, start = 0;

        for(int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if(map.containsKey(currentChar)) {
                start = Math.max(map.get(currentChar) + 1, start);
            }
            map.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
