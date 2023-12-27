public class ArraySum1 implements Runnable {
    private int[] array;
    private int startIndex;
    private int endIndex;
    private int result;

    public ArraySum1(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getResult() {
        return result;
    }
    //поток для суммы, метод run будет выполнен в отдельном потоке при запуске
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            result += array[i];
        }
    }

    public static void main(String[] args) {
        int arraySize = 1000;
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = i;
        }

        int midIndex = array.length / 2;
        ArraySum1 sum1 = new ArraySum1(array, 0, midIndex);
        ArraySum1 sum2 = new ArraySum1(array, midIndex, array.length);
        //два потока для подсчета сумм
        Thread thread1 = new Thread(sum1);
        Thread thread2 = new Thread(sum2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = sum1.getResult() + sum2.getResult();
        System.out.println("Сумма элементов: " + totalSum);
    }
}
