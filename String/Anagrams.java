public class Anagrams {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        boolean result = areAnagrams(str1, str2);
        System.out.println("Are \"" + str1 + "\" and \"" + str2 + "\" anagrams? " + result);
    }

    public static boolean areAnagrams(String str1, String str2) {

        if(str1.length() != str2.length()) return false;
        int[] charCount = new int[256]; // Assuming only lowercase a-z

        for(char c: str1.toCharArray())
            charCount[c]++;
        
        for(char c: str2.toCharArray()){
            charCount[c]--;
            if(charCount[c] < 0) return false;
        }

        return true;
    }
}
