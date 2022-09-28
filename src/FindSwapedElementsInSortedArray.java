import org.junit.Test;

public class FindSwapedElementsInSortedArray {
    public String find(int[] arr){
        int x = -1, y = -1;
        boolean firstOccurrence = false;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                y = arr[i+1];
                if(!firstOccurrence){
                    x = arr[i];
                    firstOccurrence = true;
                }else {
                    break ;
                }
            }
        }
        return ""+x+" "+y;
    }
    @Test
    public void test(){
        System.out.println(find(new int[]{1,2,3,8,5,6,7,4}));
    }
}
