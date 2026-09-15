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
     int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null )return 0;
        inorder(root, 1);
        return min;
    }
    public void inorder(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if (root.left == null && root.right == null) {
            if (depth < min) {
                min = depth;
            }
            return;
        }
        inorder(root.left, depth + 1);
        inorder(root.right, depth + 1);
    }
}