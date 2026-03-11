class Solution {
    public int lengthOfLongestSubstring(String s) {
       int max = 0;
       int i = 0,
        j = 0; 
       Set<Character> set = new HashSet<>();
       
       while( j < s.length() ){

            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i = i + 1;
            }
            set.add(s.charAt(j));
            max = Math.max(max, j - i + 1);
            j = j + 1;

       }
       return max;

    }
}