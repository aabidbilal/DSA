class Solution {
    public int maxSubArray(int[] nums) {
      int Ms=Integer.MIN_VALUE;
      int Cs=0;
      
      for (int i = 0; i < nums.length; i++) {
//   Cs=Cs+nums[i];
//   if(Cs<0){
//     Cs=0;
//   }
// if all numbers are negative we must return the largest among that ng numbers,for that,
    Cs=Math.max(nums[i],Cs+nums[i]);
  Ms=Math.max(Ms,Cs);
} 
return Ms;
    }
}