# 219. Contains Duplicate II

**LeetCode Problem:** [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)

## Approach

The approach to solving the "Contains Duplicate II" problem involves using a HashMap to store the indices of the elements in the input array. This allows for efficient lookups of previous indices of each element, enabling the detection of duplicates within a certain distance.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Create an empty HashMap to store the indices of the elements in the input array.
2. **Step 2**: Iterate through the input array, and for each element, check if it already exists in the HashMap.
3. **Step 3**: If the element exists in the HashMap, calculate the distance between the current index and the stored index. If the distance is less than or equal to `k`, return `true` as a duplicate is found within the specified distance.
4. **Step 4**: If the element does not exist in the HashMap or the distance is greater than `k`, update the HashMap with the current index of the element.
5. **Step 5**: If the iteration completes without finding any duplicates within the specified distance, return `false`.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the length of the input array, as each element is processed once.
- **Space Complexity**: The space complexity is also O(n), as in the worst-case scenario, all elements might be stored in the HashMap.

## Dry Run

Let's consider the input `nums = [1, 2, 3, 1]` and `k = 3`. Here's the execution in a structured table format:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `map = {}`, `i = 0`, `nums[i] = 1` | Create HashMap and start iteration | `map = {1: 0}` |
| 2 | `map = {1: 0}`, `i = 1`, `nums[i] = 2` | Update `map` with `nums[i]` | `map = {1: 0, 2: 1}` |
| 3 | `map = {1: 0, 2: 1}`, `i = 2`, `nums[i] = 3` | Update `map` with `nums[i]` | `map = {1: 0, 2: 1, 3: 2}` |
| 4 | `map = {1: 0, 2: 1, 3: 2}`, `i = 3`, `nums[i] = 1` | Check if `nums[i]` exists in `map` and calculate distance | `i - map.get(1) = 3 - 0 = 3`, which is less than or equal to `k` |
| 5 | `map = {1: 0, 2: 1, 3: 2}`, `i = 3`, `nums[i] = 1` | Return `true` as duplicate is found within distance `k` | `Output: true` |

The algorithm correctly identifies that the duplicate `1` is within the specified distance `k` and returns `true`.
## Code
```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k){
                return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }
}
```