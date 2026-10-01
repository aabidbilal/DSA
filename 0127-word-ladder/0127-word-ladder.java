// Approach -- 1(more brute force thinking)

// class Solution {
//     class Pair{
//         String first;
//         int sec;
//         Pair(String first, int sec){
//             this.first = first;
//             this.sec = sec;
//         }
//     }
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
//         Set<String> set = new HashSet<>();
//         int n = wordList.size();

//         for(int i = 0; i < n; i++){
//             set.add(wordList.get(i));
//         }
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(beginWord, 1));
//         set.remove(beginWord);

//         while(!q.isEmpty()){
//             Pair node = q.poll();
//             String word = node.first;
//             int step = node.sec;
            
//             if(word.equals(endWord) == true)return step;

//             for(int i = 0; i < word.length(); i++){
//                 for(char ch = 'a'; ch <= 'z'; ch++){
                    
//                     char[] charArr = word.toCharArray();
//                     charArr[i] = ch;
//                     String newWord = new String(charArr);

//                     if(set.contains(newWord)){
//                         set.remove(newWord);
//                         q.add(new Pair(newWord, step + 1));
//                     }

//                 }
//             }
//         }
//         return 0;
//     }
// }


// Approach -- 2 ( more graphh version)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();
        int n = wordList.size();

        for(int i = 0; i < n; i++){
            set.add(wordList.get(i));
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        if(set.contains(beginWord)) set.remove(beginWord);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){

                String node = q.poll();
                if(node.equals(endWord)) return level + 1;

                List<String> list = getNeighbour(node, set);

                for(String word : list){
                    if(set.contains(word)){
                        q.offer(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    public List<String> getNeighbour(String word, Set<String> set){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < word.length(); i++){
            for(char ch = 'a'; ch <= 'z'; ch++){

                char[] charArr = word.toCharArray();
                charArr[i] = ch;
                String newWord = new String(charArr);

                if(set.contains(newWord)){
                    list.add(newWord);
                }
            }
        }
        return list;
    }
}






















