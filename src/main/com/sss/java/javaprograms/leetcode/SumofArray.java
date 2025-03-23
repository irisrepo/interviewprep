package src.main.com.sss.java.javaprograms.leetcode;

public class SumofArray {
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5};
        System.out.print(sumOfArray(arr,1,3));

    }
    public static int sumOfArray(int[]arr ,int left, int right){
        if (left < 0 || right >= arr.length || left > right) {
            throw new IllegalArgumentException("Invalid left or right positions");
        }
        int sum =0;
        for(int i=left;i<=right;i++){
            sum += arr[i];
        }
        return sum;
    }
}
