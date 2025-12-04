public class Palindrome {
    public static void main(String[] args) {
        String str = "racecar";
        boolean isPalin = isPalindrome(str);
        System.out.println("Is the string \"" + str + "\" a palindrome? " + isPalin);
    }

    public static boolean isPalindrome(String str){
        int left=0, right=str.length()-1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
