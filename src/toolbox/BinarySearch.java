package toolbox;


public class BinarySearch {
    public static int findTheNextBiggerIndex(int[] nums,int curValue){
        int left = 0,right = nums.length-1;
        int nextIndex = nums.length;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>=curValue){
                nextIndex = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return nextIndex;
    }
    public static int findTheLastSmallerIndex(int[] nums,int curValue){
        int left = 0,right = nums.length-1;
        int nextIndex = nums.length;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]<=curValue){
                nextIndex = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return nextIndex;
    }

    public static void main(String[] args) {

        System.out.println(findTheNextBiggerIndex(new int[]{1,2,3,4,4,5,6,9},10));

        System.out.println(findTheLastSmallerIndex(new int[]{9,6,5,4,4,2,1},7));

    }

}
