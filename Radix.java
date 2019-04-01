public class Radix {
  public static void radixsort(int[]data){
    MyLinkedList[] buckets = new MyLinkedList[20];
  }
  public static int getDigit(int idx, int num) {
    while (num > Math.pow(10, idx)) {
      num /= 10;
    }
    return num % 10;
  }
  public static void main(String[] args) {
    System.out.println(getDigit(1, 15));
    System.out.println(getDigit(4, 12345));
    System.out.println(getDigit(6, 123456789));
  }
}
