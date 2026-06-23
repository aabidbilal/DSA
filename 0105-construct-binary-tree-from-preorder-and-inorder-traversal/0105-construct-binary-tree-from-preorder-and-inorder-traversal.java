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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int idx = 0;
        int start = 0,
            end = preorder.length - 1;

        return solve( preorder, inorder, start, end);
    }
            int idx = 0;
    public TreeNode solve(int[] preorder, int[] inorder, int start, int end ){

            if ( start > end ){
                return null;
            }
            int val = preorder[idx++];
            TreeNode root = new TreeNode(val);

            int i = start;            
            for(; i < end; i = i + 1){
                if(val == inorder[i] )
                    break;
            }
            root.left = solve(preorder, inorder, start, i - 1);
            root.right = solve(preorder, inorder, i + 1, end);

            return root;
    }
}