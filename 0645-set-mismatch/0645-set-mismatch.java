class Solution {
    public int[] findErrorNums(int[] nums) {
         int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
//                swap
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        int []ans={-1,-1};
        for(int j=0;j<nums.length;j++){
           if(nums[j]!=j+1){
            ans[0]=nums[j];
            ans[1]=j+1;

           } 
        }
        return ans;
    }
      public static void swap(int []nums,int first ,int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }

    
}