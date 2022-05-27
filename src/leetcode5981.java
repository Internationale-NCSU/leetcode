import java.util.LinkedList;
import java.util.List;

public class leetcode5981 {
    public static List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int[] countOne = new int[nums.length+1];
        countOne[0] = 0;
        for (int i = 1; i < countOne.length; i++) {
            if(nums[i-1]==1){
                countOne[i] = countOne[i-1]+1;
            }else {
                countOne[i] = countOne[i-1];
            }
        }
        for (int i = 0; i < countOne.length; i++) {
            int one = countOne[countOne.length-1]-countOne[i];
            int zero = (i-0)-(countOne[i] - countOne[0]);
            if(one+zero>=max){
                if(list.isEmpty()){
                    list.add(i);
                }else if(one+zero==max){
                    list.add(i);
                }else if(one+zero>max){
                    list.clear();
                    list.add(i);
                }
                max = one+zero;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(maxScoreIndices(new int[]{1,1}));
    }
}
