package Array;


/**
 * author:HYPO
 * date:2019/5/13 21:49
 * description:
 */
public class myArray_01 {
    private int[] data;
    private int size;

    public myArray_01() {
        this(10);
    }

    public myArray_01(int capacity) {
        data = new int[capacity];
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
    public void add(int index, int e) {
        if (data.length == size) {
            throw new IllegalArgumentException("array is full");
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
    public void addHead(int e) {
        add(0, e);
    }

    // add element by last
    public void addLast(int e) {
        add(size, e);
    }

    // delete element by index
    public void delete(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        //从index+1到size-1前移一位
        for (int i = index + 1; i <= size - 1; i++) {
            data[i - 1] = data[i];
        }

        size--;
    }

    // set element by index
    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }

        data[index] = e;
    }

    // get element by index
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }

        return data[index];
    }

    // isContain
    public boolean isContain(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }

        return false;
    }

    // search index by element
    public int searchIndex(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }

        return -1;
    }

}