# 263. Ugly Number

**LeetCode Problem:** [Ugly Number](https://leetcode.com/problems/ugly-number/)

## Approach

The approach to solving the "Ugly Number" problem involves iteratively dividing the input number `n` by its prime factors (2, 3, and 5) as long as it is divisible. This process checks if the number can be reduced to 1, which is the definition of an ugly number.

Here is a step-by-step breakdown of the logic:
1. **Step 1**: Initialize a loop to iterate over the prime factors 2, 3, and 5.
2. **Step 2**: For each prime factor `i`, check if `n` is divisible by `i`. If it is, divide `n` by `i` until it is no longer divisible.
3. **Step 3**: After checking all prime factors, check if `n` has been reduced to 1. If it has, then the original number is an ugly number.

- **Time Complexity**: The time complexity of this solution is O(log n) because in the worst case, we are dividing `n` by its smallest prime factor (2) until it is no longer divisible, which takes logarithmic time.
- **Space Complexity**: The space complexity of this solution is O(1) because we are only using a constant amount of space to store the variables `n` and `i`.

## Dry Run

Let's take the example input `n = 6`. Here's how the algorithm would execute:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `n = 6`, `i = 2` | Check if `n` is divisible by `i` | `n` is divisible by `i` |
| 2 | `n = 6`, `i = 2` | Divide `n` by `i` | `n = 3` |
| 3 | `n = 3`, `i = 3` | Check if `n` is divisible by `i` | `n` is divisible by `i` |
| 4 | `n = 3`, `i = 3` | Divide `n` by `i` | `n = 1` |
| 5 | `n = 1` | Check if `n` is equal to 1 | `n` is equal to 1, so return `true` |
| 6 | `n = 1` | Return the result | `true` |

The final output of the algorithm is `true`, indicating that the input number `6` is an ugly number.
## Code
```java
class Solution {
    public boolean isUgly(int n) {
        for(int i=2; i<=5 && n>1; i++){
            while(n % i == 0){
                n /= i;
            }
        }

        return n == 1;
    }
}
```