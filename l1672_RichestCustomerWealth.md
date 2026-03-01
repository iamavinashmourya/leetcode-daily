# 1672. Richest Customer Wealth

**LeetCode Problem:** [Richest Customer Wealth](https://leetcode.com/problems/richest-customer-wealth/)

## Approach
The approach to solving the "Richest Customer Wealth" problem involves iterating over each customer's account and calculating the total wealth by summing up all the accounts. The maximum wealth found so far is updated whenever a customer with higher total wealth is encountered.

Here's a step-by-step breakdown of the logic:
1. **Initialization**: Initialize the `ans` variable to `Integer.MIN_VALUE` to keep track of the maximum wealth found so far.
2. **Iterate over customers**: Iterate over each customer's account using a nested loop structure.
3. **Calculate total wealth**: For each customer, calculate the total wealth by summing up all the accounts.
4. **Update maximum wealth**: If the total wealth of the current customer is greater than the maximum wealth found so far, update the `ans` variable.
5. **Return maximum wealth**: After iterating over all customers, return the maximum wealth found.

- **Time Complexity**: The time complexity of this solution is O(m*n), where m is the number of customers and n is the average number of accounts per customer.
- **Space Complexity**: The space complexity of this solution is O(1), as it only uses a constant amount of space to store the `ans` variable and the loop indices.

## Dry Run

Let's consider an example input `accounts = [[1,2,3],[3,2,1]]`. Here's the execution of the algorithm in a structured table format:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `ans = Integer.MIN_VALUE`, `i = 0` | Initialize `sum` to 0, start iterating over `accounts[0]` | `sum = 0` |
| 2 | `sum = 0`, `j = 0` | Add `accounts[0][0]` to `sum` | `sum = 1` |
| 3 | `sum = 1`, `j = 1` | Add `accounts[0][1]` to `sum` | `sum = 3` |
| 4 | `sum = 3`, `j = 2` | Add `accounts[0][2]` to `sum` | `sum = 6` |
| 5 | `sum = 6`, `i = 0` | Update `ans` to `sum` (6) if it's greater than current `ans` | `ans = 6` |
| 6 | `ans = 6`, `i = 1` | Initialize `sum` to 0, start iterating over `accounts[1]` | `sum = 0` |
| 7 | `sum = 0`, `j = 0` | Add `accounts[1][0]` to `sum` | `sum = 3` |
| 8 | `sum = 3`, `j = 1` | Add `accounts[1][1]` to `sum` | `sum = 5` |
| 9 | `sum = 5`, `j = 2` | Add `accounts[1][2]` to `sum` | `sum = 6` |
| 10 | `sum = 6`, `i = 1` | Update `ans` to `sum` (6) if it's greater than current `ans` | `ans` remains 6 |
| 11 | `ans = 6` | Return `ans` as the maximum wealth | `Output = 6` |

The final output is `6`, which is the maximum wealth among all customers.
## Code
```java
class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i<accounts.length; i++){
            int sum = 0;
            for(int j = 0; j < accounts[i].length; j++){
                sum+=accounts[i][j];
            }
            if(sum>ans)
                ans = sum;
        }

        

        return ans;
    }
}
```