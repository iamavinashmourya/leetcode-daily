# 1784. Check if Binary String Has at Most One Segment of Ones

**LeetCode Problem:** [Check if Binary String Has at Most One Segment of Ones](https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/)

## Approach

The approach to solving the "Check if Binary String Has at Most One Segment of Ones" problem involves iterating through the binary string and tracking the number of segments of consecutive ones. The algorithm uses a simple counter to keep track of the number of ones in the current segment and increments the segment count whenever it encounters a zero after a segment of ones.

Here's a step-by-step breakdown of the logic:
1. **Initialization**: Initialize two counters, `count` to track the number of ones in the current segment and `seg` to track the total number of segments of ones.
2. **Iteration**: Iterate through each character in the binary string. If the character is '1', increment the `count` variable.
3. **Segment Detection**: If the character is '0' and `count` is greater than 0, it means we've reached the end of a segment of ones. In this case, increment the `seg` variable and reset `count` to 0.
4. **Final Segment Check**: After iterating through the entire string, check if `count` is greater than 0. If it is, it means the string ended with a segment of ones, so increment the `seg` variable.
5. **Result**: Return whether the total number of segments (`seg`) is equal to 1.

- **Time Complexity**: The time complexity of this algorithm is O(n), where n is the length of the binary string, because we're doing a constant amount of work for each character in the string.
- **Space Complexity**: The space complexity is O(1), because we're using a constant amount of space to store the counters, regardless of the size of the input string.

## Dry Run

Let's use the input string "110" as an example. Here's how the algorithm would execute:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | count = 0, seg = 0 | Encounter '1', increment count | count = 1, seg = 0 |
| 2 | count = 1, seg = 0 | Encounter '1', increment count | count = 2, seg = 0 |
| 3 | count = 2, seg = 0 | Encounter '0', increment seg and reset count | count = 0, seg = 1 |
| 4 | count = 0, seg = 1 | End of string, no action | count = 0, seg = 1 |
| 5 | count = 0, seg = 1 | Return result | Returns true, because seg == 1 |
## Code
```java
class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        int seg = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            } else{
                if(count > 0){
                    seg++;
                }
                count = 0;
            }
        }

        if(count > 0) seg++;
        return seg==1;
    }
}
```