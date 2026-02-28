# 21. Merge Two Sorted Lists

**LeetCode Problem:** [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

## Approach
The approach to solving this problem involves using a dummy node to simplify the merging process of two sorted linked lists. This is done by iteratively comparing nodes from both lists and appending the smaller value to the result list.

Here's a step-by-step breakdown:
1. **Initialization**: Create a dummy node and a temporary pointer `temp` to keep track of the start of the merged list.
2. **Comparison Loop**: Iterate through both lists, comparing the current nodes' values and appending the smaller one to the merged list.
3. **Tail Handling**: Once one list is exhausted, append the remaining nodes from the other list to the merged list.
4. **Result Return**: Return the next node of the temporary pointer `temp`, which points to the start of the merged list.

- **Time Complexity**: O(n + m), where n and m are the lengths of the input lists, since we're potentially traversing all nodes in both lists.
- **Space Complexity**: O(n + m), for the space required to store the merged list, but more precisely O(1) if we consider the space required by the algorithm itself excluding the output.

## Dry Run

Let's take an example where `list1` is `1 -> 3 -> 5` and `list2` is `2 -> 4`.

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `dummy` = new node, `temp` = `dummy`, `list1` = `1`, `list2` = `2` | Create dummy node and temp pointer | `dummy` points to a new node with value -1 |
| 2 | `list1` = `1`, `list2` = `2` | Compare `list1` and `list2`, append smaller value to `dummy` | `dummy` -> `1`, `list1` = `3`, `dummy` moves to `1` |
| 3 | `list1` = `3`, `list2` = `2` | Compare `list1` and `list2`, append smaller value to `dummy` | `dummy` -> `2`, `list2` = `4`, `dummy` moves to `2` |
| 4 | `list1` = `3`, `list2` = `4` | Compare `list1` and `list2`, append smaller value to `dummy` | `dummy` -> `3`, `list1` = `5`, `dummy` moves to `3` |
| 5 | `list1` = `5`, `list2` = `4` | Compare `list1` and `list2`, append smaller value to `dummy` | `dummy` -> `4`, `list2` = `null`, `dummy` moves to `4` |
| 6 | `list1` = `5`, `list2` = `null` | Append remaining nodes from `list1` to `dummy` | `dummy` -> `5`, `list1` = `null` |
| 7 | `list1` = `null`, `list2` = `null` | Return `temp.next` as the merged list | Merged list: `1 -> 2 -> 3 -> 4 -> 5` |

The final merged list is `1 -> 2 -> 3 -> 4 -> 5`.
## Code
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    dummy.next = list1;
                    list1 = list1.next;
                } else {
                    dummy.next=list2;
                    list2 = list2.next;
                }

                dummy = dummy.next;
            }

            if(list1!=null){
                dummy.next = list1;
            } else {
                dummy.next = list2;
            }
            return temp.next;
    }
}
```