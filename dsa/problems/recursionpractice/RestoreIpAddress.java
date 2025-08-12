package dsa.problems.recursionpractice;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
        public void recursion(String s, int start, List<String> path, List<String> list) {
            if (path.size() == 4) {
                if (start == s.length()) {
                    list.add(String.join(".", path));
                }
                return;
            }

            for (int len = 1; len <= 3; len++) {
                if (start + len > s.length()) break; // out of bounds
                String sub = s.substring(start, start + len);

                if (sub.length() > 1 && sub.charAt(0) == '0')
                    continue;
                int val = Integer.parseInt(sub);
                if (val > 255)
                    continue;

                path.add(sub);
                recursion(s, start + len, path, list);
                path.remove(path.size() - 1);
            }
        }

        public List<String> restoreIpAddresses(String s) {

            List<String> list = new ArrayList<>();

            recursion(s, 0, new ArrayList<>(), list);
            return list;
        }

}
