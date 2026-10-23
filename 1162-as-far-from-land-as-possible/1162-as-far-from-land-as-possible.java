class Solution {
    class Tuple{
        int row;
        int col;
        int dist;

        Tuple(int row,int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    int ans = 0;
    public int maxDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Tuple> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 1){
                    q.add(new Tuple(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        if(q.size() == 0 || q.size() == m * n) return -1;
        BFS(grid, q, visited);
        return ans;
    }

    public void BFS(int[][] grid, Queue<Tuple> q, boolean[][] visited){

        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
        };

        while(!q.isEmpty()){
            Tuple tup = q.poll();

            int r = tup.row;
            int c = tup.col;
            int d = tup.dist;

            ans = Math.max(ans, d);

            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < m && nr >= 0 && nc < n && nc >= 0){
                    if(grid[nr][nc] == 0 && !visited[nr][nc]){
                        q.add(new Tuple(nr, nc, d + 1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
}