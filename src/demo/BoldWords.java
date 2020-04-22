package demo;

import java.util.Arrays;

/**
 * @auther
 */

public class BoldWords {

    public static void main(String[] args) {
        BoldWords b = new BoldWords();
        System.out.println(b.addBoldTag("aaabbcc", new String[]{"aaa", "aab", "bc"}));
    }
    public String addBoldTag(String s, String[] dict) {
        boolean[] isBold = new boolean[s.length()];
        for (String str: dict) {
            if(str.length() == 0) continue;
            int start = 0;
            while (s.indexOf(str, start) != -1) {
                int index = s.indexOf(str, start);
                int endIndex = index + str.length();
                Arrays.fill(isBold, index, endIndex, true);
                start = index + 1;
            }
        }

        int i = 0;
        boolean bold = isBold[0];
        StringBuilder r = new StringBuilder(bold ? "<b>" : "");
        while (i < s.length()) {
            char c = s.charAt(i);
            if (isBold[i]) {
                if (!bold) {
                    r.append("<b>");
                    bold = true;
                }
            } else {
                if (bold) {
                    r.append("</b>");
                    bold = false;
                }
            }
            r.append(c);
            i++;
        }
        if(bold) r.append("</b>");
        return r.toString();
    }
}
