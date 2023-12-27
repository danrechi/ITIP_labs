public class MaxElementFinder_2 implements Runnable {
    private int[][] matrix;
    private int startRow;
    private int endRow;
    private int maxElement;
    public MaxElementFinder_2(int[][] matrix, int startRow, int endRow) {
        this.matrix = matrix;
        this.startRow = startRow;
        this.endRow = endRow;
        this.maxElement = Integer.MIN_VALUE;
    }

    public int getMaxElement() {
        return maxElement;
    }

    //run который будет выполнен в отдельном потоке при запуске
    @Override
    public void run() {
        //поиск максимального элемента в строке матрицы
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
            }
        }
    }

    // Метод main() для тестирования многопоточности
    public static void main(String[] args) {
        // Исходная матрица
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 22, 11, 12},
                {13, 14, 15, 16}
        };

        //определение количества потоков
        int numRows = arr.length;

        //создание массива потоков
        Thread[] threads = new Thread[numRows];

        //создание и запуск потоков для обработки строк матрицы
        MaxElementFinder_2[] elementFinders = new MaxElementFinder_2[numRows];
        for (int i = 0; i < numRows; i++) {
            elementFinders[i] = new MaxElementFinder_2(arr, i, i + 1);
            //создаем элемент который будет для одной строки
            threads[i] = new Thread(elementFinders[i]);
            threads[i].start();//создаем для элемента поток
        }

        try {
            //ожидание завершения выполнения всех потоков
            for (int i = 0; i < numRows; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //сравниваем максимумы каждого потока(т.е каждой строки) и находим максимальную и них
        int allMaxElement = Integer.MIN_VALUE; //
        for (int i = 0; i < numRows; i++) {
            int rowMax = elementFinders[i].getMaxElement();
            if (rowMax > allMaxElement) {
                allMaxElement = rowMax;
            }
        }

        System.out.println("Максимальный элемент матрицы: " + allMaxElement);
    }
}
