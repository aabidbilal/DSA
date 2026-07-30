class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int time = 0;
        int freshCount = 0;

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) return 0;

        int[][] directions = {
            {-1, 0},{1, 0},{0, -1},{0, 1}
        };

        while(!q.isEmpty()){
            int size = q.size(); 
            boolean rottedAny = false;

            for (int k = 0; k < size; k++) {
                Pair node = q.poll();
                int row = node.row, col = node.col;

                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; 
                        freshCount--;
                        q.add(new Pair(nr, nc));
                        rottedAny = true;
                    }
                }
            }

            if (rottedAny) time++;
        }
        return freshCount == 0 ? time : -1;
    }
}