class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            HashSet<Integer> set = new HashSet<>();

            boolean ispos = nums[i] > 0;
            set.add(i);
            int curr = i;
            //  2, -1, 1, 2, 2

            while (true) {
                int next = calnext(nums, curr);
                if (ispos) {
                    if (nums[next] < 0) {
                        break;
                    }
                }else{
                if (nums[next] >0) {
                    break;}
                }
                if (curr == next)
                    break;
                if (set.contains(next)) {
                    return true;

                }
                set.add(next);
                curr = next;
            }
            // while()
        }
        return false;
    }

    public int calnext(int[] arr, int curr) {
        int n = arr.length;
       return ((curr + arr[curr]) % n + n) % n;
    }
}