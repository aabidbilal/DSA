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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
        getPath(root, targetSum, 0, new ArrayList<>(), ans);
        return ans;

    }
    public void getPath(TreeNode root, int targetSum, int currSum, List<Integer> path, List<List<Integer>> list){

            if( root == null) return;
            
            currSum += root.val;
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(root.val);

            if( root.left == null && root.right == null && currSum == targetSum){
                list.add(newPath);
                return;
            }
            getPath(root.left, targetSum, currSum, newPath, list);
            getPath(root.right, targetSum, currSum, newPath, list);

    }
}