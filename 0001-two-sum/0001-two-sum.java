class Solution {
    public int[] twoSum(int[] arr, int target) {
        int len= arr.length;
        int[] ans=new int[2];
        
        for (int i =0;i<len;i++)
        {int sum=0;
            for(int j =1;j<len;j++)
            {   if(i==j)
            { continue;}
                sum=arr[i]+arr[j];
                if(target==sum)
                {
                    ans[0]=i;
                    ans[1]=j;
                     break;
                }
               
           
        
            }

     
        }
    return ans;
}}