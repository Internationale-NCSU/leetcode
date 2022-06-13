import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode1396 {
    class Pair<K,V>{
        K k;
        V v;
        public Pair(K k,V v){
            this.k = k;
            this.v = v;
        }
        public K getKey(){
            return this.k;
        }
        public V getValue(){
            return this.v;
        }
    }
    class UndergroundSystem {
        Map<Integer, Pair<String, Integer>> checkIn;// Pair: key->station name,id->time , value: time
        Map<Pair<String,String>,Pair<Double,Integer>> averageTimeMap;
        public UndergroundSystem() {
            checkIn = new HashMap<>();
            averageTimeMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            Pair<String,Integer> record = new Pair<>(stationName,t);
            checkIn.put(id,record);
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String,Integer> record = checkIn.remove(id);
            String checkInStation = record.getKey();
            int checkInTime = record.getValue();
            Pair<String,String> startToEnd = new Pair<>(checkInStation,stationName);
            Pair<Double,Integer> pair = averageTimeMap.getOrDefault(startToEnd, new Pair<>((double)0,0));
            double sum = pair.getKey();
            if(sum==0){
                sum = t - checkInTime;
                averageTimeMap.put(startToEnd,new Pair<>(sum,1));
            }else {
                sum = sum + t-checkInTime;
                int flow = pair.getValue();
                averageTimeMap.put(startToEnd,new Pair<>(sum,flow+1));
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            return averageTimeMap.get(new Pair<>(startStation,endStation)).getKey()/averageTimeMap.get(new Pair<>(startStation,endStation)).getValue();
        }
    }
    @Test
    public void test() {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45,"Leyton",3);
        undergroundSystem.checkIn(32,"Paradise",8);
        undergroundSystem.checkIn(27,"Leyton",10);
        undergroundSystem.checkOut(45,"Waterloo",15);
        undergroundSystem.checkOut(27,"Waterloo",20);
        undergroundSystem.checkOut(32,"Cambridge",22);
        System.out.println(undergroundSystem.getAverageTime("Paradise","Cambridge"));
        System.out.println(undergroundSystem.getAverageTime("Leyton","Waterloo"));
        undergroundSystem.checkIn(10,"Leyton",24);
        System.out.println(undergroundSystem.getAverageTime("Leyton","Waterloo"));
        undergroundSystem.checkOut(10,"Waterloo",38);
        System.out.println(undergroundSystem.getAverageTime("Leyton","Waterloo"));
    }
}
