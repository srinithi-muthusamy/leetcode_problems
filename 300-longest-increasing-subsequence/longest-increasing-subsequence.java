class Solution {
     public int f(int i,int prev,int[] nums,int[][] dp)
    {
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int notpick=0+f(i+1,prev,nums,dp);
        int pick=0;
        if(prev==-1 || nums[prev]<nums[i])
        {
            pick=1+f(i+1,i,nums,dp);
        }
        return dp[i][prev+1]=Math.max(pick,notpick);
        
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
        int ans=f(0,-1,nums,dp);
        return ans;
    }
}