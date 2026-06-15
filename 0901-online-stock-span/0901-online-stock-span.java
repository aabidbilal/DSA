class StockSpanner {
    ArrayList<Integer> list;
    Stack<Integer> st;
    public StockSpanner() {
        list = new ArrayList<Integer>();
        st = new Stack<Integer>();
    }
    
    public int next(int price) {
        list.add(price);
        int i = list.size() - 1;
	        
	        while( !st.isEmpty() && list.get(i) >= list.get(st.peek()) ){
	            st.pop();
	        }
	        int res = st.isEmpty() ? i + 1 : i - st.peek();
	        
	        st.push(i);
	    
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */