class Solution {

    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        while(fast!=1){
            slow=sqOfdigits(slow);
            fast=sqOfdigits(sqOfdigits(fast));
            if(fast==1){
                return true;
            }
            if(slow==fast){
                return false;
            }
        }
        return true;   
    }
    public int sqOfdigits(int n){
        int sum=0;
        while(n!=0){
            int digit=n%10;
            sum+=digit*digit;
            n/=10;
        }
        return sum;
    }
}