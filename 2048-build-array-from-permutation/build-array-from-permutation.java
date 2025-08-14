import java.util.Arrays;
class Solution {
    public void main(String[] args){
        int[]  nums = {0,2,1,5,3,4};
        int[] result=buildArray(nums);
        System.out.println(Arrays.toString(result));

    }
    public int[] buildArray(int[] nums)
     {
        
        int len =nums.length;
        int [] Ans=new int[len];
        for (int i =0; i < len ; i++ )
        {
           Ans[i]=nums[nums[i]];
        }
        
        return Ans;
     }
            }