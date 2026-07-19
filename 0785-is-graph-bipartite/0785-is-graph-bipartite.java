class Solution {
    static boolean ans;
    public void bfs(int i, int[][] adj, int[] visited){
        visited[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size() > 0){
            int front = q.remove();
            int color = visited[front];

            for(int ele : adj[front]){
                if(visited[ele] == visited[front]){
                    ans = false;
                    return;
                }
                if(visited[ele] == -1){
                    q.add(ele);
                    visited[ele] = 1 - color;
                }
            }
        }
    }

    public boolean isBipartite(int[][] adj) {
      int n = adj.length;
      ans = true;
      int [] visited = new int[n];
      Arrays.fill(visited, -1);
    
      for(int i = 0; i < n; i = i + 1){
        if(ans == false)return false;
        if( visited[i] == -1){
            bfs(i, adj, visited);
        }
      }
    return ans;
    }
}