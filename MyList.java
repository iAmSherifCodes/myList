package myListTest;

public class MyList {
    private int size;

    private int[] elements = new int[4];

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return elements.length;
    }

    private int getLastIndex(){
        return getSize() -1;
    }

    public void append(int element) {
        this.elements[getLastIndex()] = element;
        size++;
    }

    public void remove(int index) {
        if(isEmpty()) throw new EmptyListException("No element to remove in the list");
        elements[index] = 0;
        --size;
    }

    public void remove() {
        if (isEmpty()) throw  new EmptyListException("No element to remove in the list");
        elements[getLastIndex()] = 0 ;
        --size;

    }

    public void add(int index, int element) {
        size++;
        elements[index] = element;
    }



    public int getElement(int index) {
        return elements[index];
    }

    public int search(int element) {
        for (int elem: elements) if (elem == element) return elem;
        throw new  NoElementFoundException();
    }

    public int getElementSize() {
        return this.size;
    }


    public class EmptyListException extends RuntimeException{
        public EmptyListException(String message) {
            super(message);
        }
    }

    public class NoElementFoundException extends RuntimeException{
    }
}

