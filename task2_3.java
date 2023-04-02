// 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
// 2. Пусть дан произвольный список целых чисел, удалить из него чётные числа

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class task2_3 {

    public static List<Integer> removeEven(List<Integer> list){
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 != 0){
                list2.add(list.get(i));
            }
        }
        return list2;
        }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 9, 2, 6, 4, 3, 5, 7, 8, 0));
        System.out.println(removeEven(list));
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        System.out.println(list.stream().mapToInt(Integer::intValue).average());

    }

}