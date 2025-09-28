class Solution {
    public void rotate(int[] arr, int k) {
    
        int n = arr.length;
        k = k % n; // handle k > n

        int[] ans = new int[k];
        // Step 1: store last k elements
        for(int i = 0; i < k; i++){
            ans[i] = arr[n-k+i];
        }

        // Step 2: shift first n-k elements to the right
        for(int i = n-k-1; i >= 0; i--){
            arr[i+k] = arr[i];
        }

        // Step 3: place temp elements at the beginning
        for(int i = 0; i < k; i++){
            arr[i] = ans[i];
        }
        
    }
}