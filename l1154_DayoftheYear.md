# 1154. Day of the Year

**LeetCode Problem:** [Day of the Year](https://leetcode.com/problems/day-of-the-year/)

## Approach
The approach to solving the "Day of the Year" problem involves parsing the input date string to extract the year, month, and day, and then calculating the total number of days from the start of the year to the given date. This calculation takes into account whether the year is a leap year or not.

Here is a step-by-step breakdown of the logic:
1. **Step 1**: Extract the year, month, and day from the input date string using substring and parse them into integers.
2. **Step 2**: Initialize an array to store the number of days in each month, assuming a non-leap year.
3. **Step 3**: Check if the year is a leap year by applying the rules for leap years (year is divisible by 4, but not by 100, unless it is also divisible by 400), and update the number of days in February accordingly.
4. **Step 4**: Calculate the total number of days from the start of the year to the given date by summing the days in all months prior to the given month and adding the day of the month.
5. **Step 5**: Return the total number of days as the result.

- **Time Complexity**: The time complexity of this solution is O(1), because the number of operations is constant and does not depend on the size of the input.
- **Space Complexity**: The space complexity is also O(1), because the space used does not grow with the size of the input.

## Dry Run
Let's take the input "2019-01-09" as an example.

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | year = 0, month = 0, day = 0 | Extract year, month, and day from input string | year = 2019, month = 1, day = 9 |
| 2 | days array initialized with default values | Initialize days array | days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] |
| 3 | year = 2019 | Check if year is a leap year | days[1] remains 28, because 2019 is not a leap year |
| 4 | total = 0 | Calculate total days | total = 0 + 9 = 9 |
| 5 | total = 9 | Return total days | Output: 9 |

This dry run demonstrates how the algorithm correctly calculates the day of the year for the given input.
## Code
```java
class Solution {
    public int dayOfYear(String date) {
        int year  = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day   = Integer.parseInt(date.substring(8, 10));

        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};

        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            days[1] = 29;
        }
        
        int total = 0;

        for(int i = 0; i<month-1; i++){
            total += days[i];
        }
        total += day;

        return total;
    }
}
```