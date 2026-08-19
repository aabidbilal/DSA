class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList());
        }

        for (int i = 0; i < graph.length; i = i + 1) {
            int[] curr = graph[i];
            for (int j = 0; j < curr.length; j++) {
                adj.get(curr[j]).add(i);
            }
        }

        int[] inDeg = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int it : adj.get(i)) {
                inDeg[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.length; i++){
            if(inDeg[i] == 0){
                q.offer(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.remove();
            topo.add(node);

            for(int it : adj.get(node)){
                inDeg[it]--;
                if(inDeg[it] == 0){
                    q.offer(it);
                }
            }
        }
        Collections.sort(topo);
        return topo;
    }
}