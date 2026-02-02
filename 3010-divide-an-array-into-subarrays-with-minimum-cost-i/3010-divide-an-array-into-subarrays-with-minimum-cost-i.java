class Solution {
    public int minimumCost(int[] nums) {
      
        int Smallest=Integer.MAX_VALUE;
        int SecSmallest=nums[1];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=Smallest){
                SecSmallest=Smallest;
                Smallest=nums[i];
            }
            else if(nums[i]<SecSmallest){
                SecSmallest=nums[i];
            }
        }
        return nums[0]+Smallest+SecSmallest;

        
    }
}