class Solution {
    public int minRemoval(int[] nums, int k) {
        int maxlen=1;
        Arrays.sort(nums); 
        int i=0;
        for(int j=0;j<nums.length;j++){
            while(nums[j]>(long)k*nums[i]){
                i++;
            }
            maxlen=Math.max(maxlen,j-i+1);
            
        }
        return nums.length- maxlen;
        
    }
}