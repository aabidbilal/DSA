class MinStack {

    Stack<Integer> st;
    Stack<Integer> min;
    
    public MinStack() {
        st = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            min.push(value);
        }else{
            int n = Math.min(value, min.peek());
            min.push(n);
        }
        st.push(value);
    }
    
    public void pop() {
        st.pop();  
        min.pop();  
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */