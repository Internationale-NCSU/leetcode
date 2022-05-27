public class leetcode74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int n = matrix.length,m = matrix[0].length;
        int left = 0,right = m*n-1;
        while(left<=right){
            int mid = (left + right)/2;
            int row = mid/m,col =mid%m;
            if(target == matrix[row][col]){
                return true;
            }else {
                if (matrix[row][col] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(searchMatrix(matrix,5));
    }
}
