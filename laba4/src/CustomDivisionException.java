public class CustomDivisionException extends Exception {
    public CustomDivisionException() {
        super("Деление на ноль запрещено!");
    }
}