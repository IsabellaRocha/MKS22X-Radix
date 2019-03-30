public class Node<E> {
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
