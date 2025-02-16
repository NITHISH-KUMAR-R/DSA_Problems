package dsa.problems.arrays;

public class Solution  {
    public static volatile int count = 0;

    public static void check(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit > 0) {
                count = count+1;
            }
            n = n / 10;
        }
    }

    public static int checkNumDigit(int k[]) {
        int n = k.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
             int max = Math.max(k[i], k[j]);
                int min = Math.min(k[i], k[j]);
             int diff = max-min;
                if (diff != 0) {
                    check(diff);
                }
            }
        }
        return count; // Return final count
    }

    public static void main(String[] args) {
        int[] k = {13, 12, 23};
        int k2 [] = {10,10,10,10};
        int result = checkNumDigit(k);
        System.out.println("Total Count: " + result);
    }
}

