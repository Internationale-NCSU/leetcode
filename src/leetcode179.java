import java.util.Arrays;
import java.util.stream.Collectors;

public class leetcode179 {

    public static String largestNumber(int[] nums) {
        String[] arrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arrs,(String a,String b)->{String s1 = a+b; String s2 = b+a; return -s1.compareTo(s2);});
        if(arrs[0].equals("0")){
            return "0";
        }else {
            return Arrays.stream(arrs).collect(Collectors.joining());
        }
    }

    public static void main(String[] args) {
        int[] arr ={10,2};
        System.out.println(largestNumber(arr));
    }
}
