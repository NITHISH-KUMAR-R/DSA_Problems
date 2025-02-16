package dsa.problems.arrays;

 public class Maths {

    public boolean canPartition(String s, int index, int target) {
        if (index == s.length()) {
            return target == 0;
        }

        int sum = 0;
        for (int i = index; i < s.length(); i++) {
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum > target) {
                break;
            }
            if (canPartition(s, i + 1, target - sum)) {
                return true;
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        int totalSum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String squareStr = Integer.toString(square);
            if (canPartition(squareStr, 0, i)) {
                totalSum += square;
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        Maths solution = new Maths();

        int n = 10;
        System.out.println("Total: " + solution.punishmentNumber(n));  // Expected Output: 182

        n = 37;
        System.out.println("Total: " + solution.punishmentNumber(n));  // Expected Output: 1478
    }
}
