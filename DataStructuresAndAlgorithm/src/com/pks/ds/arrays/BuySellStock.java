package com.pks.ds.arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuySellStock {


    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(bestTimeBuySellStock(prices));
    }

    private static int bestTimeBuySellStock(int[] prices) {
        int l = 0, r = 1;
        int maxProfit = 0;
        while (r < prices.length){
            if(prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                l = r;
            }
            r = r + 1;
        }

        return maxProfit;
    }

}
