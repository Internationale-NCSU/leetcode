import java.util.HashMap;
import java.util.Map;

public class leetcode76 {
    public static String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else {
                map.put(t.charAt(i),1);
            }
        }
        int left,right,subStringLength;
        String subString=s;
        for (int i = 0; i < s.length(); i++) {
            left=i;
            Map<Character,Integer> tmpMap = new HashMap<>(map);
            for (int j = i; j < s.length(); j++) {
                right = j;

                if(tmpMap.containsKey(s.charAt(right))){
                    int count = tmpMap.get(s.charAt(right));
                    if( count > 1){
                        tmpMap.replace(s.charAt(right), count - 1);
                    }else{
                        tmpMap.remove(s.charAt(right));
                    }
                }

                if(tmpMap.isEmpty()){
                    subStringLength = right-left+1;
                    if(subStringLength<subString.length()){
                        subString = s.substring(left,right+1);
                    }
                    break;
                }

                if(i==0&&j==s.length()-1&&!tmpMap.isEmpty()){
                        return "";
                }
            }
        }
        return subString;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","V"));
    }
}
