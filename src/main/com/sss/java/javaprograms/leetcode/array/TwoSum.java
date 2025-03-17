package src.main.com.sss.java.javaprograms.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int [] arr ={1, 4, 45, 6, 10, 8};
        System.out.print(twoSum(arr,19));
    }

    public static boolean twoSum(int arr[], int target) {
        // code here
        Set<Integer> unique = new HashSet();
        int n = arr.length;
        for(int i =0 ;i < n ;i++){
           int complement = target - arr[i];
            if(unique.contains(complement)){
                return true;
            }
            else{
                unique.add(arr[i]);
            }
        }
        return false;
    }
}
