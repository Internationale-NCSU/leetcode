public class leetcode186 {
    public void reverseWords(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char tmp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = tmp;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i]!=' '){
                start = i;
                while(i<s.length&&s[i]==' '){
                    i++;
                }
                end = i;
            }
            for (int j = start; j < (end+start)/2; j++) {
                char tmp = s[j];
                s[j] = s[s.length-j-1];
                s[s.length-j-1] = tmp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
