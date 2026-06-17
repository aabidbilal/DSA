class MyCircularQueue {
    int arr[];
    int f = -1;
    int r = -1;
    int size = 0;
    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(size == arr.length){
                    return false;
            }
            else if( f == -1){
                f = r = 0;
                arr[r] = value;
            } else if (r < arr.length -1) {
                arr[++r] = value;
            } else if (r == arr.length -1) {
                r = 0;
                arr[r] = value;
            }
            size = size + 1;
            return true;
    }
    
    public boolean deQueue() {
         int x = 0;
            if(size == 0){
               return false;
            }
            else {
                if (f == arr.length - 1) {
                    x = arr[f];
                    f = 0;
                } else {
                    x = arr[f++];
                }
                size = size - 1;
            }
            return true;
    }
    
    public int Front() {
        if( size == 0){
            return -1;
        }
        return arr[f];
    }
    
    public int Rear() {
        if( size == 0){
            return -1;
        }
        return arr[r];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == arr.length;
  }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */