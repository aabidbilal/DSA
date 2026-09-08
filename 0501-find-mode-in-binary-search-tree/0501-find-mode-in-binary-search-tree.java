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
    int count = 0;

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        inorder(root, map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    if (entry.getValue() == count) {
        list.add(entry.getKey());
    }
}
int[] ans = new int[list.size()];
int i = 0;
for(int val : list){
    ans[i] = list.get(i);
    i++;
}
return ans;


    }

    public void inorder(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        count = Math.max(count, map.get(root.val));
        inorder(root.left, map);
        inorder(root.right, map);
    }

}