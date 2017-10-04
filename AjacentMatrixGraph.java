import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AjacentMatrixGraph {
    static class Graph {
        ArrayList<Object> nodelist;
        int[][] edgeWeight;
        int[][] visited;
        int edgeNum;

        public Graph(int n) {
            nodelist = new ArrayList<>(n);
            edgeWeight = new int[n][n];
            edgeNum = 0;
        }

        public void insertNode(Object i) {
            nodelist.add(nodelist.size(), i);
        }

        public void insertEdge(int i, int j, int weight) {
            edgeWeight[i][j] = weight;
            edgeNum++;
        }

        public int getFirstAjacent(int i) {
            for (int j = 0; j < nodelist.size(); j++) {
                if (edgeWeight[i][j] > 0) {
                    return j;
                }
            }
            return -1;
        }

        public int getNextAjacent(int i, int v) {
            for (int j = v + 1; j < nodelist.size(); j++) {
                if (edgeWeight[i][j] > 0) {
                    return j;
                }
            }
            return -1;
        }

        //连通图,相当于二叉树的先序遍历 isVisited标识是否遍历。
        private void depthFirsrSearchR(boolean[] isVisited, int i) {
            System.out.println(i);
            isVisited[i] = true;
            int j = getFirstAjacent(i);
            while (j != -1) {
                if(!isVisited[j]){
                    depthFirsrSearchR(isVisited, j);
                }
                j = getNextAjacent(i, j);
            }
        }



        //连通图,相当于二叉树的层次遍历 isVisited用来标识是否放到队列中。
        private void broadFirstSearch(boolean[] isVisited, int i) {
            Queue<Integer> q = new PriorityQueue<>();
            q.add(i);
            isVisited[i] = true;
            int now;
            int adj;
            while(!q.isEmpty()){
                now = q.poll();
                System.out.println(now);
                adj = getFirstAjacent(now);
                while(adj != -1){
                    if(!isVisited[adj]){
                        q.add(adj);
                        isVisited[adj]=true;
                    }
                    adj = getNextAjacent(now, adj);
                }
            }

        }


        // 非连通图
        public void depthFirstSearch() {
            boolean[] isVisited = new boolean[nodelist.size()];
            for (int k = 0; k < nodelist.size(); k++) {
                if (!isVisited[k]) {
                    depthFirsrSearchR(isVisited, k);
                }
            }
        }


        // 非连通图
        public void broadFirstSearch() {
            boolean[] isVisited = new boolean[nodelist.size()];
            for (int k = 0; k < nodelist.size(); k++) {
                if (!isVisited[k]) {
                    broadFirstSearch(isVisited, k);
                }
            }
        }
    }


    public static void main(String Args[]){
        String[] labels = {"node0", "node1", "node2", "node3", "node4", "node5", "node6", "node7"};
        Graph graph = new Graph(8);
        for(String label:labels) {
            graph.insertNode(label);
        }
        //插入九条边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
//        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);
        graph.insertEdge(7, 3, 1);
//        graph.insertEdge(7, 4, 1);
        graph.insertEdge(6, 2, 1);
        graph.insertEdge(5, 2, 1);
        graph.insertEdge(6, 5, 1);

        System.out.println("深度优先搜索序列为：");
        graph.depthFirstSearch();
        System.out.println();
        System.out.println("广度优先搜索序列为：");
        graph.broadFirstSearch();

    }

}


