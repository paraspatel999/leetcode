package demo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @auther
 */

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        IntStream.of(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    // Skip duplicate numbers of j
                    while (j+1 <= k && arr[j] == arr[j+1]) j++;
                    j++;
                    k--;
                }
            }
            // Skip duplicate numbers of i
            while (i + 1 < n && arr[i + 1] == arr[i]) i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] a = {-1,0,1,2,-1,-4};
        t.threeSum(a);
    }
}
