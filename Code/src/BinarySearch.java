public class BinarySearch {
    // 找某一个数
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        // L..R
        while (L < R) { // L..R 至少两个数的时候
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }
    // 在arr上，找满足>=value的最左位置
//    public static int nearestIndex(int[] arr, int value) {
//        if (arr==null ||arr.length==0){
//            return -1;
//        }
//        int L=0;
//        int R= arr.length-1;
//        int mid =0;
//        while (L<R){
//            mid =L+((R-L)>>2);
//        }
//    }
    public static int getLessIndex(int[] arr) {
        if( arr==null || arr.length==0 ){
            return -1;
        }
        if (arr.length==1){
            return arr[0];
        }
        else {
            if (arr[0]<arr[1]){
                return arr[0];
            }
            if (arr[arr.length-1]<arr[arr.length-2]){
                return arr[arr.length-2];
            }
            int L=0;
            int R=arr.length-1;
            int mid =0;
            while (L<R){
                mid =L +((R-L)>>2);
                if(arr[mid]<arr[mid+1]&arr[mid]<arr[mid-1]){
                    return
                }
            }
        }

    }
}
