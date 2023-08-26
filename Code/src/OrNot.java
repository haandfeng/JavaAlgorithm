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
        int count = 0;

        //   011011010000
        //   000000010000     1

        //   011011000000
        while(N != 0) {
            int rightOne = N & ((~N) + 1);
            count++;
            N ^= rightOne;
            // N -= rightOne
        }


        return count;
    }
//    一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
public static void printOddTimesNum2(int[] arr) {
    int eor = 0;
    for (int i = 0; i < arr.length; i++) {
        eor ^= arr[i];
    }
    // a 和 b是两种数
    // eor != 0
    // eor最右侧的1，提取出来
    // eor :     00110010110111000 = a^b.
    // rightOne :00000000000001000
    // 说明两个奇数词的数在该位置一定是一个0和一个1
    int rightOne = eor & (-eor); // 提取出最右的1

    // 找出其中一个
    int onlyOne = 0; // eor'
    for (int i = 0 ; i < arr.length;i++) {
        //  arr[1] =  111100011110000
        // rightOne=  000000000010000
        // arr[i] & rightOne !=0 即 arr[i]这个数在该位置上为1 这个是其中一个解(被分解成了两个数了，根据一个位置上的0和1) 把所有的数都分成了两块 一块是 某个位置上有1的数 另外一块是某位置上无1的数
        if ((arr[i] & rightOne) != 0) {
            onlyOne ^= arr[i];
        }
    }
    System.out.println(onlyOne + " " + (eor ^ onlyOne));
}
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];
        // t[0] 0位置的1出现了几个
        // t[i] i位置的1出现了几个
        for (int num : arr) {
            for (int i = 0; i <= 31; i++) {
                // 提取了每个数的32位2进制数，并把它加到了一个数组里
                t[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0) {
                continue;
            }
            if (t[i] % m == k) {
                // 把1弄进去答案里
                ans |= (1 << i);
            } else {
                return -1;
            }
        }
        if (ans == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return ans;
    }

}
