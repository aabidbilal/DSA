class Solution {
    public int searchInsert(int[] arr, int target) {
              int start=0;
        int ans=arr.length;
        int end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
        if(arr[mid]>=target){
            ans=mid;
            end=mid-1;
        } else {
            start=mid+1;

        }
        }


        return ans;

    }
}