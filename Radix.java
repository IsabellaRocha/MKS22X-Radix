import java.util.Arrays;
public class Radix {
  public static void radixsort(int[]data){
    MyLinkedList[] buckets = new MyLinkedList[20];
    int max = data[0];
    for (int idx = 0; idx < buckets.length; idx++) {
      buckets[idx] = new MyLinkedList();
    }
    for (int idx = 0; idx < data.length; idx++) {
      if (max < data[idx]) max = data[idx];
    }
    int digits = 0;
    while (max > 0) {
      max /= 10;
      digits++;
    }
    for (int idx = 1; idx < digits; idx++) {
      for (int x = 0; x < data.length; x++) {
        int digit = getDigit(idx, data[x]);
        if (data[x] >= 0) buckets[digit + 10].add(data[idx]);
        if (data[x] < 0) buckets[9 - Math.abs(digit)].add(data[idx]);
      }
    }
    MyLinkedList output = new MyLinkedList();
    for (int idx = 0; idx < buckets.length; idx++) {
      output.extend(buckets[idx]);
    }
    for (int idx = 0; idx < data.length; idx++) {
      data[idx] = (int) output.removeFront();
    }
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
    int[] data = {30, 5, 200, 1, -5, 68};
    System.out.println(Arrays.toString(data));
    radixsort(data);
    System.out.println(Arrays.toString(data));
  }
}
