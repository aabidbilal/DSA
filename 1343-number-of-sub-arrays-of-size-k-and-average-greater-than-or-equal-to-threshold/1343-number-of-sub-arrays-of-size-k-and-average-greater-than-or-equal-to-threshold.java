class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0, sum = 0, i;
        for (i = 0; i < k; i = i + 1) {
            sum = sum + arr[i];
        }
        int avg = sum / k;
        if (avg >= threshold)
            count = count + 1;

        while (i < arr.length) {
            sum = sum + arr[i];
            sum = sum - arr[i - k];

            avg = sum / k;

            if (avg >= threshold)
                count = count + 1;

            i = i + 1;
        }
        return count;
    }
}