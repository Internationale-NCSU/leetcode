import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode246 {
    public boolean isStrobogrammatic(String num) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(8,8);
        map.put(0,0);
        map.put(6,9);
        map.put(9,6);
        int front = 0, rear = num.length()-1;
        while (front<=rear){
            if(front==rear&&map.containsKey(num.charAt(front)-'0')){
                if(num.charAt(front)-'0'==6||num.charAt(front)-'0'==9){
                    return false;
                }
                break;
            }
            if(map.containsKey(num.charAt(front)-'0')){
                if(map.get(num.charAt(front)-'0')!=num.charAt(rear)-'0'){
                    return false;
                }
                front++;
                rear--;
            }else{
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(isStrobogrammatic("6"));
    }
}
