import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите IP-адрес: ");
        String ipAddress = scanner.nextLine();

        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        //диапозон 255-250 или 249-200 или 199-0 с точками x3, потом один без точки

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipAddress);

        if (matcher.matches()) {
            System.out.println("IP-адрес корректен.");
        } else {
            System.out.println("IP-адрес некорректен.");
        }
    }
}
