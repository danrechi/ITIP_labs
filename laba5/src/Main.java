import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) {
        String text = "Текст с числами 42, 3.14, -100, 12345 и 67890.";
        String regex = "-?\\d+(\\.\\d+)?";//-? минус может один/ноль раз быть перед числом
        // \\d последоват. чисел
        //+ один и более раз
        // \\.\\d - десятичная часть числа ()? - встречается ноль или один раз

        try {
            Pattern pattern = Pattern.compile(regex);//компилятор рег.выр
            Matcher matcher = pattern.matcher(text);//поиск по шаблону в строке

            boolean found = false;
            while (matcher.find()) {
                System.out.println("Найдено число: " + matcher.group());//group возвращает символы
                //найденнего совпадения
                found = true;
            }

            if (!found) {
                System.out.println("Числа не найдены в тексте.");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
            //при компиляции некорректного регулярного выражения
        }
    }
}