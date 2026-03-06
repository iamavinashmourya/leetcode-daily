# 551. Student Attendance Record I

**LeetCode Problem:** [Student Attendance Record I](https://leetcode.com/problems/student-attendance-record-i/)

## Approach

The approach involves iterating through the attendance record string and tracking the number of consecutive late arrivals and total absences. The function returns false as soon as it encounters more than two consecutive late arrivals or two total absences.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize two counters, `late` and `absent`, to keep track of consecutive late arrivals and total absences, respectively.
2. **Step 2**: Iterate through each character in the attendance record string.
3. **Step 3**: If the current character is 'L', increment the `late` counter; otherwise, reset the `late` counter to 0.
4. **Step 4**: If the current character is 'A', increment the `absent` counter.
5. **Step 5**: After updating the counters, check if the `late` counter exceeds 2 or the `absent` counter is greater than or equal to 2; if so, return false.
6. **Step 6**: If the entire string is iterated through without returning false, return true, indicating that the attendance record is acceptable.

- **Time Complexity**: The time complexity is O(n), where n is the length of the attendance record string, because we make a single pass through the string.
- **Space Complexity**: The space complexity is O(1), because we use a constant amount of space to store the `late` and `absent` counters, regardless of the input size.

## Dry Run

Let's use the example input "PPALLP" to demonstrate the algorithm. Here's the execution in a structured table format:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | late = 0, absent = 0 | Initialize counters | late = 0, absent = 0 |
| 2 | late = 0, absent = 0 | Iterate through 'P' | late = 0, absent = 0 |
| 3 | late = 0, absent = 0 | Iterate through 'P' | late = 0, absent = 0 |
| 4 | late = 0, absent = 0 | Iterate through 'A' | late = 0, absent = 1 |
| 5 | late = 0, absent = 1 | Iterate through 'L' | late = 1, absent = 1 |
| 6 | late = 1, absent = 1 | Iterate through 'L' | late = 2, absent = 1 |
| 7 | late = 2, absent = 1 | Iterate through 'P' | late = 0, absent = 1 |
| 8 | late = 0, absent = 1 | Iterate through 'P' | late = 0, absent = 1 |
| 9 | late = 0, absent = 1 | End of iteration | Return true |

The final result is true, indicating that the attendance record "PPALLP" is acceptable.
## Code
```java
class Solution {
    public boolean checkRecord(String s) {
        int late = 0;
        int absent = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'L'){
            late++;
            } else {
                late = 0;
            }
            if(s.charAt(i) == 'A') absent++;
            if(late > 2 || absent >= 2) return false;
        }
        return true;
    }
}
```