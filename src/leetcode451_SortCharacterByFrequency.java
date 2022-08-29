import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode451_SortCharacterByFrequency {
    public String frequencySort(String s) {
        int[] arr = new int[62];
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(
            (a,b)->{
                return arr[findIndex(b)]-arr[findIndex(a)];
            }
        );
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='a'&&s.charAt(i)<='z') {
                arr[s.charAt(i)-'a']++;
            }else if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                arr[s.charAt(i)-'A'+26]++;
            }else {
                arr[s.charAt(i)-'0'+52]++;
            }
        }
        for (int i = 0; i < 62; i++) {
            priorityQueue.offer(findChar(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!priorityQueue.isEmpty()){
            char c = priorityQueue.poll();
            for (int i = 0; i < arr[findIndex(c)]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public char findChar(int i){
        if(i>=0&&i<26){
            return (char) ('a'+i);
        }else if(i>=26&&i<52){
            return (char)('A'+i-26);
        }else   {
            return (char) ('0'+i-52);
        }
    }
    public int findIndex(char c){
        if(c>='a'&&c<='z') {
            return c-'a';
        }else if(c>='A'&&c<='Z'){
            return c-'A'+26;
        }else {
            return c-'0'+52;
        }
    }
    @Test
    public void test(){
        System.out.println(frequencySort("1111"));
    }
}
