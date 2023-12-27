import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        String regex = "^(?=.*[0-9])(?=.*[A-Z])[a-zA-Z0-9]{8,16}$";
        //(?=.*[0-9]) - после текущей позиции должена быть хотя бы одна цифра {границы}
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (password.length() < 8 || password.length() > 16) {
            System.out.println("Ошибка: Пароль должен быть от 8 до 16 символов.");
        } else if (!password.matches("[a-zA-Z0-9]+")) {//+ - один или более раз
            //matches - соответствует ли вся строка паттерну
            System.out.println("Ошибка: Пароль должен состоять только из букв и цифр.");
        } else if (!matcher.matches()) {
            System.out.println("Ошибка: Пароль должен содержать хотя бы одну цифру и одну заглавную букву.");
        } else {
            System.out.println("Пароль корректен.");
        }
    }
}
