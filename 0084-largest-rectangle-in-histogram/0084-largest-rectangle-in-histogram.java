class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> st1 = new Stack<Integer>();
        int n = heights.length;

        int[] NSE = new int[n];
        int[] PSE = new int[n];

        Arrays.fill(NSE, n);
        Arrays.fill(PSE, -1);

        for (int i = 0; i < n; i = i + 1) {
            int num = heights[i];
            while (!st.isEmpty() && num <= heights[st.peek()]) {
                NSE[st.pop()] = i;
            }
            st.push(i);
        }

        for (int i = 0; i < n; i = i + 1) {
            int num = heights[i];
            while (!st1.isEmpty() && num <= heights[st1.peek()]) {
                st1.pop();
            }
            PSE[i] = st1.isEmpty() ? -1 : st1.peek();
            st1.push(i);
        }
        int currArea = 0, maxArea = 0;
        for ( int i = 0; i < n; i = i + 1){
            currArea = heights[i] * ( NSE[i] - PSE[i] - 1);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}