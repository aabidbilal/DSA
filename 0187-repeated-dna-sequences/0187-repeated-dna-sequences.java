class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> ans = new HashSet<>();
        int n = s.length();
        for (int i = 0; i <= n - 10; i = i + 1) {
            String str = s.substring(i, i + 10);
            if (seen.contains(str)) {
                ans.add(str);
            } else {
                seen.add(str);
            }
        }
        return new ArrayList<>(ans);
    }
}