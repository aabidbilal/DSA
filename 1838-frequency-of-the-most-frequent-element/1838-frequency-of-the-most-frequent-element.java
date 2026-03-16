class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0, j = 0;
        long sum = 0;
       while(j < nums.length) {
            sum += nums[j];

            while( (long)nums[j] * (j - i + 1) - sum > k){
                sum -= nums[i];
                i = i + 1;
            }
                count = Math.max(count ,j - i + 1);
                j = j + 1;
            }
        
        return count;
    }
    }