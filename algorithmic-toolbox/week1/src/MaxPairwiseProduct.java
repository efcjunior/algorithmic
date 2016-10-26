import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static long getMaxPairwiseProductFast(long[] numbers){
        int n = numbers.length;
        int indexMax1 = -1;
        int indexMax2 = -1;

        for(int i = 0; i < n; ++i){
            if(indexMax1 == -1 || numbers[i] > numbers[indexMax1]){
                indexMax1 = i;
            }
        }

        for(int i = 0; i < n; ++i){
            if(i != indexMax1 && (indexMax2 == -1 || numbers[i] > numbers[indexMax2])){
                indexMax2 = i;
            }
        }

        return numbers[indexMax1] * numbers[indexMax2];
    }


    static long getMaxPairwiseProduct(long[] numbers) {
        long result = 0;
        long n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        long n = scanner.nextLong();
        long[] numbers = new long[(int)n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

}
