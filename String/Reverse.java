public class Reverse {
    public static void main(String[] args) {
        String str = "Hello World!";
        String reversedStr = reverseString(str);
        System.out.println("Reversed String: " + reversedStr);
    }

    //Worst Approach: Using Concatenation
    //Time Complexity - O(N^2) --> String is immutable, so rev += s.charAt(i) creates a new object each time.
    //Space Complexity - O(N)
    public static String reverseString(String str) {
        String rev = "";
        for(int i=str.length()-1; i>=0; i--){
            rev += str.charAt(i);
        }

        return rev;
    }

    //optimal Approach 1: Using char array
    //Time Complexity - O(N)
    //Space Complexity - O(N)
    //public static String reverseString(String str) {
    //    char[] charArray = str.toCharArray();
    //    int left = 0, right = charArray.length - 1;
    //    while (left < right) {
    //        // Swap characters
    //        char temp = charArray[left];
    //        charArray[left] = charArray[right];
    //        charArray[right] = temp;
    //        left++;
    //        right--;
    //    }
    //    return new String(charArray); 
    //}

    // Approach2: 
    //Time Complexity - O(N)
    //Space Complexity - O(N)
    //public static String reverseString(String str) {
    //    StringBuilder reversed = new StringBuilder();
    //    for(int i=str.length()-1; i>=0; i--){
    //        reversed.append(str.charAt(i));
    //    }   
    //    return reversed.toString();
    //}

}
