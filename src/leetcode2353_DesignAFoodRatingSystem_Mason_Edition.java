import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode2353_DesignAFoodRatingSystem_Mason_Edition {
    class FoodRatings {
        class Pairs<T, U> {
            T key;
            U value;

            public Pairs(T key, U valuer) {
                this.key = key;
                this.value = valuer;
            }

            public T getKey() {
                return key;
            }

            public void setKey(T key) {
                this.key = key;
            }

            public U getValue() {
                return value;
            }

            public void setValue(U value) {
                this.value = value;
            }
        }
        Map<String, PriorityQueue<Pairs<String, Integer>>> map = new HashMap<>();
        Map<String, String> foodsToCuisines = new HashMap<>();
        Map<String, Pairs<String, Integer>> foodToPairs = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                foodsToCuisines.put(foods[i], cuisines[i]);
                Pairs<String, Integer> food = new Pairs<>(foods[i], ratings[i]);
                foodToPairs.put(foods[i], food);
                if (!this.map.containsKey(cuisines[i])) {
                    PriorityQueue<Pairs<String, Integer>> pq = getPq();
                    pq.add(food);
                    map.put(cuisines[i], pq);
                } else {
                    PriorityQueue<Pairs<String, Integer>> pq = map.get(cuisines[i]);
                    pq.offer(food);
                }
            }
        }

        public PriorityQueue<Pairs<String, Integer>> getPq() {
            return new PriorityQueue<Pairs<String, Integer>>(
                    (a, b) -> {
                        int ratingA = a.getValue();
                        int ratingB = b.getValue();
                        if (ratingA != ratingB) {
                            return ratingB - ratingA;
                        } else {
                            return a.getKey().compareTo(b.getKey());
                        }
                    }
            );
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodsToCuisines.get(food);
            PriorityQueue<Pairs<String, Integer>> pq = map.get(cuisine);
            Pairs<String, Integer> foodPair = foodToPairs.get(food);
            pq.remove(foodPair);
            Pairs<String, Integer> newFoodPair = new Pairs<>(food, newRating);
            foodToPairs.put(food, newFoodPair);
            pq.offer(newFoodPair);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Pairs<String, Integer>> pq = map.get(cuisine);
            return pq.peek().getKey();
        }
    }
}
