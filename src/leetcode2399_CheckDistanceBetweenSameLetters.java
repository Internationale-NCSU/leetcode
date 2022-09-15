import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class leetcode2399_CheckDistanceBetweenSameLetters {
    public boolean checkDistances(String s, int[] distance) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c  = s.charAt(i);
            if(!set.contains(c)){
                int d = distance[c-'a'];
                if(i+d+1>=s.length()){
                    return false;
                }
                if(s.charAt(i+d+1)!=c){
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }
    @Test
    public void test(){
        int[] arr = new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(checkDistances("aa",arr));
    }
}
