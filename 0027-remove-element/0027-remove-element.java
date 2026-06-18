class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0,
                j = nums.length - 1;
        int size = 0;

        while (i <= j) {

            if( nums[i] == val ){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j = j - 1;
            }else{
                i = i + 1;
            }
        }
        return j + 1;
    }
}