package com.bilal;

public class ceiling {

    public static void main(String[] args) {
        int [] arr={2,3,5,9,14,16,18};
        int target=15;
        int ans = ceilingno(arr,target);
        System.out.println(ans);
    }
static int ceilingno(int[] arr,int target){
      boolean found=true;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
            {
                found=false;
                return mid;
            } else if (arr[mid]>target) {
                end=mid-1;
            }
            else
                start=mid+1;
        }
          if(found){
        for(int num:arr){
            if(num >target){
                return num;
            }
        }

    }
return -1;
}
}

