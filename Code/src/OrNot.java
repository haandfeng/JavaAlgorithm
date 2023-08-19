public class OrNot {
    // 交换arr的i和j位置上的值
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    // arr中，只有一种数，出现奇数次吗,其他数都出现了偶数次，打印这个数
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }
    //怎么把一个int类型的数，提取出最右侧的1来
    // a 和 b是两种数
    // eor != 0
    // eor最右侧的1，提取出来
    // eor :     00110010110111000
    // rightOne :00000000000001000
    // int rightOne = eor & (-eor); // 提取出最右的1
    public static int bit1counts(int N) {

    }
}
