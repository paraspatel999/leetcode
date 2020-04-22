package demo.arrays;

/**
 * @auther
 */

public class MaxFruit {

    class ValidFruit {
        Integer f1 = null;
        Integer f2 = null;
        int max = 0;
        int lastIndex;
        int counter = 0;

        public ValidFruit(int lastIndex) {
            this.lastIndex = lastIndex;
        }

        public void addNum(int newValue, int index) {


            if (f1 == null) {
                f1 = newValue;
                counter++;
                max = Math.max(max, counter);
                return;
            }
            if (f2 == null) {
                f2 = newValue;
                counter++;
                max = Math.max(max, counter);
                return;
            }

            if (f2 == newValue) {
                counter++;
            } else if (f1 == newValue) {
                counter++;
                swap();
                lastIndex = index;
            } else {
                f1 = f2;
                f2 = newValue;
                counter = index - lastIndex;
                lastIndex = index;
            }
            max = Math.max(max, counter);
        }

        public void reset(int index) {
            f1 = null;
            f2 = null;
            max = Math.max(max, counter);
            counter = 0;
            lastIndex = index + 1;
        }

        public void swap() {
            Integer temp = f2;
            f2 = f1;
            f1 = temp;
        }
    }
    public int totalFruit(int[] tree) {

        ValidFruit v = new ValidFruit(0);
        int max = 0;
        for (int k =0; k < tree.length; k++) {
            if (tree[k] == 0) {
                max = Math.max(max, v.max);
                v = new ValidFruit(k);
            }
            v.addNum(tree[k], k);
        }
        return Math.max(max, v.max);
    }

    public static void main(String[] args) {
        MaxFruit m = new MaxFruit();

        System.out.println(m.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
