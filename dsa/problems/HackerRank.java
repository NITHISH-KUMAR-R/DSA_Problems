package dsa.problems;

public class HackerRank {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, -5, 10, 1, 1};
        int ar2[] = {6, 6, 3, 4, -1, 9, 17};
        System.out.println(maxEvenSumSubarray(ar2)); // Should print 22
    }

    public static int maxEvenSumSubarray(int[] arr) {
        int maxEven = Integer.MIN_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num % 2 == 0) {
                // Even + Even = Even
                // Odd + Even = Odd
                maxEven = maxEven == Integer.MIN_VALUE ? num : Math.max(maxEven + num, num);
                maxOdd = maxOdd == Integer.MIN_VALUE ? Integer.MIN_VALUE : maxOdd + num;
            } else {
                // Even + Odd = Odd
                // Odd + Odd = Even
                int prevMaxEven = maxEven;
                int prevMaxOdd = maxOdd;

                maxEven = (prevMaxOdd == Integer.MIN_VALUE) ? Integer.MIN_VALUE : prevMaxOdd + num;
                maxOdd = (prevMaxEven == Integer.MIN_VALUE) ? num : Math.max(prevMaxEven + num, num);
            }
        }

        return maxEven == Integer.MIN_VALUE ? 0 : maxEven;
    }
}
