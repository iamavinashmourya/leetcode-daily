# 1688. Count of Matches in Tournament

**LeetCode Problem:** [Count of Matches in Tournament](https://leetcode.com/problems/count-of-matches-in-tournament/)

## Approach

The approach to solving the "Count of Matches in Tournament" problem involves using a simple iterative method to simulate the tournament process. This method repeatedly calculates the number of matches in each round and updates the number of teams until only one team remains.

Here is a step-by-step breakdown of the logic:
1. **Initialization**: Initialize a variable `val` to keep track of the total number of matches played, and start with the given number of teams `n`.
2. **Tournament Simulation**: Enter a loop that continues until only one team remains (`n > 1`).
3. **Match Calculation**: In each iteration, calculate the number of matches played in the current round by dividing the number of teams `n` by 2, and add this to the total number of matches `val`.
4. **Team Update**: Update the number of teams `n` to be the number of teams that will proceed to the next round, which is the integer division of `n` by 2 plus any remaining team (if `n` is odd).

After the steps, the key complexities are:
- **Time Complexity**: The time complexity of this algorithm is O(log n), where n is the number of teams, because the number of teams is roughly halved in each iteration.
- **Space Complexity**: The space complexity of this algorithm is O(1), because it uses a constant amount of space to store the variables, regardless of the input size.

## Dry Run

Let's consider an example input of `n = 7`. The execution of the algorithm can be traced as follows:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | n = 7, val = 0 | Calculate matches: n/2 = 3, val += 3 | n = 4, val = 3 |
| 2 | n = 4, val = 3 | Calculate matches: n/2 = 2, val += 2 | n = 2, val = 5 |
| 3 | n = 2, val = 5 | Calculate matches: n/2 = 1, val += 1 | n = 1, val = 6 |
| 4 | n = 1, val = 6 | Exit loop | Return val = 6 |

In this example, the algorithm correctly calculates that 6 matches are needed to determine the winner of a tournament with 7 teams.
## Code
```java
class Solution {
    public int numberOfMatches(int n) {
        int val = 0;

        while(n>1){
            val += n/2;
            n = (n/2) + (n%2);
        }

        return val;
    }
}
```