import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task3 {
    public static void main(String[] args) {
        String text = "Текст с ссылками: www.example.com и еще такая vk.com vk.org lol.net";

        String regex = "\\b(\\w+\\.(com|org|net|io|ru))\\b";
        // \w - любой буквенно-цифровой символ или подчеркивание

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            String link = matcher.group();
            System.out.println("Ссылка: " + link);
            System.out.println("Гиперссылка: https://" + link);
            found = true;
        }
        if (!found){
            System.out.println("Ссылок не найдено");
        }

    }
}
