package Array;


/**
 * author:HYPO
 * date:2019/5/13 21:49
 * description:
 */
public class myArray {
    private int[] data;
    private int size;

    public myArray() {
        this(10);
    }

    public myArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
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

    // 添加数组元素 by index
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

    // 添加数组元素，by head
    public void addHead(int e) {
        add(0, e);
    }

    // 添加数组元素，by last
    public void addLast(int e) {
        add(size, e);
    }

    // 删除数组元素，by index
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

    // 修改元素 by index
    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }

        data[index] = e;
    }

    // 查找元素 by index
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

}



















