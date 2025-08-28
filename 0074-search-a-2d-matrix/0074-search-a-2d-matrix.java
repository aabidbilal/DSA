class Solution {
    public boolean searchinrow(int [][]mat,int target ,int row){
        int n=mat[0].length;
        int s=0;
        int e=n-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target==mat[row][m]){
                return true;
            }
            else if(target>mat[row][m]){
                s=m+1;
            }
            else
            {
                e=m-1;
            }
        }
        return false;
        
    }
    public boolean searchMatrix(int[][] mat, int target) {
        int m=mat.length;
        int n = mat[0].length;
        int srow=0;
        int erow=m-1;
        while(srow<=erow){
            int mrow=srow+(erow-srow)/2;
            if(target>=mat[mrow][0] && target<=mat[mrow][n-1]){
                return searchinrow(mat,target,mrow);
            }
            else if(target>mat[mrow][n-1]){
                srow=mrow+1;
            }
            else
            {
                erow=mrow-1;
            }
        }
        return false;
    }
}