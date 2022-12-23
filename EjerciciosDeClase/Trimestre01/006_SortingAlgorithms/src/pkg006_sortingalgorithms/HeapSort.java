package pkg006_sortingalgorithms;

public class HeapSort {
  public static void sort(int[] array) {
    BinaryHeap heap = new BinaryHeap();
    for (int i = 0; i < array.length; i++) {
      heap.add(array[i]);
    }
    for (int i = 0; i < array.length; i++) {
      array[i] = heap.remove();
    }
  }
}
