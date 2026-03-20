# 110. Balanced Binary Tree

**LeetCode Problem:** [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)

## Approach
The approach to solving the "Balanced Binary Tree" problem involves recursively calculating the height of the left and right subtrees for each node and checking if the absolute difference between these heights is greater than 1. If it is, the tree is not balanced, and the function returns -1.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Check if the current node is null, in which case the function returns 0, indicating that the tree is balanced and its height is 0.
2. **Step 2**: Recursively calculate the heights of the left and right subtrees by calling the `HeightofTree` function on the left and right child nodes.
3. **Step 3**: Check if the left or right subtree is not balanced (i.e., their heights are -1) or if the absolute difference between their heights is greater than 1. If either condition is true, return -1 to indicate that the tree is not balanced.
4. **Step 4**: If the tree is balanced, return the maximum height of the left and right subtrees plus 1.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the number of nodes in the tree, since each node is visited once.
- **Space Complexity**: The space complexity is O(h), where h is the height of the tree, due to the recursive call stack.

## Dry Run
Let's consider a balanced binary tree with the following structure:
```
    3
   / \
  9  20
     / \
    15  7
```
Here's the dry run for this example:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | root = 3 | Check if root is null | root is not null, proceed to step 2 |
| 2 | root = 3 | Recursively calculate heights of left and right subtrees | left = HeightofTree(9), right = HeightofTree(20) |
| 3 | left = 1, right = 2 | Check if left or right subtree is not balanced | Both subtrees are balanced, proceed to step 4 |
| 4 | left = 1, right = 2 | Return maximum height of left and right subtrees plus 1 | Return 2 (max(1, 2) + 1) |
| 5 | root = 20 | Recursively calculate heights of left and right subtrees | left = HeightofTree(15), right = HeightofTree(7) |
| 6 | left = 1, right = 1 | Check if left or right subtree is not balanced | Both subtrees are balanced, proceed to step 4 |
| 7 | left = 1, right = 1 | Return maximum height of left and right subtrees plus 1 | Return 2 (max(1, 1) + 1) |
| 8 | root = 3 | Check if tree is balanced | Tree is balanced, return true |

The final result is that the tree is balanced, and the function returns true.
## Code
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return HeightofTree(root) != -1;
    }

    public int HeightofTree(TreeNode root){
        if(root == null) return 0;

        int left = HeightofTree(root.left);
        int right = HeightofTree(root.right);

        if(left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;

        return Math.max(left,right)+1;
    }
}
```