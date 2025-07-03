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
    public boolean findTarget(TreeNode root, int k) {
       Set<Integer> seen = new HashSet<>();
       return inOrder(root, k, seen);
    }
    private boolean inOrder(TreeNode root, int k, Set<Integer> seen)
    {
        if(root == null)
            return false;
        if(seen.contains(k - root.val))
            return true;
        seen.add(root.val);
        return inOrder(root.left, k, seen) || inOrder(root.right, k, seen);
    }
}