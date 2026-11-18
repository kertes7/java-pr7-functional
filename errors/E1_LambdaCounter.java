import java.util.ArrayList;
import java.util.List;

public class E1_LambdaCounter {
    public static void main(String[] args) {
        List<Integer> years = new ArrayList<>(List.of(2001, 1985, 2023));
        int calls = 0;
        years.sort((a, b) -> {
            calls++;                    // зміна локальної змінної всередині лямбди
            return Integer.compare(a, b);
        });
        System.out.println(calls);
    }
}
