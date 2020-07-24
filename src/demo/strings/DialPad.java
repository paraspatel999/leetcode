package demo.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @auther
 */

public class DialPad {
    Map<Integer, String> data = new HashMap<>();
    Set<String> dic = new HashSet<>();
    public void printAllNumbers(String num) {
        data.put(2, "abc");
        data.put(3, "def");
        data.put(4, "ghi");
        data.put(5, "jkl");
        data.put(6, "mno");
        data.put(7, "pqrs");
        data.put(8, "tuv");
        dic.add("a");
        dic.add("book");
        dic.add("boat");
        dic.add("cat");
        dic.add("bat");
        dic.add("hat");

        printAllNumbers("", num, 0);
    }
    private void printAllNumbers(String pre, String num, int i) {
        if (i >= num.length()) {
            if (dic.contains(pre)) {
                System.out.println(pre);
            }
            return;
        }
        char c = num.charAt(i);
        int n = c - '0';
        char[] chars = data.get(n).toCharArray();
        for (char ch : chars) {
            printAllNumbers(pre + ch, num, i + 1);
        }

    }

    public static void main(String[] args) {
        DialPad d = new DialPad();
        d.printAllNumbers("222");
    }
}
