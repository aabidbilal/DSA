class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
       return helper(preorder, Integer.MAX_VALUE);
    }
    public TreeNode helper(int[] preorder, int bound){
        if(index == preorder.length || preorder[index] > bound){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);

        root.left = helper(preorder, root.val);
        root.right = helper(preorder, bound);

        return root;
    }
}