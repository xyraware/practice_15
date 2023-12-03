import java.util.Arrays;

public class ArrayQueueModule {
        private static final int START_CAPACITY = 20;
        private static Object array[];
        private static int size;
        private static int head;
        private static int tail;

        public ArrayQueueModule() {
            array = new Object[START_CAPACITY];
            size = head = tail = 0;
        }
        public static void enqueue(Object element) {
            assert element != null;
            array[tail] = element;
            tail = (tail + 1) % array.length;
            size++;
        }

        public static Object element() {
            assert size > 0;
            return array[head];
        }

        public static Object dequeue() {
            assert size > 0;
            Object result = element();
            array[head] = null;
            size--;
            head = (head + 1) % array.length;
            return result;
        }

        public static void push(Object element) {
            assert element != null;
            head = (head == 0) ? array.length - 1 : head - 1;
            array[head] = element;
            size++;
        }

        public static Object peek() {
            assert size > 0;
            return array[(tail == 0) ? array.length - 1 : tail - 1];
        }

        public static Object remove() {
            assert size > 0;
            Object result = peek();
            tail = tail == 0 ? array.length - 1 : --tail;
            array[tail] = null;
            size--;
            return result;
        }

        public static int size() {
            return size;
        }

        public static boolean isEmpty() {
            return size == 0;
        }

        public void clear() {
            System.out.println("Функция clear в классе ArrayQueueModule");
            size = head = tail = 0;
            array = new Object[START_CAPACITY];
            System.out.println(this);
        }

    public void getArray() {
        System.out.println("Функция getArray в классе ArrayQueueModule");
        Object[] arr = this.array;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(this);
    }
    public void dump() {
        System.out.println("Функция dump в классе ArrayQueueModule");
        while (!(this.isEmpty())) {
            System.out.println("Размер ArrayQueue: "+this.size());
            this.dequeue();
            System.out.println(this);
        }
    }
    public void fill(){
        System.out.println("Функция fill  в классе ArrayQueueModule");
        for(int i=0;i<20;i++){
            this.enqueue(i*3);
        }
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "\nArrayQueueModule c размером "+size+"\nЭлементы: "+ Arrays.toString(array);
    }
}
