class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        removeValid(s, st);

        if(st.size() == 0)return s.length();

        int[] arr = new int[st.size() + 2];
        arr[0] = -1;
        arr[arr.length - 1] = s.length();

        for(int i = arr.length - 2; i >= 1; i--){
            arr[i] = st.pop();
        }

        int i = 0; 
        int max = 0;
        while(i < arr.length - 1){
            int j = i + 1;
            max = Math.max(max, arr[j] - arr[i] - 1);
            i++;
        }
        return max;
        
    }
    public void removeValid(String s, Stack<Integer> st){
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(i);
            }
            else{
                if(st.isEmpty() || s.charAt(st.peek()) == ')' ){
                    st.push(i);
                }else{
                    st.pop();
                }
            }
        }
    }
}