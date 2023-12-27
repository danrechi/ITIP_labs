import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = scanner.nextLine().toLowerCase();

        System.out.println("Введите букву для поиска: ");
        String letterInput = scanner.nextLine().toLowerCase();

        String regex = "\\b"+ letterInput +"\\w*[^0-9]\\b";
        // \w - любой буквенно-цифровой символ или подчеркивание * - ноль или более

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Слова, начинающиеся с буквы '" + letterInput + "': ");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
