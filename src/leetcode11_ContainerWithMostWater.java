public class leetcode11_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int head = 0;
        int rear = height.length-1;
        int max = 0;
        while (rear!=head){
            max = Math.max(max,(rear-head)*Math.min(height[rear],height[head]));
            if(height[rear]>height[head]){
                head++;
            }else {
                rear--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
