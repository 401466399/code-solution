package review;

import java.util.*;

public class GraphSearch {
    static class Graph{
        List<Object> nodelist;
        boolean[] visit;
        int[][] edgeWeight;
        int nodeNum;
        int edgeNum;
//        int INF = Integer.MAX_VALUE;

        public Graph(int n) {
            nodeNum = n;
            visit = new boolean[n];
            nodelist = new ArrayList<>();
            edgeWeight = new int[n][n];
            edgeNum = 0;
        }

        public void insertNode(Object i) {
            nodelist.add(nodelist.size(), i);
        }

        public void insertEdge(Object i, Object j, int weight) {
            int i_index = nodelist.indexOf(i);
            int j_index = nodelist.indexOf(j);
            edgeWeight[i_index][j_index] = weight;
            edgeNum++;
        }

        public int hasNoVisitSon(Object now){
            int index_now = nodelist.indexOf(now);
            for(int i=0; i<nodeNum; i++){
                if(edgeWeight[index_now][i]!=0 && visit[i]==false)
                    return i;
            }
            return -1;
        }
        public void WFS(Object start){
            Queue<Object> q = new PriorityQueue<>();
            q.add(start);
            Object now = start;
            visit[nodelist.indexOf(now)] = true;
            while(!q.isEmpty()){
                now = q.poll();
                System.out.println(now);
                for(int i=0; i< nodeNum; i++){
                    if(edgeWeight[nodelist.indexOf(now)][i]!=0 && visit[i]==false){
                        q.add(nodelist.get(i));
                        visit[i] = true;
                    }
                }
            }
        }
        public void DFS(Object start){
            Object now = start;
            int status;
            Stack<Object> s = new Stack<>();
            s.add(start);
            System.out.println(start);
            visit[nodelist.indexOf(start)] = true;
            while (true){
                status = hasNoVisitSon(now);
                while(status!=-1){
                    s.add(nodelist.get(status));
                    visit[status] = true;
                    System.out.println(nodelist.get(status));
                    now = nodelist.get(status);
                    status = hasNoVisitSon(now);
                }
                if(!s.empty()){
                    s.pop();
                    if(!s.empty()){
                        now = s.peek();
                    }else{
                        return;
                    }
                }else{
                    return;
                }

            }


        }

    }

    public static void main(String Args[]) {
        String[] labels = {"node0", "node1", "node2", "node3", "node4", "node5", "node6", "node7"};
        Graph graph = new Graph(8);
        for (String label : labels) {
            graph.insertNode(label);
        }
        //插入九条边
        graph.insertEdge("node0", "node1", 1);
        graph.insertEdge("node0", "node2", 1);
        graph.insertEdge("node1", "node3", 1);
        graph.insertEdge("node1", "node4", 1);
        graph.insertEdge("node3", "node7", 1);
//        graph.insertEdge(4, 7, 1);
        graph.insertEdge("node2", "node5", 1);
        graph.insertEdge("node2", "node6", 1);
        graph.insertEdge("node5", "node6", 1);
        graph.insertEdge("node1", "node0", 1);
        graph.insertEdge("node2", "node0", 1);
        graph.insertEdge("node3", "node1", 1);
        graph.insertEdge("node4", "node1", 1);
        graph.insertEdge("node7", "node3", 1);
//        graph.insertEdge(7, 4, 1);
        graph.insertEdge("node6", "node2", 1);
        graph.insertEdge("node5", "node2", 1);
        graph.insertEdge("node6", "node5", 1);

        System.out.println("深度优先搜索序列为：");
//        graph.DFS("node0");
        System.out.println();
        graph.WFS("node0");

    }
}
