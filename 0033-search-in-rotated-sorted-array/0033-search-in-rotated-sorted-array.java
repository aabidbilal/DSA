class Solution {
    public int search(int[] arr, int target) {
        int pivot=peakindex(arr);
        int ans=binarysearch(arr,target,0,pivot);
        if(ans==-1)
        {
            ans=binarysearch(arr,target,pivot+1,arr.length-1);
        }
        return ans;
    }
    public int peakindex(int []arr)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        { 
            int mid=start+(end-start)/2;
            // case 1
            if(mid<end && arr[mid]>=arr[mid+1]){
                return mid;
            }
            else if(mid>start && arr[mid]<=arr[mid-1]){
                return mid-1;
            }
            else if(arr[start]>=arr[mid]){
                   end=mid-1; 
            }else{
                start=mid+1;
            }
        }return -1;

    }
   
    public int binarysearch(int [] arr,int target,int start,int end){
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            else if(target<arr[mid]){
                end=mid-1;
            }else
            {
                start=mid+1;
            }
        }
    return -1;
    }
}