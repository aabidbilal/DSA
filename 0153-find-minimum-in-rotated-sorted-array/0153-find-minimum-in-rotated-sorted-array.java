class Solution {
    public int findMin(int[] arr) {
   
        int pivot=afterpeak(arr);
        if(pivot==-1){
        return arr[0];
        }
        return arr[pivot+1];

        
    }
    static int afterpeak(int[]arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(mid<end&&arr[mid]>arr[mid+1]){
                return mid;
            }else if(mid>start&&arr[mid]<arr[mid-1]){
                return mid-1;
            }else  if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
return -1;
    }
}