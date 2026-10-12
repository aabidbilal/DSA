class Solution {
    int ans = 0;
    class Pair {
        int row;
        int col;


        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
      int m = grid.length;
        int n = grid[0].length;


        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i = i + 1) {
            for (int j = 0; j < n; j = j + 1) {

                if (grid[i][j] == 1 && !vis[i][j]) {
                    BFS(i, j, grid, vis);
                    
                }
            }
        }
        return ans;   
    }
    private void BFS(int i, int j, int[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        int area = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;

        int[][] directions = {
            {-1,0},{1,0},{0,-1},{0,1}
        };

        while (q.size() > 0) {
            Pair front = q.remove();
            int row = front.row, col = front.col;
            area++;


            for(int [] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]){
                    if(grid[nr][nc] == 1){
                        q.add(new Pair(nr, nc));
                        vis[nr][nc] = true;
                    }
                }
            }
        }
        ans= Math.max(ans, area);
    }
}