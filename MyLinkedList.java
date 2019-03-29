public class MyLinkedList<E>{
  private int size;
  private Node start;
  private Node end;

  public MyLinkedList(int size, Node start, Node end) {
    this.size = size;
    this.start = start;
    this.end = end;
  }
  public MyLinkedList() {
  }
  public int size() {
    return size;
  }
  public boolean add(Object value) {
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
  public Object get(int idx) {
    if (idx < 0 || idx >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node current = start;
    for (int x = 0; x < idx; x++) {
      current = current.next();
    }
    return current.getData();
  }
  private Node getNthNode(int idx) {
    Node current = start;
    for (int x = 0; x < idx; x++) {
      current = current.next();
    }
    return current;
  }
  public Object set(int idx, Object value) {
    if (idx < 0 || idx >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node current = start;
    for (int x = 0; x < idx; x++) {
      current = current.next();
    }
    Object og = current.getData();
    current.setData(value);
    return og;
  }
  public boolean contains(Object value) {
    Node current = start;
    while (current != null) {
      if (current.getData() == value) {
        return true;
      }
      current = current.next();
    }
    return false;
  }
  public int indexOf(Object value) {
    Node current = start;
    for (int idx = 0; idx < size; idx++) {
      if (current.getData().equals(value)) {
        return idx;
      }
      current = current.next();
    }
    return -1;
  }
  public void add(int idx, Object value) {
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
  public Object remove(int idx) {
    if (idx < 0 || idx >= size) {
      throw new IndexOutOfBoundsException();
    }
    if (idx == 0) {
      Object og = start.getData();
      start = start.next();
      start.setPrev(null);
      size --;
      return og;
    }
    if (idx == size - 1) {
      Object og = end.getData();
      end = end.prev();
      end.setNext(null);
      size --;
      return og;
    }
    Node current = start;
    for (int x = 0; x < idx - 1; x++) {
      current = current.next();
    }
    Object og = current.next().getData();
    current.setNext(current.next().next());
    Node newCurrent = current.next();
    newCurrent.setPrev(current);
    size--;
    return og;
  }
  public boolean remove(Object value) {
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
