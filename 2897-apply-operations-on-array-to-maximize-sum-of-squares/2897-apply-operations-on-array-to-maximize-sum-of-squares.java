class Solution {
    public int maxSum(List<Integer> nums, int k) {
       int mod = 1000000007;

        int[] freq = new int[32];
        
        for(int num : nums){
            for(int b = 0; b < 32; b++){
                if((num & (1 << b)) != 0){
                    freq[b]++;
                }
            }
        }
        long result = 0;
        while(k > 0){
            long curr = 0;
            for(int b = 0; b < 32; b++){
                if(freq[b] > 0){
                    freq[b]--;
                    curr = curr | (1 << b);
                }
            }
            k--;
            result = (result + (curr * curr)) % mod;
        }
        return (int) result;
    }
}