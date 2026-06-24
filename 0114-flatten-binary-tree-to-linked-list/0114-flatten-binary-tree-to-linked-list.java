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
    public void flatten(TreeNode root) {
    
    if (root == null ) return;

    if( root.left == null && root.right == null)return;
    TreeNode left = root.left;
    TreeNode right = root.right;
    
    flatten(left);
    flatten(right);

    if(left != null){
    root.left = null;
    root.right = left;

    TreeNode temp = left;
    while(temp.right != null){
        temp = temp.right;
    }
    temp.right = right;
}

    }
}