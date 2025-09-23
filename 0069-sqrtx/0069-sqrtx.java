// class Solution {
//     public int mySqrt(int x) {
        // if (x < 2) return x;

        // for (int i = 1; i <= x / 2+1; i++) {
        //     long sq = (long) i * i;
        //     if (sq == x) return i;
        //     else if (sq > x) return i - 1;
        // }
        // return 1; // truly unreachable for x >= 2

        // optimised solution 
        class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;   // use long to avoid overflow
            if (sq == x) return mid;
            if (sq < x) {
                ans = mid;      // mid is a candidate
                left = mid + 1; // search right side
            } else {
                right = mid - 1; // search left side
            }
        }
        return ans; // floor(sqrt(x))
    }
}


    

