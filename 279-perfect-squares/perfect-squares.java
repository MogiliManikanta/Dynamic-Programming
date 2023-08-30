class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int resultTemp = Integer.MAX_VALUE;
            int j=1;
            while(i-j*j >=0){
                resultTemp = Math.min(resultTemp,dp[i-j*j]+1);
                ++j;
            }
            dp[i]=resultTemp;
        }
        return dp[n];
    }
}