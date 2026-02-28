# 832. Flipping an Image

**LeetCode Problem:** [Flipping an Image](https://leetcode.com/problems/flipping-an-image/)

## Approach
The approach to solve the "Flipping an Image" problem involves iterating over each row of the image, flipping the row, and inverting the pixel values. This is achieved by using a two-pointer technique to swap the elements from the start and end of each row, while also toggling the pixel values.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize two pointers, `left` and `right`, to the start and end of each row, respectively.
2. **Step 2**: Enter a while loop that continues until `left` is greater than `right`.
3. **Step 3**: Inside the loop, toggle the pixel value at the `left` index using the XOR operator (`^= 1`).
4. **Step 4**: Swap the elements at the `left` and `right` indices, and toggle the pixel value at the `right` index.
5. **Step 5**: Increment `left` and decrement `right` to move towards the center of the row.

- **Time Complexity**: The time complexity is O(n * m), where n is the number of rows and m is the number of columns in the image, since we're iterating over each element in the image once.
- **Space Complexity**: The space complexity is O(1), since we're modifying the input image in-place and not using any additional space that scales with the input size.

## Dry Run
Let's consider an example input:
```markdown
Image = [
    [1, 1, 0],
    [1, 0, 1],
    [0, 0, 0]
]
```
Here's the execution in a step-by-step table format:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `i = 0`, `left = 0`, `right = 2` | Toggle `image[0][0]` and swap `image[0][0]` and `image[0][2]` | `image[0][0] = 1`, `image[0][2] = 1` |
| 2 | `i = 0`, `left = 1`, `right = 1` | Toggle `image[0][1]` and swap `image[0][1]` and `image[0][1]` | `image[0][1] = 1` |
| 3 | `i = 1`, `left = 0`, `right = 2` | Toggle `image[1][0]` and swap `image[1][0]` and `image[1][2]` | `image[1][0] = 0`, `image[1][2] = 0` |
| 4 | `i = 1`, `left = 1`, `right = 1` | Toggle `image[1][1]` and swap `image[1][1]` and `image[1][1]` | `image[1][1] = 1` |
| 5 | `i = 2`, `left = 0`, `right = 2` | Toggle `image[2][0]` and swap `image[2][0]` and `image[2][2]` | `image[2][0] = 1`, `image[2][2] = 1` |
| 6 | `i = 2`, `left = 1`, `right = 1` | Toggle `image[2][1]` and swap `image[2][1]` and `image[2][1]` | `image[2][1] = 1` |

The resulting output is:
```markdown
Image = [
    [1, 0, 1],
    [0, 1, 0],
    [1, 1, 1]
]
```
## Code
```java
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0; i<image.length; i++){
            int left = 0;
            int right = image.length-1;

            while(left<=right){
                image[i][left] ^= 1;
                //if(left!=right){
                    //image[i][right] ^= 1;
                    int temp = image[i][left];
                    image[i][left] = image[i][right]^1;
                    image[i][right] = temp;
                //}
                left++;
                right--;
            }
        }
        return image;

    }
}
```