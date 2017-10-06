public class Dijkstra {
    static class Graph{
        //邻接矩阵实现
        int edgeNum;  //边数量
        int[] vecs;   //顶点集合
        int[][] weight;  //边权重
        final int INF = Integer.MAX_VALUE;
        public Graph(int n){
            vecs = new int[n];
            weight = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j)
                        weight[i][j] = 0;
                    else
                        weight[i][j] = INF;
                }
            }
            edgeNum = 0;
        }
        void insertEdge(int u, int v, int w){
            weight[u][v]= w;
            edgeNum++;
        }


        /**
         *prev[] 已经确定到start节点的最短路径的节点集合，第一个是vecStart
         * dist[] 到start节点的最短路径
         */
        void DijkstraAl(int vecStart, int[] prev, int[] dist){
            int j=0;
            boolean[] flag = new boolean[prev.length];
            flag[vecStart] = true;
            weight[vecStart][vecStart] = 0;
            // 更新dist为 weight[vecStart][i]
            dist = weight[vecStart];

            int min,vec,newdist;
            for(int k=0; k<prev.length-1; k++){

                // 从dist找不在prev中的节点的最小值，将其节点j加入prev, falg为true
                min = INF;
                vec = -1;
                for(int i=0; i<prev.length; i++){
                    if(flag[i]==false && dist[i]< min){
                        min = dist[i];
                        vec = i;
                    }
                }
                prev[++j] = vec;
                flag[vec] = true;

                // 更新dist，如果dist[j]+weight[j][k] < dist[k]
                for(int i=0; i<prev.length; i++){
                    if(weight[vec][i]!=INF){
                        newdist = dist[vec]+weight[vec][i];
                        if(newdist<dist[i]){
                            dist[i] = newdist;
                        }
                    }

                }
            }
            for (int disti:dist) {
                System.out.println(disti);
            }
        }

    }

    public static void main(String[] args){
        int vecNum = 6;
        Graph g = new Graph(vecNum);
        g.insertEdge(0,1,1);
        g.insertEdge(0,2,12);
        g.insertEdge(1,2,9);

        g.insertEdge(1,3,3);
        g.insertEdge(2,4,5);
        g.insertEdge(3,2,4);

        g.insertEdge(3,5,15);
        g.insertEdge(3,4,13);
        g.insertEdge(4,5,4);

        int[] prev = new int[vecNum];
        int[] dist = new int[vecNum];
        prev[0] = 0;

        g.DijkstraAl(0, prev, dist);

    }

}
