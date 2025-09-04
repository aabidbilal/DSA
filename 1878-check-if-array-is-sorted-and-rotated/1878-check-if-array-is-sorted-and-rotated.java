class Solution {
    public boolean check(int[] nums) {
        int flag=-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                flag=i;
                break;
            }
        }
        if(flag==-1){
            return true;
        }
        else{
            for(int i=flag+1;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]){
                    return false;
                }
            }
            if(nums[nums.length-1]>nums[0]){
                return false;
            }
        }
        return true;
        
    }
}