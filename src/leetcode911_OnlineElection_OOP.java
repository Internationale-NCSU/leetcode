import org.junit.Test;

import java.util.*;

public class leetcode911_OnlineElection_OOP {
    class TopVotedCandidate {
        class Pair<K, V> {
            K k;
            V v;

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()){
                    return false;
                }
                Pair<?, ?> pair = (Pair<?, ?>) o;
                return Objects.equals(k, pair.k) && Objects.equals(v, pair.v);
            }

            @Override
            public int hashCode() {
                return Objects.hash(k, v);
            }

            public Pair(K k, V v) {
                this.k = k;
                this.v = v;
            }

            public K getK() {
                return k;
            }

            public V getV() {
                return v;
            }

            public void setK(K k) {
                this.k = k;
            }

            public void setV(V v) {
                this.v = v;
            }
        }
        //K-person, V-votes

        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (a, b) -> {
                    if(!a.getV().equals(b.getV())) {
                        return b.getV() - a.getV();
                    }else {
                        return -1;
                    }
                }
        );
        Map<Integer, Pair<Integer,Integer>> personToVotes = new HashMap<>();
        TreeMap<Integer, Integer> timeToPerson = new TreeMap<>();
        public TopVotedCandidate(int[] persons, int[] times) {
            Pair<Integer, Integer> pair;
            for (int i = 0; i < persons.length; i++) {
                if (!personToVotes.containsKey(persons[i])) {
                    pair = new Pair<>(persons[i], 1);
                    priorityQueue.offer(pair);
                    personToVotes.put(persons[i],pair);
                    timeToPerson.put(times[i],priorityQueue.peek().getK());
                }else {
                    pair = personToVotes.get(persons[i]);
                    priorityQueue.remove(pair);
                    pair.setV(pair.getV()+1);
                    priorityQueue.offer(pair);
                    timeToPerson.put(times[i],priorityQueue.peek().getK());
                }
            }
        }

        public int q(int t) {
            return timeToPerson.get(timeToPerson.floorKey(t));
        }
    }
    @Test
    public void test(){
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(
            new int[]{0,1,1,0,0,1,0},
            new int[]{0,5,10,15,20,25,30}
        );
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(24));
    }

}
