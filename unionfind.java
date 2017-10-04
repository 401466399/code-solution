import java.util.*;
public class unionfind {

    static class UF{
        private int[] id;
        private int[] size;
        private int group_num;
        public UF(int N){
            this.group_num = N;
            id = new int[N];
            size = new int[N];
            for(int i=0; i< N ;i++){
                id[i] = i;
                size[i]=1;
            }
        }
        public int getGroup_num() {
//            获取连通分量个数
            return group_num;
        }
        public boolean connected(int i, int j){
            return find(i)==find(j);
        }

//实现1 id[]直接存储组号
//        public int find(int i){
//            return id[i];
//        }
//        public void union(int i, int j){
//            // 获得p和q的组号
//            int i_id = find(i);
//            int j_id = find(j);
//            // 如果两个组号相等，直接返回
//            if(i_id == j_id){ return;
//            }else{
//                // 遍历一次，改变组号使他们属于一个组
//                for(int k=0; k<id.length; k++){
//                    if(id[k]==i_id){ id[k] = j_id; }
//                }
//            }
//            group_num--;
//        }
//实现2 id[]存储父亲
        public int find(int i){
            // 寻找p节点所在组的根节点，根节点具有性质id[root] = root
            // 路径压缩，也可以多压缩几层。
            while(i!=id[i]){
                id[i]=id[id[i]];
                i = id[i];
            }
            return i;
        }

        public void union(int i, int j){
//将轻的作为子树
             int i_id = find(i);
             int j_id = find(j);
             if(i_id==j_id) return;
             else{
                 if(size[i_id]<size[j_id]){
                     id[i_id]=j_id;
                     size[j_id] = size[j_id]+size[i_id];
                 } else{
                     id[j_id] = i_id;
                     size[i_id] = size[i_id]+size[j_id];
                 }
             }
             group_num--;
        }
    }


    public static void main(String[] args) {

        String line;
        String[] items;
        Scanner s = new Scanner(System.in);

        line = s.nextLine();
        items = line.split("\\s+");

        UF uf = new UF(Integer.valueOf(items[0]));
        int m = Integer.valueOf(items[1]);

        for(int i=0; i< m; i++){
            line = s.nextLine();
            items = line.split("\\s+");
            uf.union(Integer.valueOf(items[0]),Integer.valueOf(items[1]));
        }
        if(uf.getGroup_num()==1){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }


    }
}
