/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> pathP = path(root, p);
        ArrayList<TreeNode> pathQ = path(root, q);

        int i = pathP.size() - 1,
            j = pathQ.size() - 1;
        
        while ( i >= 0 && j >= 0 && pathP.get(i) == pathQ.get(j)){
            i = i - 1;
            j = j - 1;
        }
        return pathP.get(i + 1);
    }
    public static ArrayList<TreeNode> path(TreeNode root, TreeNode node){
        if( root == null)return null;

        if(root == node){
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }
        ArrayList<TreeNode> left = path(root.left, node);
        if( left != null){
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right = path(root.right, node);
        if( right != null){
            right.add(root);
            return right;
        }
        return null;
    }
}