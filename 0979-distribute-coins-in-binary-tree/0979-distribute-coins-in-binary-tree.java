class Solution {
    public int distributeCoins(TreeNode root) {
        if (root == null)
            return 0;
        

        return bfs(root).get(1);
    }

    public List<Integer> bfs(TreeNode root) {
        if (root == null) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(0);
            ans.add(0);
            return ans;
        }
        List<Integer> left = bfs(root.left);
        List<Integer> right = bfs(root.right);

        int total = left.get(0) + right.get(0) + root.val;
        int extra = total - 1;

        int moves = left.get(1) + right.get(1) + Math.abs(extra);

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(extra);
        ans.add(moves);
        return ans;

    }
}