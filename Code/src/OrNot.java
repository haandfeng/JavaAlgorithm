public class OrNot {
    // ����arr��i��jλ���ϵ�ֵ
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    // arr�У�ֻ��һ������������������,��������������ż���Σ���ӡ�����
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }
    //��ô��һ��int���͵�������ȡ�����Ҳ��1��
    // a �� b��������
    // eor != 0
    // eor���Ҳ��1����ȡ����
    // eor :     00110010110111000
    // rightOne :00000000000001000
    // int rightOne = eor & (-eor); // ��ȡ�����ҵ�1
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
//    һ���������������������������Σ���������������ż���Σ���ô�ҵ�����ӡ��������
public static void printOddTimesNum2(int[] arr) {
    int eor = 0;
    for (int i = 0; i < arr.length; i++) {
        eor ^= arr[i];
    }
    // a �� b��������
    // eor != 0
    // eor���Ҳ��1����ȡ����
    // eor :     00110010110111000 = a^b.
    // rightOne :00000000000001000
    // ˵�����������ʵ����ڸ�λ��һ����һ��0��һ��1
    int rightOne = eor & (-eor); // ��ȡ�����ҵ�1

    // �ҳ�����һ��
    int onlyOne = 0; // eor'
    for (int i = 0 ; i < arr.length;i++) {
        //  arr[1] =  111100011110000
        // rightOne=  000000000010000
        // arr[i] & rightOne !=0 �� arr[i]������ڸ�λ����Ϊ1 ���������һ����(���ֽ�����������ˣ�����һ��λ���ϵ�0��1) �����е������ֳ������� һ���� ĳ��λ������1���� ����һ����ĳλ������1����
        if ((arr[i] & rightOne) != 0) {
            onlyOne ^= arr[i];
        }
    }
    System.out.println(onlyOne + " " + (eor ^ onlyOne));
}
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];
        // t[0] 0λ�õ�1�����˼���
        // t[i] iλ�õ�1�����˼���
        for (int num : arr) {
            for (int i = 0; i <= 31; i++) {
                // ��ȡ��ÿ������32λ2���������������ӵ���һ��������
                t[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0) {
                continue;
            }
            if (t[i] % m == k) {
                // ��1Ū��ȥ����
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
