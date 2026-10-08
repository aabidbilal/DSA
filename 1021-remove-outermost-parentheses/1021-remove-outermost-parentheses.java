class Solution {
    public String removeOuterParentheses(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        int start = 0;

        while(i < s.length()){

            char ch = s.charAt(i);
            if(ch == '(')balance++;
            else balance--;

            if(balance == 0 && s.charAt(i - 1) != '('){
                String ns = s.substring(start + 1, i);
                sb.append(ns);
                
            }
            if(balance == 0)start = i + 1;
            i++;

        }
        return sb.toString();
    }
}