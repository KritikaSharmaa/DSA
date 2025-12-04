//Given a string s, remove all duplicate characters from it such that each character appears only once.
//The order of the first occurrence of each character should be preserved.

import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "banana";
        String result = removeDuplicates(str);
        System.out.println("String after removing duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        HashSet<Character> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for(int i=sb.length()-1;i>=0;i--) {
            if(seen.contains(sb.charAt(i))) {
                sb.deleteCharAt(i);
            } else {
                seen.add(sb.charAt(i));
            }
        }
        return sb.toString();
    }
}
