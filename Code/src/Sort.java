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
// 非递归方法实现
    public static void mergeSort2(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return;
//        }
//        int step=1;
//        int L,M,R=-1;
//        while (step<= arr.length/2){
//             L = 0;
//            while (R<arr.length){
//                L= R+1;
//                M = L+step-1;
//                if(  M+step<arr.length){
//                    R = M+step;
//                }
//                else {
//                    R = arr.length-1;
//                }
//                merge_self(arr,L,M,R);
//            }
//            step = step<<1;
//        }
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;// 当前有序的，左组长度
        // 一组是2倍的mergeSize
        while (mergeSize < N) { // log N
            int L = 0;
            // 0....
            while (L < N) {
                // L...M  左组（mergeSize）
                int M = L + mergeSize - 1;
                if (M >= N) { // 当前组凑不齐,只有左边, 肯定有序
                    break;    // 预防越界风险
                }
                //  L...M   M+1...R(mergeSize)
                // 有可能最后一组右组数目不够
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1; // 下一次左组
            }
            // 防止溢出, INT_MAX
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }
    public static void merge_self(int[] arr, int L, int M, int R) {
        int [] copy = new int [L-R+1];
        int p1= L;
        int p2 = M+1;
        int index=0;
        while (p1<=M && p2<= R){
            copy[index++] = arr[p1] <= arr[p2] ? arr[p1++]:arr[p2++];
        }
        while (p1<=M){
            copy[index++] = arr[p1++];
        }
        while (p2<=R){
            copy[index++]= arr[p2++];
        }
        for(int i =0;i<L-R+1;i++){
            arr[L+i] =copy[i];
        }
    }

}
