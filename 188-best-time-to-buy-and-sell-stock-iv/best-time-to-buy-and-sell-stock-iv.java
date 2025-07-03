class Solution {
     public int f(int i,int buy,int t,int[] prices,int[][][] dp)
    {
        if(i==prices.length || t==0) return 0;
        if(dp[i][buy][t]!=-1) return dp[i][buy][t];
        int profit=0;
        if(buy==1)
        {
            profit = Math.max((-prices[i]+f(i+1,0,t,prices,dp)),0+f(i+1,1,t,prices,dp));
        }else{
            profit = Math.max((prices[i]+f(i+1,1,t-1,prices,dp)),0+f(i+1,0,t,prices,dp));
        }
        return dp[i][buy][t]=profit;
    }   
    public int maxProfit(int k,int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for(int[][] a:dp)
        {
            for(int[] b:a)
            {
                Arrays.fill(b,-1);
            }
        }
        int ans=f(0,1,k,prices,dp);
        return ans;
    }
}
