class Solution {
    private int climbStairsHelperRecursive(int n) {
        if(n < 0) return 0;
        if(n <= 1) return 1;
        return climbStairsHelperRecursive(n-1) + climbStairsHelperRecursive(n-2);
    }

    private int climbStairsHelperIterative(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    private int climbStairsHelperIterativeOptimized(int n) {
        int a = 1, b = 1, c = 1;
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int climbStairs(int n) {
        return climbStairsHelperIterativeOptimized(n);
    }
}