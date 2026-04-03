class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap <Integer, Integer> map = new TreeMap<>();
        for ( int [] trip : trips){
            int pass = trip[0];
            int from = trip[1];
            int to = trip[2];
            map.put(from, map.getOrDefault(from, 0) + pass);
            map.put(to, map.getOrDefault(to, 0) - pass);
        }
        int passengers = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            passengers += entry.getValue();
            if(passengers > capacity){
                return false;
            }
        }
        return true;
    }
}