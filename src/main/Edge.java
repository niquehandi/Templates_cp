
/*
FULL TEMPLATE FOR EDGE and UNIONFIND 
https://github.com/niquehandi/Templates_cp
*/

private static class Edge{
        int u,v, length;

        public Edge(int u, int v, int length){
            this.u = u;
            this.v = v;
            this.length = length;
        }
    }

    private static class unionFind{
        int[] parent, rank;

        unionFind(int n){
            parent = new    int[n+1];
            rank = new int[n + 1];
            for (int i = 0;i <= n;i++){
                parent[i] = i;
            }
        }
        int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY){
                return false;
            }
            if (rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }
            if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }
