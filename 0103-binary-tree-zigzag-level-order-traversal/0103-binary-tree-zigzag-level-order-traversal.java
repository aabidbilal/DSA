class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if( root == null ) return list;
        int level = height(root) + 1;
        for (int i = 1; i <= level; i = i + 1){

            if( i % 2 == 0) {
                list.add(printnth2(root, i));
            }
            else {
            list.add(printnth1(root, i));
            }  
            
        }
        return list; 
    }
    public int height(TreeNode root){
        if ( root == null)return 0;
        if (root.left == null && root.right == null) return 0;
        return 1 + Math.max( height(root.left), height(root.right));
    }
    public List<Integer> printnth1(TreeNode root,int n){
        
      if ( root == null) return new ArrayList<>();
        if( n == 1){
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            return list;
        }
        List<Integer> list = new ArrayList<Integer>();

        list.addAll(printnth1(root.left, n - 1));
        list.addAll(printnth1(root.right, n - 1));

        return list;
    }
    public List<Integer> printnth2(TreeNode root,int n){
        if ( root == null) return new ArrayList<>();
        if( n == 1){
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            return list;
        }
        List<Integer> list = new ArrayList<Integer>();
        
        list.addAll(printnth2(root.right, n - 1));
        list.addAll(printnth2(root.left, n - 1));
    
        return list;
    }
}