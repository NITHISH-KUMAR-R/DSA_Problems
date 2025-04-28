package dsa.stream;

import java.util.HashMap;
import java.util.Map;

public class ConsecutiveBookshelf {
    public static int consecutiveBookshelfMin(int[] books) {
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int minShelfSize = Integer.MAX_VALUE;

        for (int i = 0; i < books.length; i++) {
            int book = books[i];
            if (lastSeen.containsKey(book)) {
                int prevIndex = lastSeen.get(book);
                int shelfSize = i - prevIndex + 1;
                minShelfSize = Math.min(shelfSize, minShelfSize);
            }
            lastSeen.put(book, i);
        }

        return (minShelfSize == Integer.MAX_VALUE) ? -1 : minShelfSize;
    }

    public static void main(String[] args) {
        int[] books = {5, 1, 9, 5, 2, 6, 5, 1, 5};
        System.out.println(consecutiveBookshelfMin(books)); // Output: 2
    }
}
