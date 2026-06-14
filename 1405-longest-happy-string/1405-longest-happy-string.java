class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int c_a = 0,c_b = 0,c_c = 0;
        StringBuilder sb = new StringBuilder();
        while (true){
            if(a > 0 && (
                (a >= b && a >= c && c_a < 2)||
                (c_b == 2 && (a >= c && a <= b))||
                (c_c == 2 && (a >= b && a <= c))
            )){
                sb.append('a');
                c_a += 1;
                c_b = 0;
                c_c = 0;
                a = a - 1;

            }else if(b > 0 && (
                (b >= a && b >= c && c_b < 2)||
                (c_a == 2 && (b >= c && b <= a))||
                (c_c == 2 && (b >= a && b <= c))
            )){
                sb.append('b');
                c_b += 1;
                c_a = 0;
                c_c = 0;
                b = b - 1;
            }else if(c > 0 && (
                (c >= b && c >= a && c_c < 2)||
                (c_b == 2 && (c >= a && c <= b))||
                (c_a == 2 && (c >= b && c <= a))
            )){
                sb.append('c');
                c_c += 1;
                c_b = 0;
                c_a = 0;
                c = c - 1;
            }else{
                break;
            }
        }
        return sb.toString();
    }
}