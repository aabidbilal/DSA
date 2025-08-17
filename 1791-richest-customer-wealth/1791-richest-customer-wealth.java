class Solution {
    public int maximumWealth(int[][] arr) {
        int row=arr.length;
        int [] welth=new int[row];
        int col=arr[0].length;
        for(int i=0;i<row;i++){
           int sum=0;
            for(int j=0;j<col;j++){
                sum=sum+arr[i][j];
            }
            welth[i]=sum;
        }
        int maxw=welth[0];
        for(int i=0;i<welth.length;i++)
        {
            if(welth[i]>maxw){
                maxw=welth[i];
            }
        }
        return maxw;
        
    }
}