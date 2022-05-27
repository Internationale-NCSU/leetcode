import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class leetcode6000 {
    public static int[] sortEvenOdd(int[] nums) {
        List<Integer> odds = new LinkedList<>();
        List<Integer> evens = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                evens.add(nums[i]);
            }else {
                odds.add(nums[i]);
            }
        }
        Collections.sort(odds,Collections.reverseOrder());
        Collections.sort(evens);
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                nums[i] = evens.get(i/2);
            }else {
                nums[i] = odds.get(i/2);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Arrays.stream(sortEvenOdd(new int[]{2,1})).forEach(
                a-> System.out.println(a)
        );
    }
}
