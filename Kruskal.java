public class Kruskal {
    static class Graph{
        int[][] weight;
        int[] vecs;
        int vecNum;
        int edgeNum;
        public Graph(int n){
            edgeNum = 0;
            weight = new int[n][n];
            vecs = new int[n];
            vecNum = n;
        }
        public void insert(int i, int j, int w){
            weight[i][j] = w;
            edgeNum++;
        }
        public void kruskal(){
            // 对边权重排序
            // 选权值最小的边，判断边前后节点，如果在一个连通分量中，将构成环，需要换其他边，如果不在一个连通分量中，可以加入。然后执行集合的union。

        }
    }
    public static void main(String[] args){
        Graph g = new Graph(7);
        g.insert(0,1,12);
        g.insert(0,3,16);
        g.insert(0,2,14);

        g.insert(1,3,7);
        g.insert(1,4,10);
        g.insert(2,3,9);
        g.insert(2,5,8);

        g.insert(3,4,6);
        g.insert(3,5,2);
        g.insert(4,5,5);
        g.insert(4,6,3);
        g.insert(5,6,4);

        g.insert(1,0,12);
        g.insert(3,0,16);
        g.insert(2,0,14);

        g.insert(3,1,7);
        g.insert(4,1,10);
        g.insert(3,2,9);
        g.insert(5,2,8);

        g.insert(4,3,6);
        g.insert(5,3,2);
        g.insert(5,4,5);
        g.insert(6,4,3);
        g.insert(6,5,4);

        g.kruskal();

    }
    class Edge implements Comparable

    {
        int a;  //边的一个顶点，从数字0开始
        int b;  //边的另一个顶点
        int weight;  //权重

        Edge(int a,int b,int weight){
            this.a=a;
            this.b=b;
            this.weight=weight;
        }

        @Override
        public int compareTo(Object o){
            Edge m = (Edge)o;
            int result=(int)(this.weight - m.weight);
            if(result>0) return 1;
            else if(result==0) return 0;
            else return -1;
        }

    }
}
