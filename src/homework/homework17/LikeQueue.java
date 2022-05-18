package homework.homework17;

import java.util.EmptyStackException;

public class LikeQueue {

    private String[] arr = new String[10];
    private int size = 0;
    private int decreaseCount = 0;

    public void add(String word) {
        grow(size + 1);
        arr[size] = word;
        size++;
    }

    private void grow(int size) {
        if (size % 10 == 0) {
            String[] bufferArray = new String[arr.length + 10];
            for (int i = 0; i < arr.length; i++) {
                bufferArray[i] = arr[i];
            }
            arr = bufferArray;

        }
    }

    public String poll() {
        if (size == 0) {
            return null;
        }
        decrease();
        String result = arr[decreaseCount];
        arr[decreaseCount] = null;
        decreaseCount++;


        return result;
    }

    private void decrease() {
        if (decreaseCount == 10) {
            String[] bufferArray = new String[arr.length - 10];
            for (int i = 10; i < arr.length; i++) {
                bufferArray[i-10] = arr[i];
            }
            arr = bufferArray;
            decreaseCount = 0;
            size-=10;
        }
    }
    public String likeToString() {
        String result = "[";
        for (int i = decreaseCount; i < size; i++) {
            result += arr[i];
            if (!(i + 1 == size)) {
                result += " , ";
            }
        }
        result += "]";
        return result;
    }
}
