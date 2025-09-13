class Solution {
    public int findKthLargest(int[] nums, int k) {
          Arrays.sort(nums); // ascending
        return nums[nums.length - k];
        
    }
}