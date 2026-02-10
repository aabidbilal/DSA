class Solution {
    public boolean isPalindrome(String s) {
        int p = 0;
        int q = s.length() - 1;

        while (p <= q) {

            // Skip non alphanumeric from left
            if (!Character.isLetterOrDigit(s.charAt(p))) {
                p++;
                continue;
            }

            // Skip non alphanumeric from right
            if (!Character.isLetterOrDigit(s.charAt(q))) {
                q--;
                continue;
            }

            // Compare in lowercase
            if (Character.toLowerCase(s.charAt(p)) != 
                Character.toLowerCase(s.charAt(q))) {
                return false;
            }

            p++;
            q--;
        }

        return true;
    }
}
