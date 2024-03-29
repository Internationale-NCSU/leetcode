//        You've created a meal plan for the next few days, and prepared a list of products that you'll need as ingredients for each day's meal.
//        There are many shops around you that sell the products you're looking for, but you only have time to visit one or two stores each day.
//        Given the following information, your task is to find the minimum cost you'll need to spend on each meal:
//
//        cntProducts - an integer representing the total number of products you'll be using in all of your meals;
//        quantities - a rectangular matrix of integers, where quantities[i][j] represents the amount of product j available in shop i;
//        costs - a rectangular matrix of integers, where costs[i][j] represents the cost of buying product j from shop i;
//        meals - a rectangular matrix of integers, where meals[m][j] represents the amount of product j required to make the mth meal.
//        Return an array of length meals.length representing the minimum cost of each meal (assuming you can only visit up to two shops each day).
//
//        NOTE:
//        You only like to use fresh ingredients, so you'll need to buy new products from the shops each day (you may not use leftovers from a previous day).
//        Each store re-stocks their merchandise every night, so the amounts in the quantities array are available each day.
//        It's guaranteed that it will always be possible to buy all the products needed for each meal by visiting only one or two shops.
//        Example
//        For cntProducts = 2,
//        quantities = [[1, 3],
//        [2, 1],
//        [1, 3]]
//        costs = [[2, 4],
//        [5, 2],
//        [4, 1]]
//        and
//        meals = [[1, 1],
//        [2, 2],
//        [3, 4]]
//        the output should be choosingShops(cntProducts, quantities, costs, meals) = [3, 8, 19].
//
//        There are 3 shops and 2 products in total.
//
//        To cook the first meal you need to buy one product 0 and one product 1. The most optimal way is to buy them in the first and third shops respectively: buying one product 0 in the first shop costs 2 * 1 = 2 and buying one product 1 in the third shop costs 1 * 1 = 1. So you pay 2 + 1 = 3 units of money for this meal.
//        To cook the second meal you need to buy two of product 0 and two of product 1. The optimal way is to buy one product 0 in the first shop, and then buy one product 0 and two product 1s in the third shop. This way, you spend (1 * 2) + (1 * 4 + 2 * 1) = 8 units of money.
//        To cook the third meal you need to buy three of product 0 and four of product 1. The optimal way is to buy two product 0s and one product 1 in the second shop, and then buy one product 0 and three product 1s in the third shop. This way, you spend (2 * 5 + 1 * 2) + (1 * 4 + 3 * 1) = 19 units of money.
//        Input/Output
//
//        [execution time limit] 3 seconds (java)
//
//        [input] integer cntProducts
//
//        An integer representing the number of different products in all shops.
//
//        Guaranteed constraints:
//        2 ≤ cntProducts ≤ 50.
//
//        [input] array.array.integer quantities
//
//        A matrix of integers representing the quantities for every product in every shop.
//
//        Guaranteed constraints:
//        2 ≤ quantities.length ≤ 50,
//        quantities[i].length = cntProducts,
//        0 ≤ quantities[i][j] ≤ 1000.
//
//        [input] array.array.integer costs
//
//        A matrix of integers representing the costs for every product in every shop.
//
//        Guaranteed constraints:
//        costs.length = quantities.length,
//        costs[i].length = cntProducts,
//        1 ≤ costs[i][j] ≤ 1000.
//
//        [input] array.array.integer meals
//
//        A matrix representing the list of required ingredients for each meal you need to process.
//
//        Guaranteed constraints:
//        1 ≤ meals.length ≤ 50,
//        meals[i].length = cntProducts,
//        0 ≤ meals[i][j] ≤ 2000.
//
//        [output] array.integer
//
//        Return an array of integers of length meals.length, where the ith element represents the minimum cost for buying the products to cook the ith meal, visiting only one or two shops.

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class chooseShop {
    public static int[] choseShop(int cntProduct,int[][] quantities, int[][] cost, int[][] meal){
        List<Integer[]>[] list = new List[cntProduct];
        int[] result = new int[cntProduct];
        for (int i = 0; i < cntProduct-1; i++) {
            //0:余量, 1:单价, 2:店铺
            List<Integer[]> ingredient = new LinkedList<>();
            for (int j = 0; j < quantities.length; j++) {
                Integer[] properties = new Integer[3];
                properties[0] = quantities[j][i];
                properties[1] = cost[j][i];
                properties[2] = j;
                ingredient.add(properties);
            }
            list[i] = ingredient;
        }
        for (int i = 0; i < cntProduct-1; i++) {
            Collections.sort(list[i],(Integer[] a,Integer[] b)->{ return a[1] - b[1]; });
            for (Integer[] integers : list[i]) {
                System.out.println(integers[0]+" "+integers[1]+" "+integers[2]);
            }
            System.out.println("-------------");
        }
        for (int i = 0; i < meal.length; i++) {
            int mealCost = 0;
            for (int j = 0; j < meal[i].length; j++) {
                int visit = 0;
                while(true) {
                    list[j].get(visit);
                }
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[][] quantities = {{1,3},{2,1},{1,3}};
        int[][] cost = {{2,4},{5,2},{4,1}};
        int[][] meal = {{1,1},{2,2},{3,4}};
        System.out.println(choseShop(3,quantities,cost,meal));

    }
}
