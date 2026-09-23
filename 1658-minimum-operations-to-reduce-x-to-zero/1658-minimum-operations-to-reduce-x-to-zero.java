class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        int sum = 0;

        for(int val : nums){
            total += val;
        }
        int rem = total - x;

        if(rem < 0)return -1;
        if(rem == 0)return nums.length;

        int i = 0, j = 0;
        int size = 0;

        while(j < nums.length){
            
            sum += nums[j];
            while(sum > rem){
                sum -= nums[i];
                i++;
            }
            if(sum == rem){
                size = Math.max(size, j - i + 1);
            }
            j++;
        }
        return size == 0 ? -1 : nums.length - size;
 
    }
}