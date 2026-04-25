class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=0; i<n+1; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge:edges){
            if(!union(edge[0], edge[1], parent, rank)){
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }

    private boolean union(int a, int b, int[] parent, int[] rank){
        int parentA = find(a, parent);
        int parentB = find(b, parent);

        if(parentA == parentB){
            return false;
        }
        else if(rank[parentA] > rank[parentB]){
            parent[parentB] = parentA;
            rank[parentA] += rank[parentB];
        }
        else{
            parent[parentA] = parentB;
            rank[parentB] += rank[parentA];
        }
        return true;
    }

    private int find(int a, int[] parent){
        if(a == parent[a]){
            return a;
        }
        return find(parent[a], parent);
    }
}


// Time Complexity = O(V + (E + @(V)))
// Space Complexity = O(V)

// Amortized Complexity
// It means the average cost per operation over a sequence of operations — not the cost of a single operation.

// Analogy
// Think of a phone battery:
// Most days  → 0 mins to charge (already charged)
// Once a week → 60 mins to charge

// Amortized daily cost = 60/7 ≈ 9 mins/day
// Any single day looks cheap, but occasionally you pay a big cost. Amortized spreads that big cost across all days.