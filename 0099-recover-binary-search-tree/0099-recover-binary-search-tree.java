class Solution {
    TreeNode prev = null,
        first = null, second = null;

    public void recoverTree(TreeNode root) {
       inorder(root);

       
    if (first != null && second != null)
        swap(first, second);
    }

    public void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public void inorder( TreeNode root){
         if (root == null)
            return;

        inorder(root.left);
        if (prev != null) {
            if (root.val < prev.val){
                
                if(first == null){
                    first = prev;   
                }
                second = root;
            }
        }
            prev = root;
        inorder(root.right);
    }
}