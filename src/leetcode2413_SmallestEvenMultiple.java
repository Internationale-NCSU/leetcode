public class leetcode2413_SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        if(n%2==1){
            return n*2;
        }else {
            return n;
        }
    }
}
