class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();

        int [] NSE = new int[nums.length];
        Arrays.fill(NSE,nums.length );

        for( int i = 0; i < nums.length; i = i + 1){

            while( !st.isEmpty() && nums[i] > nums[st.peek()]){
                NSE[st.pop()] = i;
            }
            st.push(i);
        }
        int[] ans = new int[nums.length - k + 1];
        int j = 0, z = 0;

        for ( int i = 0; i <= nums.length - k; i = i + 1){

            if( j >= i + k){
             j = i;
            }

            int max = nums[j];

            while( j < i + k ){
                max = nums[j];
                j = NSE[j];
            }
            ans[z++] = max;
        }
        return ans;
    }
}