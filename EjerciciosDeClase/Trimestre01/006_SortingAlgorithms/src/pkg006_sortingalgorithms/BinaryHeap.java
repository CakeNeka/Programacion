/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg006_sortingalgorithms;

import java.util.Arrays;

public class BinaryHeap {

    private int[] heap;
    private int size;

    public BinaryHeap() {
        heap = new int[10];
        size = 0;
    }

    public void add(int value) {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = value;
        size++;
        int current = size - 1;
        int parent = (current - 1) / 2;
        while (current > 0 && heap[current] < heap[parent]) {
            int temp = heap[current];
            heap[current] = heap[parent];
            heap[parent] = temp;
            current = parent;
            parent = (current - 1) / 2;
        }
    }

  public int remove() {
    // Store the value of the root node (the minimum value in the heap) in a variable
    int result = heap[0];
    // Replace the root node with the last element in the heap
    heap[0] = heap[size - 1];
    // Decrement the size of the heap
    size--;
    // Initialize a variable to store the current node being compared
    int current = 0;
    // Loop until the current node is outside the bounds of the heap
    while (current < size) {
      // Calculate the indices of the left and right children of the current node
      int left = current * 2 + 1;
      int right = current * 2 + 2;
      // If the left child is outside the bounds of the heap, we have reached the end
      // of the heap and can exit the loop
      if (left >= size) {
        break;
      }
      // Initialize a variable to store the index of the minimum child
      int minIndex = left;
      // If the right child exists and has a smaller value than the left child,
      // update the minIndex variable to store the index of the right child
      if (right < size && heap[right] < heap[left]) {
        minIndex = right;
      }
      // If the value of the current node is greater than the value of the minimum child,
      // swap the values of the current node and the minimum child and update the current
      // node to be the minimum child
      if (heap[current] > heap[minIndex]) {
        int temp = heap[current];
        heap[current] = heap[minIndex];
        heap[minIndex] = temp;
        current = minIndex;
      } else {
        // If the value of the current node is not greater than the value of the minimum child,
        // the heap property is satisfied and we can exit the loop
        break;
      }
    }
    // Return the minimum value that was removed from the heap
    return result;
  }




    public int peek() {
        return heap[0];
    }

    public int size() {
        return size;
    }
}
