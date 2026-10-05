class Solution {
    class Pair {
        int row;
        int col;
        int step;

        Pair(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }

    int steps = (int)1e9;

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length,
                n = grid[0].length;
        
        if(grid[0][0] == 1 || grid[m - 1][n - 1] == 1)return -1;

        boolean[][] visited = new boolean[m][n];

        BFS(0, 0, grid, visited);

        return steps == (int)1e9 ? -1 : steps;
    }

    public void BFS(int row, int col, int[][] grid, boolean[][] visited) {
        int m = grid.length,
                n = grid[0].length;

        visited[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col, 1));

        while (!q.isEmpty()) {

            int r = q.peek().row;
            int c = q.peek().col;
            int s = q.peek().step;
            q.remove();

            if(r == m - 1 && c == n - 1){
                steps = Math.min(steps, s);
            }

            int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
            int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

            for( int i = 0; i < 8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    if(!visited[nr][nc] && grid[nr][nc] != 1){
                        visited[nr][nc] = true;
                        q.add(new Pair(nr, nc, s + 1));
                    }
                }                  
            }
        }

    }
}