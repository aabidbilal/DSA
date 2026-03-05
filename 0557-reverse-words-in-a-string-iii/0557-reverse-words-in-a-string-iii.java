class Solution {
    public String reverseWords(String s) {
        char[] arr = new char[s.length()];
        int i = 0, j = 0, k = 0;
        while (j < s.length()) {

            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            int end = j - 1;
            while (i <= end) {
                arr[k] = s.charAt(end);
                k++;
                end--;
            }
            if (j < s.length() && s.charAt(j) == ' ') {
                arr[k] = ' ';
                k++;
            }
            i = ++j;
        }
        return new String(arr, 0, k);
    }
}