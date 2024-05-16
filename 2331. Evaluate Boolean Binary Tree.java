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
    public boolean evaluateTree(TreeNode root) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return root.val == 1;

        boolean leftValue = evaluateTree(root.left);
        boolean rightValue = evaluateTree(root.right);

        if (root.val == 2)
            return leftValue || rightValue;
        else // root.val == 3
            return leftValue && rightValue;
    }
}
