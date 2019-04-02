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
    MyLinkedList<Integer> temp = new MyLinkedList();
    for (int idx = digits; idx > 0; idx--) {
      for (int x = 0; x < data.length; x++) {
        int digit = getDigit(idx, data[x]);
        if (data[x] >= 0) buckets[digit + 10].add(data[x]);
        if (data[x] < 0) buckets[9 - Math.abs(digit)].add(data[x]);
      }
      for (int i = 0; i < buckets.length; i++) {
        temp.extend(buckets[i]);
      }
      for (int i = 0; i < data.length; i++) {
        data[i] = (int)temp.removeFront();
      }
      temp.clear();
      for (int i = 0; i < buckets.length; i++) {
        buckets[i].clear();
      }
    }
    MyLinkedList<Integer> output = new MyLinkedList();
    for (int idx = 0; idx < buckets.length; idx++) {
      output.extend(buckets[idx]);
    }
    for (int idx = 0; idx < data.length; idx++) {
      data[idx] = (int)output.removeFront();
    }
  }
  public static int getDigit(int idx, int num) {
    return (int)(num / Math.pow(10, idx)) % 10;
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
