
/*
Пусть дан список сотрудников:
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности Имени.
 */

package Task2;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;



public class Main {
    public static void main(String[] args) {
        Map<String, Integer> namesDict = new HashMap<>();

        String[] namesArr = {
                "Егор Павлов",
                "Светлана Гусева",
                "Кристина Арбокаайте",
                "Алина Мусина",
                "Анна Круглова",
                "Егор Петров",
                "Петр Лыков",
                "Павел Черенков",
                "Петр Чернышов",
                "Светлана Федорова",
                "Анна Серова",
                "Мария Танина",
                "Мария Рыжова",
                "Марина Пупова",
                "Алина Тучина",
                "Егор Мезенцев",
                "Петр Владимиров",
                "Егор Фотин"
        };

        for (String el: namesArr) {
            String name = el.split(" ")[0];

            if (namesDict.containsKey(name)) {
                namesDict.replace(name, namesDict.get(name) + 1);
            }
            else namesDict.put(name, 1);
        }

        Map<String, Integer> sortedDict = sortHashMap(namesDict);

        System.out.println(namesDict);
        System.out.println(sortedDict);
    }

    public static Map<String, Integer> sortHashMap(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        int max = 1;

        for (int value: map.values())
            if (value > max) max = value;

        for (int i = max; i > 0; i--) {
            for (var el: map.entrySet())
                if (map.get(el.getKey()) == i)
                    sortedMap.put(el.getKey(), el.getValue());
        }

        return sortedMap;
    }
}