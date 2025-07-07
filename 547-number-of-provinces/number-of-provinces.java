class Solution {
    public void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;
        for(int a : adj.get(node))
        {
            if(vis[a]==0)
            {
                dfs(a,vis,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 && i!=j) adj.get(i).add(j);
            }
        }
        int c=0;
        int[] vis=new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,adj);
                c++;
            }
        }
        return c;
    }
}