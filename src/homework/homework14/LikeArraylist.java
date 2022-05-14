package homework.homework14;

public class LikeArraylist {

    String[] array = new String[10];
    String[] bufferArray = new String[0];
    private int size =0;

    public void grow(int size) {
        if (size%10==0){
            bufferArray = new String[array.length + 10];
            for (int i = 0; i < array.length; i++) {
                bufferArray[i] = array[i];
            }
            array = bufferArray;

        }

    }
    public void add (String word){
        grow(size+1);
        array[size]=word;
        size++;
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
            if (array[i]==null){
                break;
            }
            result += array[i];

            if (!(array[i+1]==null)) {
                result += " , ";
            }

        }
        result += "]";
        return result;
    }



}
