# 867. Transpose Matrix

**LeetCode Problem:** [Transpose Matrix](https://leetcode.com/problems/transpose-matrix/)

## Approach
The approach to solving the "Transpose Matrix" problem involves creating a new matrix where the rows and columns are swapped compared to the original matrix. This is achieved through a simple iteration over the original matrix, copying elements to their corresponding positions in the new matrix.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize a new matrix `result` with dimensions that are the reverse of the original matrix `matrix`. The number of rows in `result` is equal to the number of columns in `matrix`, and vice versa.
2. **Step 2**: Iterate over each element in the original `matrix` using nested loops. The outer loop iterates over the rows, and the inner loop iterates over the columns.
3. **Step 3**: For each element at position `(i, j)` in the original `matrix`, copy its value to the corresponding position `(j, i)` in the `result` matrix. This effectively swaps the row and column indices, achieving the transpose operation.

- **Time Complexity**: The time complexity of this solution is O(m*n), where m is the number of rows in the original matrix and n is the number of columns. This is because we iterate over each element in the matrix once.
- **Space Complexity**: The space complexity is also O(m*n), as we create a new matrix of the same size as the original matrix.

## Dry Run
Let's consider an example input:
```markdown
matrix = [
  [1, 2, 3],
  [4, 5, 6]
]
```
Here's the step-by-step execution:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `matrix = [[1, 2, 3], [4, 5, 6]]` | Initialize `result` with dimensions (3, 2) | `result = [[0, 0], [0, 0], [0, 0]]` |
| 2 | `i = 0, j = 0` | Copy `matrix[0][0]` to `result[0][0]` | `result = [[1, 0], [0, 0], [0, 0]]` |
| 3 | `i = 0, j = 1` | Copy `matrix[0][1]` to `result[1][0]` | `result = [[1, 0], [2, 0], [0, 0]]` |
| 4 | `i = 0, j = 2` | Copy `matrix[0][2]` to `result[2][0]` | `result = [[1, 0], [2, 0], [3, 0]]` |
| 5 | `i = 1, j = 0` | Copy `matrix[1][0]` to `result[0][1]` | `result = [[1, 4], [2, 0], [3, 0]]` |
| 6 | `i = 1, j = 1` | Copy `matrix[1][1]` to `result[1][1]` | `result = [[1, 4], [2, 5], [3, 0]]` |
| 7 | `i = 1, j = 2` | Copy `matrix[1][2]` to `result[2][1]` | `result = [[1, 4], [2, 5], [3, 6]]` |
| 8 | - | Return `result` | `result = [[1, 4], [2, 5], [3, 6]]` |

The final output is the transposed matrix:
```markdown
result = [
  [1, 4],
  [2, 5],
  [3, 6]
]
```
## Code
```java
class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j<matrix[0].length;j++){
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
```