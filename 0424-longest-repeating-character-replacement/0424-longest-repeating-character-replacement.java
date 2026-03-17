class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0, j = 0, max = 0;
        int maxC = 0;
        while (j < s.length()) {

            char b = s.charAt(j);
            count[b - 'A'] = count[b - 'A'] + 1;
            maxC = Math.max(maxC, count[b - 'A']);

            while ((j - i + 1) - maxC > k) {

                char a = s.charAt(i);
                count[a - 'A'] = count[a - 'A'] - 1;
                i = i + 1;
                for (int l = 0; l < 26; l = l + 1) {
                    maxC = Math.max(maxC, count[l]);
                }
            }
            max = Math.max(max, j - i + 1);
            j = j + 1;
        }
        return max;
    }
}