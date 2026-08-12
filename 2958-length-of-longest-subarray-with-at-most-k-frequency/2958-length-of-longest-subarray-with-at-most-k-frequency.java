class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int maxLen = 0;

        while(j < nums.length){
            int num = nums[j];
            map.put(num, map.getOrDefault(num, 0) + 1);

            while(map.get(num) > k){
                map.put(nums[i], map.get(nums[i]) - 1);
                i = i + 1;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j = j + 1;
        }
        return maxLen;
    }
}