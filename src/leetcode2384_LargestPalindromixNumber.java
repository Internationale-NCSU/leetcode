import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class leetcode2384_LargestPalindromixNumber {
    public String largestPalindromic(String num) {
        TreeMap<Integer,Integer> map = new TreeMap<>(
            (a,b)->{
                return b-a;
            }
        );
        for (int i = 0; i < num.length(); i++) {
            map.put(num.charAt(i)-'0',map.getOrDefault(num.charAt(i)-'0',0)+1);
        }
        int maxOddKey = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()%2==1){
                if(map.getOrDefault(maxOddKey,0)<entry.getValue()){
                    maxOddKey = entry.getKey();
                }else if(map.get(maxOddKey)==entry.getValue()){
                    maxOddKey = maxOddKey>entry.getKey()?maxOddKey:entry.getKey();
                }
            }
        }
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            int integer = it.next();
            if(integer!=maxOddKey&&map.get(integer)%2!=0){
                it.remove();
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = maxOddKey==-1?0:1;
        Map.Entry<Integer,Integer> entry = null;
        while(map.size()>size){
            int c = map.firstKey();
            if(c==maxOddKey){
                entry = map.firstEntry();
                map.remove(c);
            }
            if(map.get(c)%2==0) {
                int times = map.get(c);
                for (int i = 0; i < times / 2; i++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        StringBuilder middle = new StringBuilder();
        if(entry!=null) {
            int c = entry.getKey();
            int times = entry.getValue();
            for (int i = 0; i < times; i++) {
                middle.append(c);
            }
        }
        StringBuilder tmp = new StringBuilder(sb);
        return tmp.append(middle).append(sb.reverse()).toString();
    }
    @Test
    public void test(){
        System.out.println(largestPalindromic("2233999443322777"));
    }
}
