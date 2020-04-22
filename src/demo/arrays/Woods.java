package demo.arrays;

/**
 * @auther
 */

public class Woods {

    public boolean isValid(int[] wood, int cutLength, int k){
        int count = 0;
        for(int w: wood){
            count += w / cutLength;
        }
        return count >= k;
    }
    public int cutWood(int[] wood, int k){
        // corner cases:
        if(wood.length == 0 || k == 0) return 0;
        int left = 1, right = Integer.MAX_VALUE;
        int res = 0;
        if(!isValid(wood, left, k)) return 0;
        while(left < right){
            int mid = left + (right - left)/2;
            boolean valid = isValid(wood, mid, k);
            if(valid){
                left = mid + 1;
                res = mid;
            }
            else
                right = mid;
        }
        return res;
    }

    public static void main(String[] args) {
        Woods w  = new Woods();
        int[] ar = {5,9,7};
       // w.cutWood(ar, 3);
        double baseCostDailyAmount = 100 * (12.48 - (9 + 8) / (100 + 28.25));
        System.out.println(baseCostDailyAmount);

    }
}
