import java.util.*;

public class leetcode5978 {
    public static  boolean isMatched(String start, String target){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < start.length(); i++) {
            map.put(start.charAt(i),map.getOrDefault(start.charAt(i),0)+1);
        }
        boolean isDifferent = false;
        if(start.length()==target.length()){
            return false;
        }
        Set<Character> dic = new HashSet<>(map.keySet());
        for (int i = 0; i < target.length(); i++) {
            if(map.containsKey(target.charAt(i))){
                if(map.get(target.charAt(i))-1==0){
                    map.remove(target.charAt(i));
                    continue;
                }
                map.put(target.charAt(i),map.get(target.charAt(i))-1);
            }else if(!isDifferent&&!dic.contains(target.charAt(i))){
                isDifferent = true;
            }else {
                return false;
            }
        }
        if(map.size()==0) {
            return true;
        }else if(map.size()==1) {
            Set<Character> keySet= map.keySet();
            for (Character character : keySet) {
                if(dic.contains(character)){
                    return false;
                }else {
                    return true;
                }
            }
        }else {
                return false;
        }
        return true;
    }
    public static int wordCount(String[] startWords, String[] targetWords) {
        int countValid = 0;
        Arrays.sort(startWords,(a,b)->{return a.length()-b.length();});
        Arrays.sort(targetWords,(a,b)->{return a.length()-b.length();});
        for (int i = 0; i < targetWords.length; i++) {
            for (int j = 0; j < startWords.length; j++) {
                if(targetWords[i].length()-startWords[j].length()>1){
                    continue;
                }else if(isMatched(startWords[j],targetWords[i])){
                    countValid++;
                    break;
                }
            }
        }
        return countValid;
    }

    public static void main(String[] args) {
        String[] a =new String[]{"q","ugqm","o","ar","e"};
        String[] b = new String[]{"nco","mnwhi","tkuw","ugmiq","fb","oykr","us","sra","dxg","dbp","ql","fq"};
        System.out.println(isMatched("nu","nu"));
        System.out.println(wordCount(a,b));
    }
}
