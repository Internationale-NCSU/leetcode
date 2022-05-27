public class leetcode125 {
    public static boolean isPalindrome(String s) {
        String text = "";
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                text = text.concat(String.valueOf(s.charAt(i)));
            }
        }
        int front = 0 ;
        int rear = text.length()-1;
        while(true){
            if(front>=rear) {
                return true;
            }
            if(text.charAt(front)!=text.charAt(rear)){
                break;
            }else {
                front++;
                rear--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
