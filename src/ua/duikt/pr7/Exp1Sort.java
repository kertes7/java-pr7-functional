package ua.duikt.pr7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/** Дослід 1: сортування за роком трьома способами + лічильник порівнянь у лямбді. */
public class Exp1Sort {

    public static void main(String[] args) {
        Data.utf8();
        List<Title> base = Data.titles();

        // 1) анонімний клас (6 рядків коду)
        List<Title> a = new ArrayList<>(base);
        a.sort(new Comparator<Title>() {
            @Override
            public int compare(Title x, Title y) {
                return Integer.compare(x.getYear(), y.getYear());
            }
        });
        System.out.println("1) анонімний клас:");
        a.forEach(t -> System.out.println("   " + t));

        // 2) лямбда-вираз (1 рядок)
        List<Title> b = new ArrayList<>(base);
        b.sort((x, y) -> Integer.compare(x.getYear(), y.getYear()));
        System.out.println("2) лямбда (x, y) -> ...:");
        b.forEach(t -> System.out.println("   " + t));

        // 3) Comparator.comparingInt + посилання на метод (1 рядок)
        List<Title> c = new ArrayList<>(base);
        c.sort(Comparator.comparingInt(Title::getYear));
        System.out.println("3) Comparator.comparingInt(Title::getYear):");
        c.forEach(t -> System.out.println("   " + t));

        System.out.println("Однаковий порядок у всіх трьох способів: " + (a.equals(b) && b.equals(c)));

        // Лічильник порівнянь: int calls = 0; calls++ у лямбді — помилка компіляції (див. errors/E1_LambdaCounter.java).
        // Допустимий обхід: об'єкт-лічильник, посилання на який «фактично незмінне».
        AtomicInteger calls = new AtomicInteger();
        new ArrayList<>(base).sort((x, y) -> {
            calls.incrementAndGet();
            return Integer.compare(x.getYear(), y.getYear());
        });
        System.out.println("Кількість порівнянь (через AtomicInteger): " + calls.get());
    }
}
