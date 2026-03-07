# 771. Jewels and Stones

**LeetCode Problem:** [Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)

## Approach

The approach involves iterating over each character in the "jewels" and "stones" strings, and checking if each stone is present in the list of jewels. The algorithm uses a simple iterative method to count the number of stones that are jewels.

Here's a step-by-step breakdown:
1. **Step 1**: Convert the "jewels" string into a list of characters for efficient lookups.
2. **Step 2**: Initialize a count variable to keep track of the number of stones that are jewels.
3. **Step 3**: Iterate over each character in the "stones" string, checking if it exists in the list of jewels.
4. **Step 4**: If a stone is found to be a jewel, increment the count variable.
5. **Step 5**: After iterating over all stones, return the total count of stones that are jewels.

- **Time Complexity**: The time complexity is O(n + m) where n is the length of the "jewels" string and m is the length of the "stones" string, because we're doing a constant amount of work for each character in both strings. However, the `contains` method in the `ArrayList` has a time complexity of O(n), so the overall time complexity becomes O(n*m).
- **Space Complexity**: The space complexity is O(n) where n is the length of the "jewels" string, because we're storing all the jewels in an `ArrayList`.

## Dry Run

Let's consider an example input: `jewels = "aA", stones = "aAAbbbb"`. Here's the execution in a structured table format:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `l1 = [], count = 0` | Convert "jewels" string to list of characters | `l1 = [a, A]` |
| 2 | `l1 = [a, A], count = 0` | Initialize count variable | `count = 0` |
| 3 | `l1 = [a, A], count = 0` | Iterate over "stones" string, check if 'a' is in `l1` | `count = 1` |
| 4 | `l1 = [a, A], count = 1` | Iterate over "stones" string, check if 'A' is in `l1` | `count = 2` |
| 5 | `l1 = [a, A], count = 2` | Iterate over "stones" string, check if 'A' is in `l1` | `count = 3` |
| 6 | `l1 = [a, A], count = 3` | Iterate over "stones" string, check if 'b' is in `l1` | `count = 3` |
| 7 | `l1 = [a, A], count = 3` | Iterate over "stones" string, check if 'b' is in `l1` | `count = 3` |
| 8 | `l1 = [a, A], count = 3` | Iterate over "stones" string, check if 'b' is in `l1` | `count = 3` |
| 9 | `l1 = [a, A], count = 3` | Iterate over "stones" string, check if 'b' is in `l1` | `count = 3` |
| 10 | `l1 = [a, A], count = 3` | Return count | `Output: 3` |
## Code
```java
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        ArrayList<Character> l1 = new ArrayList<>();
        int count = 0;
        for(char ch : jewels.toCharArray()){
            l1.add(ch);
        }

        for(char ch : stones.toCharArray()){
            if(l1.contains(ch)){
                count++;
            }
        }

        return count;

        //my optmial solution is here 
        // char[] c = jewels.toCharArray();
        // char[] p = stones.toCharArray();

        // Arrays.sort(c);
        // Arrays.sort(p);
        // int l = 0, r = 0;
        // int count = 0;
        // while(l <c.length && r<p.length){
        //     if(c[l] == p[r]){
        //         count++;
        //         r++;
        //     } else if(c[l] > p[r]){
        //         r++;
        //     } else{
        //         l++;
        //     }
        // }
        // return count;

    }
}
```