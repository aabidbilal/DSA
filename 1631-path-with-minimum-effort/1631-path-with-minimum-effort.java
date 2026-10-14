class Solution {
    class Pair {
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    int ans = 0;

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length,
                n = heights[0].length;

        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        BFS(heights, 0, 0, dist);
        return ans;
    }

    public void BFS(int[][] heights, int row, int col, int[][] dist) {

        int m = heights.length,
                n = heights[0].length;
                
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (x, y) -> Integer.compare(x.dist, y.dist));

        dist[0][0] = 0;
        pq.add(new Pair(row, col, 0));

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        while(!pq.isEmpty()){

            Pair p = pq.poll();

            int r = p.row,
                c = p.col,
                d = p.dist;

                if(r == m - 1 && c == n - 1){
                    ans = d;
                    break;
                }
            
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n){

                    int effort = Math.max(d, 
                                            Math.abs(heights[nr][nc] - heights[r][c])
                                        );
                    if(effort < dist[nr][nc]){
                        dist[nr][nc] = effort;
                        pq.add(new Pair(nr, nc, effort));
                    }
                    
                }
            }
        }

    }
}