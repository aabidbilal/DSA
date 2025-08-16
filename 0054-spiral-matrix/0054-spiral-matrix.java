class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List <Integer> ans=new ArrayList<>();
        int srow=0;int scol=0;
        int erow=mat.length-1;
        int ecol=mat[0].length-1;
        while(srow<=erow&&scol<=ecol){
            // top
            // leetsynced
            for( int j =scol; j<=ecol; j++){
                ans.add(mat[srow][j]);
            }
            // right
            for(int i =srow+1; i<=erow; i++){
                ans.add(mat[i][ecol]);
            }
            // bottom
            for(int j =ecol-1; j>=scol; j--){
                if(srow==erow){
                    break;
                }
                ans.add(mat[erow][j]);
            }
            // left
            for(int i =erow-1; i>=srow+1; i--){
                if(scol==ecol){
                    break;
                }
                ans.add(mat[i][scol]);
            }
        
        srow++;scol++;erow--;ecol--;}
        return ans;

    }
    


}