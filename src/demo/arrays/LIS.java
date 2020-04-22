package demo.arrays;

import java.util.ArrayList;

/**
 * @auther
 */

public class LIS {
    public int lengthOfLIS(int[] arr) {
        if (arr.length == 0 || arr == null)
            return 0;

        ArrayList<Integer> al = new ArrayList<>();

        for (int n : arr) {
            if (al.size() == 0) {
                al.add(n);
            } else if (n > al.get(al.size() - 1)) {
                al.add(n);
            } else {
                int i = 0;
                int j = al.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    if (n > al.get(mid)) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }
                al.set(j, n);
            }
        }
        return al.size();


    }

    public static void main(String[] args) {
        LIS l = new LIS();

        l.lengthOfLIS(new int[]{10,2,5,3,4});
    }

}
