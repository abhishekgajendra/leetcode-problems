
//Brute force approach
// public class Solution {
//     public int maxProfit(int prices[]) {
//         int maxprofit = 0;
//         for (int i = 0; i < prices.length - 1; i++) {
//             for (int j = i + 1; j < prices.length; j++) {
//                 int profit = prices[j] - prices[i];
//                 if (profit > maxprofit)
//                     maxprofit = profit;
//             }
//         }
//         return maxprofit;
//     }
// }


//see solution provided by leetcode
public class Stockbuyandsell {
     static int maxProfit(int[] prices)
    {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0;i<prices.length;i++)
        {
            if(min>prices[i])
                min = prices[i];
            else if( prices[i]-min>maxProfit)
                maxProfit =   prices[i]-min;  
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {4,5,9,34,3,7};

        System.out.println("maximum profit will be"+" "+maxProfit(prices) );

    }
}
