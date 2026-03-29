# 744. Find Smallest Letter Greater Than Target

**LeetCode Problem:** [Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)

## Approach

The approach used to solve the "Find Smallest Letter Greater Than Target" problem is a binary search algorithm, which efficiently finds the smallest letter greater than the target in a sorted array of letters. This algorithm works by repeatedly dividing the search interval in half until the desired letter is found.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize two pointers, `left` and `right`, to the start and end of the `letters` array, respectively.
2. **Step 2**: Calculate the middle index `mid` using the formula `left + (right - left) / 2`.
3. **Step 3**: Compare the letter at the `mid` index with the `target`. If the letter is less than or equal to the `target`, move the `left` pointer to `mid + 1`. If the letter is greater than the `target`, move the `right` pointer to `mid - 1`.
4. **Step 4**: Repeat steps 2-3 until `left` is greater than `right`.
5. **Step 5**: After the loop ends, return the letter at the `left` index, wrapping around to the start of the array if necessary using the modulo operator (`left % letters.length`).

- **Time Complexity**: The time complexity of this algorithm is O(log n), where n is the number of elements in the `letters` array, because it uses a binary search approach.
- **Space Complexity**: The space complexity is O(1), as it only uses a constant amount of space to store the pointers and indices.

## Dry Run

Let's consider an example input: `letters = ['c', 'f', 'j']` and `target = 'a'`.

Here's the execution in a structured table format:

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `left = 0`, `right = 2`, `letters = ['c', 'f', 'j']`, `target = 'a'` | Initialize pointers | - |
| 2 | `left = 0`, `right = 2` | Calculate `mid = (0 + 2) / 2 = 1` | `mid = 1` |
| 3 | `left = 0`, `right = 2`, `mid = 1` | Compare `letters[mid] = 'f'` with `target = 'a'` | `letters[mid] > target`, so `right = mid - 1 = 0` |
| 4 | `left = 0`, `right = 0` | Calculate `mid = (0 + 0) / 2 = 0` | `mid = 0` |
| 5 | `left = 0`, `right = 0`, `mid = 0` | Compare `letters[mid] = 'c'` with `target = 'a'` | `letters[mid] > target`, so `right = mid - 1 = -1` |
| 6 | `left = 0`, `right = -1` | `left` is greater than `right`, so exit loop | - |
| 7 | `left = 0`, `right = -1` | Return `letters[left % letters.length] = letters[0] = 'c'` | `result = 'c'` |

The final output is `'c'`, which is the smallest letter greater than the target `'a'`.
## Code
```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(letters[mid]<=target){
                left = mid+1;
            } else if(letters[mid]>=target){
                right = mid-1;
            }
        }
        return letters[left%letters.length];
    }
}
```