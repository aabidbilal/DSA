import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        long available = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        int[] freq = new int[max + 1];

        long total = 0;

        for (int d : diff) {
            freq[d]++;
            total += d;
        }

        if (available >= total) {
            return 0;
        }

        for (int d = max; d > 0 && available > 0; d--) {
            int count = freq[d];
            long moves = Math.min(available, (long) count);

            freq[d] -= (int) moves;
            freq[d - 1] += (int) moves;
            available -= moves;
        }

        long sum = 0;

        for (int d = 1; d <= max; d++) {
            sum += (long) d * d * freq[d];
        }

        return sum;
    }
}