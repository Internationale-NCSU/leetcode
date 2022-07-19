public class leetcode9_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }else {
            String s = String.valueOf(x);
            int front = 0,rear = s.length()-1;
            while(front<=rear){
                if(s.charAt(front)!=s.charAt(rear)){
                    return false;
                }
                front++;
                rear--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(11211));
    }
}
