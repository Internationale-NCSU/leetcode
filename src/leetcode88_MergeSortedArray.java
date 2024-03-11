import org.junit.Test;

public class leetcode88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        for (int i = 0; i < nums3.length; i++) {
            nums3[i] = nums1[i];
        }

        int p1 = 0, p2 = 0,p = 0;
        while(p1<m&&p2<n){
            if(nums3[p1]>nums2[p2]){
                nums1[p] = nums2[p2];
                p2++;
                p++;
            }else{
                nums1[p] = nums3[p1];
                p1++;
                p++;
            }
        }
        if(p2>=n){
            for(;p<nums1.length;p++){
                nums1[p] = nums3[p1];
                p1++;
            }
        }else{
            for(;p<nums1.length;p++){
                nums1[p] = nums2[p2];
                p2++;
            }
        }
    }
    @Test
    public void test(){
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);

    }

}
