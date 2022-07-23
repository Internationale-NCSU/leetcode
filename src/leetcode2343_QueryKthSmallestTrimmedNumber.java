import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

public class leetcode2343_QueryKthSmallestTrimmedNumber {
    class Pair{
        String str;
        int index;
        public Pair(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }
    
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] arr= new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int result = -1;
            PriorityQueue<Integer> pq = new PriorityQueue<>(query[0],
                    (a,b)->{
                    if(nums[a].substring(nums[a].length()-query[1])
                            .equals(nums[b].substring(nums[b].length()-query[1]))){
                        return a-b;
                    }else {
                        return nums[a].substring(nums[a].length() - query[1])
                                .compareTo(nums[b].substring(nums[b].length() - query[1]));
                    }
                }
            );
            for (int i = 0; i < nums.length; i++) {
                pq.add(i);
            }
            for (int i = 0; i < query[0]; i++) {
                result = pq.poll();
            }
            arr[index] = result;
            index++;
        }
        return arr;
    }
    @Test
    public void test(){
        System.out.println(smallestTrimmedNumbers(new String[]{"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"
}, new int[][]{{6,1}})[0]);
    }
    @Test
    public void stringTest(){
        System.out.println("1231".substring(3).compareTo("2"));
    }
}
