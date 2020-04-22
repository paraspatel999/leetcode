package demo.arrays;

/**
 * @auther
 */

public class FindElementInArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        return findElement(nums, 0, nums.length - 1, target);
    }

    private int findElement(int[] nums , int i, int j, int target) {
        if (i < j) {
            return -1;
        }
        int mid = (i + j)/2;

        if (nums[mid] == target) return mid;

        if (nums[mid] >= nums[i]) {
            if (target >= nums[i]) {
                return findElement(nums, i, mid - 1, target);
            }
            return findElement(nums, mid + 1, j, target);
        }
        if (nums[i] <= target || target < nums[mid]) return findElement(nums, i, mid -1, target);
        return findElement(nums, mid + 1, j, target);
    }
}
