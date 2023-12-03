import java.util.Arrays;

public class ArrayQueueADT {
    private static final int START_CAPACITY = 10;
    private Object array[];
    private int size;
    private int head;
    private int tail;
    public ArrayQueueADT() {//конструктор
        array = new Object[START_CAPACITY];
        size = head = tail = 0;
    }

    public void setAllForArrayQueueADT(Object[] array,int size,int head,int tail) {
        this.array = array;
        this.size = size;
        this.head = head;
        this.tail = tail;
    }

    public static void enqueue(ArrayQueueADT adt, Object element) {//функция добавления в очередь
        assert element != null;
        adt.array[adt.tail] = element;
        adt.tail = (adt.tail + 1) % adt.array.length;
        adt.size++;
    }
    public static Object dequeue(ArrayQueueADT adt) {//функция удаления из очереди
        assert adt.size > 0;
        Object result = adt.head;
        adt.array[adt.head] = null;
        adt.size--;
        adt.head = (adt.head + 1) % adt.array.length;
        return result;
    }
    public static void push(ArrayQueueADT adt, Object element) {//первый элемент очереди-это вводимый элемент, размер очереди увеличится
        assert element != null;
        adt.head = (adt.head == 0) ? adt.array.length - 1 : adt.head - 1;
        adt.array[adt.head] = element;
        adt.size++;
    }
    public static Object peek(ArrayQueueADT adt) {//функция возвращает последний элемент
        assert adt.size > 0;
        return adt.array[(adt.tail == 0) ? adt.array.length - 1 : adt.tail - 1];
    }
    public static Object remove(ArrayQueueADT adt) {//удаление элемента в очереди
        assert adt.size > 0;
        Object result = peek(adt);
        adt.tail = adt.tail == 0 ? adt.array.length - 1 : --adt.tail;
        adt.array[adt.tail] = null;
        adt.size--;
        return result;
    }
    public static int size(ArrayQueueADT adt) {//возвращается размер очереди
        return adt.size;
    }
    public static boolean isEmpty(ArrayQueueADT adt) {// возвращается булевое значение, которое отражает пустая ли очередь
        return adt.size == 0;
    }
    public void clear(ArrayQueueADT adt) {//очистка очереди
        System.out.println("Функция clear в классе ArrayQueueADT");
        adt.size = adt.head = adt.tail = 0;
        adt.array = new Object[START_CAPACITY];
        System.out.println(adt);
    }
    public  void getArray(ArrayQueueADT queue) {//очередь переводится в массив
        System.out.println("Функция getArray в классе ArrayQueueADT");
        Object[] arr = queue.array;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(queue);
    }
    public  void dump(ArrayQueueADT adt) {//очередь постепенно удаляется, начиная с головного элемента
        System.out.println("Функция dump в классе ArrayQueueADT");
        while (!adt.isEmpty(this)) {
            System.out.println("Размер ArrayQueueADT: "+adt.size(this));
            this.dequeue(adt);
            System.out.println(adt);
        }
    }
    @Override
    public String toString() {
        return "\nArrayQueueADT c размером: " + size+ "\nЭлементы: " + Arrays.toString(array);
    }
    public static void fill(ArrayQueueADT queue) {
        System.out.println("Функция fill в классе ArrayQueueADT");
        for (int i = 0; i < 15; i++) {
            ArrayQueueADT.enqueue(queue,i);
        }
        System.out.println(queue);
    }
}
