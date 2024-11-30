public class DisjointSet {
    int[] parent;
    int[] sz;

    DisjointSet(int n) {
        parent = new int[n];
        sz = new int[n];
        for (int k = 0; k < n; k++) {
            parent[k] = k;
            sz[k] = 1;
        }
    }

    int root(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }


    public void link(int x, int y) {
        int rootX = root(x), rootY = root(y);
        if (sz[rootX] <= sz[rootY]) {
            parent[rootX] = rootY;
            sz[rootY] += sz[rootX];
        } else {
            parent[rootY] = rootX;
            sz[rootX] += sz[rootY];
        }
    }


    boolean isConnected(int x, int y) {
        return root(x) == root(y);
    }
}
