import java.util.ArrayList;
import java.util.List;

public class Prim {
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
        public void prim(int start){
            //节点列表
            //u集合
            List<Integer> u = new ArrayList<>();
            List<Integer> v = new ArrayList<>();
            List<String> edgelist = new ArrayList<>();
            u.add(0);
            //v集合
            for(int i=0; i<vecNum-1; i++){
                v.add(i+1);
            }
            String temp="";
            int temp_vec = -1;
            int i_index, j_index;
            int min;

            //选择边
            while(u.size()!=vecNum){
                min = Integer.MAX_VALUE;
                for(int i=0; i<u.size(); i++){
                    for(int j=0; j<v.size(); j++){
                        i_index = u.get(i);
                        j_index = v.get(j);
                        if(weight[i_index][j_index]!=0){
                            if(weight[i_index][j_index]<min){
                                min = weight[i_index][j_index];
                                temp_vec = j_index;
                                temp = String.valueOf(i_index)+" : "+String.valueOf(j_index);
                            }
                        }
                    }
                }
                // 按照值删除。。默认按索引删除了
                v.remove(Integer.valueOf(temp_vec));
                //
                u.add(temp_vec);
                edgelist.add(temp);
            }
            for(String s:edgelist) {
                System.out.println(s);
            }
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

        g.prim(0);

    }

}
