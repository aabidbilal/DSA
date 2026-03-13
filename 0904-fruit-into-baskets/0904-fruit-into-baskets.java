class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        int i = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < fruits.length) {
            int toAdd = fruits[j];

            if (!map.containsKey(toAdd)) {
                map.put(toAdd, 0);
            }
            map.put(toAdd, map.get(toAdd) + 1);
            while (map.size() > 2) {
                int toRem = fruits[i];
                map.put(toRem, map.get(toRem) - 1);
                i = i + 1;

                if (map.get(toRem) == 0) {
                    map.remove(toRem);
                }
            }
            max = Math.max(max, j - i + 1);
            j = j + 1;
        }
        return max;

    }
}