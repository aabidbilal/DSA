class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){return 0;}
        int p=1;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[j-1]){
             nums[p]=nums[j];
                p++;
            }
        }
       
        return p;
        
    }
}