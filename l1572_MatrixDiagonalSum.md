# 1572. Matrix Diagonal Sum

**LeetCode Problem:** [Matrix Diagonal Sum](https://leetcode.com/problems/matrix-diagonal-sum/)

## Approach
The approach involves iterating over the matrix to calculate the sum of its diagonals. This is achieved by maintaining a running sum of elements at positions where the row index equals the column index (primary diagonal) and where the row index equals the difference between the matrix length and the column index minus one (secondary diagonal).

Here is a step-by-step breakdown of the logic:
1. **Initialization**: Initialize the sum variable to 0 and store the length of the matrix in the variable `n`.
2. **Diagonal Sum Calculation**: Iterate over the matrix, adding elements at positions `mat[i][i]` and `mat[n-1-i][i]` to the sum, where `i` ranges from 0 to `n-1`.
3. **Handling Odd-Length Matrices**: Check if the matrix length `n` is odd. If it is, subtract the middle element `mat[n/2][n/2]` from the sum because it was counted twice.
4. **Returning the Result**: Return the calculated sum.

- **Time Complexity**: The time complexity is O(n), where n is the number of rows (or columns) in the matrix, because we are iterating over the matrix once.
- **Space Complexity**: The space complexity is O(1), because we are using a constant amount of space to store the sum and other variables, regardless of the input size.

## Dry Run

Let's consider a 3x3 matrix as an example:
```markdown
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
```
Here is the execution in a structured table format:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | sum = 0, n = 3 | Initialize sum and n | sum = 0, n = 3 |
| 2 | sum = 0, n = 3 | Add mat[0][0] and mat[2][0] to sum | sum = 1 + 7 = 8 |
| 3 | sum = 8, n = 3 | Add mat[1][1] and mat[1][1] to sum | sum = 8 + 5 + 5 = 18 |
| 4 | sum = 18, n = 3 | Add mat[2][2] and mat[0][2] to sum | sum = 18 + 9 + 3 = 30 |
| 5 | sum = 30, n = 3 | Check if n is odd, subtract mat[n/2][n/2] from sum | sum = 30 - 5 = 25 |
| 6 | sum = 25, n = 3 | Return the calculated sum | Output: 25 |
## Code
```java
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for(int i = 0; i<mat.length; i++){
            sum += mat[i][i];
            sum += mat[n-1-i][i];
        }

        if(n%2==0){
            return sum;
        } else {
            return sum - mat[n/2][n/2];
        }
    }
}
```