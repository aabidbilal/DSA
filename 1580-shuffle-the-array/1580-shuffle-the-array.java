class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] ans=new int[nums.length];
        int j=0;
        for(int i=0;i<2*n;i=i+2){
            ans[i]=nums[j];
            j++;
            }
           int k=n;
        for(int i=1;i<2*n;i=i+2){
            ans[i]=nums[k];
            k++;
            }
        return ans;
    }
}