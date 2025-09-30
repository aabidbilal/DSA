class Solution {
    public void moveZeroes(int[] arr) {
          int pos = 0; // index for placing non-zero elements

        // Step 1: put all non-zero elements at the beginning
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[pos] = arr[i];
                pos++;
            }
        }

        // Step 2: fill the rest with 0
        while (pos < arr.length) {
            arr[pos] = 0;
            pos++;
        }
            }
        
        

}