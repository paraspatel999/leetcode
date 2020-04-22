package demo.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * @auther
 */

public class NGE {

    public static void main(String[] args) {
        NGE n = new NGE();
        int[] a = {10,2,1,8};
        Arrays.stream(n.getNGE(a)).forEach(x -> System.out.println(x));;
    }

    public int[] getNGE(int[] a) {
        Stack<Pair> data = new Stack<>();
        int[] ans = new int[a.length];
        for (int i =0; i< a.length; i++) {
            while (!data.isEmpty() && data.peek().value < a[i]) {
                int index = data.pop().index;
                ans[index] = a[i];
            }
            data.push(new Pair(a[i], i));
        }
        while (!data.isEmpty()) {
            int index = data.pop().index;
            ans[index] = -1;
        }
        return ans;
    }

    class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
