public class ArrayAverage {
    public static void main(String[] args) {
        //String[] arr = {"1","2","aaa"};
        int[] arr = {1, 2, 5, 4, 5};
        int sum = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
//                int num = Integer.parseInt(arr[i]);
//                sum += num;
                sum += arr[i];
            }
            double average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат данных.");
        }
    }
}
