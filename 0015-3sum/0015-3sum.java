class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int f=0;f<nums.length-2;f++){
            if(nums[f]>0){
                break;
            }
            if(f==0||nums[f]!=nums[f-1]){
                helper(f,nums,ans);
            }
        }
        return ans;
        
    }
    public void helper(int f,int [] nums,List<List<Integer>> ans){
      
        int i=f+1;
        int j=nums.length-1;
        while(i<j){
            int sum=nums[f]+nums[i]+nums[j];
            if(sum>0){
                j--;
            }else if(sum<0){
                i++;
            }else{
                 ans.add(Arrays.asList(nums[f], nums[i], nums[j]));
                 i++;
                 j--;
                 while(i<j&&nums[i]==nums[i-1]){
                    i++;
                 }
                   while(i<j&&nums[j]==nums[j+1]){
                    j--;
                 }

                
            }
        }
    }
}