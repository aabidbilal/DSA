class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int[] res = new int[nums1.length];
      HashMap<Integer, Integer> map = new HashMap<>();


      Stack<Integer> st = new Stack<>();
      
      int n = nums2.length;
      st.push(nums2[n - 1]);
      map.put(nums2[n - 1], -1);
      
      for ( int i = n - 2; i >= 0 ; i = i - 1){
            while( st.size() > 0 && st.peek() < nums2[i] ){
                st.pop();
            }
            if( st.size() == 0) map.put(nums2[i], -1);
            else{
                map.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }
        int j = 0;
        for(int num : nums1){
            res[j] = map.get(num);
        j++;
        }
        return res;
    }
}