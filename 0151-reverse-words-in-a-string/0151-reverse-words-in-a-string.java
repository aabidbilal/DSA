class Solution {
    public String reverseWords(String s) {
        int i=0,j=s.length()-1;
    
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
          while(j >= 0 && s.charAt(j) == ' '){
            j--;
        }
        char[] arr = new char[s.length()];
        int k=0;
        while(j>=i){
            int end=j;
            while(j>=i&&s.charAt(j)!=' '){
                j--;
            }
            for(int p=j+1;p<=end;p++){
                arr[k]=s.charAt(p);
                k++;
            }
            if(j>i){
                arr[k]=' ';
                k++;
            }
            while(j>=i&&s.charAt(j)==' '){
                j--;
            }
        }

return new String(arr,0,k);
        
    }
}