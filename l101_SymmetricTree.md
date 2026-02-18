# 101. Symmetric Tree

**LeetCode Problem:** [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)

## Approach
The approach used to solve the "Symmetric Tree" problem involves checking if the left subtree is a mirror reflection of the right subtree. This is achieved by recursively comparing the nodes of the two subtrees.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Check if both the left and right subtrees are null. If they are, the function returns true, indicating that the subtrees are mirror images of each other.
2. **Step 2**: Compare the values of the nodes in the left and right subtrees. If the values are not equal, the function returns false, indicating that the subtrees are not mirror images.
3. **Step 3**: Recursively call the `isMirror` function on the left child of the left subtree and the right child of the right subtree, and on the right child of the left subtree and the left child of the right subtree. This ensures that the entire subtrees are compared, not just the root nodes.
4. **Step 4**: If all recursive calls return true, the `isSymmetric` function returns true, indicating that the tree is symmetric.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the number of nodes in the tree, since each node is visited once.
- **Space Complexity**: The space complexity is O(h), where h is the height of the tree, due to the recursive call stack. In the worst case, the tree is completely unbalanced, and the space complexity becomes O(n).

## Dry Run
Let's consider a symmetric tree with the following structure:
```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```
Here's the execution of the algorithm in a step-by-step table format:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `root = 1` | Call `isSymmetric(root)` | - |
| 2 | `l = 2, r = 2` | Call `isMirror(l, r)` | - |
| 3 | `l = 2, r = 2` | Compare `l.val` and `r.val` | `l.val == r.val` is true |
| 4 | `l.left = 3, r.right = 3` | Call `isMirror(l.left, r.right)` | - |
| 5 | `l.left = 3, r.right = 3` | Compare `l.left.val` and `r.right.val` | `l.left.val == r.right.val` is true |
| 6 | `l.right = 4, r.left = 4` | Call `isMirror(l.right, r.left)` | - |
| 7 | `l.right = 4, r.left = 4` | Compare `l.right.val` and `r.left.val` | `l.right.val == r.left.val` is true |
| 8 | `l.left = null, r.right = null` | Call `isMirror(l.left, r.right)` | `l.left == r.right` is true |
| 9 | `l.right = null, r.left = null` | Call `isMirror(l.right, r.left)` | `l.right == r.left` is true |
| 10 | - | Return result of `isMirror(l, r)` | `isSymmetric(root)` returns true |

The final result is that the tree is symmetric, and the function returns true.
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

    public boolean isMirror(TreeNode l,  TreeNode r){
        if(l == null || r == null){
            return l==r;
        }
        return (l.val == r.val) && isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
}
```