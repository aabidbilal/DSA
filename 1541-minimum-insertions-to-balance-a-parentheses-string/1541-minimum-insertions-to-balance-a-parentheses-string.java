class Solution {
    public int minInsertions(String s) {

        int count = 0,
                two = 0,
                i = 0;
        Stack<Character> st = new Stack();

        while (i < s.length()) {

            char ch = s.charAt(i);

            if (ch == '(') {
                if (two != 0) {
                    if (st.isEmpty())
                        count += 2;
                    else {
                        count++;
                        st.pop();
                    }
                    two = 0;
                }
                st.push(ch);
            } else {
                two++;
                if (two == 2) {
                    if (st.isEmpty())
                        count++;
                    else
                        st.pop();
                    two = 0;
                }

            }
            i++;
        }
        if (st.isEmpty()) {
            if (two != 0)
                count += 2;
        } else {
            int rem = st.size() * 2 - two;
            count += rem;
        }
        return count;
    }
}