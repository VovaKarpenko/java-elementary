package homework.homework14;

public class LikeArraylist {

    String[] array = new String[0];
    String[] bufferArray = new String[0];

    public void add(String word) {
        bufferArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            bufferArray[i] = array[i];
        }
        array = bufferArray;
        array[array.length - 1] = word;
    }

    public void remove(int index) {
        bufferArray = new String[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            if (i >= index) {
                String swap = array[i];
                array[i] = array[i + 1];
                array[i + 1] = swap;
            }
        }
        for (int i = 0; i < bufferArray.length; i++) {
            bufferArray[i] = array[i];
        }
        array = bufferArray;

    }


    public void set(int index, String word) {
        array[index] = word;
    }

    public String get(int index) {
        return array[index];
    }


    public String toStrin() {
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            if (i < array.length - 1)
                result += " , ";
        }
        result += "]";
        return result;
    }

}
