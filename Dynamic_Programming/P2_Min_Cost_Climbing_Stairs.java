class Solution {
    private int minCostClimbingStairsHelperIterative(int[] cost) {
        int n = cost.length;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = cost[0];
        for(int i = 2; i <= n; i++) {
            arr[i] = cost[i-1] + Math.min(arr[i-1], arr[i-2]);
        }
        return Math.min(arr[n], arr[n-1]);
    }

    private int minCostClimbingStairsHelperIterativeOptimized(int[] cost) {
        int n = cost.length;
        int a = 0, b = cost[0], c = cost[0];
        for(int i = 2; i <= n; i++) {
            c = cost[i-1] + Math.min(a, b);
            a = b;
            b = c;
        }
        return Math.min(a, b);
    }

    public int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairsHelperIterativeOptimized(cost);
    }
}