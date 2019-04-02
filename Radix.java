public class Radix {
  public static void radixsort(int[]data){
    MyLinkedList[] buckets = new MyLinkedList[20];
    int max = data[0];
    for (int idx = 0; idx < data.length; idx++) {
      if (max < data[idx]) max = data[idx];
    }
    int digits = 0;
    while (max > 0) {
      max /= 10;
      digits++;
    }
    for (int idx = 0; idx < digits; idx++) {
      for (int x = 0; x < data.length; x++) {
        int digit = getDigit(idx, data[x]);
        if (data[x] >= 0) buckets[digit + 10].add(data[idx]);
        if (data[x] < 0) buckets[9 - Math.abs(digit)].add(data[idx]);
      }
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
  }
}
