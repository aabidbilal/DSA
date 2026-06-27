
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if ( root == null){
            return null;
        }
        if( key < root.val){
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if ( key > root.val){
            root.right = deleteNode(root.right, key);
            return root;
        }else{
            // zero child 
            if( root.left == null && root.right == null){
                root = null;
                return root;
            }
            // 1 child
            else if(root.left == null){
                TreeNode temp = root.right;
                root = null;
                return temp;
            }
            else if(root.right == null){
                TreeNode temp = root.left;
                root = null;
                return temp;
            }
            //  2 child
            else{
                TreeNode child = root.left,
                    parent = root;
                while( child.right != null){
                    parent = child;
                    child = child.right;
                }
                if ( root != parent){
                    parent.right = child.left;
                    child.left = root.left;
                    child.right = root.right;
                    root = null;
                    return child;
                }else{
                    child.right = root.right;
                    root = null;
                    return child;
                }
            }
        }
    }
}