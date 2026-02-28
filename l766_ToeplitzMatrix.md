# 766. Toeplitz Matrix

**LeetCode Problem:** [Toeplitz Matrix](https://leetcode.com/problems/toeplitz-matrix/)

## Approach
The approach to solving the "Toeplitz Matrix" problem involves iterating over the matrix and checking if each element is equal to the element diagonally below it. This is done by comparing the elements at position (i, j) with the elements at position (i+1, j+1) for all possible positions in the matrix.

Here's a step-by-step breakdown:
1. **Step 1**: Initialize variables to store the number of rows (m) and columns (n) in the matrix.
2. **Step 2**: Iterate over each element in the matrix, excluding the last row and column, to compare the current element with the element diagonally below it.
3. **Step 3**: If any pair of elements is not equal, immediately return false, indicating that the matrix is not a Toeplitz matrix.
4. **Step 4**: If the iteration completes without finding any unequal pairs, return true, indicating that the matrix is a Toeplitz matrix.

- **Time Complexity**: The time complexity of this solution is O(m*n), where m is the number of rows and n is the number of columns in the matrix, because we are iterating over each element in the matrix once.
- **Space Complexity**: The space complexity is O(1), because we are only using a constant amount of space to store the variables m, n, i, and j.

## Dry Run
Let's consider the following example input:
```markdown
[
  [1, 2, 3, 4],
  [5, 1, 2, 3],
  [9, 5, 1, 2]
]
```
Here's the execution of the algorithm in a step-by-step table format:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | m = 3, n = 4, i = 0, j = 0 | Compare matrix[0][0] with matrix[1][1] | matrix[0][0] (1) == matrix[1][1] (1) |
| 2 | m = 3, n = 4, i = 0, j = 1 | Compare matrix[0][1] with matrix[1][2] | matrix[0][1] (2) == matrix[1][2] (2) |
| 3 | m = 3, n = 4, i = 0, j = 2 | Compare matrix[0][2] with matrix[1][3] | matrix[0][2] (3) == matrix[1][3] (3) |
| 4 | m = 3, n = 4, i = 1, j = 0 | Compare matrix[1][0] with matrix[2][1] | matrix[1][0] (5) == matrix[2][1] (5) |
| 5 | m = 3, n = 4, i = 1, j = 1 | Compare matrix[1][1] with matrix[2][2] | matrix[1][1] (1) == matrix[2][2] (1) |
| 6 | m = 3, n = 4, i = 1, j = 2 | Compare matrix[1][2] with matrix[2][3] | matrix[1][2] (2) == matrix[2][3] (2) |
| 7 |  | End of iteration, all pairs are equal | Return true |
The final output is: true
## Code
```java
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i<m-1;i++){
            for(int j=0; j<n-1; j++){
                if(matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }
        return true;
    }
}
```