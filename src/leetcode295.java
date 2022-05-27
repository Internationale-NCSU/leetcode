import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class leetcode295 {
    public static class MedianFinder {
        List<Integer> list;
        public MedianFinder() {
            list = new LinkedList<>();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            Collections.sort(list);
            if(list.size()%2==0){
                double num1 = list.get(list.size()/2-1);
                double num2 = list.get(list.size()/2);
                return (num1+num2)/2;
            }else {
                return list.get(list.size()/2);
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(-3);
        medianFinder.addNum(-4);
        System.out.println(medianFinder.list);
        System.out.println(medianFinder.findMedian());
    }
}
