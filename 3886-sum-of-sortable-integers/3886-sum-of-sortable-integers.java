class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean sortable = true;
            int prevMax = Integer.MIN_VALUE;

            for (int start = 0; start < n; start += k) {
                int descents = 0;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int j = 0; j < k; j++) {
                    int curr = start + j;
                    int next = start + (j + 1) % k;

                    min = Math.min(min, nums[curr]);
                    max = Math.max(max, nums[curr]);

                    if (nums[curr] > nums[next]) {
                        descents++;
                    }
                }

                // This block must be sortable by rotation.
                if (descents > 1) {
                    sortable = false;
                    break;
                }

                // Consecutive sorted blocks must be ordered.
                if (prevMax > min) {
                    sortable = false;
                    break;
                }

                prevMax = max;
            }

            if (sortable) {
                ans += k;
            }
        }

        return ans;
    }
}