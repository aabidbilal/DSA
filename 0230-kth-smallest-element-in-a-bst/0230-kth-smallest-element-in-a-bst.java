class Solution {
    int val = 0;
    int counter = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return val;
    }
    public void inorder(TreeNode root, int k){
        if(root == null)
            return;
        inorder(root.left, k);
        counter = counter + 1;
        if( counter == k){
            val = root.val;
            return;
        }
        inorder(root.right, k);
    }
}