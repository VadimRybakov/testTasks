package RybakovVadimSolving;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {

    public static Map<Integer, Integer> frequencyArr(int[] arr){

        int N = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(arr[i])) {
                for (int j = i + 1; j < N; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }
                map.put(arr[i], count);
            }
            count = 1;
        }

        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
    }

    public static void main(String[] args) {

        int[] arr = {99, 45 ,233, 2, -123, 2, 45, 0, -11, 3, -11, -11, -39, 2, 0, 2};

        for(Map.Entry<Integer, Integer> pair : frequencyArr(arr).entrySet()){
            System.out.println("Число " + pair.getKey() + " число вхождений в массив: " + pair.getValue());
        }
    }
}
