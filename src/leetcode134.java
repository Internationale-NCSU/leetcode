import java.util.stream.IntStream;
public class leetcode134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = IntStream.of(gas).sum();
        int costSum = IntStream.of(cost).sum();
        if(gasSum>=costSum){
            int begin = -1;
            int attempt = 0;
            int remnant = 0;
            for (int i = 0; i < gas.length-1 ; i++) {
                remnant = gas[i]-cost[i];
                if(remnant<0){
                    continue;
                }else {
                    begin = i;
                    while (i<cost.length-1){
                        if(remnant<=0&&i!=gas.length-1){
                            begin = -1;
                            break;
                        }else {
                            i++;
                            remnant = remnant + gas[i] -cost[i];
                            if(remnant<=0&&i!=gas.length-1){
                                begin = -1;
                                break;
                            }
                        }
                    }
                }
            }
            if(begin==-1) {
                begin = cost.length-1;
            }
            return begin;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5},cost ={3,4,5,1,2};
        int[] gas1 = {5,1,2,3,4},cost1 = {4,4,1,5,1};
        System.out.println(canCompleteCircuit(gas1,cost1));
    }
}
