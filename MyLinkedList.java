public class MyLinkedList<E>{
  public class Node {
    private Object data;
    private Node next,prev;

    public Node(Object data, Node next, Node prev) {
      this.data = data;
      this.next = next;
      this.prev = prev;
    }
    public Node() {
    }
    public void setNext(Node next) {
      this.next = next;
    }
    public Object setData(Object data) {
      Object og = this.data;
      this.data = data;
      return og;
    }
    public void setPrev(Node prev) {
      this.prev = prev;
    }
    public Node next() {
      return next;
    }
    public Object getData() {
      return data;
    }
    public Node prev() {
      return prev;
    }
    public String toString() {
      return "" + data;
    }
  }

  private int size;
  private Node start;
  private Node end;

  public MyLinkedList(int size, Node start, Node end) {
    this.size = size;
    this.start = start;
    this.end = end;
  }
  public MyLinkedList() {
    size = 0;
    start = null;
    end = null;
  }
  public int size() {
    return size;
  }
  public boolean add(E value) {
    if (size == 0) {
      start = new Node(value, null, null);
      end = start;
      size++;
      return true;
    }
    else {
      Node newEnd = new Node(value, null, end);
      end.setNext(newEnd);
      end = newEnd;
      size++;
      return true;
    }
  }
  public String toString() {
    String output = "[";
    Node current = start;
    int idx = 0;
    while (current != null && idx < size - 1) {
      output += current + ", ";
      current = current.next();
      idx++;
    }
    if (end == null) {
      output +="]";
    }
    else {
      output += end + "]";
    }
    return output;
  }
  public E get(int idx) {
    if (idx < 0 || idx >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node current = start;
    for (int x = 0; x < idx; x++) {
      current = current.next();
    }
    return (E)current.getData();
  }
  public E set(int idx, E value) {
    if (idx < 0 || idx >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node current = start;
    for (int x = 0; x < idx; x++) {
      current = current.next();
    }
    E og = (E)current.getData();
    current.setData(value);
    return og;
  }
  public boolean contains(E value) {
    Node current = start;
    while (current != null) {
      if (current.getData() == value) {
        return true;
      }
      current = current.next();
    }
    return false;
  }
  public int indexOf(E value) {
    Node current = start;
    for (int idx = 0; idx < size; idx++) {
      if (current.getData().equals(value)) {
        return idx;
      }
      current = current.next();
    }
    return -1;
  }
  public void add(int idx, E value) {
    if (idx < 0 || idx > size) {
      throw new IndexOutOfBoundsException();
    }
    Node current = start;
    if (idx == 0) {
      current = new Node(value, start, null);
      start = current;
      size++;
    }
    else if (idx == size) {
      current = new Node(value, null, end);
      end.setNext(current);
      end = current;
      size++;
    }
    else {
      for (int x = 0; x < idx - 1; x++) {
        current = current.next();
      }
      Node newNode = new Node(value, current.next(), current);
      current.setNext(newNode);
      current = current.next().next();
      current.setPrev(newNode);
      size++;
    }
  }
  public E removeFront() {
    E og = (E)start.getData();
    start = start.next();
    start.setPrev(null);
    size--;
    return og;
  }
  public E remove(int idx) {
    if (idx < 0 || idx >= size) {
      throw new IndexOutOfBoundsException();
    }
    if (idx == 0) {
      removeFront();
    }
    if (idx == size - 1) {
      E og = (E)end.getData();
      end = end.prev();
      end.setNext(null);
      size --;
      return og;
    }
    Node current = start;
    for (int x = 0; x < idx - 1; x++) {
      current = current.next();
    }
    current = current.next();
    E og = (E)current.getData();
    current = current.prev();
    current.setNext(current.next().next());
    Node newCurrent = current.next();
    newCurrent.setPrev(current);
    size--;
    return og;
  }
  public boolean remove(E value) {
    if (contains(value)) {
      remove(indexOf(value));
      return true;
    }
    return false;
  }
  public String toStringDebug() { //Prints backwards for testing
    String output = "[";
    Node current = end;
    int idx = size - 1;
    while (current != null && idx > 0) {
      output += current + ", ";
      current = current.prev();
      idx--;
    }
    if (start == null) {
      output +="]";
    }
    else {
      output += start + "]";
    }
    return output;
  }
  public void clear() {
    size = 0;
    start = null;
    end = null;
  }
  public void extend(MyLinkedList<E> other) {
    if (this.size == 0) {
      this.start = other.start;
      this.end = other.end;
    }
    else {
      this.end.setNext(other.start);
      if (other.end != null) {
        this.end = other.end;
      }
    }
    other.start = null;
    other.end = null;
    this.size = this.size() + other.size();
    other.size = 0;
  }
}
