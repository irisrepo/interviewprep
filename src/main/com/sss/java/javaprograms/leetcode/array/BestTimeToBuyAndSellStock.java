package src.main.com.sss.java.javaprograms.leetcode.array;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();

        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int result1 = stock.maxProfit(prices1);
        System.out.println("Max profit: " + result1); // Output: 5

        // Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        int result2 = stock.maxProfit(prices2);
        System.out.println("Max profit: " + result2); // Output: 0

        // Test Case 3
        int[] prices3 = {2, 4, 1};
        int result3 = stock.maxProfit(prices3);
        System.out.println("Max profit: " + result3); // Output: 2

        // Test Case 4
        int[] prices4 = {1, 2, 3, 4, 5};
        int result4 = stock.maxProfit(prices4);
        System.out.println("Max profit: " + result4); // Output: 4

        //Test Case 5
        int[] prices5 = {3, 3};
        int result5 = stock.maxProfit(prices5);
        System.out.println("Max profit: " + result5); // Output: 0

        //Test Case 6
        int[] prices6 = {2, 1, 2, 1, 0, 1, 2};
        int result6 = stock.maxProfit(prices6);
        System.out.println("Max profit: " + result6); // Output: 2
    }
}



