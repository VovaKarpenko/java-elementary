package homework.homework15;

import sun.net.www.protocol.http.ntlm.NTLMAuthentication;

public class LikeLinkedList {
    private static int size = 0;
    private Node first;
    private Node last;

    public void add(int num) {
        newInt(num);

    }


    public void add(int index, int num) {
        if (index == size) {
            newInt(num);
        } else {
            superAdd(support(index), num);
        }
    }


    public void remove(int index) {

        delete(support(index));

        size--;

    }

    public void set(int index, int num) {
        Node buff = support(index);
        buff.value = num;
    }


    public Integer get(int index) {
        return support(index).value;
    }


    private static class Node {
        Integer value;
        Node next;
        Node prev;

        private Node(Node next, Node prev, Integer value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
            size++;
        }

    }


    public void superAdd(Node addElement, int num) {
        Node prev = addElement.prev;
        Node newNode = new Node(addElement, prev, num);
        addElement.prev = newNode;
        if (prev == null) {
            first = newNode;
        }else {
            prev.next = newNode;
        }

    }



    private void delete(Node remElement) {
        Node prev = remElement.prev;
        Node next = remElement.next;
        if (prev == null) {
            first = next;
        } else if (next == null) {
            last = prev;
            prev.next = null;
        } else {
            prev.next = next;
            remElement.value = null;
        }
    }

    private Node support(int index) {
        if (index < (size / 2)) {
            Node buffFirst = first;
            for (int i = 0; i < index; i++) {
                buffFirst = buffFirst.next;
            }
            return buffFirst;
        } else {
            Node buffLast = last;
            for (int i = size - 1; i > index; i--) {
                buffLast = buffLast.prev;
            }
            return buffLast;
        }
    }


    private void newInt(Integer num) {
        Node l = last;
        Node newNode = new Node(null, l, num);
        last = newNode;
        if (first == null) {
            first = newNode;
        } else {
            l.next = newNode;

        }

    }

    public int size() {
        return size;
    }

    public String toString() {
        String result = "{";
        Node buff = first;
        while (buff != null) {
            result += buff.value;

            if (buff.next != null) {
                result += " , ";

            }
            buff = buff.next;
        }
        result += "}";
        return result;
    }
}



