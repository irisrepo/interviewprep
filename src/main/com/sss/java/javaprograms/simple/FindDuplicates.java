package src.main.com.sss.java.javaprograms.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 3, 5, 6, 7, 7};
        Map<Integer, Integer> uniqueMap = new HashMap<>();

        for (int num : arr) {
            uniqueMap.put(num, uniqueMap.getOrDefault(num, 0) + 1);
        }
        System.out.println(uniqueMap);

        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : uniqueMap.entrySet()){
            if(entry.getValue()>1){
                duplicates.add(entry.getKey());
            }
        }
        System.out.println(duplicates);
    }
}
