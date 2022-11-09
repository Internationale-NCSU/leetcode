import java.util.*;
import java.io.*;
public class GfG
{
    public int minSwaps(int[] nums)
    {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[len];
        int result = 0;
        for(int i=0;i<len;i++) {
            if(visited[i] || map.get(nums[i]) == i){
                continue;
            }
                    int j = i, size = 0;
                    while(!visited[j]) {
                    visited[j] = true;
                    j = map.get(nums[j]);
                    size++;
                    }
                    if(size > 0) {
                    result += (size - 1);
                    }
                    }
                    return result;
                    }
                    }

// Driver class
class MinSwaps
{
    // Driver program to test the above function
    public static void main(String[] args)
    {
        int []a = {1, 5, 4, 3, 2};
        GfG g = new GfG();
        System.out.println(g.minSwaps(a));
    }
}
// This code is contributed by Saurabh Johari