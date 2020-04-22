package demo.graph;

/**
 * @auther
 */

public class NumOfShop {

    public int numberAmazonTreasureTrucks(int m, int n,
                                   int[][] ar)
    {
        int count = 0;
        for (int i = 0; i< ar.length; i++) {
            for (int j =0; j < ar[i].length; j++) {
                if (ar[i][j] == 1) {
                    traverse(ar, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void traverse(int[][] ar, int i, int j) {

        if (ar[i][j] == 0) return;
        ar[i][j] = 0;
        if (i - 1 >= 0) {
            traverse(ar, i -1, j);
        }
        if (i + 1 < ar.length) {
            traverse(ar, i +1, j);
        }
        if (j - 1 >= 0) {
            traverse(ar, i, j -1);
        }
        if (j + 1 < ar[i].length) {
            traverse(ar, i , j + 1);
        }
    }

    public static void main(String[] args) {
        NumOfShop s = new NumOfShop();
        System.out.println(s.numberAmazonTreasureTrucks(4,4, new int[][]{
                {1,1,1,0},
                {0,0,0,0},
                {1,1,1,0},
                {0,0,0,1}
        }));
    }
}
