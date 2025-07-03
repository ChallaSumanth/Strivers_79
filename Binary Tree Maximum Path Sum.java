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
    public int maxPathSum(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = (int) -1e9;
        maxSum(root, sum);
        return sum[0];
    }

    private int maxSum(TreeNode root, int[] sum)
    {
        if(root == null)
            return 0;

        int leftSum = Math.max(0, maxSum(root.left, sum));
        int rightSum = Math.max(0, maxSum(root.right, sum));

        sum[0] = Math.max(sum[0], leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
