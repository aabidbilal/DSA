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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = inorder(root1);
        List<Integer> list2 = inorder(root2);

        int i = 0,
                j = 0;
        List<Integer> ans = new ArrayList<>();

        while (i < list1.size() && j < list2.size()) {
            int num1 = list1.get(i);
            int num2 = list2.get(j);

            if (num1 <= num2) {
                ans.add(num1);
                i = i + 1;
            } else {
                ans.add(num2);
                j = j + 1;
            }
        }
        while (i < list1.size()) {
            ans.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            ans.add(list2.get(j));
            j++;
        }
        return ans;
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        while (root != null) {
            if (root.left == null) {
                list.add(root.val);
                root = root.right;
            } else {
                TreeNode pred = root.left;
                while (pred.right != null && pred.right != root) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = root;
                    root = root.left;
                } else {
                    pred.right = null;
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
        return list;
    }
}