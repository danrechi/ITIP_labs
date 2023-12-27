import java.util.Arrays;

public class Stack<T> {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // 3
        System.out.println(stack.peek()); // 2
        stack.push(4);
        System.out.println(stack.pop());  // 4
    }
    private T[] data;
    private int size;

    public Stack(int capacity) {
        // Создаем массив типа T. Приведение типа (T[]) new Object[capacity] безопасно, так как
        // компилятор гарантирует, что тип T является ссылочным типом.
        data = (T[]) new Object[capacity];
        size = 0;
    }
    //добавление эл. в стек
    public void push(T element) {
        if (size == data.length) {
            // Если массив полный, увеличиваем его размер вдвое.
            resize();
        }
        data[size++] = element;
    }
    //удаление элемента из стека
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        // Уменьшаем размер стека и возвращаем элемент с вершины стека.
        return data[--size];
    }
    //получение верхнего элемента без удаления
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        // Возвращаем элемент с вершины стека без его удаления.
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Приватный метод для увеличения размера массива вдвое.
    private void resize() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }


}

