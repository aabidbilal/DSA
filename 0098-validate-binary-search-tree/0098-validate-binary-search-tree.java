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
    static TreeNode prev = null;
    static boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        flag = true;
        preorder(root);
        return flag;
    }
    public void preorder(TreeNode root){
        if( root == null)return;
        preorder(root.left);
        if(prev == null) prev = root;
        else if(root.val <= prev.val){
            flag = false;
        }else{
            prev = root;
        }

        preorder(root.right);
    }
}