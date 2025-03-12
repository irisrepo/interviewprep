package src.main.com.sss.java.javaprograms.simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepaeatinElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4, 5, 4};
        int[] arr2 = {1, 2, 3, 4, 5};

        Collections.rotate(Collections.singletonList(arr2),2);

       System.out.println("FirstNonRepeatedEleemt=="+firstNonRepeatedCharacter(arr));

    }

    public static Integer firstNonRepeatedCharacter(int[] arr){
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }
}
