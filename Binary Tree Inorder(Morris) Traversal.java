Moris Inorder traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode cur = root;

        while(cur != null)
        {
            TreeNode prev = cur.left;
            if(prev == null)
            {
                ans.add(cur.val);
                cur = cur.right;
            }
            else{
                while(prev.right != null)
                    prev = prev.right;

                prev.right = cur;
                TreeNode temp = cur;
                cur = cur.left;
                temp.left = null;
            }
        }
        return ans;
    }
}