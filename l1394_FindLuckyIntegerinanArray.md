# 1394. Find Lucky Integer in an Array

**LeetCode Problem:** [Find Lucky Integer in an Array](https://leetcode.com/problems/find-lucky-integer-in-an-array/)

## Approach
The approach to solving the "Find Lucky Integer in an Array" problem involves using a HashMap to store the frequency of each integer in the array, then iterating through the array to find the maximum integer where its frequency equals its value. This approach allows for efficient lookup and comparison of frequencies.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize a HashMap to store the frequency of each integer in the array and a variable `max` to keep track of the maximum lucky integer found so far.
2. **Step 2**: Iterate through the array, and for each integer, update its frequency in the HashMap.
3. **Step 3**: Iterate through the array again, and for each integer, check if its frequency in the HashMap equals its value. If it does, update `max` with the maximum of the current `max` and the integer's value.
4. **Step 4**: After iterating through the entire array, return the value of `max`, which represents the largest lucky integer found in the array.

- **Time Complexity**: The time complexity of this approach is O(n), where n is the number of elements in the array, because we're doing two separate passes through the array.
- **Space Complexity**: The space complexity of this approach is O(n), as in the worst-case scenario (when all integers are unique), the HashMap will store n entries.

## Dry Run
Let's consider the input `arr = [2,2,3,4]`. Here's the step-by-step execution:

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `map = {}`, `max = -1` | Initialize HashMap and max variable | `map = {}`, `max = -1` |
| 2 | `arr = [2,2,3,4]`, `map = {}` | Iterate through array, update frequency in HashMap | `map = {2=2, 3=1, 4=1}` |
| 3 | `arr = [2,2,3,4]`, `map = {2=2, 3=1, 4=1}`, `max = -1` | Check if frequency of 2 equals its value, update max | `max = 2` |
| 4 | `arr = [2,2,3,4]`, `map = {2=2, 3=1, 4=1}`, `max = 2` | Check if frequency of 3 equals its value, no update | `max = 2` |
| 5 | `arr = [2,2,3,4]`, `map = {2=2, 3=1, 4=1}`, `max = 2` | Check if frequency of 4 equals its value, no update | `max = 2` |
| 6 | `arr = [2,2,3,4]`, `map = {2=2, 3=1, 4=1}`, `max = 2` | Return max | `max = 2` |

The final output for the input `arr = [2,2,3,4]` is `2`, which is the largest lucky integer in the array.
## Code
```java
class Solution {
    public int findLucky(int[] arr) {
        int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i , map.getOrDefault(i,0) + 1);
        }
        for(int i = 0; i< arr.length; i++){
            if(map.get(arr[i]) == arr[i]){
                max = Math.max(max, arr[i]);
            }
        }
        return max;
    }
}
```