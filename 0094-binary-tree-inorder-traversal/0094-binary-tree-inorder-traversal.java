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
        
        List<Integer> list = new ArrayList<>();
        while(root != null){
        if(root.left == null){
            list.add(root.val);
            root = root.right;
        }else{
            TreeNode pred = root.left;
            while(pred.right != null && pred.right != root){
                pred = pred.right;
            }
            if(pred.right == null){
                pred.right = root;
                root = root.left;
            }else{
                pred.right = null;
                list.add(root.val);
                root = root.right;
            }
        }
        }

        
        return list;
    }
}