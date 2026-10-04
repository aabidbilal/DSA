class Solution {
    
    public boolean checkValidString(String s) {
        
        Stack<Integer> st = new Stack<>();
        Stack<Integer> strCnt = new Stack<>();
        int i = 0;

        while(i < s.length()){

            char ch = s.charAt(i);

            if(ch == '(')st.push(i);
            else if(ch == '*')strCnt.push(i);
            else{
                if(st.isEmpty() && strCnt.size() == 0)return false;
                else if(!st.isEmpty())st.pop();
                else if (st.isEmpty() && strCnt.size() > 0)strCnt.pop();

            }
            i++;
        }
        while(!st.isEmpty() && strCnt.size() > 0){
           
                int top = st.peek();
                int idx = strCnt.peek();

                if(top < idx){
                    st.pop();
                    strCnt.pop();
                    
                }else break;
            
        }
        return st.size() == 0;
    }
}