class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxLen = 0;
        
        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while(map.get(ch) > 2){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i = i + 1;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j = j + 1;
        }
        return maxLen;
    }
}