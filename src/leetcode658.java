import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode658 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5};
        System.out.println(findClosestElements(arr,4,-1));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0,right = arr.length-1;
        while(right-left+1 > k){
            if(arr[left] >= x){
                right = right -1;
            }else if(arr[right] <= x){
                left = left +1;
            }else{
                int difLeft = x - arr[left],difRight = arr[right] - x;
                if(difLeft>difRight){
                    left = left + 1;
                }else {
                    right = right - 1;
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int i = left; i <= right ; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
