class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0; i<n; i++){
            if(gas[i] >= cost[i]){
                boolean[] visited = new boolean[n];
                if(dfs(i, gas, cost, n, visited)){
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean dfs(int index, int[] gas, int[] cost, int n, boolean[] visited){
        int gasLeft = 0;
        
        while(!visited[index]){
            visited[index] = true;
            gasLeft = gasLeft + gas[index] - cost[index];
            if(gasLeft < 0){
                return false;
            }

            if(index+1 == n){
                index = 0;
            }
            else{
                index++;
            }
        }
        return true;
    }
}
