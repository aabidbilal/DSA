class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
                        && board[i][j] == 'O') {

                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        int[][] directions = {
            {-1,0},{1,0},{0,-1},{0,1}
        };
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();

            for(int dir[] : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]){
                    if(board[nr][nc] == 'O'){
                        q.add(new Pair(nr, nc));
                        vis[nr][nc] = true;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}