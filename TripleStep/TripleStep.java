package TripleStep;

// Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
// steps at a time, implement a method to count how many possible ways the child can run up the
// stairs.
public class TripleStep {
    // public static int tripleStep(int n) {
    //     if(n<0){
    //         return 0;
    //     }
    //     else if (n==1||n==0){
    //         return 1;
    //     }else{
    //         return tripleStep(n-1)+tripleStep(n-2)+tripleStep(n-3);
    //     }
    // }

    public static int tripleStep(int n) {
    if (n < 0) return 0;
    if (n == 0 || n == 1) return 1;
    if (n == 2) return 2;

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    return dp[n];
}

    public static void main(String[] args) {
        int n = 30;
        System.out.println(tripleStep(n));
    }
}
