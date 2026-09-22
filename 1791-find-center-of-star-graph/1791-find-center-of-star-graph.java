class Solution {
    public int findCenter(int[][] edges) {
        int i = edges[0][0];
        int j = edges[0][1];
        int x = edges[1][0];
        int y = edges[1][1];

        if( i == x || i == y){
            return i;
        }
 
         return j;
        }
    }