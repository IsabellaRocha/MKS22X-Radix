import java.util.*;
public class MyLinkedList<E>{
  public class Node {
    private E data;
    private Node next,prev;

    public Node(E data, Node next, Node prev) {
      this.data = data;
      this.next = next;
      this.prev = prev;
    }
    public Node() {
    }
    public void setNext(Node next) {
      this.next = next;
    }
    public E setData(E data) {
      E og = this.data;
      this.data = data;
      return og;
    }
    public void setPrev(Node prev) {
      this.prev = prev;
    }
    public Node next() {
      return next;
    }
    public E getData() {
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
  public E removeFront() {
    if (size == 0) throw new NoSuchElementException();
    E og = start.getData();
    if (size == 1) {
      clear();
      return og;
    }
    start = start.next();
    start.setPrev(null);
    size--;
    return og;
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
