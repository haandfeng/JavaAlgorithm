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
}
