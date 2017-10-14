package review;

public class Search {
    static void exchange(int[] a, int i, int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void merge(int[] a, int start, int mid, int mid1, int end){
        int[] temp = new int[end-start+1];
        int i=0;
        int start_ = start;
        while (start<=mid && mid1<=end){
            temp[i++] = (a[start]<=a[mid1])?a[start++]:a[mid1++];
        }
        if(start<=mid){
            for(int j=start; j<=mid; j++){
                temp[i++] = a[j];
            }
        }
        if(mid1<=end){
            for(int j=mid1; j<=end; j++){
                temp[i++] = a[j];
            }
        }
        for(int k=start_; k<=end;k++){
            a[k] = temp[k-start_];
        }
    }
    public static void mergeSort(int[] a,int start, int end){
        if(start>=end)return;
        int mid = (start+end)/2;
        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);
        merge(a,start,mid,mid+1,end);
    }
    public static int partition(int[] a, int start, int end){
        int base = a[start];
        int left = start+1;
        int right = end;
        while(left<=right){
            while(a[left]<base && left<=right)left++;
            while(a[right]>=base && left<=right) right--;
            if(left<right)
                exchange(a,left,right);
        }
        exchange(a,start,left-1);
        return left-1;
    }
    public static void quickSort(int[] a,int start, int end){
        if(start>=end) return;
        int baseIndex = partition(a,start,end);
        quickSort(a,start,baseIndex-1);
        quickSort(a,baseIndex+1,end);
    }
    static void MaxHeap(int[] a,int n){
        int maxPos,left,right;
        // 遍历非叶子节点,调整得到最大堆。
        for(int i=(n-2)/2; i>=0; i--){
            left = 2*i+1;
            right = 2*i+2;
            maxPos = left;
            // 看是否有右儿子
            if(right<n){
                //从左儿子，右儿子以及自己，中找最大的，替换数据。
                if(a[left]>a[right]){
                    maxPos = left;
                }else maxPos = right;
            }
            if(a[i]<a[maxPos])
                exchange(a,i,maxPos);
        }

    }
    static public void HeapSort(int[] a){
        // 堆化n-1次
        for(int i=a.length; i>1; i--){
            MaxHeap(a,i);
            exchange(a,0,i-1);
        }
    }
    public static void main(String[] args){
        int[] a = {7,4,2,5,3,1,8,9,20};
//        HeapSort(a);
//        quickSort(a,0,a.length-1);
        mergeSort(a,0,a.length-1);
        for(int i=0; i<a.length; i++){System.out.println(a[i]);}
//        MacHeap(a);
//        System.out.println(a[0]);
    }
}
