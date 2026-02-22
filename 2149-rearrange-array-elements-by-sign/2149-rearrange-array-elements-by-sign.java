class Solution {
    public int[] rearrangeArray(int[] nums) {
        int fpos=0;
        int fneg=1;
        int []ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0&&fpos<nums.length){
                ans[fpos]=nums[i];
                fpos+=2;
            }else if(fneg<nums.length){
                ans[fneg]=nums[i];
                fneg+=2;

            }
        }
        return ans;
    }
}