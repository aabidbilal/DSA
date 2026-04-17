class Solution {
    public boolean isValid(String str) {
         Stack<Character> st = new Stack<>();
        int i = 0;
        while( i < str.length()){
            char ch = str.charAt(i);
            if ( ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else {

                if (st.isEmpty()) {
                    return false;
                }
                char top = st.peek();
                if ((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')) {
                    st.pop();
                }else return false;
            }
            i = i + 1;
        }
        if ( st.isEmpty()){
            return true;
        }
        return false;
    }
}