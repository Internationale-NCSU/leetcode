import org.junit.Test;

import java.util.PriorityQueue;

public class HackerRank_BankTransaction {
    public int maxNumberOfTransaction(int[] transactions){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int count = 0;
        int curBalance = 0;
        for (int i = 0; i < transactions.length; i++) {
            if(transactions[i]>=0) {
                count++;
                curBalance += transactions[i];
            }else{
                if(curBalance + transactions[i] > 0){
                    priorityQueue.offer(transactions[i]);
                    count++;
                    curBalance += transactions[i];
                }else if(!priorityQueue.isEmpty()) {
                    int last = priorityQueue.peek();
                    if(transactions[i]>last){
                        priorityQueue.poll();
                        priorityQueue.offer(transactions[i]);
                        curBalance += transactions[i] - last;
                        if(curBalance + transactions[i]>=0){
                            transactions[i]+=curBalance;
                        }
                    }
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(maxNumberOfTransaction(new int[]{1,2,3,-6,2,-1,-1,3,-7,-1,-2}));
    }
}
