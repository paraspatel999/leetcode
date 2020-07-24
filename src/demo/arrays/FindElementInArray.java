package demo.arrays;

/**
 * @auther
 */

public class FindElementInArray {

    public static void main(String[] args) {
        FindElementInArray f = new FindElementInArray();
        int[] a = {4,6,7,8,10,3};
        System.out.println(f.search(a, 10));
    }
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        return findElement(nums, 0, nums.length - 1, target);
    }

    private int findElement(int[] nums , int i, int j, int target) {

        while ( i <= j) {

            int mid = i +  (j - i)/2;

            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[i]) {
                if (target >= nums[i] && target <= nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (target <= nums[j] && target > nums[mid] ) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
       return -1;
    }
}
