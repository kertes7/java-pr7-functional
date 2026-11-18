package ua.duikt.pr7;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/** Спільні тестові дані (10 тайтлів; умові «після 2015 року» відповідає частина, але не всі) та допоміжні методи. */
final class Data {
    private Data() { }

    static void utf8() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));
    }

    static List<Title> titles() {
        List<Title> list = new ArrayList<>();
        list.add(new Title("T-5131", "Людина-павук: Навколо всесвіту", 2023));
        list.add(new Title("T-1017", "Назад у майбутнє", 1985));
        list.add(new Title("T-8507", "Дюна", 2021));
        list.add(new Title("T-2521", "Матриця", 1999));
        list.add(new Title("T-5593", "Коко", 2017));
        list.add(new Title("T-6145", "Шрек", 2001));
        list.add(new Title("T-4737", "Локі", 2021));
        list.add(new Title("T-7161", "Зоотрополіс", 2016));
        list.add(new Title("T-7002", "Аватар", 2009));
        list.add(new Title("T-8945", "Зоряні війни: Пробудження Сили", 2015));
        return list;
    }
}
