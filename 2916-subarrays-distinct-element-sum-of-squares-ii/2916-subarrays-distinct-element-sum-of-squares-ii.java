
import java.util.Arrays;

class Solution {

    static final long MOD = 1_000_000_007L; 

    long[] sqSumSegTree; 
    long[] segTree;      
    long[] lazy;         
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sqSumSegTree = new long[4 * n]; 
        segTree = new long[4 * n];      
        lazy = new long[4 * n];         

        int[] lastSeen = new int[100001];
        Arrays.fill(lastSeen, -1);

        long result = 0;

        for (int i = 0; i < n; i++) {
            int start = lastSeen[nums[i]] + 1;
            int end = i;

            updateRange(start, end, 0, 0, n - 1, 1);

            result = (result + sqSumSegTree[0]) % MOD;

            lastSeen[nums[i]] = i;
        }

        return (int) result;
    }

    public void updateRange(
            int start, int end, int i, int l, int r, long val) {

        if (lazy[i] != 0) {
            lazyAddition(i, l, r, lazy[i]);

            if (l != r) {
                
                lazy[2 * i + 1] = (lazy[2 * i + 1] + lazy[i]) % MOD;
                lazy[2 * i + 2] = (lazy[2 * i + 2] + lazy[i]) % MOD;
            }
            lazy[i] = 0;
        }

        if (r < start || end < l || l > r) {
            return;
        }
        if (start <= l && r <= end) {
            lazyAddition(i, l, r, val);

            if (l != r) {
                
                lazy[2 * i + 1] = (lazy[2 * i + 1] + val) % MOD;
                lazy[2 * i + 2] = (lazy[2 * i + 2] + val) % MOD;
            }

            return;
        }

        int mid = l + (r - l) / 2;

        updateRange(start, end, 2 * i + 1, l, mid, val);
        updateRange(start, end, 2 * i + 2, mid + 1, r, val);

        segTree[i] =
                (segTree[2 * i + 1] + segTree[2 * i + 2]) % MOD;

        sqSumSegTree[i] =
                (sqSumSegTree[2 * i + 1]
                + sqSumSegTree[2 * i + 2]) % MOD;
    }

    public void lazyAddition(int i, int l, int r, long val) {
        long len = r - l + 1;

        sqSumSegTree[i] = (
                sqSumSegTree[i]
                + 2L * val % MOD * segTree[i] % MOD
                + len % MOD * val % MOD * val % MOD
        ) % MOD;

        segTree[i] = (segTree[i] + len % MOD * val) % MOD;
    }
}
