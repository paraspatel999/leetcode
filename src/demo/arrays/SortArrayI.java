package demo.arrays;

import java.util.Arrays;

/**
 * @auther
 */

public class SortArrayI {

    public static void main(String[] args) {
        SortArrayI s = new SortArrayI();
        Arrays.stream(s.sortChunks(new int[]{1,3,5,2,4,10,20,30,11,12,13})).forEach(x -> System.out.print(x + " "));
    }
    public int[] sortChunks(int[] nums) {
        int j = 1;

        while (j < nums.length) {
            if (nums[j-1] < nums[j]) {
                j++;
            } else {
                int s2 = j;
                while (++j < nums.length) {
                    if (nums[j-1] > nums[j]) {
                        sortChunk(nums, 0, s2-1, s2, j-1);
                        s2 = j;
                    }
                }
                sortChunk(nums, 0, s2-1, s2, j-1);
            }
        }
        return nums;
    }

    private void sortChunk(int[] nums, int s1, int e1, int s2, int e2) {
        int k = 0;
        int[] res = new int[e2 + 1];
        while (s1 <= e1 && s2 <= e2) {
            if (nums[s1] < nums[s2]) {
                res[k] = nums[s1];
                s1++;
            } else {
                res[k] = nums[s2];
                s2++;
            }
            k++;
        }

        while (s1 <= e1) {
            res[k++] = nums[s1++];
        }

        while (s2 <= e2) {
            res[k++] = nums[s2++];
        }
        System.arraycopy(res, 0, nums, 0, k);
    }

}
