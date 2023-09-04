public class ThoughtOfMergeSort {
    public static int smallSum(int[] arr) {
        if(arr== null|| arr.length<2){
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }
    public static int process(int[] arr, int L, int R) {
        if (L==R){
            return 0;
        }
        int M = L+((R-L)>>1);

        process(arr,M+1,R);
        return process(arr,L,M)+process(arr,M+1,R)+ merge(arr,L,M,R);

    }
    public static int merge(int[] arr, int L,int M, int R){
        int res=0;
        int p1 =L;
        int p2 =M+1;
        int index=0;
        int [] help = new int [R-L+1];
        while (p1<=M && p2<=R) {
            if (arr[p1] < arr[p2]) {
                help[index++] = arr[p1++];
                res += arr[p1 - 1] * (R - p2 + 1);
            } else {
                help[index++] = arr[p2++];
            }
        }
            while (p1 <= M) {
                help[index++] = arr[p1++];
            }
            while (p2 <= R) {
                help[index++] = arr[p2++];
            }
            for ( index= 0; index < help.length; index++) {
                arr[L + index] = help[index];
            }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums  ={7,5,6,4};
        solution.reversePairs(nums);
    }
}
// ÄæĞò¶ÔÎÊÌâ https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null|| nums.length<2){
            return 0;
        }
        return process(nums,0,nums.length-1);
    }
    public int process(int[] nums, int L, int R){
        if (L==R){
            return 0;
        }
        int M = L+((R-L)>>1);
        return process(nums,L,M)+process(nums,M+1,R)+merge(nums,L,M,R);
    }
    public static int merge(int[] arr, int L,int M, int R){
        int res=0;
        int p1 =L;
        int p2 =M+1;
        int index=0;
        int [] help = new int [R-L+1];
        while (p1<=M && p2<=R) {
            if (arr[p1] > arr[p2]) {
                help[index++] = arr[p1++];
                res += R - p2 + 1;
//                System.out.println(res);
            } else {
                help[index++] = arr[p2++];
            }
        }
            while (p1 <= M) {
                help[index++] = arr[p1++];
            }
            while (p2 <= R) {
                help[index++] = arr[p2++];
            }
            for ( index= 0; index < help.length; index++) {
                arr[L + index] = help[index];
            }

        return res;
    }
}