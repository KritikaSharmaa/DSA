package Recursion.Basic;

public class CheckPalindrome {
    public static void main(String[] args) {
        String str ="MADAM";
        System.out.println(ispalindrome(0, str.length()-1, str));
    }

    public static boolean ispalindrome(int left, int right, String str){
        if(left>=right) return true;

        if(str.charAt(left) != str.charAt(right)) return false;

        return ispalindrome(left+1, right-1, str);
    }
}
