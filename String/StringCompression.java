import java.util.HashMap;

public class StringCompression {
    public static void main(String[] args) {
        String str = "aaabbbccdaa";
        String compressedStr = compressString(str);
        System.out.println("Compressed String: " + compressedStr);
    }

    public static String compressString(String str) {
        StringBuilder compressed = new StringBuilder();
        int count=0;
        for(int i=0; i<str.length(); i++){
            if(i==0 || str.charAt(i) == str.charAt(i-1)){
                count++;
            } else {
                compressed.append(str.charAt(i-1));
                compressed.append(count);
                count=1;
            }
        }
        // Append the last character and its count
        compressed.append(str.charAt(str.length()-1));
        compressed.append(count);

        return compressed.toString();
    }
}
