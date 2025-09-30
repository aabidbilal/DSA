class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cnt++;
                max=Math.max(cnt,max);
            }
            else{
                cnt=0;
            }
        }
        return max;

        
    }
}
//  int mo = 0;   // current streak
//         int count = 0; // max streak
//         for(int i=0; i<arr.length; i++){
//             if(arr[i] == 0){
//                 if(mo > count){
//                     count = mo;
//                 }
//                 mo = 0; // reset streak
//             } else {
//                 mo++;
//             }
//         }
//         // final check in case array ends with 1's
//         count = Math.max(count, mo);

//         System.out.println(count);