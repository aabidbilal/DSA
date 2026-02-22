class Solution {
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1,count=0;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return ispalindrome(i+1,j,s)||ispalindrome(i,j-1,s);

            }
            i++;
            j--;
        }
        return true;

       
    }
    public boolean ispalindrome(int i,int j,String s){
        while(i<j){
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        i++;
        j--;}
        return true;
    }
}