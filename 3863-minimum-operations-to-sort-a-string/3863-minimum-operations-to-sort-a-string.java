
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) return 0;


        if (n == 2) return -1;

        char min = 'z';
        char max = 'a';
        int minCount = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch < min) {
                min = ch;
                minCount = 1;
            } else if (ch == min) {
                minCount++;
            }

            if (ch > max) {
                max = ch;
                maxCount = 1;
            } else if (ch == max) {
                maxCount++;
            }
        }

        char first = s.charAt(0);
        char last = s.charAt(n - 1);

        if (first == min || last == max) return 1;

        if (first == max && last == min
                && maxCount == 1 && minCount == 1) {
            return 3;
        }

        return 2;
    }
}
