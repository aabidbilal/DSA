class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        int ans[] = new int[seq.length()];
        int A_cnt = 0, B_cnt = 0;
        int i = 0;

        while(i < seq.length()){
            char ch = seq.charAt(i);
            if(ch == '('){
                if(A_cnt <= B_cnt){
                    ans[i] = 0;
                    A_cnt++;
                }else{
                    ans[i] = 1;
                    B_cnt++;
                }
            }else{
                if(A_cnt >= B_cnt){
                    ans[i] = 0;
                    A_cnt--;
                }else{
                    ans[i] = 1;
                    B_cnt--;
                }
            }
            i++;
        }

        return ans;
    }
}