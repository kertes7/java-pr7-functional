package ua.duikt.pr7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Дослід 2: цикл for-each проти Stream API; лінивість потоку (peek).
 * Запуск: java Exp2Streams terminal   — конвеєр із термінальною операцією
 *         java Exp2Streams noterminal — конвеєр без термінальної операції
 */
public class Exp2Streams {

    // Ту саму задачу розв'язано циклом: назви тайтлів, що вийшли після 2015 року
    static List<String> namesWithLoop(List<Title> titles) {
        List<String> result = new ArrayList<>();
        for (Title t : titles) {
            if (t.getYear() > 2015) {
                result.add(t.getName());
            }
        }
        return result;
    }

    static List<String> namesWithStream(List<Title> titles) {
        return titles.stream()
                .filter(t -> t.getYear() > 2015)
                .map(Title::getName)
                .toList();
    }

    public static void main(String[] args) {
        Data.utf8();
        List<Title> titles = Data.titles();

        List<String> loop = namesWithLoop(titles);
        List<String> stream = namesWithStream(titles);
        System.out.println("цикл:  " + loop);
        System.out.println("потік: " + stream);
        System.out.println("Результати збігаються: " + loop.equals(stream));

        String mode = args.length > 0 ? args[0] : "terminal";
        System.out.println();
        System.out.println("=== peek, режим: " + mode + " ===");
        Stream<Title> pipeline = titles.stream()
                .filter(t -> t.getYear() > 2015)
                .peek(t -> System.out.println("peek " + t.getId()));          // побічний друк для спостереження

        if (mode.equals("terminal")) {
            long count = pipeline.count();                                    // термінальна операція запускає конвеєр
            System.out.println("термінальна операція count() = " + count);
        } else {
            System.out.println("(термінальної операції немає — конвеєр лише побудовано, але не запущено)");
        }
    }
}
