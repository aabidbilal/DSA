class Solution {
    public int majorityElement(int[] nums) {
        for(int i =0;i<=nums.length/2;i++){
            int count =0;
            int cnum=nums[i];
            for(int j=0;j<nums.length;j++){
                if(nums[j]==cnum){
                    count++;
                }

            }
            if(count>nums.length/2){
                return cnum;
            }

        }

        return -1;
    }
        
    }
