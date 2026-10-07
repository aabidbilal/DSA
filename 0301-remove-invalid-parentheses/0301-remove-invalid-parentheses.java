class Solution {

    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int leftRem = 0;
        int rightRem = 0;

        // Find minimum removals needed
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                leftRem++;
            }

            else if (ch == ')') {

                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }

        backtrack(
                s,
                0,
                leftRem,
                rightRem,
                0,
                new StringBuilder());

        return new ArrayList<>(result);
    }

    private void backtrack(
            String s,
            int index,
            int leftRem,
            int rightRem,
            int open,
            StringBuilder current) {

        // Finished processing the string
        if (index == s.length()) {

            if (leftRem == 0 &&
                    rightRem == 0 &&
                    open == 0) {

                result.add(current.toString());
            }

            return;
        }

        char ch = s.charAt(index);

        // CASE 1: '('
        if (ch == '(') {

            // Option 1: Remove it
            if (leftRem > 0) {

                backtrack(
                        s,
                        index + 1,
                        leftRem - 1,
                        rightRem,
                        open,
                        current);
            }

            // Option 2: Keep it
            current.append('(');

            backtrack(
                    s,
                    index + 1,
                    leftRem,
                    rightRem,
                    open + 1,
                    current);

            current.deleteCharAt(current.length() - 1);
        }

        // CASE 2: ')'
        else if (ch == ')') {

            // Option 1: Remove it
            if (rightRem > 0) {

                backtrack(
                        s,
                        index + 1,
                        leftRem,
                        rightRem - 1,
                        open,
                        current);
            }

            // Option 2: Keep it
            // Only possible if there is an unmatched '('
            if (open > 0) {

                current.append(')');

                backtrack(
                        s,
                        index + 1,
                        leftRem,
                        rightRem,
                        open - 1,
                        current);

                current.deleteCharAt(current.length() - 1);
            }
        }

        // CASE 3: letter
        else {

            current.append(ch);

            backtrack(
                    s,
                    index + 1,
                    leftRem,
                    rightRem,
                    open,
                    current);

            current.deleteCharAt(current.length() - 1);
        }
    }
}