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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        int level = height(root) + 1;
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if( root == null)return list;

        for( int i = 1; i <= level; i = i + 1){
            
            List<Integer> arr = new ArrayList<>();
            list.add(getLO(root, i, arr));
        }
        return list;

    }
    public int height( TreeNode root){
        if ( root == null) return 0;
        if(root.left == null && root.right == null ){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public List<Integer> getLO(TreeNode root, int n, List<Integer> list){

        if( root == null)return new ArrayList<>();
        if( n == 1){
            list.add(root.val);
            return list;
        }
        getLO(root.left, n - 1, list);
        getLO(root.right, n - 1, list);

        return list;
    }

}