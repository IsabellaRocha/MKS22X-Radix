import java.util.Arrays;
public class Radix {
  public static void radixsort(int[]data){
    @SuppressWarnings({"unchecked", "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    int max = data[0];
    for (int idx = 0; idx < buckets.length; idx++) {
      buckets[idx] = new MyLinkedList<Integer>();
    }
    for (int idx = 0; idx < data.length; idx++) {
      if (max < data[idx]) max = data[idx];
    }
    int digits = 0;
    while (max > 0) {
      max /= 10;
      digits++;
    }
    MyLinkedList<Integer> store = new MyLinkedList();
    for (int idx = digits; idx > 0; idx--) {
      for (int x = 0; x < data.length; x++) {
        int digit = (data[x] / (int) Math.pow(10, idx)) % 10;
        if (data[x] > 0) buckets[digit + 10].add(data[x]);
        else buckets[9 - Math.abs(digit)].add(data[x]);
      }
      for (int i = 0; i < buckets.length; i++) {
        store.extend(buckets[i]);
      }
      for (int i = 0; i < data.length; i++) {
        data[i] = (int)store.removeFront();
      }
    }
  }
  public static int getDigit(int idx, int num) {
    int temp = num;
    int dig = 0;
    while (temp != 0) {
      dig++;
      temp /= 10;
    }
//    System.out.println(num);
//    System.out.println(dig);
    if (idx > dig) return 0;
    if (idx == dig) {
      while (num > 10) {
  //      System.out.println(num);
        num /= 10;
      }
      return num % 10;
    }
    while (num > Math.pow(10, idx)) {
//      System.out.println(num);
      num /= 10;
    }
    return num % 10;
  }
  public static void main(String[] args) {
    System.out.println(getDigit(3, 200));
    System.out.println(getDigit(5, 34245));
    System.out.println(getDigit(3, 5));
    System.out.println(getDigit(4, 12345));
    System.out.println(getDigit(6, 123456789));
    int[] data = {30, 5, 200, 1, -5, 68};
    System.out.println(Arrays.toString(data));
    radixsort(data);
    System.out.println(Arrays.toString(data));
  }
}
