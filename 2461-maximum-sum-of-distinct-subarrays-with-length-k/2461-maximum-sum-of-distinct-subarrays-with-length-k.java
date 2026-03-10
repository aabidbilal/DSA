class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0,
                max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int dups = 0;
        for (int i = 0; i < k; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
            sum += nums[i];
            if (map.get(nums[i]) > 1) {
                dups++;
            }
        }
        if (dups == 0) {
            max = Math.max(max, sum);
        }
        for (int i = k; i < nums.length; i++) {
            int numToadd = nums[i],
                    numTorem = nums[i - k];
            if (!map.containsKey(numToadd)) {
                map.put(numToadd, 0);
            }
            map.put(numToadd, map.get(numToadd) + 1);
            if (map.get(numToadd) > 1) {
                dups++;
            }
            sum += numToadd;
            if (map.get(numTorem) > 1) {
                dups--;
            }
            map.put(numTorem, map.get(numTorem) - 1);
            sum -= numTorem;
            if (dups == 0) {
                max = Math.max(max, sum);
            }

        }
        return max;

    }
}