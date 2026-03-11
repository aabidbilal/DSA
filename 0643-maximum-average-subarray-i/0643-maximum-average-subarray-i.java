class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int j;
        double avg = 0, sum = 0, maxAvg = Integer.MIN_VALUE;

        for (j = 0; j < k; j++) {
            sum += nums[j];
        }
        avg = sum / k;
        maxAvg = Math.max(maxAvg, avg);

        while (j < nums.length) {
            sum += nums[j];
            sum -= nums[j - k];

            avg = sum / k;
            maxAvg = Math.max(maxAvg, avg);
            j++;

        }
        return maxAvg;

    }
}