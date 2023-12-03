import java.util.Arrays;
public class ArrayQueue {
    private final int START_CAPACITY = 10;
    private Object array[];
    private int size;
    private int head;
    private int tail;
    public ArrayQueue() {//конструктор
        array = new Object[START_CAPACITY];
        size = head = tail = 0;
    }
    public void setAllForArrayQueue(Object[] array,int size,int head,int tail) {
        this.array = array;
        this.size = size;
        this.head = head;
        this.tail = tail;
    }
    //Предусловия: значение не должно быть равно null
    //Постусловие: последний элемент очереди равен элементу и размер очереди увеличивается
    public void enqueue(Object element) {//функция добавления в очередь
        assert element != null;
        this.array[this.tail] = element;
        this.tail = (this.tail + 1) % this.array.length;
        this.size++;
    }
    // Предусловие: размер очереди больше 0
    //Постусловие: результатом должен являться первым элементов (головой) очереди
    public Object element() {
        assert size > 0;
        return array[head];
    }
    //Предусловие: размер очереди должен быть больше нуля
    //Постусловия: результатом должен являться последний элемент массива и его размер уменьшится на один
    public Object dequeue() {//функция удаления из очереди
        assert size > 0;
        Object result = element();
        array[head] = null;
        size--;
        head = (head + 1) % array.length;
        return result;
    }
    //Предусловия: элемент не должен быть равен null
    //Постусловия: первый элемент очереди-это вводимый элемент, размер очереди увеличится
    public void push(Object element) {
        assert element != null;
        head = (head == 0) ? array.length - 1 : head - 1;
        array[head] = element;
        size++;
    }
    //Предусловие: размер очереди должен быть больше 0
    //Постусловие: функция возвращает последний элемент
    public Object peek() {
        assert size > 0;
        return array[(tail == 0) ? array.length - 1 : tail - 1];//если хвостовой элемент=0, то размер массива уменьшается на один, иначе уменьшается хвостовой элемент
    }
    //Предусловие: размер очереди должен быть больше 0
    // Постусловие: возвращается последний элемент очереди, размер уменьшается
    public Object remove() {//удаление элемента в очереди
        assert size > 0;
        Object result = peek();
        tail = tail == 0 ? array.length - 1 : --tail;//если хвостовой элемент=0, то размер массива уменьшается на один, иначе уменьшается хвостовой элемент
        array[tail] = null;
        size--;
        return result;
    }
    //Постусловие: возвращается размер очереди
    public int size() {
        return size;
    }
    // Постуслвоие: возвращается булевое значение, которое отражает пустая ли очередь
    public boolean isEmpty() {
        return size == 0;
    }
    //Инвариант: размер очереди равен 0
    // Постусловие: очистка очереди
    public void clear() {
        System.out.println("Функция clear в классе ArrayQueue");
        size = head = tail = 0;
        array = new Object[START_CAPACITY];
        System.out.println(this);
    }
    //Постусловие: возвращается очередь в виде массива
    public Object[] toArray() {
        Object[] temp = new Object[size];
        temp=this.array;
        return temp;
    }
    //Постусловие: очередь заполнится числами от 0 до 10
    public void fill() {
        System.out.println("Функция fill в классе ArrayQueue");
        for (int i = 0; i < 10; i++) {
            this.enqueue(i*2);
        }
        System.out.println(this);
    }
    //Постусловие: очередь постепенно удаляется, начиная с головного элемента
    public void dump() {
        System.out.println("Функция dump в классе ArrayQueue");
        while (!this.isEmpty()) {
            System.out.println("Размер ArrayQueue: "+this.size() );
            this.dequeue();
            System.out.println(this);
        }
    }
//Постусловие: очередь переводится в массив
    public void getArray() {
        System.out.println("Функция getArray в классе ArrayQueue");
        Object[] arr = this.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "\nArrayQueueADT" + " c размером " + size + "\nэлементы: " + Arrays.toString(array);
    }
}
