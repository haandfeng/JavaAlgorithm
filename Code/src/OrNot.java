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

    }
}
