# 762. Prime Number of Set Bits in Binary Representation

**LeetCode Problem:** [Prime Number of Set Bits in Binary Representation](https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/)

## Approach

The approach to solving the "Prime Number of Set Bits in Binary Representation" problem involves iterating over the range of numbers from `left` to `right`, counting the number of set bits in each number's binary representation, and checking if this count is a prime number. This process is repeated for each number in the given range.

Here is a step-by-step breakdown of the logic:
1. **Step 1**: Initialize a counter variable `cnt` to keep track of the numbers with a prime number of set bits.
2. **Step 2**: Iterate over the range of numbers from `left` to `right` (inclusive) using a for loop.
3. **Step 3**: For each number `i` in the range, count the number of set bits in its binary representation using the `Integer.bitCount(i)` method and store it in the `setBits` variable.
4. **Step 4**: Check if the `setBits` count is a prime number by calling the `isPrime(setBits)` method.
5. **Step 5**: If `setBits` is a prime number, increment the `cnt` variable to keep track of the count.
6. **Step 6**: After iterating over the entire range, return the `cnt` variable, which represents the total count of numbers with a prime number of set bits.

- **Time Complexity**: The time complexity of this solution is O(n*sqrt(m)), where n is the range of numbers (`right - left + 1`) and m is the maximum possible value of `setBits`, which is the number of bits in the binary representation of the maximum number in the range.
- **Space Complexity**: The space complexity of this solution is O(1), as it only uses a constant amount of space to store the variables `cnt`, `i`, and `setBits`.

## Dry Run

Let's consider an example input: `left = 6` and `right = 10`. Here's a step-by-step execution of the algorithm:

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `cnt = 0`, `left = 6`, `right = 10` | Initialize variables | `cnt = 0` |
| 2 | `i = 6`, `cnt = 0` | Count set bits in `i` (6) | `setBits = 2` |
| 3 | `i = 6`, `setBits = 2`, `cnt = 0` | Check if `setBits` (2) is prime | `isPrime(2) = true` |
| 4 | `i = 6`, `setBits = 2`, `cnt = 0` | Increment `cnt` since `setBits` is prime | `cnt = 1` |
| 5 | `i = 7`, `cnt = 1` | Count set bits in `i` (7) | `setBits = 3` |
| 6 | `i = 7`, `setBits = 3`, `cnt = 1` | Check if `setBits` (3) is prime | `isPrime(3) = true` |
| 7 | `i = 7`, `setBits = 3`, `cnt = 1` | Increment `cnt` since `setBits` is prime | `cnt = 2` |
| 8 | `i = 8`, `cnt = 2` | Count set bits in `i` (8) | `setBits = 1` |
| 9 | `i = 8`, `setBits = 1`, `cnt = 2` | Check if `setBits` (1) is prime | `isPrime(1) = false` |
| 10 | `i = 9`, `cnt = 2` | Count set bits in `i` (9) | `setBits = 2` |
| 11 | `i = 9`, `setBits = 2`, `cnt = 2` | Check if `setBits` (2) is prime | `isPrime(2) = true` |
| 12 | `i = 9`, `setBits = 2`, `cnt = 2` | Increment `cnt` since `setBits` is prime | `cnt = 3` |
| 13 | `i = 10`, `cnt = 3` | Count set bits in `i` (10) | `setBits = 2` |
| 14 | `i = 10`, `setBits = 2`, `cnt = 3` | Check if `setBits` (2) is prime | `isPrime(2) = true` |
| 15 | `i = 10`, `setBits = 2`, `cnt = 3` | Increment `cnt` since `setBits` is prime | `cnt = 4` |
| 16 | `i = 11` (out of range) | Return `cnt` | `result = 4` |

The final output of the algorithm is `4`, indicating that there are 4 numbers in the range `[6, 10]` with a prime number of set bits in their binary representation.
## Code
```java
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt = 0;
        for(int i = left; i <= right; i++){
            int setBits = Integer.bitCount(i);
            if(isPrime(setBits)){
                cnt++;
            }
        }

        return cnt;
    }

    public boolean isPrime(int n){
        if(n<=1){
            return false;
        }

        for(int i = 2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }
}
```