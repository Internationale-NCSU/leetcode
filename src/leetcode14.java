import java.util.Arrays;
import java.util.Map;

public class leetcode14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int common = strs[0].length();
        if(strs.length==1){
            return strs[0];
        }
        for (int i = 1; i < strs.length; i++) {
            int subCommon = 0;
            int n = strs[0].length()<strs[i].length()?strs[0].length():strs[i].length();
            for (int j = 0; j < n; j++) {
                if(strs[i].charAt(j)==strs[0].charAt(j)){
                    subCommon++;
                }else {
                    break;
                }
            }
            common = Math.min(common,subCommon);
            if(common==0) {
                break;
            }
        }
        return strs[0].substring(0,common);
    }

}
