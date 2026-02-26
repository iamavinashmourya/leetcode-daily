# 566. Reshape the Matrix

**LeetCode Problem:** [Reshape the Matrix](https://leetcode.com/problems/reshape-the-matrix/)

## Approach
The approach to solving the "Reshape the Matrix" problem involves checking if the total number of elements in the original matrix can be reshaped into the desired dimensions, and if so, iterating through the original matrix to populate the new reshaped matrix. This is done by maintaining a row and column index for the output matrix and incrementing them as elements are assigned.

Here is a step-by-step breakdown of the logic:
1. **Step 1**: Calculate the total number of rows and columns in the original matrix.
2. **Step 2**: Check if the total number of elements in the original matrix is equal to the total number of elements in the desired reshaped matrix. If not, return the original matrix.
3. **Step 3**: Initialize an output matrix with the desired dimensions and initialize row and column indices to 0.
4. **Step 4**: Iterate through each element in the original matrix, assigning it to the corresponding position in the output matrix based on the current row and column indices.
5. **Step 5**: After each assignment, increment the column index. If the column index reaches the desired number of columns, reset it to 0 and increment the row index.

- **Time Complexity**: The time complexity of this solution is O(n*m), where n is the number of rows and m is the number of columns in the original matrix, as each element is visited once.
- **Space Complexity**: The space complexity is also O(n*m), as a new matrix of the same total size is created.

## Dry Run
Let's consider an example where the input matrix is `[[1,2],[3,4]]` and the desired dimensions are `r=1` and `c=4`. 

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `rows=2`, `cols=2`, `r=1`, `c=4` | Calculate total elements in original and desired matrices | `total_elements_original = 4`, `total_elements_desired = 4` |
| 2 | `total_elements_original = 4`, `total_elements_desired = 4` | Check if total elements are equal | `total_elements_original == total_elements_desired` is true |
| 3 | `output` matrix initialized as `new int[1][4]` | Initialize `row=0`, `col=0` | `output = [[0,0,0,0]]`, `row=0`, `col=0` |
| 4 | `i=0`, `j=0`, `output = [[0,0,0,0]]`, `row=0`, `col=0` | Assign `mat[0][0]` to `output[row][col]` | `output = [[1,0,0,0]]`, `row=0`, `col=1` |
| 4 | `i=0`, `j=1`, `output = [[1,0,0,0]]`, `row=0`, `col=1` | Assign `mat[0][1]` to `output[row][col]` | `output = [[1,2,0,0]]`, `row=0`, `col=2` |
| 4 | `i=1`, `j=0`, `output = [[1,2,0,0]]`, `row=0`, `col=2` | Assign `mat[1][0]` to `output[row][col]` | `output = [[1,2,3,0]]`, `row=0`, `col=3` |
| 4 | `i=1`, `j=1`, `output = [[1,2,3,0]]`, `row=0`, `col=3` | Assign `mat[1][1]` to `output[row][col]` | `output = [[1,2,3,4]]`, `row=0`, `col=4` |
| 5 | `col=4` | Reset `col=0`, increment `row` | `col=0`, `row=1` (but since we've filled the desired output, this step is essentially redundant) |

The final output after these steps is `[[1,2,3,4]]`, which is the reshaped matrix.
## Code
```java
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        if((rows*cols) != (r*c)) return mat;

        int[][] output = new int[r][c];
        int col = 0;
        int row = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                output[row][col] = mat[i][j];
                col++;
                if(col==c){
                    col=0;
                    row++;
                }
            }
        }
        return output;
    }
}
```