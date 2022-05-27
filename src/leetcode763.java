import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class leetcode763 {
    public static int findLastPosition(String s,char c){
        for (int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i)==c){
                return i;
            }
        }
        return 0;
    }
    public static List<Integer> partitionLabels(String s) {
        int j = 0;
        int start = 0;
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i)-'a'] = i;
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            j = Math.max(j,last[s.charAt(i)-'a']);
            if(i==j){
                result.add(i-start+1);
                start = i+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = partitionLabels("qiejxqfnqceocmy");
        result.forEach(
                (a)->{
                    System.out.print(a+",");
                }
        );
    }
}
