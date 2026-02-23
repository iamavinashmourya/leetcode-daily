# 123. Best Time to Buy and Sell Stock III

**LeetCode Problem:** [Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)

## Approach
The approach to solving this problem involves using dynamic programming to track the maximum profit that can be obtained after the first buy, first sell, second buy, and second sell. This is achieved by maintaining four variables: `buy1`, `sell1`, `buy2`, and `sell2`, which represent the maximum profit after the first buy, first sell, second buy, and second sell respectively.

Here is a step-by-step breakdown of the logic:
1. **Step 1**: Initialize the variables `buy1`, `sell1`, `buy2`, and `sell2` to keep track of the maximum profit after the first buy, first sell, second buy, and second sell respectively. `buy1` and `buy2` are initialized to `-prices[0]` to represent the cost of buying the stock at the first price.
2. **Step 2**: Iterate through the array of prices, updating the variables at each step. For each price, update `buy1` to be the maximum of its current value and `-prices[i]`, which represents the cost of buying the stock at the current price.
3. **Step 3**: Update `sell1` to be the maximum of its current value and `buy1 + prices[i]`, which represents the profit after selling the stock at the current price.
4. **Step 4**: Update `buy2` to be the maximum of its current value and `sell1 - prices[i]`, which represents the cost of buying the stock at the current price after selling the first stock.
5. **Step 5**: Update `sell2` to be the maximum of its current value and `buy2 + prices[i]`, which represents the profit after selling the second stock at the current price.
6. **Step 6**: After iterating through all prices, return `sell2`, which represents the maximum possible profit after the second sell.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the number of prices, as we are iterating through the array of prices once.
- **Space Complexity**: The space complexity of this solution is O(1), as we are using a constant amount of space to store the variables `buy1`, `sell1`, `buy2`, and `sell2`.

## Dry Run
Let's consider the example input `prices = [3, 3, 5, 0, 0, 3, 1, 4]`. Here is the execution of the algorithm in a structured table format:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 0 | buy1 = -3, sell1 = 0, buy2 = -3, sell2 = 0 | Initialize variables | buy1 = -3, sell1 = 0, buy2 = -3, sell2 = 0 |
| 1 | buy1 = -3, sell1 = 0, buy2 = -3, sell2 = 0 | Update variables for price 3 | buy1 = -3, sell1 = 0, buy2 = -3, sell2 = 0 |
| 2 | buy1 = -3, sell1 = 0, buy2 = -3, sell2 = 0 | Update variables for price 5 | buy1 = -3, sell1 = 2, buy2 = -1, sell2 = 0 |
| 3 | buy1 = -3, sell1 = 2, buy2 = -1, sell2 = 0 | Update variables for price 0 | buy1 = -1, sell1 = 2, buy2 = 2, sell2 = 2 |
| 4 | buy1 = -1, sell1 = 2, buy2 = 2, sell2 = 2 | Update variables for price 0 | buy1 = -1, sell1 = 2, buy2 = 2, sell2 = 2 |
| 5 | buy1 = -1, sell1 = 2, buy2 = 2, sell2 = 2 | Update variables for price 3 | buy1 = -1, sell1 = 2, buy2 = 2, sell2 = 5 |
| 6 | buy1 = -1, sell1 = 2, buy2 = 2, sell2 = 5 | Update variables for price 1 | buy1 = -1, sell1 = 2, buy2 = 2, sell2 = 5 |
| 7 | buy1 = -1, sell1 = 2, buy2 = 2, sell2 = 5 | Update variables for price 4 | buy1 = -1, sell1 = 2, buy2 = 2, sell2 = 6 |
| 8 | buy1 = -1, sell1 = 2, buy2 = 2, sell2 = 6 | Return sell2 | Result/Output = 6 |

The final output of the algorithm is 6, which is the maximum possible profit after the second sell.
## Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int buy2 = -prices[0];
        int sell1 = 0;
        int sell2 = 0;

        if(prices == null || prices.length == 0) return 0;

        for(int i = 1; i<prices.length; i++){
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);

            buy2 = Math.max(buy2, sell1-prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return sell2;
    }
}
```