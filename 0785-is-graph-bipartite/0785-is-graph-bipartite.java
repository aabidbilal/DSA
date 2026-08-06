class Solution {
    class Pair {
        int node;
        int color;

        Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public boolean bfs(int i, int[][] adj, int[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, 0));
        vis[i] = 0;
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int color = q.peek().color;
            q.remove();

            for (int ele : adj[node]) {
                if (vis[ele] == -1) {
                    q.add(new Pair(ele, 1 - color));
                    vis[ele] = 1 - color;
                } else if (vis[ele] == color) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] adj) {
        int n = adj.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for (int i = 0; i < n; i = i + 1) {

            if (vis[i] == -1) {
                if(!bfs(i, adj, vis))return false;
            }
        }
        return true;
    }
}