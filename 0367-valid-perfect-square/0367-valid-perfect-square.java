class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<0){
            return false;
        }
        long start=1;
        long end=num;
        
        while(start<=end){
             long mid=start+(end-start)/2;
            long sq=mid*mid;
            if(sq==num){
                return true;
            }if(mid*mid>num){
                end=mid-1;
            }else{
                start=mid+1;
            }

        }


        return false;
    }
}