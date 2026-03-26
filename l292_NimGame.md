# 292. Nim Game

**LeetCode Problem:** [Nim Game](https://leetcode.com/problems/nim-game/)

## Approach
The approach to solving the "Nim Game" problem involves understanding the pattern of winning and losing positions in the game. By analyzing the game's rules, we can determine that the outcome depends on the remainder when the number of stones is divided by 4.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Determine the number of stones, which is the input `n`.
2. **Step 2**: Calculate the remainder when `n` is divided by 4 using the modulo operator (`n % 4`).
3. **Step 3**: Check if the remainder is not equal to 0 (`n % 4 != 0`).
4. **Step 4**: If the remainder is not 0, the function returns `true`, indicating that the current player can win the game. Otherwise, it returns `false`.

- **Time Complexity**: The time complexity of this solution is O(1), as it only involves a constant number of operations regardless of the input size.
- **Space Complexity**: The space complexity is also O(1), as it only uses a fixed amount of space to store the input and the result.

## Dry Run

Let's consider an example input `n = 5`. Here's the execution of the algorithm in a step-by-step table format:

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `n = 5` | Determine the number of stones | `n = 5` |
| 2 | `n = 5` | Calculate the remainder when `n` is divided by 4 | `n % 4 = 1` |
| 3 | `n % 4 = 1` | Check if the remainder is not equal to 0 | `1 != 0` is `true` |
| 4 | `1 != 0` is `true` | Return `true` if the remainder is not 0 | `true` |

In this example, since `5 % 4 = 1` and `1 != 0`, the function returns `true`, indicating that the current player can win the game with 5 stones.
## Code
```java
class Solution {
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
}
```