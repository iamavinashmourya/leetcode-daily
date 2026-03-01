# 1295. Find Numbers with Even Number of Digits

**LeetCode Problem:** [Find Numbers with Even Number of Digits](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/)

## Approach
The approach to solving the "Find Numbers with Even Number of Digits" problem involves iterating through each number in the input array, checking if it has an even number of digits, and incrementing a count if it does. This is achieved by using a helper function to calculate the number of digits in each number.

1. **Step 1**: Initialize a count variable to keep track of the numbers with an even number of digits.
2. **Step 2**: Iterate through each number in the input array.
3. **Step 3**: For each number, call the `isEven` function to check if it has an even number of digits by first calculating the number of digits using the `digit` function.
4. **Step 4**: If the number of digits is even, increment the count.
5. **Step 5**: After checking all numbers, return the count.

- **Time Complexity**: The time complexity is O(n*m), where n is the number of elements in the input array and m is the average number of digits in the numbers. This is because for each number, we are potentially iterating through all its digits to calculate the number of digits.
- **Space Complexity**: The space complexity is O(1), excluding the space needed for the input array, as we are only using a constant amount of space to store the count and other variables.

## Dry Run

Let's take the input array `[12, 345, 2, 6, 7896]` as an example. Here's how the algorithm would execute:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `count = 0`, `nums = [12, 345, 2, 6, 7896]` | Initialize count and start iterating through nums | `count = 0` |
| 2 | `num = 12` | Check if `num` has an even number of digits | `numofDigit = 2`, `isEven = true` |
| 3 | `isEven = true` | Increment count since `isEven` is true | `count = 1` |
| 4 | `num = 345` | Check if `num` has an even number of digits | `numofDigit = 3`, `isEven = false` |
| 5 | `isEven = false` | Do not increment count since `isEven` is false | `count = 1` |
| 6 | `num = 2` | Check if `num` has an even number of digits | `numofDigit = 1`, `isEven = false` |
| 7 | `isEven = false` | Do not increment count since `isEven` is false | `count = 1` |
| 8 | `num = 6` | Check if `num` has an even number of digits | `numofDigit = 1`, `isEven = false` |
| 9 | `isEven = false` | Do not increment count since `isEven` is false | `count = 1` |
| 10 | `num = 7896` | Check if `num` has an even number of digits | `numofDigit = 4`, `isEven = true` |
| 11 | `isEven = true` | Increment count since `isEven` is true | `count = 2` |
| 12 | End of iteration | Return count | `count = 2` |

The final output would be `2`, indicating that there are two numbers with an even number of digits in the input array.
## Code
```java
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            if(isEven(num)){
                count++;
            }
        }
        return count;
    }


    boolean isEven(int num){
        int numofDigit = digit(num);
        if(numofDigit % 2 ==0){
            return true;
        }
        return false;   
    }

    static int digit(int num){
        if(num == 0){
            return 1;
        }
        int count = 0;
        while(num > 0){
            count++;
            num/=10;
        }
        return count;
    }
}
```