# 1089. Duplicate Zeros

**LeetCode Problem:** [Duplicate Zeros](https://leetcode.com/problems/duplicate-zeros/)

## Approach
The approach used to solve the "Duplicate Zeros" problem involves iterating through the input array, checking for zeros, and shifting elements to duplicate the zeros. This is achieved by using a simple iterative method that manipulates the array in-place.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize the iteration variable `i` to 0, which will be used to traverse the array from left to right.
2. **Step 2**: Check if the current element `arr[i]` is equal to 0. If it is, then proceed to duplicate the zero.
3. **Step 3**: When a zero is found, use a nested loop to shift all elements to the right of the current zero one position to the right, starting from the end of the array.
4. **Step 4**: After shifting the elements, place a new zero at the position where the original zero was found, effectively duplicating it.
5. **Step 5**: Increment the iteration variable `i` to skip the newly duplicated zero in the next iteration.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the length of the input array, because we are potentially iterating through the array once and performing a constant amount of work for each element.
- **Space Complexity**: The space complexity is O(1), because we are only using a constant amount of space to store the iteration variables and are modifying the input array in-place.

## Dry Run
Let's take the input array `[1,0,2,3,0,4,5,0]` as an example.

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `i = 0`, `arr = [1,0,2,3,0,4,5,0]` | Check if `arr[0]` is 0, it's not, increment `i` | `i = 1` |
| 2 | `i = 1`, `arr = [1,0,2,3,0,4,5,0]` | Found zero at `arr[1]`, shift elements to the right | `arr = [1,0,0,3,0,4,5,0]`, `i = 2` |
| 3 | `i = 2`, `arr = [1,0,0,3,0,4,5,0]` | Check if `arr[2]` is 0, it's not, increment `i` | `i = 3` |
| 4 | `i = 3`, `arr = [1,0,0,3,0,4,5,0]` | Check if `arr[3]` is 0, it's not, increment `i` | `i = 4` |
| 5 | `i = 4`, `arr = [1,0,0,3,0,4,5,0]` | Found zero at `arr[4]`, shift elements to the right | `arr = [1,0,0,3,0,0,5,0]`, `i = 5` |
| 6 | `i = 5`, `arr = [1,0,0,3,0,0,5,0]` | Check if `arr[5]` is 0, it's not, increment `i` | `i = 6` |
| 7 | `i = 6`, `arr = [1,0,0,3,0,0,5,0]` | Check if `arr[6]` is 0, it's not, increment `i` | `i = 7` |
| 8 | `i = 7`, `arr = [1,0,0,3,0,0,5,0]` | Found zero at `arr[7]`, but out of bounds, stop | `arr = [1,0,0,3,0,0,5,0]`, final result |

The final output of the algorithm is the modified array `[1,0,0,3,0,0,5,0]`.
## Code
```java
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                int j;
                for(j = n-2; j>=i+1; j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = 0;
                i++;
            }
        }

        

    }
}
```