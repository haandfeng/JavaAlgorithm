public class Sort {
    public static  void swap(int[] arr, int i, int j)
    {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] =temp;
    }
    public static void SelectionSort(int [] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i =0; i<arr.length-1; i++)
        {
            int min = i;
            for (int j =i+1;j<arr.length;j++){
                if (arr[min]<arr[j]){
                    min =j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
    }
    public static void  BubbleSort(int [] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i =0; i<arr.length-1; i++) {
            for (int j =arr.length-1 ;j>i;j--){
                if (arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }

    }
    public  static void InsertionSort(int [] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i=1;i<arr.length;i++){
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }

    }


    // 递归方法实现归并排序
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L...R]范围上，变成有序的
// L...R    N    T(N) = 2*T(N/2) + O(N)  ->
    public static void process(int[] arr, int L, int R) {
        if (L==R){ // base case
            return;
        }
        int M = L+((R-L)>>1);
        process(arr,L,M);
        process(arr,M+1,R);
        merge(arr,L,M,R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        //写的不会
//            int index=0;
//            int mid =M;
//            int l =L;
//            while (L<=mid || M<=R){
//                while (L<=mid && arr[L]<=arr[M+1]){
//                    copy[index++] = arr[L];
//                    L++;
//                }
//                while (M+1<=R &&arr[M+1]<=arr[L])
//                {
//                    copy[index++] = arr[M+1];
//                    M++;
//                }
//                L++;
//            }
//            if (L<=mid)
//            {
//                for(;L<=mid;L++){
//                    copy[index++] = arr[L];
//                }
//            }
//            if(M<=R){
//                for(;M+1<=R;M++){
//                    copy[index++] = arr[M+1];
//                }
//            }
//            for(int i=0;i<copy.length;i++){
//                arr[l]=copy[i];
//            }
//    }
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
    // 非递归版本
    public static void mergeSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int step=1;
        int n =0;
        while (step<arr.length){
            //
            for(int i=0;i<arr.length;i+=step)
            {
                // size = step
                // i he i+step  L= i M=i+step-1 R=i+step+size
                arr[i] =

            }
            step= step<<1;
        }

    }
}
