public class leetcode5194 {
    public static int minMoves(int target, int maxDoubles) {
        int countStep = 0;
        while (target!=1){
            if(target%2==1){
                target = target-1;
                countStep++;
            }else if(maxDoubles>0) {
                maxDoubles--;
                target = target/2;
                countStep++;
            }else {
                countStep = countStep+target-1;
                break;
            }

        }
        return countStep;
    }

    public static void main(String[] args) {
        System.out.println(minMoves(8
                ,1));
    }
}
