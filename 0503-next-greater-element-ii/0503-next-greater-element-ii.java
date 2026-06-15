class Solution {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st1 = new Stack<Integer>();
        

        int [] res = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;
        for ( int i = 0; i < 2 * n; i = i + 1){
            
            int idx = i % n;
            while( !st1.isEmpty() && nums[idx] > nums[st1.peek()]){
                res[st1.pop()] = nums[idx];
                
            }
            if ( i < n){
                st1.push(i);
            }
        }
        return res;
    }
}