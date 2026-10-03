// APPROACH 1

// class Solution {
//     public int longestValidParentheses(String s) {

//         Stack<Integer> st = new Stack<>();
//         removeValid(s, st);
        
//         if (st.size() == 0)
//             return s.length();

//         int[] arr = new int[st.size() + 2];
//         arr[0] = -1;
//         arr[arr.length - 1] = s.length();

//         for (int i = arr.length - 2; i >= 1; i--) {
//             arr[i] = st.pop();
//         }

//         int i = 0;
//         int max = 0;
//         while (i < arr.length - 1) {
//             int j = i + 1;
//             max = Math.max(max, arr[j] - arr[i] - 1);
//             i++;
//         }
//         return max;

//     }

//     public void removeValid(String s, Stack<Integer> st) {

//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);

//             if (ch == '(') {
//                 st.push(i);
//             } else {
//                 if (st.isEmpty() || s.charAt(st.peek()) == ')') {
//                     st.push(i);
//                 } else {
//                     st.pop();
//                 }
//             }
//         }
//     }
// }

// Approach 2
// why do we finding each invalid index then calculating the max  diff seperately we can do this in one go 
// first we will push a imaginary boundary at the top of stack -- why -- suppose if all the string is valid how do we calculate the length (doing j - i + 1)  will not help 
// every time so .. a every point top of stack will maintain the most recent invalid index and at every point we will update the max value
// at every index if it is --- ( -- blind push in stack 
//  and if it is ) we will pop the top element -- why pop -- cuz we belive for every ) there should already be a (  present in stack and if it is not present its invalid index
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(i);

            }else{
                st.pop();
                if(!st.isEmpty()){
                    maxLen = Math.max(maxLen, i - st.peek());
                }else
                    st.push(i);
            }
        }
        return maxLen;
    }
}
