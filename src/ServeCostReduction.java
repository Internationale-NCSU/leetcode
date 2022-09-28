import org.junit.Test;

import java.util.*;

public class ServeCostReduction {
    public class Pair<K,V>{
        K k;
        V v;

        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, v);
        }
    }
    public int solve(int[] from, int[] to, int[] weight){
        double sum = 0;
        for (int i = 0; i < weight.length; i++) {
            sum+=weight[i];
        }
        Map<Integer, Set<Pair<Integer,Integer>>> map = new HashMap<>();
        Map<Pair<Integer,Integer>,Double>  edgesValueMapping = new HashMap<>();
        for (int i = 0; i < from.length; i++) {
            int small = Math.min(from[i],to[i]);
            int large = Math.max(from[i],to[i]);
            Pair<Integer,Integer> pair = new Pair<>(large,small);
            if(!edgesValueMapping.containsKey(pair)){
                edgesValueMapping.put(pair, (double) weight[i]);
            }

            if(map.containsKey(from[i])){
                map.get(from[i]).add(pair);
            }else {
                Set<Pair<Integer,Integer>> set = new HashSet<>();
                set.add(pair);
                map.put(from[i],set);
            }
            if(map.containsKey(to[i])){
                map.get(to[i]).add(pair);
            }else {
                Set<Pair<Integer,Integer>> set = new HashSet<>();
                set.add(pair);
                map.put(to[i],set);
            }
        }
        PriorityQueue<Pair<Pair<Integer,Integer>,Double>> pq = new PriorityQueue<>(
            (a,b)->{
                if(!a.getV().equals(b.getV())){
                    return (int) (a.getV()-b.getV());
                    // value is weight of the 2 nodes.
                }else {
                    return (int) (edgesValueMapping.get(b.getK()) - edgesValueMapping.get(a.getK()));
                }
            }
        );
        Set<Pair<Integer,Integer>> elemAppearedTwice = new HashSet<>();
        Iterator<Map.Entry<Integer, Set<Pair<Integer, Integer>>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
                //iterator.next is a Map<Integer,Set> Object
                // getValue is a Set.
            int size = iterator.next().getValue().size();
            if(size<=2){
                iterator.remove();
            }
        }
        Set<Pair<Integer,Integer>> set = new HashSet<>();
        // built up pq, record the edges which appear more than once
        for (Map.Entry<Integer, Set<Pair<Integer, Integer>>> integerSetEntry : map.entrySet()) {
            for (Pair<Integer, Integer> integerIntegerPair : integerSetEntry.getValue()) {
                if(!set.contains(integerIntegerPair)){
                    set.add(integerIntegerPair);
                }else {
                    elemAppearedTwice.add(integerIntegerPair);
                }
            }
        }
        Set<Pair<Integer,Integer>> mark = new HashSet<>();
        for (Map.Entry<Integer, Set<Pair<Integer, Integer>>> integerSetEntry : map.entrySet()) {
            Set<Pair<Integer,Integer>> s = integerSetEntry.getValue();
            for (Pair<Integer, Integer> integerIntegerPair : s) {
                if(mark.contains(integerIntegerPair)){
                    continue;
                }
                double w = edgesValueMapping.get(integerIntegerPair);
                if(elemAppearedTwice.contains(integerIntegerPair)){
                    w = w/2;
                }
                Pair pair = new Pair<>(integerIntegerPair,w);
                pq.offer(pair);
                mark.add(integerIntegerPair);
            }
        }
        // marked deleted element in pq.
        Set<Pair<Integer,Integer>> eleDeleted = new HashSet<>();
        while(!pq.isEmpty()){
            Pair<Pair<Integer,Integer>,Double> pair = pq.poll();
            if(eleDeleted.contains(pair.getK())){
                continue;
            }
            double ww = edgesValueMapping.get(pair.getK());
            sum = sum - ww;
            int large = pair.getK().getK();
            int small = pair.getK().getV();

            if(map.containsKey(large)){
                map.get(large).remove(pair.getK());
                eleDeleted.add(pair.getK());
                if(map.get(large).size()<=2){
                    for (Pair<Integer, Integer> integerIntegerPair : map.get(large)) {
                        eleDeleted.add(integerIntegerPair);
                    }
                }
            }

            if(map.containsKey(small)){
                map.get(small).remove(pair.getK());
                eleDeleted.add(pair.getK());
                if(map.get(small).size()<=2){
                    for (Pair<Integer, Integer> integerIntegerPair : map.get(small)) {
                        eleDeleted.add(integerIntegerPair);
                    }
                }
            }
        }
        return (int) sum;
    }
    @Test
    public void test(){
        System.out.println(solve(new int[]{2,4,1,3,5},new int[]{0,0,0,2,2},new int[]{6,3,3,8,8}));
    }
}
