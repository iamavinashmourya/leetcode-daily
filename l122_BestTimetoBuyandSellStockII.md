# 122. Best Time to Buy and Sell Stock II

**LeetCode Problem:** [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

## Approach
The approach to solving the "Best Time to Buy and Sell Stock II" problem involves iterating through the array of stock prices and accumulating the profit from each upward trend. This is achieved by comparing each price with its previous price and adding the difference to the total profit whenever an upward trend is found.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize a variable `profit` to 0, which will store the maximum possible profit.
2. **Step 2**: Iterate through the array of stock prices starting from the second price (index 1).
3. **Step 3**: For each price, compare it with its previous price. If the current price is greater than the previous price, it means an upward trend is found.
4. **Step 4**: If an upward trend is found, calculate the profit from this trend by subtracting the previous price from the current price and add it to the total profit.
5. **Step 5**: Continue this process until all prices have been iterated through.
6. **Step 6**: Return the total profit accumulated from all upward trends.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the number of days (i.e., the length of the prices array), because it involves a single pass through the array of prices.
- **Space Complexity**: The space complexity is O(1), as it uses a constant amount of space to store the profit variable, regardless of the input size.

## Dry Run
Let's consider the example input: `prices = [7, 1, 5, 3, 6, 4]`

Here's the step-by-step execution:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `profit = 0`, `i = 1`, `prices[i] = 1`, `prices[i-1] = 7` | Compare `prices[i]` with `prices[i-1]` | No action, `prices[i]` is not greater than `prices[i-1]` |
| 2 | `profit = 0`, `i = 2`, `prices[i] = 5`, `prices[i-1] = 1` | Compare `prices[i]` with `prices[i-1]` | Add `prices[i] - prices[i-1] = 5 - 1 = 4` to `profit`, `profit = 4` |
| 3 | `profit = 4`, `i = 3`, `prices[i] = 3`, `prices[i-1] = 5` | Compare `prices[i]` with `prices[i-1]` | No action, `prices[i]` is not greater than `prices[i-1]` |
| 4 | `profit = 4`, `i = 4`, `prices[i] = 6`, `prices[i-1] = 3` | Compare `prices[i]` with `prices[i-1]` | Add `prices[i] - prices[i-1] = 6 - 3 = 3` to `profit`, `profit = 7` |
| 5 | `profit = 7`, `i = 5`, `prices[i] = 4`, `prices[i-1] = 6` | Compare `prices[i]` with `prices[i-1]` | No action, `prices[i]` is not greater than `prices[i-1]` |
| 6 | `profit = 7` | Return `profit` | `profit = 7` |

The final output is `7`, which is the maximum possible profit that can be achieved by buying and selling stocks in the given prices array.
## Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }

        return profit;
    }
}
```