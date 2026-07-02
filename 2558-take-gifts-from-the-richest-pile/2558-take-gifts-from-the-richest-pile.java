class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < gifts.length; i = i + 1){
            pq.add(gifts[i]);
        }
        while(k != 0){
            int pile = pq.poll();
            pq.add((int) Math.sqrt(pile));
            k = k - 1;
        }
        long rem = 0;
        for (int pile : pq){
            rem += pile;
        }
        return rem;

    }
}