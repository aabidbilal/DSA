class Solution {
    public int findCircleNum(int[][] adj) {

    int n = adj.length;
    int count = 0;
    boolean[] vis = new boolean[n];

    for ( int i = 0; i < n; i = i + 1){

        if(!vis[i]){
            BFS(i, vis, adj);
            count = count + 1;
        }
    } 
    return count;     
    }
    public void BFS(int i, boolean[] vis, int[][] adj){
        vis[i] = true;
        int n = adj.length;

        Queue<Integer> q = new LinkedList<>();

        q.add(i);
        while(q.size() > 0){
            int front = q.remove();

            for(int j = 0; j < n; j = j + 1){
                if(adj[front][j] == 1 && !vis[j]){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }

}