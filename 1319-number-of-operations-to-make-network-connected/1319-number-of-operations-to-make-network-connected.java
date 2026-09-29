class Solution {
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1)return -1;
        int count = 0;

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < connections.length; i++){
            int a = connections[i][0];
            int b = connections[i][1];

            list.get(a).add(b);
            list.get(b).add(a);
        }
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                DFS(i, visited, list);
                count++;
            }
        }
        return count - 1;
    }
    public void DFS(int source, boolean[] visited, List<List<Integer>> list){
        visited[source] = true;
        
        for(int it : list.get(source)){
            if(!visited[it]){
                DFS(it, visited, list);
            }
        }
    }
}