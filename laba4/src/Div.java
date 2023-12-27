import java.io.*;

public class Div {
    public static void main(String[] args) {
        try {
            int numerator = 10;
            int denominator = 0;
            int result = divideNumbers(numerator, denominator);
            System.out.println("Результат деления: " + result);
        } catch (CustomDivisionException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            //Логируем информацию об ошибке в файл
            logException(e);
        }
    }

    public static int divideNumbers(int numerator, int denominator) throws CustomDivisionException {
        if (denominator == 0) {
            throw new CustomDivisionException();//выбрасывает исключение
        }
        return numerator / denominator;
    }

    public static void logException(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("error.log", true))) {
            //true - данные добавляются в конец файла
            e.printStackTrace(writer);//запись инфы об ошибке в файл
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в файл: " + ioException.getMessage());
        }
    }
}