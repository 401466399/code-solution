public class Bellman_Ford {
//    例题链接
//    http://blog.csdn.net/tengweitw/article/details/17451125
    static class Graph{
        int[][] weight;
        int[] vecs;
        int nodesNum;
        public Graph(int n){
            this.nodesNum = n;
            vecs = new int[n];
            weight = new int[n][n];
        }
        public void insertEdge(int i, int j, int w){
            weight[i][j] = w;
        }

        public void bellman(){
            int[]prev = new int[nodesNum];
        // 节点初始化
            final int INF = Integer.MAX_VALUE;
            int[] nodeValues = new int[nodesNum];
            nodeValues[0] = 0;
            for(int i=1; i<nodesNum; i++){
                nodeValues[i] = INF;
            }
            int temp;
            // 遍历n-1次
            for(int i=0; i<nodesNum-1; i++){
               //  遍历每条边
                for(int j=0; j<nodesNum; j++){
                    for(int k=0; k<nodesNum; k++){
                        if(weight[j][k]!=0){
                            temp = nodeValues[j]+weight[j][k];
                            if(temp<nodeValues[k]){
                                nodeValues[k] = temp;
                                prev[k] = j;
                            }

                        }
                    }
                }
            }

            int ii=0;
            for(int i=0; i<nodesNum; i++){
                System.out.println("节点0到节点"+i+"的距离为: "+ nodeValues[i]);
                System.out.print("路径为：");
                ii = i;
                while(prev[ii]!=0){
                    System.out.print(prev[ii]+"   ");
                    ii = prev[ii];
                }
                System.out.print(i);
                System.out.println();
                //输出的路径是倒着的哦。
            }


            // 判断是否有负权环
            for(int j=0; j<nodesNum; j++){
                for(int k=0; k<nodesNum; k++){
                    if(weight[j][k]!=0){
                        temp = nodeValues[j]+weight[j][k];
                        if(temp<nodeValues[k])
                            System.out.println("there is negative weight circle");
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(5);
        g.insertEdge(0,1,6);
        g.insertEdge(0,2,7);

        g.insertEdge(1,3,5);
        g.insertEdge(1,2,8);
        g.insertEdge(1,4,-4);

        g.insertEdge(2,3,-3);
        g.insertEdge(2,4,9);

        g.insertEdge(3,1,-2);

        g.insertEdge(4,3,7);
        g.insertEdge(4,0,2);
        g.bellman();
    }
}
