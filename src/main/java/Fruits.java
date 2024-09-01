import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Fruits {
    public static void main(String[] args) {
        List fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("grape");
        // Поиск значения "apple" при помощи Optional
        Optional<String> apple = fruits.stream().filter(fruit -> "apple".equals(fruit)).findFirst();
        System.out.println(apple.orElse("Not found"));

        // Поиск значения "grape", если не найдено вернуть "Not found"
        Optional<String> grape = fruits.stream().filter(fruit -> "grape".equals(fruit)).findFirst();
        System.out.println(grape.orElse("Not found"));

        // Поиск длинны слова "banana" из списка
        String lengthWord = (String) fruits.stream().filter(word -> word.equals("banana")).findFirst().orElse(null);

        if (lengthWord != null) {
            System.out.println("Длина слова 'banana': " + lengthWord.length());
        } else {
            System.out.println("Not found");
        }
    }
}