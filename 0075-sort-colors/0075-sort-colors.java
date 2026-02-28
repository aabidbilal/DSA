class Solution {
    public void sortColors(int[] nums) {
        int i=0,k=0,j=nums.length-1;
        while(k<=j){
            if(nums[k]==0){
                swap(i,k,nums);
                 i++;
                 k++;
            }
            else if(nums[k]==2){
                swap(k,j,nums);
                j--;
            }else{
                k++;
            }

        }
        
    }
    public void swap(int s,int e,int[] arr){
        int temp=arr[e];
        arr[e]=arr[s];
        arr[s]=temp;
    }
}