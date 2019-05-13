package Array;

/**
 * author:HYPO
 * date:2019/5/13 23:11
 * description: 泛型 generic
 */
public class myArray_02<T> {
    private T[] data;
    private int size;

    public myArray_02() {
        this(10);
    }

    public myArray_02(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // getCapacity
    public int getCapacity() {
        return data.length;
    }

    // getSize
    public int getSize() {
        return size;
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size=%d, capacity=%d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1)
                sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    // add element by index
    public void add(int index, T e) {
        if (data.length == size) {
//            throw new IllegalArgumentException("array is full");
            resize(2 * data.length);
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        //从size-1开始到index向后移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;

        size++;
    }

    // add element by head
    public void addHead(T e) {
        add(0, e);
    }

    // add element by last
    public void addLast(T e) {
        add(size, e);
    }

    // delete element by index
    public void deleteByIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        //从index+1到size-1前移一位
        for (int i = index + 1; i <= size - 1; i++) {
            data[i - 1] = data[i];
        }

        size--;
        data[size] = null;

        if (size == data.length / 2) {
            resize(data.length / 2);
        }
    }

    // deleteByElement
    public void deleteByElement(T e) {
        int index = searchIndex(e);
        if (index != -1) {
            deleteByIndex(index);
        }
    }

    // set element by index
    public void set(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }

        data[index] = e;
    }

    // get element by index
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }

        return data[index];
    }

    // isContain
    public boolean isContain(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }

        return false;
    }

    // search index by element
    public int searchIndex(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }

        return -1;
    }

    // dynamic array,resize
    public void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
