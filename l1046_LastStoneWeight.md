# 1046. Last Stone Weight

**LeetCode Problem:** [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)

## Approach

The approach to solving the "Last Stone Weight" problem involves sorting the stones array and then iteratively smashing the two heaviest stones until only one stone remains. This process is repeated until the second heaviest stone becomes zero, at which point the last stone's weight is returned.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Check if there is only one stone left, in which case its weight is returned immediately.
2. **Step 2**: Initialize a while loop that continues as long as the second heaviest stone has a weight greater than zero.
3. **Step 3**: Inside the loop, calculate the difference between the heaviest and second heaviest stones, and update the weights of these two stones accordingly.
4. **Step 4**: Sort the stones array again after updating the weights to maintain the correct order for the next iteration.
5. **Step 5**: Repeat steps 2-4 until the second heaviest stone becomes zero, at which point the weight of the last stone is returned.

- **Time Complexity**: The time complexity of this solution is O(n^2 log n) due to the sorting operation inside the while loop, where n is the number of stones.
- **Space Complexity**: The space complexity is O(1) since we are modifying the input array in-place and not using any additional space that scales with the input size.

## Dry Run

Let's consider the example input `stones = [2,7,4,1,8,1]`. Here's how the algorithm would execute:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `stones = [2,7,4,1,8,1]` | Sort the stones array | `stones = [1,1,2,4,7,8]` |
| 2 | `stones = [1,1,2,4,7,8]` | Smash the two heaviest stones (8 and 7) | `difference = 1`, `stones = [1,1,2,4,0,1]`, sort again | `stones = [0,1,1,2,4,1]` |
| 3 | `stones = [0,1,1,2,4,1]` | Smash the two heaviest stones (4 and 2) | `difference = 2`, `stones = [0,1,1,0,2,1]`, sort again | `stones = [0,0,1,1,2,1]` |
| 4 | `stones = [0,0,1,1,2,1]` | Smash the two heaviest stones (2 and 1) | `difference = 1`, `stones = [0,0,0,1,1,1]`, sort again | `stones = [0,0,0,1,1,1]` |
| 5 | `stones = [0,0,0,1,1,1]` | Smash the two heaviest stones (1 and 1) | `difference = 0`, `stones = [0,0,0,0,1,0]`, sort again | `stones = [0,0,0,0,0,1]` |
| 6 | `stones = [0,0,0,0,0,1]` | Return the weight of the last stone |  | `Result/Output = 1` |

The final output of the algorithm for this example input is `1`, which is the weight of the last stone remaining.
## Code
```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);

        if(stones.length == 1) return stones[0];
        int n = stones.length;
        while(stones[n-2] > 0){
            int difference = stones[n-1] - stones[n-2];
            stones[n - 2] = 0;
            stones[n - 1] = difference;
            Arrays.sort(stones);
        }

        return stones[n-1];
    }
}
```