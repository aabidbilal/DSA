class Solution {
    class Pair{
        int node;
        int dist;

        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    class Tuple{
        int stops;
        int nodes;
        int dist;

        Tuple(int stops, int nodes, int dist){
            this.stops = stops;
            this.nodes = nodes;
            this.dist = dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];

            adj.get(from).add(new Pair(to, cost));
        }

        int INF = (int)(1e9);
        
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        dist[src] = 0;
        BFS(adj, src, dst, k, dist);

        if(dist[dst] == INF) return -1;

        return dist[dst];
    }
    public void BFS(List<List<Pair>> adj, int src, int dest, int k, int[] dist){

        

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        while(!q.isEmpty()){
            Tuple t = q.poll();

            int stop = t.stops;
            int node = t.nodes;
            int d = t.dist;

            if(stop > k) continue;

            for(Pair pair : adj.get(node)){
                
                int newD = pair.dist;
                int newNode = pair.node;

                if(d + newD < dist[newNode] && stop <= k){

                    dist[newNode] = d + newD;
                    q.add(new Tuple(stop + 1, newNode, d + newD));
                }

            }
        }
    }
}