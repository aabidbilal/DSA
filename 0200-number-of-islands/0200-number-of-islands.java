class Solution {
    class pair {
        int row;
        int col;

        pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i = i + 1) {
            for (int j = 0; j < n; j = j + 1) {

                if (grid[i][j] == '1' && !vis[i][j]) {
                    BFS(i, j, grid, vis);
                    count = count + 1;
                }
            }
        }
        return count;

    }

    private void BFS(int i, int j, char[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i, j));
        vis[i][j] = true;

        while (q.size() > 0) {
            pair front = q.remove();
            int row = front.row, col = front.col;

            // bottom
            if (row + 1 < m) {
                if (grid[row + 1][col] != '0' && !vis[row + 1][col]) {
                    q.add(new pair(row + 1, col));
                    vis[row + 1][col] = true;
                }
            }
            // right
            if (col + 1 < n) {
                if (grid[row][col + 1] != '0' && !vis[row][col + 1]) {
                    q.add(new pair(row, col + 1));
                    vis[row][col + 1] = true;
                }
            }
            // left
            if (col - 1 >= 0) {
                if (grid[row][col - 1] != '0' && !vis[row][col - 1]) {
                    q.add(new pair(row, col - 1));
                    vis[row][col - 1] = true;
                }
            }
             // top
            if (row - 1 >= 0) {
                if (grid[row - 1][col] != '0' && !vis[row - 1][col]) {
                    q.add(new pair(row - 1, col));
                    vis[row - 1][col] = true;
                }
            }
        }
    }
}
