import java.util.Map;

public class leetcode42 {
    public static int trap(int[] height) {
        int climax = 0;
        int[] reservoirLeft = new int[height.length];
        int[] reservoirRight = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if(height[i]<climax){
                reservoirLeft[i] = climax - height[i];
            }else {
                climax = Math.max(climax, height[i]);
            }
        }
        climax = 0;
        for (int i = height.length-1; i >= 0; i--) {
            if(height[i]<climax){
                reservoirRight[i] = climax - height[i];
            }else {
                climax = Math.max(climax, height[i]);
            }
        }
        int volume = 0;
        for (int i = 0; i < height.length; i++) {
            if(reservoirLeft[i]!=0&&reservoirRight[i]!=0){
                volume = volume + Math.min(reservoirLeft[i],reservoirRight[i]);
            }
        }
        return volume;

    }
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
