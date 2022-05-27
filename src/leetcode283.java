import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode283 {
    public static void swap(int i,int j){
        int tmp = i;
        i = j;
        j = tmp;
    }

    public static void moveZeroes(int[] nums) {
        List list = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                list.add(nums[i]);
            }
        }
        list.stream().filter((a)->{return (int)a!=0;});
        for (int i = 0; i < nums.length; i++) {
            if(i<list.size()){
                nums[i] = (int)list.get(i);
            }else {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
