class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        vis[sr][sc] = true;

        int[][] direction = {
                { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 }
        };

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;

            for (int[] dir : direction) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (image[nr][nc] == image[row][col] && !vis[nr][nc]) {
                        vis[nr][nc] = true;
                        q.add(new Pair(nr, nc));
                    }
                }
            }
            image[row][col] = color;
        }
        return image;
    }
}