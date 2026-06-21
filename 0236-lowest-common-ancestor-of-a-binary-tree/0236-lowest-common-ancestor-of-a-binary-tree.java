
class Solution {
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // APPROACH --> 2
        LCA(root, p , q);
        return lca;

    }
    public boolean LCA (TreeNode root, TreeNode p, TreeNode q ){
        if ( root == null) return false;
        boolean self = (root == p || root == q);

        boolean left = LCA(root.left, p, q);
        if(lca != null){
            return true;
        }
        boolean right = LCA(root.right, p, q);
         if(lca != null){
            return true;
        }

        if( (left && right) || (left && self) || (right && self)){
            lca = root;
        }
        return left || right || self;
    }
}


        // APPROACH --> 1  

//         ArrayList<TreeNode> pathP = path(root, p);
//         ArrayList<TreeNode> pathQ = path(root, q);

//         int i = pathP.size() - 1,
//             j = pathQ.size() - 1;

//         while ( i >= 0 && j >= 0 && pathP.get(i) == pathQ.get(j)){
//             i = i - 1;
//             j = j - 1;
//         }
//         return path.get(i + 1);
//     }
//     public static ArrayList<TreeNode> path(TreeNode root, TreeNode node){
//         if( root == null)return null;

//         if(root == node){
//             ArrayList<TreeNode> list = new ArrayList<>();
//             list.add(root);
//             return list;
//         }
//         ArrayList<TreeNode> left = path(root.left, node);
//         if( left != null){
//             left.add(root);
//             return left;
//         }
//         ArrayList<TreeNode> right = path(root.right, node);
//         if( right != null){
//             right.add(root);
//             return right;
//         }
//         return null;
//     }
// }