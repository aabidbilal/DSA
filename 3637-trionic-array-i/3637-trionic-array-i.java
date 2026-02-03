class Solution {
    public boolean isTrionic(int[] nums) {
       int n=nums.length;
       if(n<4){
        return false;
       }
       int i=0;
       while(i<n-1&&nums[i]<nums[i+1]){
        i++;
       }
       int p=i;
       if(p==0||p==n-1){
        return false;
       }
       while(i<n-1&&nums[i]>nums[i+1]){
        i++;
       }
       int q=i;
        if(q==0||q==n-1){
        return false;
       }
       while(i<n-1&&nums[i]<nums[i+1]){
        i++;
       }
       return i==n-1;


       

    }
}