package demo.strings;

/**
 * @auther
 */

public class Permutation {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.printAllPermutation("cart");
    }
    public void printAllPermutation(String s) {
        helper("", s);
    }

    private void helper(String s, String s1) {
       for (int i = 0; i < s1.length(); i++) {
           helper(s + s1.charAt(i), s1.substring(0, i) + s1.substring(i+1));
       }
       if (s.length() == 4) {
           System.out.println(s);
       }
    }
}
