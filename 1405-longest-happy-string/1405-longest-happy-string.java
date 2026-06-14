class CharacterCount{
    int count;
    char c;
    CharacterCount(int _count, char _c){
        count = _count;
        c = _c;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharacterCount> maxHeap = new PriorityQueue<CharacterCount>((x, y) -> y.count - x.count);
        
        if ( a > 0 ){
            maxHeap.add(new CharacterCount(a, 'a'));
        }
        if ( b > 0 ){
            maxHeap.add(new CharacterCount(b, 'b'));
        }
        if ( c > 0 ){
            maxHeap.add(new CharacterCount(c, 'c'));
        }
        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()){
            CharacterCount maxEle = maxHeap.poll();
            int count = maxEle.count;
            char _c = maxEle.c;

            if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == _c && sb.charAt(sb.length() - 2) == _c ){
                if(maxHeap.isEmpty()){
                    break;
                }
                CharacterCount secMaxEle = maxHeap.poll();
                int sCount = secMaxEle.count;
                char sC = secMaxEle.c;

                sb.append(sC);
                sCount -= 1;
                if(sCount > 0){
                    maxHeap.add( new CharacterCount(sCount, sC));
                }
            }else{
                sb.append(_c);
                count = count - 1;
            }
            if ( count > 0 ){
                    maxHeap.add( new CharacterCount(count, _c));
                }

        }
        return sb.toString();
    }
}