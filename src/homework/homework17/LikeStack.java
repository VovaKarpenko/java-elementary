package homework.homework17;

import java.util.EmptyStackException;

public class LikeStack {

    private Integer[] arr = new Integer[10];
    private int count = 0;

    public void push(int num) {
        grow(count + 1);
        arr[count] = num;
        count++;
    }

    private void grow(int size) {
        if (size % 10 == 0) {
            Integer[] bufferArray = new Integer[arr.length + 10];
            for (int i = 0; i < arr.length; i++) {
                bufferArray[i] = arr[i];
            }
            arr = bufferArray;

        }
    }

    public Integer pop() {
        if (count - 1 == -1) {
            throw new EmptyStackException();
        } else {
            int buffer = arr[count-1];
            arr[count-1] = null;
            count--;
            return buffer;
        }
    }

    public String likeToString() {
        String result = "[";
        for (int i = 0; i < count; i++) {
            result += Integer.toString(arr[i]);
            if (!(i + 1 == count)) {
                result += " , ";
            }
        }
        result += "]";
        return result;
    }
}

