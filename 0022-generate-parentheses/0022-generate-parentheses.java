class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("", n, 0, 0);
        return list;
    }
    public void generate(String s, int n, int open, int close){

        if(s.length() == 2 * n){
            list.add(s);
            return;
        }
        if(open < n){
            generate(s + '(', n, open + 1, close);
        }
        if(close < open){
            generate(s + ')', n, open, close + 1);
        }
    }
}