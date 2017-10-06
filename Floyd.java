public class Floyd {
    static class Graph{
        final int INF = Integer.MAX_VALUE;
        int[] vecs;
        int[][] weight;
        int edgeNum;
        public Graph(int n){
            vecs = new int[n];
            weight = new int[n][n];
            edgeNum = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j)
                        weight[i][j] = 0;
                    else
                        weight[i][j] = INF;
                }
            }
        }
        public void insert(int i, int j, int w){
            weight[i][j] = w;
            edgeNum++;
        }
        public void dijkstra(){
            int temp;
            int n = vecs.length;
            for(int k=0; k<n; k++){
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        //防止溢出
                        if(weight[i][k]!=INF && weight[k][j]!=INF){
                            temp = weight[i][k]+weight[k][j];
                            if(temp < weight[i][j])
                                weight[i][j] = temp;
                        }
                    }
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(weight[i][j]+"\t");
                }
                System.out.println();
            }
        }
    }
    public static void main(String args[]){
        int vecnum = 7;
        Graph g = new Graph(vecnum);
        g.insert(0,1,12);
        g.insert(0,5,16);
        g.insert(0,6,14);
        g.insert(1,2,10);

        g.insert(1,5,7);
        g.insert(2,3,3);
        g.insert(2,4,5);
        g.insert(2,5,6);

        g.insert(3,4,4);
        g.insert(4,5,2);
        g.insert(4,6,8);
        g.insert(5,6,9);




        g.insert(1, 0,12);
        g.insert(5, 0,16);
        g.insert(6, 0,14);
        g.insert(2, 1,10);

        g.insert(5, 1,7);
        g.insert(3, 2,3);
        g.insert(4, 2,5);
        g.insert(5, 2,6);

        g.insert(4, 3,4);
        g.insert(5, 4,2);
        g.insert(6, 4,8);
        g.insert(6, 5,9);
        g.dijkstra();
    }
}
