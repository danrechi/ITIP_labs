public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }
    public static String reverseString(String a){
        String res = "";
        for (int i = a.length()-1; i >= 0; i--){
            res += a.charAt(i);
        }
        return res;
    }
    public static boolean isPalindrome(String s){
        return s.equals(reverseString(s));
    }

}