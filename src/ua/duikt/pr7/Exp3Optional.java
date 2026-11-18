package ua.duikt.pr7;

import java.util.List;
import java.util.Optional;

/** Дослід 3: Optional — findFirst, get() на порожньому, orElse. */
public class Exp3Optional {

    public static void main(String[] args) {
        Data.utf8();
        List<Title> titles = Data.titles();

        // елемента за умовою «вийшов до 1950 року» у списку немає
        Optional<Title> none = titles.stream().filter(t -> t.getYear() < 1950).findFirst();
        System.out.println("Пошук без результату: " + none);

        try {
            none.get();                                        // get() на порожньому Optional
        } catch (java.util.NoSuchElementException e) {
            System.out.println("none.get() кинув виняток:");
            e.printStackTrace();
        }

        String name1 = none.map(Title::getName).orElse("не знайдено");
        System.out.println("map(...).orElse(\"не знайдено\") для пошуку без результату: " + name1);

        // умова з досліду 2 («після 2015 року»): елемент є
        Optional<Title> found = titles.stream().filter(t -> t.getYear() > 2015).findFirst();
        System.out.println("Пошук за умовою досліду 2: " + found);
        String name2 = found.map(Title::getName).orElse("не знайдено");
        System.out.println("map(...).orElse(\"не знайдено\") для наявного: " + name2);
    }
}
