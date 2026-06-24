
class Solution {
    public int pathSum(TreeNode root, int targetSum) {

        if ( root == null) return 0;
        int count = calPath(root, (long)targetSum);
        count += pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

        return count;
    }
    public int calPath(TreeNode root, long targetSum){
        
        if (root == null) return 0;
        int count = 0;
        if( root.val == targetSum)
            count = count + 1;
        
        count += calPath(root.left, targetSum - root.val) + calPath(root.right, targetSum - root.val);

        return count;
    }
}